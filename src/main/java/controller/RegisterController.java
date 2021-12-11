package controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Author;
import model.DAO.AuthorDAO;
import util.AlertControl;

public class RegisterController {


    @FXML
    private TextField user_Register;

    @FXML
    private TextField pass_Register;

    @FXML
    private TextField web_Register;

    @FXML
    private TextField email_Register;

    @FXML
    private Button btn_register;
    
    
    
    /*
     * @param usuario,password,website,email 
     * 
     * @return usuario nuevo en la bbdd (AUTOR)
     */
    @FXML
    private void signUp() throws IOException {
    	AuthorDAO aDAO= new AuthorDAO();
    	String nombre= user_Register.getText();
    	String password= pass_Register.getText();
    	String mail=email_Register.getText();
    	String web= web_Register.getText();
		Author a= new Author(nombre,web,mail,password);   
    	try {
    		if(a!=null) {
    			aDAO.save(a);
    			AlertControl.mensajeAdvertencia("Enhorabuena","BIENVENIDO A BOOKTECH");
    			Author.get_Instance().setName(nombre);
    			App.setRoot("firstScreen");
    			
		    }
    	}catch(Exception e) {
    		AlertControl.mensajeError("Error","Rellene los datos");
        	
    	}
    }
    
    
    
    
    
}