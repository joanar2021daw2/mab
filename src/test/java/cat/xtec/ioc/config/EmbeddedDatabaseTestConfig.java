package cat.xtec.ioc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import org.springframework.context.annotation.Import;

/*
@EnableTransactionManagement habilita la capacitat de gestionar les
transaccions amb la BD.
@PropertySource(value = {“classpath:application-test.properties”}) 
permet definir propietats a un fitxer de propietats que serà accessible
a través del component injectat Environment. 
*/

@Configuration
@EnableTransactionManagement
@PropertySource(value = {"classpath:application-test.properties"})
//@PropertySource(value = {"classpath:jdbc.properties", "classpath:hibernate.properties"})
@Import(value = {HibernateConfiguration.class, DAOConfig.class})

public class EmbeddedDatabaseTestConfig {

    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.H2).build();
        return db;
    }

}
