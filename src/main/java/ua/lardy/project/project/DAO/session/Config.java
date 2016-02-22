package ua.lardy.project.project.DAO.session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурационный класс. Класс для получения объекта сессии обменна данными с реляционными таблицам.
 * @author Sinyak D.V.
 * @version 1.0
 */
@Configuration
public class Config {

    /**
     * Метод предназначен возвращать сессию доступа к базам данных.
     * @return Возвращает объект сессии.
     */
    @Bean
    public SessionFactory sessionFactory(){
        return new AnnotationConfiguration().configure().buildSessionFactory();
    }
}
