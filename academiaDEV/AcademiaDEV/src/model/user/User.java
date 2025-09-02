package model.user;

import java.util.UUID;

public abstract class User {
    protected UUID id;
    protected String name;
    protected String email;

    public User(String name, String email) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
    }

    public User(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public String getName() {
        return this.name;
    }

    public Object getId() {
        return this.id;
    }
}
