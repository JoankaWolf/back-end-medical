package com.medical_back.medical.externalServiceICD.dtoICD;

import lombok.Data;


@Data
public class Datum {

        private final String code;
        private final String name;
        private final String description;
        private final String chapter;
        private final String block;


}
