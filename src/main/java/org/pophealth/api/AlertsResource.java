package org.pophealth.api;

import java.util.List;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.pophealth.model.Alert;

@Path("/alerts")
public class AlertsResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String addAlerts(List<Alert> alerts) {
        return "hello";
    }
}
