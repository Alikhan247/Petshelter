package kz.iitu.alikhan.petshelter.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Component
public class Database {
    @Value("${database.url}")
    private String url;
    @Value("${database.user}")
    private String username;
    @Value("${database.password}")
    private String password;
    @Value("${database.driver}")
    private String driver;

    private DriverManagerDataSource driverManagerDataSource;

    @PostConstruct
    public void init(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(url);
        driverManagerDataSource.setUsername(username);
        driverManagerDataSource.setPassword(password);
        driverManagerDataSource.setDriverClassName(driver);
        this.driverManagerDataSource = driverManagerDataSource;
    }

    public DataSource getDataSource(){
        return this.driverManagerDataSource;
    }

}
