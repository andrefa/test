package org.fiveware.web.cfg;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "org.fiveware.service", "org.fiveware.model"})
public class RootConfig {

}