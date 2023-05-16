package jins.studyBackend.mapper;

import jins.studyBackend.vo.MemberVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.HashMap;
import java.util.List;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class mapperTest {
    @Autowired
    MainMapper mainMapper;

    @Test
    @DisplayName("mapper test")
    void MapperTest() throws Exception{
        System.out.println("test started");
        List user = mainMapper.getUser();
        System.out.println("test : "+user);
    }

    @Test
    void postTest() throws Exception{
        System.out.println("post user");
        MemberVO memberVO = new MemberVO();
        memberVO.id = "50";
        memberVO.name = "알리바바";
        memberVO.pw = "12345";
        memberVO.age = 100;
        memberVO.phone = "1234";
        memberVO.email = "www@www.www";

        mainMapper.regiUser(memberVO);
    }

    @Test
    void putTest() throws Exception{
        System.out.println("put user");
        MemberVO memberVO = new MemberVO();
        memberVO.id = "10";
        memberVO.age = 10;

        mainMapper.updateUser(memberVO);
    }

    @Test
    void delTest() throws Exception{
        System.out.println("del user");
        MemberVO memberVO = new MemberVO();
        String id = "2";
        mainMapper.delUser(id);
    }
}
