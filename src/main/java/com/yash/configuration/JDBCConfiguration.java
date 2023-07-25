package com.yash.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@PropertySource({"classpath:db.properties","classpath:sql.properties","classpath:schema.sql","classpath:data.sql"})
public class JDBCConfiguration {
	@Bean("embedded")
	@Primary
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
			.generateUniqueName(false)
			.setName("springBootDB")
			.setType(EmbeddedDatabaseType.H2)
			//.addScript("schema.sql")
			//.addScript("data.sql")
			.setScriptEncoding("UTF-8")
			.ignoreFailedDrops(true)
			.build();
	}

}
