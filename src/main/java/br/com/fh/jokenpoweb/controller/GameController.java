package br.com.fh.jokenpoweb.controller;

import br.com.fh.jokenpoweb.dto.RodadaDTO;
import br.com.fh.jokenpoweb.model.Partida;
import br.com.fh.jokenpoweb.repository.JogadorRepository;
import br.com.fh.jokenpoweb.dto.JogadorDTO;
import br.com.fh.jokenpoweb.model.Jogador;
import br.com.fh.jokenpoweb.repository.PartidaRepository;
import br.com.fh.jokenpoweb.service.RoboService;
import br.com.fh.jokenpoweb.util.GameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author douglas
 */
@Controller
public class GameController {

    @Autowired
    private JogadorRepository jogadorRepository;

    @Autowired
    private PartidaRepository partidaRepository;

    private Partida partida;

    private Jogador jogador;

    private int count;

    private int ptsJogador;

    private int ptsComputador;

    @GetMapping("/game")
    public String game(Model model) {
        
        zerarCounts();

        model.addAttribute("nome", jogador.getNome());
        
        return "game";
    }

    @PostMapping("/game")
    public String game(Model model, JogadorDTO jogadorDto) {
        
        zerarCounts();
        
        jogador = jogadorDto.toJogador();
        
        model.addAttribute("nome", jogador.getNome());

        return "game";
    }

    @PostMapping("/game/jogada")
    public String jogada(Model model, RodadaDTO rodadaDto) {

        count++;

        // Chegou a 10 rodadas, partida acaba
        if (count == 10) {

           jogadorRepository.save(jogador);
           
           populaPartida();
           partidaRepository.save(partida);

            model.addAttribute("nome", jogador.getNome());
            model.addAttribute("ptsJogador", ptsJogador);
            model.addAttribute("ptsComputador", ptsComputador);
            model.addAttribute("vencedor", partida.getVencedor());

            return "resultado";
        }

        String escolhaComputador = RoboService.joga();

        String ganhadorRodada = GameUtils.verificaGanhadorRodada(rodadaDto.getEscolha(), escolhaComputador);
        contabizaPontosPorRodada(ganhadorRodada);

        model.addAttribute("nome", jogador.getNome());
        model.addAttribute("escolhaComputador", escolhaComputador);
        model.addAttribute("ganhador", ganhadorRodada);

        return "game";
    }

    /**
     * Conta pontos por rodada
     *
     * @param ganhadorRodada
     */
    private void contabizaPontosPorRodada(final String ganhadorRodada) {
        if (ganhadorRodada.equals("player")) {
            ptsJogador++;
        } else if (ganhadorRodada.equals("computador")) {
            ptsComputador++;
        }
    }

    /**
     * Preenche objeto Partida
     */
    private void populaPartida() {
        String vencedor = GameUtils.verificaGanhadorPartida(ptsJogador, ptsComputador);

        partida = new Partida();
        partida.setJogador(jogador);
        partida.setPontuacaoJogador(ptsJogador);
        partida.setPontuacaoComputador(ptsComputador);
        partida.setVencedor(vencedor);
    }

    /**
     * Zerar contadores
     */
    private void zerarCounts() {
        count = 0;
        ptsJogador = 0;
        ptsComputador = 0;
    }

}
