package jins.studyBackend.service;

import jins.studyBackend.vo.MemberVO;

import java.util.HashMap;
import java.util.List;

public interface MainService {

    public List<MemberVO> getUser();

    public void regiUser(MemberVO memberVO);

    public void updateUser(MemberVO memberVO);

    public void delUser(long id);

    public HashMap getUserOne(long id);
    
    public int updateUser2(long id, MemberVO memberVO);

    public String loginDo(MemberVO memberVO) throws Exception;
}
