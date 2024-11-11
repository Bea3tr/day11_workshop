package ssf.day11_workshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.security.SecureRandom;

@Controller
// GET / or GET /index.html
@RequestMapping
public class ImageOfTheDay {

    Random rand = new SecureRandom();

    @GetMapping(path={"/", "/index.html"})
    public String getImageIndex(Model model) {
        model.addAttribute("randImage", getPicture());
        return "image";
    }

    private String getPicture() {
        int idx = rand.nextInt(Constants.PICTURES.length);
        return "/images/%s".formatted(Constants.PICTURES[idx]);
    }
}