package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Annotation;
import model.Author;
import model.Book;
import model.Chapter;
import model.Part;
import model.DAO.AnnotationDAO;
import model.DAO.BookDAO;
import model.DAO.ChapterDAO;
import model.DAO.PartDAO;
import util.AlertControl;

public class NoteModalController implements Initializable{
	BookDAO bdao= new BookDAO();
	ChapterDAO cdao= new ChapterDAO();
    @FXML
    private TextField NAME_ModalNote;

    @FXML
    private ComboBox<Chapter> CBchapter_ModalBook;

    @FXML
    private Button btn_addNote;
    
    @FXML
    private Button EXIT;

    @FXML
    private TextArea Description_ModalNote;
    
    
    
    @FXML
    private void addNote() {
    	String name=NAME_ModalNote.getText();
    	String description=Description_ModalNote.getText();
    	Chapter ch=CBchapter_ModalBook.getSelectionModel().getSelectedItem();
    	Annotation n= new Annotation(name,description,ch,Book.get_Instance());
    	AnnotationDAO aDAO= new AnnotationDAO();
    	aDAO.save(n);
    	AlertControl.mensajeAdvertencia("Enhorabuena", "Nota añadida con exito");
    	
    }



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		CBchapter_ModalBook.setItems(FXCollections.observableArrayList(cdao.getByPart(Part.get_Instance())));
		
	}
	

	@FXML
	private void exit() throws IOException {
		App.setRoot("mainScreen");
	}
	
}
