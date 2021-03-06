package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Author;
import model.Book;
import model.DAO.AuthorDAO;
import model.DAO.BookDAO;
import util.AlertControl;

public class FirstScreenController implements Initializable {
	AuthorDAO aa;
	Author a1;
	BookDAO bb=new BookDAO();
	
    @FXML
    private TextField autor_FScreen;
    
    @FXML
    private Button EXIT;


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


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		autor_FScreen.setText("Welcome "+Author.get_Instance().getName());
		allBooksCB();
		cb_booksRemove.setItems(FXCollections.observableArrayList(bb.getByAuthor(Author.get_Instance())));

	}
	
	
	 
    /*
     * @param book[]
     * 
     * @return todos los libros de un determinado autor
     */
	
    @FXML
    private void allBooksCB() {
    	cb_booksFS.setItems(FXCollections.observableArrayList(bb.getByAuthor(Author.get_Instance())));
    	Book b=cb_booksFS.getSelectionModel().getSelectedItem();
    	b=Book.get_Instance();    
    	}
    
    
    /*
     * @param book[]
     * 
     * @return todos los libros de un determinado autor
     */
    @FXML
    private void selectedBook() throws IOException {
    	Long id=cb_booksFS.getSelectionModel().getSelectedItem().getId();
    	Author a=cb_booksFS.getSelectionModel().getSelectedItem().getAuthor();
    	String n=cb_booksFS.getSelectionModel().getSelectedItem().getName();
    	Book.get_Instance().setId(id);
    	Book.get_Instance().setName(n);
    	Book.get_Instance().setAuthor(a);
    	App.setRoot("mainScreen");
    	}
    
    
    /*
     * @param book[]
     * 
     * @return todos los libros de un determinado autor
     */
    @FXML
    private void addBookTF() throws IOException {
    BookDAO bDAO=new BookDAO();
    Book b1= new Book();
    String nombre=tf_nameBookFS.getText();
    b1.setName(nombre);
    b1.setAuthor(Author.get_Instance());
    bDAO.save(b1);
    AlertControl.mensajeAdvertencia("Enhorabuena", "Su libro ha sido guardado con ??xito");
    tf_nameBookFS.clear();
    
    }
    
    
    /*
     * @param book[]
     * 
     * @return todos los libros de un determinado autor
     */
    @FXML
    private void removeBookCB() throws IOException {
    	 	BookDAO bDAO=new BookDAO();
    	    Book b=cb_booksRemove.getSelectionModel().getSelectedItem();
    	    bDAO.delete(b);
    	    AlertControl.mensajeAdvertencia("Enhorabuena", "Su libro ha sido eliminado con ??xito");
    	    
    }
    

	@FXML
	private void exit() throws IOException {
		App.setRoot("loginScreen");
	}
    	
    }