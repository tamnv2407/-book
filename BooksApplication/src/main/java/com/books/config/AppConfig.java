package com.books.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * AppConfig config required bean for application
 * @author tamnv
 *
 */
@Configuration
@PropertySources({ @PropertySource(value = "sql/sql-book.properties"),
		@PropertySource(value = "sql/sql-user.properties") })
public class AppConfig{

	/**
	 * PasswordEncoder object to encode and compare password
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}