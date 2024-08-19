package com.fullstack.gvozdenbank.entities;

import com.fullstack.gvozdenbank.enums.UserTypes;
import jakarta.persistence.*;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @NotNull(message = "Name cannot be null")
    @Column(name = "user_name")
    private String user_name;

    @Column(name = "user_type")
    @Enumerated(EnumType.STRING)
    private UserTypes user_type;

    @OneToMany(mappedBy="account_id")
    private List<BankAccountEntity> accounts;
}
