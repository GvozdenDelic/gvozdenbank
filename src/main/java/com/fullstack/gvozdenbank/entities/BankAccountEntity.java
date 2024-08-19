package com.fullstack.gvozdenbank.entities;

import com.fullstack.gvozdenbank.enums.AccountTypes;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bank_account")
public class BankAccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long account_id;

    @Column(name = "name")
    private String name;

    @Column(name = "account_type")
    @Enumerated(EnumType.STRING)
    private AccountTypes account_type;

    @ManyToOne
    @JoinColumn(name = "user_id")
    UserEntity user;

    @Column(name = "balance")
    private Float balance;

    @Column(name = "interest")
    private Float interest;
}
