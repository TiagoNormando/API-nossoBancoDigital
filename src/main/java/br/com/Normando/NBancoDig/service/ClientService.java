package br.com.Normando.NBancoDig.service;

import br.com.Normando.NBancoDig.model.ClientModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientService {
    Page<ClientModel> getAll(Pageable page);
    //
    ClientModel findById(Integer id);
    //
    ClientModel save(ClientModel clientMd);
    //
    ClientModel save(Integer id, ClientModel clientMd);
    //
    void delete(Integer id);
}
