package com.fullstack.gvozdenbank.mappers;

import com.fullstack.gvozdenbank.dto.BankAccountDTO;
import com.fullstack.gvozdenbank.entities.BankAccountEntity;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMapper {
    public BankAccountDTO entityToDto(BankAccountEntity bankAccount) {
        if(bankAccount == null) {
            return null;
        }

        BankAccountDTO bankAccountDTO = new BankAccountDTO();
        bankAccountDTO.setName(bankAccount.getName());
        bankAccountDTO.setAccount_type(bankAccount.getAccount_type());
        bankAccountDTO.setBalance(bankAccount.getBalance());
        bankAccountDTO.setAccount_id(bankAccount.getAccount_id());
        bankAccountDTO.setInterest(bankAccount.getInterest());
        return bankAccountDTO;
    }
    public BankAccountEntity dtoToEntity(BankAccountDTO bankAccountDTO) {
        if(bankAccountDTO == null) {
            return null;
        }

        BankAccountEntity bankAccount = new BankAccountEntity();
        bankAccount.setName(bankAccountDTO.getName());
        bankAccount.setAccount_type(bankAccountDTO.getAccount_type());
        bankAccount.setBalance(bankAccountDTO.getBalance());
        bankAccount.setAccount_id(bankAccountDTO.getAccount_id());
        bankAccount.setInterest(bankAccountDTO.getInterest());

        return bankAccount;
    }
}