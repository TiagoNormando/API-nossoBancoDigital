package br.com.Normando.NBancoDig.model;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AccountModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //
     @Column(nullable = false)
    private String numBanco;
    //
    @Column(nullable = false)
    private String numAg;
    //
    @Column(nullable = false)
    private String numCC;
    //
    @Column(nullable = false)
    private Double valorSaldo;
    //
    @JoinColumn(name = "idProposed", nullable = false)
    @ManyToOne
    private ProposedModel proposed;
}
