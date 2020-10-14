package br.com.Normando.NBancoDig.service.impl;



import br.com.Normando.NBancoDig.model.AddressModel;
import br.com.Normando.NBancoDig.model.ClientModel;
import br.com.Normando.NBancoDig.repository.AddressRepository;
import br.com.Normando.NBancoDig.service.ClientService;
import br.com.Normando.NBancoDig.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ClientService clientService;


    @Override
    public Page<AddressModel> getAll(Pageable page){
        return addressRepository.findAll(page);
    }

    @Override
    public AddressModel findById(Integer id){
        Optional<AddressModel> value = addressRepository.findById(id);
        return value.isPresent() ? value.get() : null;
    }
    //
    @Override
    public List<AddressModel> findByClient(Integer id){
         List<AddressModel> value = addressRepository.findByClient(id);
        return value;
    }
    @Override
    public AddressModel save(AddressModel addressMd){
        addressMd.setClient(clientService.findById(addressMd.getClient().getId()));

        return addressRepository.save(addressMd);
    }
    //
    public AddressModel save(Integer id, AddressModel addressMd) {
        addressMd.setId(id);
        addressMd.setClient(clientService.findById(addressMd.getClient().getId()));
        //
        return addressRepository.save(addressMd);
    }



    public void delete(Integer id){
        addressRepository.deleteById(id);
    }
}
