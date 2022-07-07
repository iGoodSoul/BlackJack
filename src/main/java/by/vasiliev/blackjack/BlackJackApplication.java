package by.vasiliev.blackjack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlackJackApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlackJackApplication.class, args);
        System.out.print("BlackJack Application started successfully");
    }

}