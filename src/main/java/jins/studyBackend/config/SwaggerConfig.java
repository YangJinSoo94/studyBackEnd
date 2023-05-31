package jins.studyBackend.config;

import io.jsonwebtoken.Header;
import org.checkerframework.checker.units.qual.A;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // Docket : 웹 페이지를 생성하는 객체
    @Bean
    public Docket makeDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                // 순서는 지켜야한다.
                .select()
                .apis(RequestHandlerSelectors.basePackage("jins.studyBackend"))
                .paths(PathSelectors.any())
                .build()
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("api info hahahaha")
                .description("this is apiinfo")
                .version("0.1")
                .build();
    }

    private SecurityContext securityContext(){
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth(){
        // 권한에 대한 범위를 설정
        // 보통은 global로 하고 post의 body에 인증가능한 값들을 추가로 인증하는 절차를 채택
        // global : 모든 api에 jwt 형태로 생성할것이다.
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverthing");

        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        //refuerence : 샘플 개념으로 이해
        return Arrays.asList(new SecurityReference(Header.JWT_TYPE, authorizationScopes));
    }

    private ApiKey apiKey(){
        return new ApiKey(Header.JWT_TYPE, HttpHeaders.AUTHORIZATION, "header");
    }
}
