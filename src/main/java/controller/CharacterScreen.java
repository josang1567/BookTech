package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Character;

public class CharacterScreen {


    @FXML
    private TextField name_character;

    @FXML
    private TextArea features_character;

    @FXML
    private TextField rol_character;

    @FXML
    private ComboBox<Character> cb_characters;

}
