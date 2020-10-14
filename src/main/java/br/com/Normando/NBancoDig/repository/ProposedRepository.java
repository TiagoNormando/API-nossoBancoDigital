package br.com.Normando.NBancoDig.repository;

import br.com.Normando.NBancoDig.model.ProposedModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProposedRepository extends JpaRepository<ProposedModel, Integer> {
}
