package at.markus;

import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Main {

    public static void main(String[] args) {
        JDABuilder jdaBuilder = JDABuilder.createDefault("ODEwOTU0NjU3MjUzOTQ5NDYx.YCrKYQ.PglxChGQSmyptkcFVaQc1RjlufE").addEventListeners(new Listener());
        try {
            jdaBuilder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
