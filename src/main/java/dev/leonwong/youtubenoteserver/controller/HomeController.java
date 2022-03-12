package dev.leonwong.youtubenoteserver.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String getHomePage() {
        return "<h1>Youtube note server</h1>";
    }

    @GetMapping("/test")
    @ResponseBody
    public HashMap<String, Object> sayHello() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("key1", "Hello World");
        map.put("results", 12);
        return map;
    }

    @GetMapping("/fibo/{n}")
    @ResponseBody
    public String getFibo(@PathVariable int n) throws InterruptedException {
        AtomicInteger result = new AtomicInteger();
        Thread t1 = new Thread(() -> {
            result.set(fibo(n));
        });
        t1.start();
        System.out.println(fibo(10));
        t1.join();
        return String.valueOf(result.get());
    }

    private int fibo(int n) {
        if (n < 2)
            return 1;
        else return fibo(n - 2) + fibo(n - 1);
    }
}
