// src/main/java/com/ganicar/carinventory/HomeController.java
package com.ganicar.carinventory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "forward:/index.html";
    }
}