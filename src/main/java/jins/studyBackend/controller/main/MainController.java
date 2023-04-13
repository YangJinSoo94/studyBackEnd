package jins.studyBackend.controller.main;

import jins.studyBackend.service.MainService;
import jins.studyBackend.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    // @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}) 도 사용가능
    @PostMapping(path = "/regiUser", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public Object regiUser( MemberVO memberVO){

        mainService.regiUser(memberVO);
        return mainService.getUser();
    }
/*
    @PutMapping("modUser")
    public int updateUser(){
        return 1;
    }

    @DeleteMapping("delUser")
    public int deleteUser(){
        return 1;
    }*/

}
