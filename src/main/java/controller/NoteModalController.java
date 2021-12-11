package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Book;
import model.Chapter;

public class NoteModalController {

    @FXML
    private TextField NAME_ModalNote;

    @FXML
    private ComboBox<Book> CBbook_ModalNote;

    @FXML
    private ComboBox<Chapter> CBchapter_ModalBook;

    @FXML
    private Button btn_addNote;

    @FXML
    private TextArea Description_ModalNote;
}
