package com.fullstack.gvozdenbank.dto;

import com.fullstack.gvozdenbank.enums.AccountTypes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BankAccountDTO {
    private Long account_id;
    @NotNull
    private String name;
    @NotNull
    private AccountTypes account_type;
    @NotNull
    private Float balance;
    @NotNull
    @JsonIgnore
    private Float interest;
}
