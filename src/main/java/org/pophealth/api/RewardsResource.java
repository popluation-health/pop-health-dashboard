package org.pophealth.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.pophealth.model.Reward;
import org.pophealth.service.RewardService;

@Path("/rewards")
public class RewardsResource {

    @Inject
    RewardService rewardService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addRewards(List<Reward> rewards) {
        rewards.stream().forEach(reward -> rewardService.createReward(reward));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reward> getRewards() {

        List<Reward> testRewards = new ArrayList<>();

//        for(int i =0;i<20;i++){
//            Reward test = new Reward();
//            test.setCategory("Steps");
//            test.setFulfilled(false);
//            test.setRewardName("3k Steps");
//            test.setValue(100.0-i);
//            testRewards.add(test);
//            rewardService.createReward(test);
//        }

        return rewardService.getAllRewards();
    }

    @GET
    @Path("/totalRewards")
    @Produces(MediaType.APPLICATION_JSON)
    public Double getTotalRewards() {
        return rewardService.getTotalRewards();
    }

    @GET
    @Path("/unfufilled")
    @Produces(MediaType.APPLICATION_JSON)
    public Integer getUnfufilledRewards() {
        return rewardService.getUnfufilledRewards();
    }

    @GET
    @Path("/categoryCounts")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Integer> getCategoryCounts() {
        return rewardService.getRewardCategories();
    }

}
