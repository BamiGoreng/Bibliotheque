
package fr.ldnr.formation.groupe3.bibliotheque;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import fr.ldnr.formation.groupe3.bibliotheque.controller.ServiceEmprunt;
import fr.ldnr.formation.groupe3.bibliotheque.controller.ServiceLivre;
import fr.ldnr.formation.groupe3.bibliotheque.model.Emprunt;
import fr.ldnr.formation.groupe3.bibliotheque.model.Livre;

/**
 * Classe main de l'application bibliothèque
 * 
 * @author groupe 3
 *
 */
@SpringBootApplication
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
		logger.info("Application Bibliothèque démarrée");
	}

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setViewClass(JstlView.class);
		vr.setPrefix("/WEB-INF/vues/"); // lieu de stockage de JSP scanné par l'application
		vr.setSuffix(".jsp"); // format de fichiers recherchés
		return vr;
	}

	@Bean
	public SessionFactory getSessionFactory() {
		Properties options = new Properties();
		options.put("hibernate.dialect", "org.sqlite.hibernate.dialect.SQLiteDialect");
		options.put("hibernate.connection.driver_class", "org.sqlite.JDBC");
		options.put("hibernate.connection.url", "jdbc:sqlite:bibliotheque.sqlite");
		options.put("hibernate.hbm2ddl.auto", "update"); // TODO : changer la methode pour générer une table au
															// lancement
		options.put("hibernate.show_sql", "true");
		SessionFactory sf = new Configuration().addProperties(options).addAnnotatedClass(Livre.class)
				.addAnnotatedClass(Emprunt.class).buildSessionFactory();
		return sf;
	}
}
