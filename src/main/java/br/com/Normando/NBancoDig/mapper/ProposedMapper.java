package br.com.Normando.NBancoDig.mapper;


import br.com.Normando.NBancoDig.dto.ClientDto;
import br.com.Normando.NBancoDig.dto.ProposedDto;
import br.com.Normando.NBancoDig.exception.BussinesException;
import br.com.Normando.NBancoDig.model.ProposedModel;
import org.springframework.data.domain.Page;


public class ProposedMapper {

    public ProposedModel convertToEntity(ProposedDto proposedDto) {
        try {
            ProposedModel proposedMd = new ProposedModel();
            //
            proposedMd.setId(proposedDto.getId());
            proposedMd.setProposedDate(proposedDto.getProposedDate());
            proposedMd.setProposedAccept(proposedDto.getProposedAccept());
            //
            return proposedMd;
        } catch ( Exception ex)
        {
            throw new BussinesException("Erro no Request: " + ex);
        }

    }

    public ProposedDto convertToDto(ProposedModel proposedMd) {
        try {
            ProposedDto proposedDto = new ProposedDto();
            //
            proposedDto.setId(proposedMd.getId());
            proposedDto.setProposedDate(proposedMd.getProposedDate());
            proposedDto.setProposedAccept(proposedMd.getProposedAccept());
            //
            return proposedDto;
        } catch ( Exception ex)
        {
            throw new BussinesException("Erro no Request: " + ex);
        }

    }

    public Page<ProposedDto> convertPageToDto(Page<ProposedModel> proposed){
        return proposed.map(this::convertToDto);
    }
}
