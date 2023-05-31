package jins.studyBackend.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//2023.05.31 Swagger에 설명 넣는 어노테이션
@ApiModel("유저vo")
public class MemberVO {

    // 2023.05.31 Swagger에 설명 넣는 어노테이션
    @ApiModelProperty("아이디")
    public String id;
    public String pw;
    public String name;
    public Integer age;
    public String email;
    public String phone;
}
