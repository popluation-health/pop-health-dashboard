package org.pophealth.service;

import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import org.pophealth.model.Reward;
import org.pophealth.model.RewardCategoryGroup;
import org.pophealth.model.RewardProgram;

@ApplicationScoped
public class RewardsService {

    private NumberFormat usd = NumberFormat.getCurrencyInstance(Locale.US);
    @Transactional
    public void createReward(Reward reward) {
        reward.persist();
    }

    @Transactional
    public void createProgram(RewardProgram program) {
        program.persist();
    }

    public List<Reward> getAllRewards() {
       return Reward.listAll();
    }

    public Double getTotalRewards(){

        List<Reward> rewards = Reward.listAll();

        Double rewardVal = 0.0;
        if(rewards!=null && !rewards.isEmpty()) {
            rewardVal = rewards.stream()
                    .mapToDouble(r -> r.getValue())
                    .sum();
        }
        return rewardVal;
    }

    public Integer getUnfufilledRewards() {
        List<Reward> rewards = Reward.list("fulfilled", false);
        return rewards !=null? rewards.size(): 0;
    }

    public  Map<String, Integer> getRewardCategories() {
        List<Reward> rewards = Reward.listAll();

        Map<String, List<Reward>> categories = new HashMap<>();
        if(rewards!=null && !rewards.isEmpty()) {
            categories = rewards.stream().collect(Collectors.groupingBy(Reward::getCategory));
        }

        Map<String, Integer> categoryCounts = new HashMap<>();
        categories.entrySet().stream().forEach((entry) -> categoryCounts.put(entry.getKey(), entry.getValue().size()));

        return categoryCounts;
    }

    //TODO
    public  List<RewardCategoryGroup> getValueByMonth() {

        List<Reward> rewards = Reward.list("order by rewardDate asc"  );
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM-yyyy");

        List<RewardCategoryGroup> groups = new ArrayList<>();

        if(rewards !=null) {
            for (Reward reward : rewards) {


            }
        }

        return groups;
    }

    public String getRewardsBudget(long id ){
        RewardProgram program = RewardProgram.find("id", id).firstResult();

        String programBudget = "";
        if(program!=null) {
            programBudget = usd.format(program.rewardsBudget);
        }

        return programBudget;
    }
}
