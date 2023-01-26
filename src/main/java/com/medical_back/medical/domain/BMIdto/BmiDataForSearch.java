package com.medical_back.medical.domain.BMIdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BmiDataForSearch {
  private int age;
  private int weight;
  private int height;

//  1. age (Required)
//  It should use to input the user’s age. It must be number. It cannot be negative or bigger than 80.
//
//  2. weight (Required)
//  It should use to input the user’s mass. It must be number. It cannot be smaller than 40 or bigger than 160. The unit of weight is in kg.
//
//3. height (Required)
//  It should use to input the user’s age. It must be number. It cannot be smaller than 130 or bigger than 230. The unit of weight is in cm.
}
