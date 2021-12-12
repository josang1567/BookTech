package controller;

import java.util.Set;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Book;
import model.Character;
import model.DAO.CharacterDAO;

public class CharacterScreenController {
		@FXML
		private TextField name;
		@FXML
		private TextField rol;
		@FXML 
		TextArea description;
		@FXML
		ListView<Character> charactersList;
		
		
		@FXML
		protected void initialize() {
			Set<Character> allCharacters= new CharacterDAO().getByBooks(Book.get_Instance());
			ObservableList<Character> listcharacter = FXCollections.observableArrayList(allCharacters);
			charactersList.setItems(listcharacter);
			charactersList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
				data(newValue);
			});
		}
		

		private void data(Character c) {
			if(c!=null) {
				name.setText(name.getText()+": "+c.getName());
				rol.setText(rol.getText()+": "+c.getRol());
				description.setText(description.getText()+": "+c.getCharacteristics());
				
			}else {
				name.setText(name.getText()+": ");
				rol.setText(rol.getText()+": ");
				description.setText(description.getText()+": ");
			}
			
		}
		
}
