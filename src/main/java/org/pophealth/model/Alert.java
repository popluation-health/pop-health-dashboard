package org.pophealth.model;

import lombok.Data;

@Data
public class Alert {

    private boolean open;
    private String alertType;
    private String severity;




}
