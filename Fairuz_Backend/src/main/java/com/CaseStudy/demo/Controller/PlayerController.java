package com.CaseStudy.demo.Controller;
import com.CaseStudy.demo.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping
    public String getAllPlayers() {
        return "Returning All Players";
    }
    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id) {
        return "Returning user with Id " + id;
    }


}

