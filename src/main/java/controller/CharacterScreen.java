package controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Book;
import model.Character;
import model.DAO.CharacterDAO;

public class CharacterScreen {


    @FXML
    private TextField name_character;

    @FXML
    private TextArea features_character;
    
    @FXML
    private Button EXIT;

    @FXML
    private TextField rol_character;

    @FXML
	ListView<Character> charactersList;
    
    @FXML
	protected void initialize() {
		ObservableList<Character> listcharacter = FXCollections.observableArrayList(new CharacterDAO().getByBooks(Book.get_Instance()));
		charactersList.setItems(listcharacter);
		charactersList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			data(newValue);
		});
	}
	

	private void data(Character c) {
		if(c!=null) {
			name_character.setText(name_character.getText()+": "+c.getName());
			rol_character.setText(rol_character.getText()+": "+c.getRol());
			features_character.setText(features_character.getText()+": "+c.getCharacteristics());
			
		}else {
			name_character.setText(name_character.getText()+": ");
			rol_character.setText(rol_character.getText()+": ");
			features_character.setText(features_character.getText()+": ");
		}
		
	}
	
	@FXML
	private void exit() throws IOException {
		App.setRoot("mainScreen");
	}
	
}