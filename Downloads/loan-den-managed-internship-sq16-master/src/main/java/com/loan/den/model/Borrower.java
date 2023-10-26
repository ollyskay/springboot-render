package com.loan.den.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Borrower extends BaseEntity{
    private String employedBefore;
    private String currentEmploymentStatus;
    private String earning;
    private String workType;
    private String employmentStatus;
    private String otherIncomeSource;
    private Integer monthlyPersonalIncome;
    private String extraIncomeDescription;

    @OneToOne
    private User user;
}
