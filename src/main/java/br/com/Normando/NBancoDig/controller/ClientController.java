package br.com.Normando.NBancoDig.controller;

import br.com.Normando.NBancoDig.dto.ClientDto;
import br.com.Normando.NBancoDig.mapper.ClientMapper;
import br.com.Normando.NBancoDig.model.ClientModel;
import br.com.Normando.NBancoDig.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/client")
@RestController


public class ClientController {
    @Autowired
    private ClientService clientService;
    
    //
    private ClientMapper clientMapper = new ClientMapper();
    //
    @GetMapping
    public Page<ClientDto> getAll(Pageable page) {

        return clientMapper.convertPageToDto(clientService.getAll(page));
    }
    //
    @GetMapping(value = "/{id}")
    public ClientDto findById(@PathVariable Integer id) {
        return clientMapper.convertToDto(clientService.findById(id));
    }
    //
    @Transactional
    @PostMapping
    public ClientDto add(@RequestBody ClientDto clientDto) {
        ClientModel client = clientMapper.convertToEntity(clientDto);
        //
        return clientMapper.convertToDto(clientService.save(client));
    }
    //
    @Transactional
    @PutMapping(value = "/{id}")
    public ClientDto update(@PathVariable Integer id, @RequestBody ClientDto clientDto) {
        ClientModel client = clientMapper.convertToEntity(clientDto);
        //
        return clientMapper.convertToDto(clientService.save(id,client));
    }
    @Transactional
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        clientService.delete(id);
    }

}
