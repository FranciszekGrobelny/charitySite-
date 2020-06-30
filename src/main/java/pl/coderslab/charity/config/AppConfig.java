package pl.coderslab.charity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "pl.coderslab.charity.repository")
public class AppConfig {
}
