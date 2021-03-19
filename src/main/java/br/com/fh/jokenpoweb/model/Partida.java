package br.com.fh.jokenpoweb.model;

import javax.persistence.*;

@Entity
@Table(name = "partida")
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "jogador_id")
    private Jogador jogador;

    private Integer pontuacaoJogador;
    private Integer pontuacaoComputador;
    private String vencedor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
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

}
