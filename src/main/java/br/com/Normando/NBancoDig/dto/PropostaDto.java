package br.com.Normando.NBancoDig.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class PropostaDto {
    private Integer id;
    private String proposedDate;
    private boolean accept;

}
