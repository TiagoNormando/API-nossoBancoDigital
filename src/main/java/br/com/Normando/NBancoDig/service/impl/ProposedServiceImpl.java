package br.com.Normando.NBancoDig.service.impl;


import br.com.Normando.NBancoDig.exception.BussinesException;
import br.com.Normando.NBancoDig.model.ProposedModel;
import br.com.Normando.NBancoDig.repository.ProposedRepository;
import br.com.Normando.NBancoDig.service.ProposedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProposedServiceImpl implements ProposedService {
    @Autowired
    private ProposedRepository proposedRepository;

    @Override
    public Page<ProposedModel> getAll(Pageable page){
        return proposedRepository.findAll(page);
    }

    @Override
    public ProposedModel findById(Integer id){
        try {
            Optional<ProposedModel> value = proposedRepository.findById(id);
            return value.isPresent() ? value.get() : null;
        } catch (Exception ex) {
            throw new BussinesException("Erro no request: " + ex);

        }

    }
    //
    @Override
    public ProposedModel save(ProposedModel ProposedMd){
        try {
            return proposedRepository.save(ProposedMd);
        } catch (Exception ex) {
            throw new BussinesException("Erro no request: " + ex);

        }

    }
    //
    public ProposedModel save(Integer id, ProposedModel ProposedMd) {
        try {
            ProposedMd.setId(id);
            //
            return proposedRepository.save(ProposedMd);
        } catch (Exception ex) {
            throw new BussinesException("Erro no request: " + ex);
        }
    }

    public void delete(Integer id){
        proposedRepository.deleteById(id);
    }
}
