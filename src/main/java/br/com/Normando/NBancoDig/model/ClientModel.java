package br.com.Normando.NBancoDig.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class ClientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //
    @CPF
    @Column(unique = true, nullable = false)
    private String cpf;
    //
    @Column(nullable = false)
    private String name;
    //
    @Email
    @Column(unique = true, nullable = false)
    private String email;
    //
    @Column(nullable = false)
    private Date birthDate;
    //
    @Column(nullable = false)
    private String lastName;
    //
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    List<AddressModel> AddressList;
    //
}
