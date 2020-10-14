package br.com.Normando.NBancoDig.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor

public class AddressDto {
    private Integer id;
    private String zipCod;
    private String street;
    private String district;
    private String complement;
    private String city;
    private String state;
    private ClientDto client;
}

