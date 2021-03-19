package br.com.fh.jokenpoweb.dto;

import br.com.fh.jokenpoweb.model.Jogador;

public class JogadorDTO {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Converte JogadorDTO para Jogador
     *
     * @return
     */
    public Jogador toJogador() {
        Jogador jogador = new Jogador();
        jogador.setNome(nome);
        return jogador;
    }

}
