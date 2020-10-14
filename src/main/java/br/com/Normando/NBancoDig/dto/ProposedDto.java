package br.com.Normando.NBancoDig.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ProposedDto {
    private Integer id;
    private Date proposedDate;
    private Boolean proposedAccept;
}
