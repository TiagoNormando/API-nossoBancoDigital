package br.com.Normando.NBancoDig.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
public class AccountDto {
    private Integer id;
    private String  numBanco;
    private String  numAg;
    private String  numCC;
    private Double valorSaldo;
    private ProposedDto proposed;
}

