package jins.studyBackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
       // WebMvcConfigurer.super.addCorsMappings(registry); //cors 발생시켜준다.
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods(
                        HttpMethod.GET.name()
                        , HttpMethod.POST.name()
                        , HttpMethod.PUT.name()
                        , HttpMethod.DELETE.name()
                        , HttpMethod.OPTIONS.name() // 옵션(get~delete보다 사전실행되는것
                        , HttpMethod.PATCH.name() ); // 상태); //cors 다 열어준다.
    }
}
