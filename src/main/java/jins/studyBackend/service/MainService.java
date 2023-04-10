package jins.studyBackend.service;

import jakarta.annotation.Resource;
import jins.studyBackend.dao.MainDAO;
import jins.studyBackend.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {

    @Resource(name="mainDAO")
    private MainDAO mainDAO;

    public List<MemberVO> getUser() {
        return mainDAO.getUser();
    }

    public int regiUser(){
        return 1;
    }

    public int updateUser(){
        return 1;
    }

    public int deleteUser(){
        return 1;
    }
}
