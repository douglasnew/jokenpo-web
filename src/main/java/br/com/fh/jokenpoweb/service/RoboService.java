package br.com.fh.jokenpoweb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author douglas
 */
public class RoboService {

    public static String joga() {

        List<String> escolhas = new ArrayList<>();
        escolhas.add("Pedra");
        escolhas.add("Papel");
        escolhas.add("Tesoura");

        Random random = new Random();
        int op = random.nextInt(3);

        return escolhas.get(op);
    }

}
