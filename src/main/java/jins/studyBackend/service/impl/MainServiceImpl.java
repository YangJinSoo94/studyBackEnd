package jins.studyBackend.service.impl;

import jins.studyBackend.mapper.MainMapper;
import jins.studyBackend.service.MainService;
import jins.studyBackend.vo.MemberVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@Service
public class MainServiceImpl implements MainService {

    private MainMapper mainMapper;

    @Override
    public List<MemberVO> getUser(){
        System.out.println("getUser");
        return mainMapper.getUser();
    }
    @Override
    public void regiUser(MemberVO memberVO){
        System.out.println("regiUser");
        mainMapper.regiUser(memberVO);
    }

    @Override
    public void updateUser(MemberVO memberVO){
        System.out.println("updateUser");
        mainMapper.updateUser(memberVO);
    }

    @Override
    public void delUser(long id){
        System.out.println("delUser");
        mainMapper.delUser(id);
    }

    public HashMap getUserOne(long id){
        System.out.println("getUserOne");
        return mainMapper.getUserOne(id);
    }

    public int updateUser2(long id, MemberVO memberVO){
        memberVO.setId(id);
        return mainMapper.updateUser2(memberVO);
    }
}
