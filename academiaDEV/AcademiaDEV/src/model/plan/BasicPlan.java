package model.plan;

public class BasicPlan implements SubscriptionPlan {
    @Override
    public boolean canEnroll(int currentEnrollments) {
        return currentEnrollments <= 3;
    }
}
