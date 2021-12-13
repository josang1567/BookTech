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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Author;
import model.Book;
import model.Character;
import model.DAO.AuthorDAO;
import model.DAO.BookDAO;
import model.DAO.CharacterDAO;
import util.AlertControl;

public class AddCharacterController {
    @FXML
    private TextField NAME_addCharacter;

    @FXML
    private ComboBox<Book> CBbook_addCharacter;
    

    @FXML
    private Button EXIT;

    @FXML
    private Button btn_addCharacter;

    @FXML
    private TextArea description_addCharacter;

    @FXML
    private TextField rol_addCharacter;
    
    
    private static EntityManager em;
	private static EntityManagerFactory emf;
	static String nullcamps = "";

	@FXML
	private void initialize() {

		/**
		 * hay que poner el autor por singleton
		 */
		List<Book> allbooks = new BookDAO().getByAuthor(Author.get_Instance());
		ObservableList<Book> listBooks = FXCollections.observableArrayList(allbooks);
		CBbook_addCharacter.setValue(listBooks.get(0));
		CBbook_addCharacter.setItems(listBooks);
		if (allbooks.size() > 3) {
			CBbook_addCharacter.setVisibleRowCount(3);
		}
	}

	@FXML
	private void Save() throws IOException {

		if (!validateform())
			return;

		Character newcharacter = new Character();
		CharacterDAO cda= new CharacterDAO();
		newcharacter.setName(NAME_addCharacter.getText());
		newcharacter.setRol(rol_addCharacter.getText());
		newcharacter.setCharacteristics(description_addCharacter.getText());
		newcharacter.getBooks().add(CBbook_addCharacter.getValue());

		try {
			cda.save(newcharacter);
		} catch (Exception e) {
			AlertControl.mensajeError("Error", "Error al guardar el personaje");
		}
		AlertControl.mensajeAdvertencia("Okey", "Personaje Guardado");

	}

	private boolean validateform() {
		boolean result = true;

		if (NAME_addCharacter.getText().trim().equals("")) {
			result = false;
			nullcamps += "Name\n";
		}
		if (rol_addCharacter.getText().trim().equals("")) {
			result = false;
			nullcamps += "Rol\n";
		}
		if (description_addCharacter.getText().trim().equals("")) {
			result = false;
			nullcamps += "Description\n";
		}
		if (result == false) {
			AlertControl.mensajeError("Error", "Error al guardar el personaje");
		}
		return result;
	}

	
	@FXML
	private void exit() throws IOException {
		App.setRoot("mainScreen");
	}

}





