package springmvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by DCLab on 10/5/2015.
 */
@Configuration
@ComponentScan(basePackages={"springmvc"},
        excludeFilters={ @ComponentScan.Filter(type= FilterType.ANNOTATION, value=EnableWebMvc.class) })
public class RootConfig {
}
