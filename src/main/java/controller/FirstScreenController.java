package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Author;
import model.Book;
import model.DAO.AuthorDAO;
import model.DAO.BookDAO;

public class FirstScreenController implements Initializable {
	AuthorDAO aa;
	BookDAO bb;
	
    @FXML
    private TextField autor_FScreen;

    @FXML
    private Button btn_editarModal;

    @FXML
    private ComboBox<Book> cb_booksFS;

    @FXML
    private TextField tf_nameBookFS;

    @FXML
    private ComboBox<Book> cb_booksRemove;

    @FXML
    private Button btn_add;

    @FXML
    private Button btn_delete;
    
    @FXML
    private TextField oldbook_FS;

    @FXML
    private TextField newbook_FS;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		autor_FScreen.setText("Welcome "+Author.get_Instance().getName());
	}
	
	
	 
    /*
     * @param book[]
     * 
     * @return todos los libros de un determinado autor
     */
	
    @FXML
    private void allBooksCB() throws IOException {
    	
    }
    
    /*
     * @param book[]
     * 
     * @return todos los libros de un determinado autor
     */
    @FXML
    private void addBookTF() throws IOException {
    
    	
    	
    }
    
    
    /*
     * @param book[]
     * 
     * @return todos los libros de un determinado autor
     */
    @FXML
    private void removeBookCB() throws IOException {

    	
    	
    }
    
    /*
     * @param book[]
     * 
     * @return todos los libros de un determinado autor
     */
    @FXML
    private void openModalCreateNote() throws IOException {

    	
    	
    }
    
    
   
    
}
