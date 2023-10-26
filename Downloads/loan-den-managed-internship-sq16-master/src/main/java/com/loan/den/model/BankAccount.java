package com.loan.den.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BankAccount extends BaseEntity {
    private String bank;
    private Long accountNumber;
    private String accountName;

    @OneToOne
    private User user;
}
