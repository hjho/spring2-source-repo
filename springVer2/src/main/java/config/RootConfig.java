package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"config"})
@ComponentScan(basePackages= {"com.kosmo.ver"})
@ComponentScan(basePackages= {"mvc.board"})
@ComponentScan(basePackages= {"transact.aution"})
public class RootConfig {

}
