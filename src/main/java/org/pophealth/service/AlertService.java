package org.pophealth.service;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import org.pophealth.model.Alert;

@ApplicationScoped
public class AlertService {

    @Transactional
    public void createAlert(Alert alert) {
        alert.persist();
    }

    @Transactional
    public List<Alert> getAllAlerts() {
        return Alert.listAll();
    }



}
