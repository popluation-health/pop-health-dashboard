package org.pophealth.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import java.time.LocalDate;
import javax.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Alert extends PanacheEntity {

    private String alertName;
    private String alertType;
    private boolean open;
    private String severity;
    private LocalDate measurementDate;

}
