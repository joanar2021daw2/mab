package cat.xtec.ioc.config;

/**
 *
 * @author JoseAndrade
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@PropertySource(value = {"classpath:jdbc.properties", "classpath:hibernate.properties"})
@Import(value = {HibernateConfiguration.class})
public class HibernateMysqlConfiguration {

    @Autowired
    private Environment environment;

    //Configuració especifica per connectar amb la BD MySQL
    
    //Data source es lúnic que es modifica per cambiar la BD que volem utilitzar,
    //i ho fem a @PropertySource, propietats de la DB i d'hibernate
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }

}
