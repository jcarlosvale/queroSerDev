package br.com.letscode.controller;

import br.com.letscode.controller.dto.HelloWorldDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
public class HelloWorldController {

    @GetMapping(path = "/hello-world-anterior")
    public String helloWorldAnterior() {
        return "Ola mundo";
    }

    @GetMapping(path = "/hello-world/{nome}/{idade}")
    public HelloWorldDTO helloWorld(@PathVariable(name = "nome") String nome,
                                    @PathVariable(name = "idade") int idade) {


        var helloWorld = new HelloWorldDTO();
        helloWorld.setUsername(nome);
        helloWorld.setIdade(idade);
        //helloWorld.setMensagem("Bem-vindo " + nome);

        return helloWorld;
    }

    @GetMapping(path = "/hello-world-final/{nome}/{idade}")
    public ResponseEntity<HelloWorldDTO> helloWorldOficial(@PathVariable(name = "nome") String nome,
                                                           @PathVariable(name = "idade") int idade) {


        var helloWorld = new HelloWorldDTO();
        helloWorld.setUsername(nome);
        helloWorld.setIdade(idade);
//        helloWorld.setMensagem("Bem-vindo " + nome);

        return new ResponseEntity(helloWorld, HttpStatus.OK);
    }

    @GetMapping(path = "/hello-world/{nome}")
    public ResponseEntity<HelloWorldDTO> helloWorldOficial(@PathVariable(name = "nome") String nome) {

        var helloWorld = new HelloWorldDTO();
//        helloWorld.setMensagem("Novo teste");
        helloWorld.setUsername(nome);

        return new ResponseEntity(helloWorld, HttpStatus.OK);
    }

    //POST --> CREATE
    @PostMapping(path = "/hello-world/")
    public ResponseEntity<Void> postSimulation(@RequestBody HelloWorldDTO helloWorldDto) {

        log.info(helloWorldDto);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    //PUT --> UPDATE
    @PutMapping(path = "/hello-world/")
    public ResponseEntity<Void> putSimulation(@RequestBody HelloWorldDTO helloWorldDto) {

        log.info("PUT: " + helloWorldDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    //DELETE
    @DeleteMapping(path = "/hello-world/{nome}")
    public ResponseEntity<Void> deleteSimulation(@PathVariable(name = "nome") String nome) {
        log.info("APAGANDO " + nome);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
