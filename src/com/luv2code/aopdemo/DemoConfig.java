package com.luv2code.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy			//Spring AOP proxy support
@ComponentScan("com.luv2code.aopdemo")
public class DemoConfig {

}
