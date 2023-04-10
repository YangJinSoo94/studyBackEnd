package jins.studyBackend.service.impl;

import ch.qos.logback.core.CoreConstants;
import jins.studyBackend.dao.MainDAO;
import jins.studyBackend.service.MainService;
import jins.studyBackend.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;

@Service
public class MainServiceImpl implements MainService {

    @Autowired
    private MainDAO mainDAO;

    @Override
    public List<MemberVO> getUser(){
        System.out.println("test");
        return mainDAO.getUser();
    }
}
