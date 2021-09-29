package com.emse.spring.faircorp.hello;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class DummyUserService implements UserService {
    private final GreetingService greeting;

    public DummyUserService(GreetingService greeting) {
        this.greeting = greeting;
    }

    @Override
    public void greetAll() {
        List<String> liste = new ArrayList<>();
        liste.add("Elodie");
        liste.add("Charles");
        for (String str:liste){
            greeting.greet(str);
        }
    }
}
