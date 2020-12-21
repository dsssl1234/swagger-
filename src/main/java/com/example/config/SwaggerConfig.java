package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2 //开启Swagger2
public class SwaggerConfig {

    @Bean
    public Docket docket1(Environment environment){
        //修改组名，如果要配置多个组，则创建多个docket，然后也需要维护下面这些信息
        return new Docket(DocumentationType.SWAGGER_2).groupName("测试2");
    }

    //配置了swagger的Docket实例
    @Bean
    public Docket docket(Environment environment){
        //设置要显示的swagger环境
        Profiles profiles =Profiles.of("dev","test");
        //通过environment来判断是否是在上面的这个两个环境，在把这个boolean放在enable中
        boolean b = environment.acceptsProfiles(profiles);
        //进入到Docket的构造方法，可以看到传入了DocumentationType，在进入DocumentationType，可以发现有三个参数
        //其中就有一个SWAGGER_2，直接拿过来实例化。
        //为什么要用apiInfo这个方法，还是到Docket的构造方法，第一行中调用的是就是
        // this.apiInfo = ApiInfo.DEFAULT;因为是默认的，我们需要替换他，换成我们自己的
        return  new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .groupName("测试组")
                //是否开启swagger，默认为true，若为false，则不能在网页中访问
                .enable(true)
                //select和build是一个组合
                .select()
                //RequestHandlerSelectors配置要扫描的接口方式
                // basePackage：指定要扫描的包
                //any():扫描全部  none():不扫描
                //withClassAnnotation()扫描类上的注解，参数是一个注解的反射对象
                //withMethodAnnotation()扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
                //paths:过滤路径
//                .paths(PathSelectors.ant("/com.**"))
                .build();
    }
    //配置swagger信息，需要一个apiInfo类
    private ApiInfo apiInfo(){
        //到这个ApiInfo源码中，可以找到只有一个构造方法，最底下有一个默认的实例方法，直接复制
        //我们现在做的就是修改他原本的默认配置，并且直接复制的话，DEFAULT_CONTACT会爆红，到
        //源码去可以找到对应的对象
        Contact DEFAULT_CONTACT = new Contact("", "", "");//存的是作者信息
        return new ApiInfo(
                "这是一个标题",
                "这是详情描述",
                "1.0",
                "urn:tos",
                DEFAULT_CONTACT, "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());

    }

}
