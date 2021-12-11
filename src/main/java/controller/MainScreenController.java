package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import model.Book;
import model.Chapter;

public class MainScreenController {
	 @FXML
	    private Button btn_share;

	    @FXML
	    private Button btn_cloud;

	    @FXML
	    private Button btn_exitmain;

	    @FXML
	    private Button btn_addCharacter;

	    @FXML
	    private TextArea ta_content;

	    @FXML
	    private TextField print_notes;

	    @FXML
	    private ComboBox<?> cb_part;

	    @FXML
	    private ComboBox<Book> cb_chapter;

	    @FXML
	    private ComboBox<?> cb_notes;

	    @FXML
	    private Button btn_save;

	    @FXML
	    private ComboBox<Book> cb_removeNote;

	    @FXML
	    private Button btn_addNote;

	    @FXML
	    private Button btn_editNote;

	    @FXML
	    private Button btn_removeNote;
	    
	    
	 

}
