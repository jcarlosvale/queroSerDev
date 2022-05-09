package br.com.letscode.controller;

import br.com.letscode.controller.dto.HelloWorldDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello-world-anterior")
    public String helloWorldAnterior() {
        return "Ola mundo";
    }

    @GetMapping(path = "/hello-world")
    public HelloWorldDTO helloWorld() {

        var helloWorld = new HelloWorldDTO();
        helloWorld.setMensagem("Novo teste");
        helloWorld.setUsername("jcarlos");

        return helloWorld;
    }

    @GetMapping(path = "/hello-world/{nome}/{idade}")
    public HelloWorldDTO helloWorld(@PathVariable(name = "nome") String nome,
                                    @PathVariable(name = "idade") int idade) {


        var helloWorld = new HelloWorldDTO();
        helloWorld.setUsername(nome);
        helloWorld.setIdade(idade);
        helloWorld.setMensagem("Bem-vindo " + nome);

        return helloWorld;
    }


}
