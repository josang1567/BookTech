package controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Author;
import model.Book;
import model.Character;
import model.DAO.AuthorDAO;
import model.DAO.BookDAO;

public class AddCharacterScreenController {
	private static EntityManager em;
	private static EntityManagerFactory emf;
	static String nullcamps = "";
	@FXML
	private TextField name;
	@FXML
	private TextField rol;
	@FXML
	private TextArea description;
	@FXML
	private ComboBox<Book> book;

	@FXML
	private void initialize() {

		/**
		 * hay que poner el autor por singleton
		 */
		Set<Book> allbooks = new BookDAO().getByAuthor(Author.get_Instance());
		ObservableList<Book> listBooks = FXCollections.observableArrayList(allbooks);
		book.setValue(listBooks.get(0));
		book.setItems(listBooks);
		if (allbooks.size() > 3) {
			book.setVisibleRowCount(3);
		}
	}

	@FXML
	private void Save() throws IOException {
		emf = Persistence.createEntityManagerFactory("aplicacionMariaDB");
		em = emf.createEntityManager();

		em.getTransaction().begin();

		if (!validateform())
			return;

		Character newcharacter = new Character();

		newcharacter.setName(name.getText());
		newcharacter.setRol(rol.getText());
		newcharacter.setCharacteristics(description.getText());
		newcharacter.getBooks().add(book.getValue());

		try {
			em.persist(newcharacter);
		} catch (Exception e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Alert");
			alert.setContentText("ERROR AL GUARDAR");
			alert.showAndWait();
		}
		alertInfo();

	}

	private boolean validateform() {
		boolean result = true;

		if (name.getText().trim().equals("")) {
			result = false;
			nullcamps += "Name\n";
		}
		if (rol.getText().trim().equals("")) {
			result = false;
			nullcamps += "Rol\n";
		}
		if (description.getText().trim().equals("")) {
			result = false;
			nullcamps += "Description\n";
		}
		if (result == false) {
			alert();
		}
		return result;
	}

	private void alert() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setHeaderText(null);
		alert.setTitle("Alert");
		alert.setContentText("Rellene todos los campos: " + nullcamps);
		alert.showAndWait();
	}

	private void alertInfo() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setTitle("Info");
		alert.setContentText("Character save");
		alert.showAndWait();
	}

}
