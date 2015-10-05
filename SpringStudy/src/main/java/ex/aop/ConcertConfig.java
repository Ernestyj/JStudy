package ex.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Jian on 2015/9/29.
 */
@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class ConcertConfig {
    @Bean
    public Audience audience(){
        return new Audience();
    }
}
