package devs.moigorod.RegisterLogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collection;
import java.util.Collections;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableSwagger2
public class RegisterLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegisterLoginApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/v1/*"))
                .apis(RequestHandlerSelectors.basePackage("devs.moigorod.RegisterLogin"))
                .build()
                .apiInfo(apiCustomData());
    }

    private ApiInfo apiCustomData(){
        return new ApiInfo(
                "Moi gorod API Application",
                "Reg&Login",
                "1.0",
                "Register",
                new Contact("Moi gorod", "https://makers.kg",
                        "contact@gmail.com"),
                "Think Wisely",
                "https://makers.kg",
                Collections.emptyList()
        );

    }
}
