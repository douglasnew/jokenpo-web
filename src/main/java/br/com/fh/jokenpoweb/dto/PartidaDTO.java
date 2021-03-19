package br.com.fh.jokenpoweb.dto;

import br.com.fh.jokenpoweb.model.Jogador;
import br.com.fh.jokenpoweb.model.Partida;

public class PartidaDTO {

    private String nomeJogador;
    private Integer pontuacaoJogador;
    private Integer pontuacaoComputador;
    private String vencedor;

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public Integer getPontuacaoJogador() {
        return pontuacaoJogador;
    }

    public void setPontuacaoJogador(Integer pontuacaoJogador) {
        this.pontuacaoJogador = pontuacaoJogador;
    }

    public Integer getPontuacaoComputador() {
        return pontuacaoComputador;
    }

    public void setPontuacaoComputador(Integer pontuacaoComputador) {
        this.pontuacaoComputador = pontuacaoComputador;
    }

    public String getVencedor() {
        return vencedor;
    }

    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
    }

    public Partida toPartida() {
        Partida partida = new Partida();

        Jogador jogador = new Jogador();
        jogador.setNome(nomeJogador);

        partida.setJogador(jogador);
        partida.setPontuacaoJogador(pontuacaoJogador);
        partida.setPontuacaoComputador(pontuacaoComputador);
        partida.setVencedor(vencedor);

        return partida;
    }
}
