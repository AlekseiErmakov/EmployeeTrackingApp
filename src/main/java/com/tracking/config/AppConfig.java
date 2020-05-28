package com.tracking.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.tracking")
@EnableWebMvc
@Import({WebSecurityConfig.class, WebConfig.class, HibernateConfig.class, MvcConfig.class, MapConfig.class})
public class AppConfig {
}
