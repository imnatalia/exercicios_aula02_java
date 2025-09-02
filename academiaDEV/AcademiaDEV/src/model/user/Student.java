package model.user;

import model.plan.SubscriptionPlan;

public class Student extends User {
    private SubscriptionPlan subscriptionPlan;

    public Student(String name, String email) {
        super(name, email);
    }

    public Student(String email, SubscriptionPlan subscriptionPlan) {
        super(email);
        this.subscriptionPlan = subscriptionPlan;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    public SubscriptionPlan getSubscriptionPlan() {
        return subscriptionPlan;
    }
}
