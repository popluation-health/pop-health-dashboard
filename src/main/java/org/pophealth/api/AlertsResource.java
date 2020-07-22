package org.pophealth.api;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.pophealth.model.Alert;
import org.pophealth.service.AlertService;

@Path("/alerts")
public class AlertsResource {

    @Inject
    AlertService alertService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addAlerts(List<Alert> alerts) {
        alerts.stream().forEach(alert -> alertService.createAlert(alert));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Alert> getAlerts() {
//
//        for(int i=0;i<20;i++) {
//            Alert test = new Alert();
//            test.setAlertName("Weight");
//            test.setAlertType("INFO");
//            test.setOpen(true);
//            test.setSeverity("high");
//
//            alertService.createAlert(test);
//        }

        return alertService.getAllAlerts();
    }
}
