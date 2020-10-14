package br.com.Normando.NBancoDig.service.impl;


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
        Optional<ClientModel> value = clientRepository.findById(id);
        return value.isPresent() ? value.get() : null;
    }
    //
    @Override
    public ClientModel save(ClientModel clientMd){
        return clientRepository.save(clientMd);
    }
    //
    public ClientModel save(Integer id, ClientModel clientMd) {
        clientMd.setId(id);
        //
        return clientRepository.save(clientMd);
    }

    @Override
    public void delete(Integer id){
        clientRepository.deleteById(id);
    }
}
