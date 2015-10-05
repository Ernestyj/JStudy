package ex.ioc.config;

import ex.ioc.CDPlayer;
import ex.ioc.CompactDisc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Jian on 2015/9/28.
 */
@Configuration
//@ComponentScan
public class CDPlayerConfig {
    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc){
        return new CDPlayer(compactDisc);
    }
}
