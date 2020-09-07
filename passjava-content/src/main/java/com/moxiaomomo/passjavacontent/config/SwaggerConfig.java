package com.moxiaomomo.passjavacontent.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author moguang
 * @version 2018/9/20
 * @description: SwaggerConfig
 */
@Configuration
@ConditionalOnProperty(prefix = "swagger", value = { "enable" }, havingValue = "true")
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        System.out.println("=====initial swagger(api)======");
        return new Docket(DocumentationType.SWAGGER_2)
//                // 指定当前服务的host
//                .host("taccountapi.xxx.com:443").forCodeGeneration(true)
                // 指定package下生成API文档
                .select().apis(RequestHandlerSelectors.basePackage("com.moxiaomomo.passjavacontent.controller"))
                // 过滤生成链接
                .paths(PathSelectors.any()).build().apiInfo(apiInfo());
    }

    // api接口作者相关信息
    private ApiInfo apiInfo() {
        System.out.println("=====initial swagger(apiInfo)======");
        Contact contact = new Contact("moguang", "", "809444138@qq.com");
        ApiInfo apiInfo = new ApiInfoBuilder().license("Apache License Version 2.0").title("xx test server")
                .description("接口文档").contact(contact).version("1.0").build();
        return apiInfo;
    }
}
