package kz.iitu.alikhan.petshelter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("kz.iitu.alikhan.petshelter")
@PropertySource("application.properties")
public class SpringConfiguration {

}
