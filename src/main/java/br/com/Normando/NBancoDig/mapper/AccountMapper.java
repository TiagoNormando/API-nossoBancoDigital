package br.com.Normando.NBancoDig.mapper;



import br.com.Normando.NBancoDig.dto.AccountDto;
import br.com.Normando.NBancoDig.model.AccountModel;
import org.springframework.data.domain.Page;

import java.util.List;


public class AccountMapper {

    public AccountModel convertToEntity(AccountDto accountDto) {
        AccountModel accountMd = new AccountModel();
        //
        accountMd.setId(accountDto.getId());
        accountMd.setNumBanco(accountDto.getNumBanco());
        accountMd.setNumAg(accountDto.getNumAg());
        accountMd.setNumCC(accountDto.getNumCC());
        accountMd.setValorSaldo(accountDto.getValorSaldo());
        //
        if (accountDto.getProposed() != null) {
            accountMd.setProposed(
                    new ProposedMapper().convertToEntity(accountDto.getProposed())
            );
        }
        //
        return accountMd;
    }

    public AccountDto convertToDto(AccountModel accountMd) {
        AccountDto accountDto = new AccountDto();
        //
        accountDto.setId(accountMd.getId());
        accountDto.setNumBanco(accountMd.getNumBanco());
        accountDto.setNumAg(accountMd.getNumAg());
        accountDto.setNumCC(accountMd.getNumCC());
        accountDto.setValorSaldo(accountMd.getValorSaldo());
        //
        if (accountMd.getProposed() != null) {
            accountDto.setProposed(
                    new ProposedMapper().convertToDto(accountMd.getProposed())
            );
        }
        //
        return accountDto;
    }

    public Page<AccountDto> convertPageToDto(Page<AccountModel> account){
        return account.map(this::convertToDto);
    }
}
