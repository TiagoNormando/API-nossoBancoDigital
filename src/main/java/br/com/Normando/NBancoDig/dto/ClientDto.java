package br.com.Normando.NBancoDig.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor

public class ClientDto{
    private Integer id;
    private String name;
    private String lastName;
    private String email;
    private Date  birthDate;
    private String cpf;
}
