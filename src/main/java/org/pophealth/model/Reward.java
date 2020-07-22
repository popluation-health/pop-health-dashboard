package org.pophealth.model;

import lombok.Data;

@Data
public class Reward {

    private String name;
    private Double value;
    private boolean fulfilled;
    private String category;


}
