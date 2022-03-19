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
}
