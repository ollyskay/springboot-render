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
public class GovernmentID extends BaseEntity  {
    private String docType;
    private Long docNumber;
    private String fileName;

    @OneToOne
    private User user;
}
