package com.movie;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
//(exclude={SecurityAutoConfiguration.class})
//(exclude=DataSourceAutoConfiguration.class)
@EnableJpaAuditing
public class MovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}



	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
//	
//	@Primary
//	 @Bean(name = "dataSource")
//	 @ConfigurationProperties(prefix = "spring.datasource")
//	 public DataSource getDataSource() {
//	      return DataSourceBuilder.create().build();
//	 }
//
//	 @Bean
//	 public JdbcTemplate jdbcTemplate(DataSource dataSource) {
//	      return new JdbcTemplate(dataSource);
//	 }
}
