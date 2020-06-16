package com.volsu.UI.config;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
@ComponentScan(basePackages = "com.volsu.UI")
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Value("${baseUrl}")
    private String baseUrl;

    @Value("${baseTimeout}")
    private int baseTimeout;

    @Bean(name = "webDriver")
    public WebDriver webDriver() {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "/src/main/resources/chromedriver.exe");
        return new ChromeDriver();
    }
}