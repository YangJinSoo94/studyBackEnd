package jins.studyBackend.controller.main;

import jins.studyBackend.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/getUser")
    public Object getUser() {
        System.out.println("getUser do");
        return mainService.getUser();
    }
    @PostMapping("/regiUser")
    public int regiUser(){
        return 1;
    }

    @PutMapping("modUser")
    public int updateUser(){
        return 1;
    }

    @DeleteMapping("delUser")
    public int deleteUser(){
        return 1;
    }

}
