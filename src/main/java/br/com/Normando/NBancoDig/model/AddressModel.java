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
public class AddressModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //
    @Column(nullable = false)
    private String zipCod;
    //
    @Column(nullable = false)
    private String street;
    //
    @Column(nullable = false)
    private String district;
    //
    @Column(nullable = false)
    private String complement;
    //
    @Column(nullable = false)
    private String city;
    //
    @Column(nullable = false)
    private String state;
    //
    @JoinColumn(name = "idClient", nullable = false)
    @ManyToOne
    private ClientModel client;
}
