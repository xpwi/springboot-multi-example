package com.xiaopengwei.springboot.atomikos.config;

import java.sql.SQLException;
import java.util.HashMap;
import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlXADataSource;
import com.xiaopengwei.springboot.atomikos.repository.customer.CustomerDatasourceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import com.atomikos.jdbc.AtomikosDataSourceBean;

/**
 * <p>
 *   customer 端数据源 => 数据库 atomikos_one
 * </p>
 *
 * @author github.com/xpwi
 * @since 2019-04-09
 */
@Configuration
@DependsOn("transactionManager")
@EnableJpaRepositories(basePackages = "com.xiaopengwei.springboot.atomikos.repository.customer", entityManagerFactoryRef = "customerEntityManager", transactionManagerRef = "transactionManager")
@EnableConfigurationProperties(CustomerDatasourceProperties.class)
public class CustomerConfig {

	@Autowired
	private JpaVendorAdapter jpaVendorAdapter;

	@Autowired
	private CustomerDatasourceProperties customerDatasourceProperties;

	@Primary
	@Bean(name = "customerDataSource", initMethod = "init", destroyMethod = "close")
//	@Qualifier("customerDataSource")
	public DataSource customerDataSource() {
		MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
		mysqlXaDataSource.setUrl(customerDatasourceProperties.getUrl());
		try {
			mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		mysqlXaDataSource.setPassword(customerDatasourceProperties.getPassword());
		mysqlXaDataSource.setUser(customerDatasourceProperties.getUsername());
		try {
			mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
		xaDataSource.setXaDataSource(mysqlXaDataSource);
		xaDataSource.setUniqueResourceName("xads1");
		return xaDataSource;

	}

	@Primary
	@Bean(name = "customerEntityManager")
	@DependsOn("transactionManager")
	public LocalContainerEntityManagerFactoryBean customerEntityManager() {

		HashMap<String, Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.transaction.jta.platform", AtomikosJtaPlatform.class.getName());
		properties.put("javax.persistence.transactionType", "JTA");

		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		entityManager.setJtaDataSource(customerDataSource());
		entityManager.setJpaVendorAdapter(jpaVendorAdapter);
		entityManager.setPackagesToScan("com.xiaopengwei.springboot.atomikos.entity.customer");
		entityManager.setPersistenceUnitName("customerPersistenceUnit");
		entityManager.setJpaPropertyMap(properties);
		return entityManager;
	}

}
