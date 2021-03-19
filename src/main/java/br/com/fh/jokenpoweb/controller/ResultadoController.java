package br.com.fh.jokenpoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResultadoController {

    @GetMapping("/resultado")
    public String resultado() {
        return "resultado";
    }

}
