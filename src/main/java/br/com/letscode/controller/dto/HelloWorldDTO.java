package br.com.letscode.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//java bean: construtor padrao, get/sets
@NoArgsConstructor
@Data
public class HelloWorldDTO {

    private String mensagem;
    private String username;
    private LocalDateTime data;
    private String corPreferida;
    private Integer idade;
}
