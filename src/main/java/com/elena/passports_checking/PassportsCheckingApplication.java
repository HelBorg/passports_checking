package com.elena.passports_checking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
public class PassportsCheckingApplication {

    public static void main(String[] args) {
        SpringApplication.run(PassportsCheckingApplication.class, args);
        try {
            ElasService service = new ElasService();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
