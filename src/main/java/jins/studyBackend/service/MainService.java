package jins.studyBackend.service;

import jins.studyBackend.dao.MainDAO;
import jins.studyBackend.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MainService {

    public List<MemberVO> getUser();

    public void regiUser(MemberVO memberVO);
}
