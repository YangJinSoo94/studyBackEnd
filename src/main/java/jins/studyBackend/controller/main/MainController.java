package jins.studyBackend.controller.main;

import jins.studyBackend.service.MainService;
import jins.studyBackend.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Object regiUser(MemberVO memberVO){

        mainService.regiUser(memberVO);
        return mainService.getUser();
    }

    @PutMapping("updateUser")
    public Object updateUser(MemberVO memberVO){
        try{
            mainService.updateUser(memberVO);
        }catch (Exception e){
            e.printStackTrace();;
        }
        return mainService.getUser();
    }

    @DeleteMapping("/delUser")
    public Object delUser(MemberVO memberVO){

        mainService.delUser(memberVO.getId());
        return mainService.getUser();
    }

    /**
     * get방식?
     *  @DeleteMapping("/delUser/{id}")
     *  public Object delUser(@PathVariable int id){
     *      mainService.delUser(id);
     *      return mainService.getUser();
     *  }
     */

}
