package com.lanshen.inspection.dianjian;

import com.lanshen.inspection.common.feign.annotation.EnableInspectionFeignClients;
import com.lanshen.inspection.common.security.annotation.EnableInspectionResourceServer;
import com.lanshen.inspection.common.swagger.annotation.EnableOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author archetype auto
 * <p>
 * 项目启动类
 */
@EnableOpenApi("dianjian")
@EnableInspectionFeignClients
@EnableDiscoveryClient
@EnableInspectionResourceServer
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
