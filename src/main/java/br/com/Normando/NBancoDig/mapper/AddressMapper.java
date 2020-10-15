package br.com.Normando.NBancoDig.mapper;



import br.com.Normando.NBancoDig.dto.AddressDto;
import br.com.Normando.NBancoDig.exception.BussinesException;
import br.com.Normando.NBancoDig.model.AddressModel;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class AddressMapper {

    public AddressModel convertToEntity(AddressDto addressDto) {
        try {
            AddressModel addressMd = new AddressModel();
            //
            addressMd.setId(addressDto.getId());
            //
            if (verifyCep(addressDto.getZipCod())) {
                addressMd.setZipCod(addressDto.getZipCod());
            }
            //
            addressMd.setStreet(addressDto.getStreet());
            addressMd.setDistrict(addressDto.getDistrict());
            addressMd.setComplement(addressDto.getComplement());
            addressMd.setCity(addressDto.getCity());
            addressMd.setState(addressDto.getState());
            //
            if (addressDto.getClient() != null) {
                addressMd.setClient(
                        new ClientMapper().convertToEntity(addressDto.getClient())
                );
            }
            //
            return addressMd;
        } catch ( Exception ex)
        {
            throw new BussinesException("Erro no Request: " + ex);
        }
    }

    public List<AddressDto> convertToListDto(List<AddressModel> address){
        try {
            Stream<AddressDto> addressDtoStream = address.stream().map(this::convertToDto);
            List<AddressDto> addressDtos = addressDtoStream.collect(Collectors.toList());
            return addressDtos;
        } catch ( Exception ex)
        {
            throw new BussinesException("Erro no Request: " + ex);
        }
    }
    //
    public boolean verifyCep(String cep){
        String padrao = "^\\d{5}[-]\\d{3}$";

        return (cep.matches(padrao))? true : false;
    }

    public AddressDto convertToDto(AddressModel addressMd) {
        try {
            AddressDto addressDto = new AddressDto();
            //
            addressDto.setId(addressMd.getId());
            addressDto.setZipCod(addressMd.getZipCod());
            addressDto.setStreet(addressMd.getStreet());
            addressDto.setDistrict(addressMd.getDistrict());
            addressDto.setComplement(addressMd.getComplement());
            addressDto.setCity(addressMd.getCity());
            addressDto.setState(addressMd.getState());
            //
            if (addressMd.getClient() != null) {
                addressDto.setClient(
                        new ClientMapper().convertToDto(addressMd.getClient())
                );
            }
            //
            return addressDto;
        } catch ( Exception ex)
        {
          throw new BussinesException("Erro no Request: " + ex);
        }
    }

    public Page<AddressDto> convertPageToDto(Page<AddressModel> addresses){
        return addresses.map(this::convertToDto);
    }
}
