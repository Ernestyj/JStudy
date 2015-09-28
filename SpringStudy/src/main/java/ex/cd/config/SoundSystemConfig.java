package ex.cd.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Jian on 2015/9/28.
 */
@Configuration
//@Import({CDPlayerConfig.class, CDConfig.class})
@Import({CDPlayerConfig.class})
@ImportResource("classpath:cd_config.xml")
public class SoundSystemConfig {
}
