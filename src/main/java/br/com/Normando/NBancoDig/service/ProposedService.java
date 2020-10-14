package br.com.Normando.NBancoDig.service;


import br.com.Normando.NBancoDig.model.ProposedModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProposedService {
    //
    Page<ProposedModel> getAll(Pageable page);
    //
    ProposedModel findById(Integer id);
    //
    ProposedModel save(ProposedModel ProposedMd);
    //
    ProposedModel save(Integer id, ProposedModel ProposedMd);
    //
    void delete(Integer id);

}
