package com.jayanth.crime.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CrimeRecord {
    private String district;
    private int value;
}
