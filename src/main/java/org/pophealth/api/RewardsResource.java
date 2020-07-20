package org.pophealth.api;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.pophealth.model.Reward;

@Path("/rewards")
public class RewardsResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String addRewards(List<Reward> rewards) {
        return "hello";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reward> getRewards(List<Reward> rewards) {
        return new ArrayList<>();
    }

    
}
