package jins.studyBackend.dao;

import jins.studyBackend.vo.MemberVO;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository("mainDAO")
public class MainDAO {
    private SqlSession mapper;

    public Select.List getUser(){
        return (LList<MemberVO>) mapper.selectList("mainMapper.getUser");
    }
}
