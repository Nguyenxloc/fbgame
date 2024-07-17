package com.example.java4.RestControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("flappy-bird")
public class FlappyBirdController {
    @GetMapping("")
    public String hienThi() {
        return "/flappyBird/index.jsp";
    }
}
