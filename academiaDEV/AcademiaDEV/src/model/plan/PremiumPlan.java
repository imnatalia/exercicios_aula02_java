package model.plan;

public class PremiumPlan implements SubscriptionPlan {
    @Override
    public boolean canEnroll(int currentEnrollments) {
        // premium plan don't have limits
        return true;
    }
}
