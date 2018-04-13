package org.lab2.authorization;


public class AuthForm {

    private final String authType;
    private final User user;


    public AuthForm(String authType, User user) {
        this.authType = authType;
        this.user = user;
    }

    public String getAuthType() {
        return authType;
    }

    public User getUser() {
        return user;
    }
}
