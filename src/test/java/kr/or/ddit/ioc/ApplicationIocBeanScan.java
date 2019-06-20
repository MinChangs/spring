package kr.or.ddit.ioc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//defaultFilters : @Configuration, @Service, @Repository, @Component
//useDefaultFilters 를 false로 선언하면 개발자가 원하는 어노테이션만 스캔가능 
// ex : @Component만 스캔
@Configuration
@ComponentScan(basePackages = {"kr.or.ddit"}, useDefaultFilters = true)
public class ApplicationIocBeanScan {

}
