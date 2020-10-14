package br.com.Normando.NBancoDig.service;


import br.com.Normando.NBancoDig.model.AddressModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


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
    void delete(Integer id);

}
