package jins.studyBackend.service;

import jins.studyBackend.vo.MemberVO;

import java.util.HashMap;
import java.util.List;

public interface MainService {

    public List<MemberVO> getUser();

    public void regiUser(MemberVO memberVO);

    public void updateUser(MemberVO memberVO);

    public void delUser(String id);

    public HashMap getUserOne(String id);
    
    public int updateUser2(String id, MemberVO memberVO);

    public String loginDo(MemberVO memberVO) throws Exception;

    public boolean authToken(String token);
}
