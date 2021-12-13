package controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Annotation;
import model.Book;
import model.Chapter;
import model.Part;
import model.DAO.AnnotationDAO;
import model.DAO.BookDAO;
import model.DAO.ChapterDAO;
import model.DAO.PartDAO;

public class MainScreenController implements Initializable {
	ObservableList<Part> partList = FXCollections.observableArrayList();
	ObservableList<Chapter> chapterList = FXCollections.observableArrayList();
	ObservableList<Annotation> annotationList = FXCollections.observableArrayList();

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
	private ComboBox<Part> cb_part;

	@FXML
	private ComboBox<Chapter> cb_chapter;

	@FXML
	private ComboBox<Annotation> cb_notes;

	@FXML
	private Button btn_save;

	@FXML
	private ComboBox<Annotation> cb_removeNote;

	@FXML
	private Button btn_addNote;

	@FXML
	private Button btn_editNote;

	@FXML
	private Button btn_removeNote;

	Book dummy=new BookDAO().getById(1L);										//DUMMY HASTA USAR USUARIO LOGUEADO
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.cb_part.setItems(this.partList);
		this.cb_chapter.setItems(this.chapterList);
		this.cb_notes.setItems(annotationList);
		this.cb_removeNote.setItems(annotationList);
		partList.addAll(new PartDAO().getByBook(dummy));						//USAR USUARIO LOGUEADO
		this.annotationList.addAll(new AnnotationDAO().getByBook(dummy));	//USAR USUARIO LOGUEADO
	}

	@FXML
	public void partSelection() {
		
		if (this.cb_part.getSelectionModel().getSelectedItem() != null) {
			if(this.cb_chapter.getSelectionModel().getSelectedItem()!=null) {
				this.chapterList.clear();
				this.print_notes.clear();
				this.annotationList.clear();
				this.annotationList.addAll(new AnnotationDAO().getByBook(dummy));	//USAR USUARIO LOGUEADO
			}
			this.chapterList.addAll(new ChapterDAO().getByPart(this.cb_part.getSelectionModel().getSelectedItem()));
			this.cb_chapter.setDisable(false);
		} else {
			this.cb_chapter.setDisable(true);
		}
	}

	public void loadChapter() {
		if(this.cb_chapter.getSelectionModel().getSelectedItem() != null) {
			this.annotationList.clear();
			this.print_notes.clear();
			this.annotationList.addAll(new AnnotationDAO().getByChapter(this.cb_chapter.getSelectionModel().getSelectedItem()));
		}
	}
	
	@FXML
	public void annotationLoader() {
		if (this.cb_notes.getSelectionModel().getSelectedItem() != null) {
			this.print_notes.setText(this.cb_notes.getSelectionModel().getSelectedItem().getDescription());
		}
	}
	
	@FXML
	public void removeAnnotation() {
		if (this.cb_removeNote.getSelectionModel().getSelectedItem() != null) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation");
			alert.setHeaderText(this.cb_removeNote.getSelectionModel().getSelectedItem().getName() + " will be permanently removed.");
			alert.setContentText("Are you ok with this?");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				new AnnotationDAO().delete(this.cb_removeNote.getSelectionModel().getSelectedItem());
			}
		}
	}
	
	public void editAnnotation() {
		//TODO
	}

	@FXML
	private void share() {
	}

}
