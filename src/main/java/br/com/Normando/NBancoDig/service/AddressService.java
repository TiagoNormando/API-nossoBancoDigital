package br.com.Normando.NBancoDig.service;


import br.com.Normando.NBancoDig.model.AddressModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface AddressService {
    //
    Page<AddressModel> getAll(Pageable page);
    //
    AddressModel findById(Integer id);
    //
    AddressModel save(AddressModel addressMd);
    //
    AddressModel save(Integer id, AddressModel addressMd);
    //
   List<AddressModel> findByClient(Integer id);
    //
    void delete(Integer id);

}
