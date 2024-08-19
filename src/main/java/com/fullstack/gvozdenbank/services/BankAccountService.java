package com.fullstack.gvozdenbank.services;

import com.fullstack.gvozdenbank.dto.BankAccountDTO;
import com.fullstack.gvozdenbank.entities.BankAccountEntity;
import com.fullstack.gvozdenbank.entities.UserEntity;
import com.fullstack.gvozdenbank.enums.UserTypes;
import com.fullstack.gvozdenbank.exceptions.InsuficientBalanceException;
import com.fullstack.gvozdenbank.exceptions.UnauthorisedUserException;
import com.fullstack.gvozdenbank.mappers.BankAccountMapper;
import com.fullstack.gvozdenbank.repository.BankAccountRepository;
import com.fullstack.gvozdenbank.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BankAccountService {
    private final UserRepository userRepository;
    private final BankAccountRepository bankAccountRepository;
    private final BankAccountMapper bankAccountMapper;

    @Autowired
    public BankAccountService(UserRepository userRepository, BankAccountRepository bankAccountRepository, BankAccountMapper bankAccountMapper) {
        this.userRepository = userRepository;
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountMapper = bankAccountMapper;
    }

    public String createBankAccount(BankAccountDTO bankAccountDTO) {
        BankAccountEntity bankAccount = bankAccountMapper.dtoToEntity(bankAccountDTO);
        bankAccountRepository.save(bankAccount);
        return "New bank account created !";
    }

    public BankAccountDTO getBankAccountById(Long id) {
        BankAccountEntity bankAccount = bankAccountRepository.findById(id).orElse(null);
        return bankAccountMapper.entityToDto(bankAccount);
    }

    public ArrayList<BankAccountDTO> getAllBankAccounts() {
        List<BankAccountEntity> bankAccounts = bankAccountRepository.findAll();
        ArrayList<BankAccountDTO> bankAccountDTOS = new ArrayList<>();
        for(BankAccountEntity bankAccount : bankAccounts) {
            bankAccountDTOS.add(bankAccountMapper.entityToDto(bankAccount));
        }
        return bankAccountDTOS;
    }

    public String deposit(Long userId, Long accountId, Float amount) throws UnauthorisedUserException {
        BankAccountEntity account = bankAccountRepository.findById(accountId).orElseThrow();
        UserEntity user = userRepository.findById(userId).orElseThrow();
        if(user.getUser_type() == UserTypes.CLIENT && account.getUser().getUser_id().equals(accountId)) {
            account.setBalance(account.getBalance() + amount);
            bankAccountRepository.save(account);
            return "Successfully deposited " + amount + " to bank account with ID " + accountId;
        } else {
            throw new UnauthorisedUserException("User has to be of client type and own the bank account");
        }
    }

    public String withdraw(Long userId, Long accountId, Float amount) throws UnauthorisedUserException, InsuficientBalanceException {
        BankAccountEntity account = bankAccountRepository.findById(accountId).orElseThrow();
        UserEntity user = userRepository.findById(userId).orElseThrow();
        if(user.getUser_type() == UserTypes.CLIENT && account.getUser().getUser_id().equals(accountId)) {
            if (account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
                bankAccountRepository.save(account);
                return "Successfully withdrawn " + amount + " from bank account with ID " + accountId;
            } else {
                throw new InsuficientBalanceException("Insufficient balance");
            }
        } else {
            throw new UnauthorisedUserException("User has to be of client type and own the bank account");
        }
    }

    public String deleteBankAccountById(Long id) {
        bankAccountRepository.deleteById(id);
        return "Successfully deleted bank account with ID: " + id;
    }
}
