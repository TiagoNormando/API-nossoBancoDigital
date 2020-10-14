package br.com.Normando.NBancoDig.repository;

import br.com.Normando.NBancoDig.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressModel, Integer> {
}
