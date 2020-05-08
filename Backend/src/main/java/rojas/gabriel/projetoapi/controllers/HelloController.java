package rojas.gabriel.projetoapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "Bem-vindos ao sistema de JOGOS!";
    }

}
