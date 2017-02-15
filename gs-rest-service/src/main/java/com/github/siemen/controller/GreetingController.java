package com.github.siemen.controller;

import com.github.siemen.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Zhan on 2017/2/15 0015.
 */
@RestController
public class GreetingController {
    private final String template = "Hello,%s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name",defaultValue = "world") String name){

        return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }
}
