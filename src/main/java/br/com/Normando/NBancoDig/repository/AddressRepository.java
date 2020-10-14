package br.com.Normando.NBancoDig.repository;

import br.com.Normando.NBancoDig.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<AddressModel, Integer> {
    @Query( value = "select a from AddressModel a where a.idClient = :clientId", nativeQuery = true)
    List<AddressModel> findByClient(@Param("clientId") Integer clientId);
}
