package com.mgmtp.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Tan Dat on 07/12/2016.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("com.mgmtp.configuration")
public class HibernateConfiguration {
}
