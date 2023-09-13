package com.scorecard.scoreboard.Model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@EqualsAndHashCode
public class CumulativeScore {
    private String decadevName;
    private double cumulativeScore;

}

