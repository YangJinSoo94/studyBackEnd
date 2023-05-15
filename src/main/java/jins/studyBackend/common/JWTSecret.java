package jins.studyBackend.common;

import com.google.gson.Gson;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jins.studyBackend.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

@Slf4j        // 로그
@Component    // 빈을 생성하기 위한 스프링 어노테이션 [자체적인 객체]
public class JWTSecret {
    private static final int MINUTES = 24*60*60*1000;
    KeyPair keyPair;
    Key publicKey;
    Key privateKey;

    // component가 생성할 때마다 키를 새로 생성하고 public key와 private key를 뽑아온다.
    public JWTSecret() throws NoSuchAlgorithmException {
        keyPair = KeyPairGenerator.getInstance(SignatureAlgorithm.RS256.getFamilyName()).genKeyPair();
        publicKey = keyPair.getPublic();
        privateKey = keyPair.getPrivate();
    }

    // 토큰생성
    public String makeJwtToken(MemberVO memberVO){
        Date now = new Date();

        Date expireDate = new Date(now.getTime() + MINUTES);
        log.debug("now : "+now.toString());
        log.debug("expireDate : "+expireDate.toString());
        return Jwts.builder()
                // 헤더부분
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                // 보통서버명 혹은 사용자명
                .setIssuer("보통은 서버명을 넣는다.")
                .setIssuedAt(now)
                // 만료일자
                .setExpiration(expireDate)
                // PAYLOAD
                .claim("user_id", memberVO.id)
                .claim("user_name", memberVO.name)
                // 해시생성
                .signWith(privateKey, SignatureAlgorithm.RS256)
                .compact();
    }

    public void parseJwtToken(String token){
        Jwt jwt = Jwts.parserBuilder().setSigningKey(publicKey).build().parse(token);
        log.debug("is sign : "+new Gson().toJson(jwt.getBody()));
    }
}
