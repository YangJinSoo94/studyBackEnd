package jins.studyBackend.mapper;

import jins.studyBackend.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface MainMapper {
    public List<MemberVO> getUser();

    public void regiUser(MemberVO memberVO);

    public void updateUser(MemberVO memberVO);

    public void delUser(long id);

    // 강의
    HashMap getUserOne();

    int updateUser2(MemberVO memberVO);
}
