package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Author;
import model.Book;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * JavaFX App
 */
public class App extends Application {

	private static Scene scene;

	@Override
	public void start(Stage stage) throws IOException {
		scene = new Scene(loadFXML("mainScreen"));
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}

	static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}

	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}

	public static void main(String[] args) {
		/*
		EntityManager em;
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("aplicacionMariaDB");
		em = emf.createEntityManager();
		em.getTransaction().begin();

		Author au = new Author("AutorPrueba", "prueba.org", "prueba@prueba.org", "passprueba");
		Book bu = new Book("libroPrueba", au);
		bu.setAuthor(au);
		em.persist(au);
		em.persist(bu);

		em.getTransaction().commit();
		*/
		launch();
	}

}