package com.kata.clientprofileauthentication.configuration;

import java.util.Properties;
import com.kata.clientprofileauthentication.models.auth.InputFormAndAuthentication;
import com.kata.clientprofileauthentication.repository.secureRepository.SecureRepository;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 * класс конфигурации для подключения к postgresql
 */
@Configuration
@Slf4j
public class ConfigurationPostgresql {
    @Value("${datasource.url}")
    private String URL;
    @Value("${datasource.driver-class-name}")
    private String driver;
    @Value("${datasource.username}")
    private String username;
    @Value("${datasource.password}")
    private String password;
    @Value("${hibernate.ddl-auto}")
    private String hbm2ddl;
    @Value("${hibernate.show_sql}")
    private String show_sql;
    @Value("${datasource.scan}")
    private String packageScan;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(URL);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(packageScan);
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(hibernateProperties());
        return em;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", hbm2ddl);
        properties.setProperty("hibernate.show_sql", show_sql);
        return properties;
    }
    /**
     * тестовый метод для создание 2ух пользаков в бд
     * @param repo - создание дефолтной бд с двумя пользаками для тестов
     * @return - //
     */
    @Bean
    public CommandLineRunner commandLineRunner2(SecureRepository repo) {
        return args -> {
            InputFormAndAuthentication inp1 = new InputFormAndAuthentication(12L,"Андрей","Андреев",
                    "Андреевич","Andy@mail.ru", "ООО \"Все ужасно!\"",
                    "По приколу", "Andrei_ovseuzhasno@client.centre",
                    "$2a$10$YLpavfhdEvGD8uazoxeIZ.rGfItuszdmr9Q3ny/appvxmEK9OdpJO",false);
            /**
             * пароль b7b0FYtgA7
             */
            InputFormAndAuthentication inp2 = new InputFormAndAuthentication(13L,"Олег","Тиньков",
                    "Олегович","Tinkoff@mail.ru", "ООО \"ТинькоффИнвстишн!\"",
                    "Я так чувствую", "Oleg_otinkofvssh@client.centre",
                    "$2a$10$VyfLahfGmhQq9tSrsUI4MuIV5LXGQXm1wMmAwe.1DJ.Z10g3v3HcK", false);
            /**
             * пароль sn3zLiIo5zhra
             */
            repo.deleteAll();
            repo.save(inp1);
            repo.save(inp2);
            log.info("Создание тестовых пользоватлей");
        };
    }
}
