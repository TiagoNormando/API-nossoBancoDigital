package br.com.Normando.NBancoDig.service.impl;


import br.com.Normando.NBancoDig.exception.BussinesException;
import br.com.Normando.NBancoDig.model.AddressModel;
import br.com.Normando.NBancoDig.model.ClientModel;
import br.com.Normando.NBancoDig.repository.ClientRepository;
import br.com.Normando.NBancoDig.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientImpl implements ClientService {
    //
    @Autowired
    private ClientRepository clientRepository;
    //
    @Override
    public Page<ClientModel> getAll(Pageable page){
        return clientRepository.findAll(page);
    }
    //
    @Override
    public ClientModel findById(Integer id){
        try {
            Optional<ClientModel> value = clientRepository.findById(id);
            return value.isPresent() ? value.get() : null;

        } catch (Exception ex) {
            throw new BussinesException("Erro no request: " + ex);

        }
    }
    //
    @Override
    public ClientModel save(ClientModel clientMd){
        try {
            return clientRepository.save(clientMd);
        } catch (Exception ex) {
            throw new BussinesException("Erro no request: " + ex);

        }

    }
    //
    public ClientModel save(Integer id, ClientModel clientMd) {
        try {
            clientMd.setId(id);
            //
            return clientRepository.save(clientMd);
        } catch (Exception ex) {
            throw new BussinesException("Erro no request: " + ex);

        }

    }

    @Override
    public void delete(Integer id){
        clientRepository.deleteById(id);
    }
}
