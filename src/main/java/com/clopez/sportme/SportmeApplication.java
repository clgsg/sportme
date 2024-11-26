package com.clopez.sportme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.clopez.sportme.models.*"})
public class SportmeApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SportmeApplication.class, args);

		/*EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("sportme");
			EntityManager em = emf.createEntityManager();

			// Iniciar transacción
			em.getTransaction().begin();

			// Crear objetos usando el constructor vacío
			Usuario usuario = new Usuario();
			usuario.setApodo("transparentNick");
			usuario.setNombre("Nicolás");
			usuario.setPrimerApellido("López");
			usuario.setSegundoApellido("Martínez");

			// Crear objetos con constructor completo
			Usuario fontainebleau = new Usuario("fonainebleau", "José", "Jaraiz", "Jota");

			// Persistir los registros
			em.persist(usuario);
			em.persist(fontainebleau);

			// Modificar un usuario
			fontainebleau.setSegundoApellido("Juárez");

			// confirmar transacción y enteidades
			em.getTransaction().commit();

			// cerrar em y efm
			em.close();
			emf.close();

		} catch (PersistenceException e) {
			System.out.println("Error de persistencia: " + e.getMessage());
		} finally {
			if (em != null) {
				if (em.getTransaction().isActive())
					em.getTransaction().rollback();
				em.close();
			}
			if (emf != null)
				emf.close();
		}
		System.out.println("Prueba finalizada");*/

	}
}
