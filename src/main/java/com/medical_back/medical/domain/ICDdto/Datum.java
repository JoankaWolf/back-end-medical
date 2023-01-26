package com.medical_back.medical.domain.ICDdto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class Datum {

        public String code;
        public String name;
        public String description;
        public String chapter;
        public String block;


}
