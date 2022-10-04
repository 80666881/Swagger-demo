package com.zeller.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration //配置类
@EnableSwagger2 // 开启Swagger2的自动配置
public class SwaggerConfig {

    @Bean //配置docket以配置Swagger具体参数
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()// 通过.select()方法，去配置扫描接口,RequestHandlerSelectors 配置如何扫描接口
                .apis(RequestHandlerSelectors.basePackage("com.zeller.swagger.controller"))
                .paths(PathSelectors.ant("/mall/**"))
                .build();
    }

    @Bean
    public Docket docket1() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("group1");
    }
    @Bean
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("group2");
    }
    @Bean
    public Docket docket3() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("group3");
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact(
                "联系人A",
                "http://xxx.xxx.com/联系人 访问链接",
                "联系人邮箱");
        return new ApiInfo(
                "Swagger学习",
                "学习如何配置描述",
                "v1.0",
                "http://temrs.service.url组织链接",
                contact,
                "Apach2.0许可",
                "许可链接",
                new ArrayList<>()
        );
    }

}