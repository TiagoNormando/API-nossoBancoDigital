package br.com.Normando.NBancoDig.repository;


import br.com.Normando.NBancoDig.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<ClientModel, Integer> {

    List<ClientModel> findAll();
}
