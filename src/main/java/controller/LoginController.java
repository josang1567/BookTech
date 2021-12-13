package controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Author;
import model.DAO.AuthorDAO;
import util.AlertControl;

public class LoginController implements Initializable{
    
	@FXML
    private TextField user_Login;

    @FXML
    private Button signin_Login;

    @FXML
    private PasswordField pass_Login;
    
    @FXML
    private Button btn_register;
    
    
    /*
     * @param usuario,password
     * 
     * @return usuario existente en la bbdd si es igual a true
     */
    
    @FXML
    private void signIn() throws IOException {
    	AuthorDAO aDAO= new AuthorDAO();
    	String nombre= user_Login.getText();
    	String password= pass_Login.getText();
    	try {
    		if(aDAO.getByNamePassword(nombre, password)!=null &&  nombre!=null && password!=null) {
    			Author.get_Instance().setName(nombre);
    			Author.get_Instance().setPassword(password);
    			Author.get_Instance().setEmail(aDAO.getByNamePassword(nombre, password).getEmail());
    			Author.get_Instance().setWebsite(aDAO.getByNamePassword(nombre, password).getWebsite());
    			Author.get_Instance().setId(aDAO.getByNamePassword(nombre, password).getId());
    			App.setRoot("firstScreen");	
		    }
    	}catch(Exception e) {
    		AlertControl.mensajeError("Error","No se encuentra al usuario, compruebe sus datos");
        	
    	}
    }
    
    @FXML
    private void signUp() throws IOException {
    	App.setRoot("registerScreen");
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println(Author.get_Instance());
		
	}
    
    
}
