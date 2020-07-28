package org.pophealth.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import javax.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class RewardProgram extends PanacheEntity {

    public Double rewardsBudget;

}
