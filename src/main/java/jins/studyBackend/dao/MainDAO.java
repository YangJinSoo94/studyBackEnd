package jins.studyBackend.dao;

import jins.studyBackend.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MainDAO {
    public List<MemberVO> getUser();

    public void regiUser(MemberVO memberVO);
}
