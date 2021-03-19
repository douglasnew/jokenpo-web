package br.com.fh.jokenpoweb.util;

/**
 * @author douglas
 */
public class GameUtils {

    /**
     * Verifica o ganhador da rodada
     *
     * @param jogadaPlayer
     * @param jogadaComputador
     * @return
     */
    public static String verificaGanhadorRodada(final String jogadaPlayer, final String jogadaComputador) {
        if (jogadaPlayer.equals(jogadaComputador)) {
            return "empate";
        }
        else if ( jogadaPlayer.equals("Papel") && jogadaComputador.equals("Pedra") ||
                jogadaPlayer.equals("Pedra") && jogadaComputador.equals("Tesoura") ||
                jogadaPlayer.equals("Tesoura") && jogadaComputador.equals("Papel") ) {
            return "player";
        } else {
            return "computador";
        }
    }

    /**
     * Verifica o ganhador da partida
     *
     * @param pontosPlayer
     * @param pontosComputador
     * @return
     */
    public static String verificaGanhadorPartida(final Integer pontosPlayer, final Integer pontosComputador) {
        if (pontosPlayer > pontosComputador) {
            return "jogador";
        } else if (pontosPlayer < pontosComputador) {
            return "computador";
        } else {
            return "empate";
        }
    }

}
