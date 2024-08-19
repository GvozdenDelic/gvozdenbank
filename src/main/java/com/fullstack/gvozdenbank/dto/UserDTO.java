package com.fullstack.gvozdenbank.dto;

import com.fullstack.gvozdenbank.enums.UserTypes;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserDTO {
    private Long user_id;
    @NotNull
    private String user_name;
    @NotNull
    private UserTypes user_type;
}
