package br.com.Normando.NBancoDig.mapper;

import br.com.Normando.NBancoDig.dto.ClientDto;
import br.com.Normando.NBancoDig.model.ClientModel;
import org.springframework.data.domain.Page;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class ClientMapper {
    public ClientModel convertToEntity(ClientDto clientDto) {
        ClientModel client = new ClientModel();
        //
        client.setId(clientDto.getId());
        client.setName(clientDto.getName());
        client.setLastName(clientDto.getLastName());
        client.setCpf(clientDto.getCpf());
        client.setEmail(clientDto.getEmail());
        //
        if (clientDto.getBirthDate() != null) {
            if (calculateAge(clientDto.getBirthDate()) > 18) {
                client.setBirthDate(clientDto.getBirthDate());
            }
        }
        //
        return client;
    }


    public int calculateAge(Date birthDate) {
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        int d1 = Integer.parseInt(formatter.format(birthDate));
        int d2 = Integer.parseInt(formatter.format(new Date()));
        int age = (d2 - d1)/10000;
        return age;
    }

    public ClientDto convertToDto(ClientModel clientMd) {
        ClientDto clientDto = new ClientDto();
        //
        clientDto.setId(clientMd.getId());
        clientDto.setName(clientMd.getName());
        clientDto.setLastName(clientMd.getLastName());
        clientDto.setCpf(clientMd.getCpf());
        clientDto.setEmail(clientMd.getEmail());
        clientDto.setBirthDate(clientMd.getBirthDate());
        //
        return clientDto;
    }

    public Page<ClientDto> convertPageToDto(Page<ClientModel> clients){
        return clients.map(this::convertToDto);
    }
}
