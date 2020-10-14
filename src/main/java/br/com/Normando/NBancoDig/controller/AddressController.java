package br.com.Normando.NBancoDig.controller;

import br.com.Normando.NBancoDig.dto.AddressDto;
import br.com.Normando.NBancoDig.mapper.AddressMapper;
import br.com.Normando.NBancoDig.model.AddressModel;
import br.com.Normando.NBancoDig.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(value = "/addresses")
@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;
    private AddressMapper addressMapper = new AddressMapper();
    //
    @GetMapping
    public Page<AddressDto> getAll(Pageable page) {
        return addressMapper.convertPageToDto(addressService.getAll(page));
    }

    @GetMapping(value = "/{id}")
    public AddressDto findById(@PathVariable Integer id) {
        return addressMapper.convertToDto(addressService.findById(id));
    }

    @GetMapping(value = "/client/{clientId}")
    public List<AddressDto> findByClient(@PathVariable Integer clientId) {
        return addressMapper.convertToListDto(addressService.findByClient(clientId));
    }

    @Transactional
    @PostMapping
    public AddressDto add(@RequestBody AddressDto addressDto) {
        AddressModel addressMd = addressMapper.convertToEntity(addressDto);
        return addressMapper.convertToDto(addressService.save(addressMd));
    }
    //
    @Transactional
    @PutMapping(value = "/{id}")
    public AddressDto update(@PathVariable Integer id, @RequestBody AddressDto addressDto) {
        AddressModel addressMd = addressMapper.convertToEntity(addressDto);

        return addressMapper.convertToDto(addressService.save(id,addressMd));
    }
    //
    @Transactional
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        addressService.delete(id);
    }

}
