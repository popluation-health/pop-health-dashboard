package org.pophealth.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import java.time.LocalDate;
import javax.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Reward  extends PanacheEntity {


    private String rewardName;
    private Double value;
    private boolean fulfilled;
    private String category;
    private LocalDate measurementDate;

}
