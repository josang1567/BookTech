package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Book;

public class AddCharacterController {
    @FXML
    private TextField NAME_addCharacter;

    @FXML
    private ComboBox<Book> CBbook_addCharacter;

    @FXML
    private Button btn_addCharacter;

    @FXML
    private TextArea description_addCharacter;

    @FXML
    private TextField rol_addCharacter;
}
