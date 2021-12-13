package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import model.Annotation;
import model.Author;
import model.Book;
import model.Chapter;
import model.Character;
import model.Part;
import model.DAO.AnnotationDAO;
import model.DAO.BookDAO;
import model.DAO.ChapterDAO;
import model.DAO.CharacterDAO;
import model.DAO.PartDAO;
import util.AlertControl;

public class MainScreenController implements Initializable {
	ObservableList<Part> partList = FXCollections.observableArrayList();
	ObservableList<Chapter> chapterList = FXCollections.observableArrayList();
	ObservableList<Annotation> annotationList = FXCollections.observableArrayList();

	@FXML
	private Button btn_share;
	
	@FXML
    private Button SHOW;
	
	@FXML
	private Button btn_cloud;

	@FXML
	private Button btn_exitmain;

	@FXML
	private Button btn_addCharacter;

	@FXML
	private TextArea ta_content;

	@FXML
	private TextArea print_notes;

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


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Book.get_Instance();
		this.cb_part.setItems(this.partList);
		this.cb_chapter.setItems(this.chapterList);
		this.cb_notes.setItems(annotationList);
		this.cb_removeNote.setItems(annotationList);
		partList.addAll(new PartDAO().getByBook(Book.get_Instance()));
		this.annotationList.addAll(new AnnotationDAO().getByBook(Book.get_Instance()));	
	}

	@FXML
	public void partSelection() {
		if (this.cb_part.getSelectionModel().getSelectedItem() != null) {
			if (this.cb_chapter.getSelectionModel().getSelectedItem() != null) {
				this.print_notes.clear();
				this.annotationList.clear();
				this.ta_content.clear();
				this.ta_content.setDisable(true);
				this.annotationList.addAll(new AnnotationDAO().getByBook(Book.get_Instance())); // USAR LIBRO LOGUEADO
			}
			this.chapterList.clear();
			Long id=this.cb_part.getSelectionModel().getSelectedItem().getId();
			String name=this.cb_part.getSelectionModel().getSelectedItem().getName();
			Part.get_Instance().setId(id);
			Part.get_Instance().setName(name);
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
			this.ta_content.setText(this.cb_chapter.getSelectionModel().getSelectedItem().getDescription());
			this.ta_content.setDisable(false);
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
				if(this.cb_notes.getSelectionModel().getSelectedItem() == this.cb_removeNote.getSelectionModel().getSelectedItem()) {
					this.cb_notes.getSelectionModel().clearSelection();
					this.print_notes.clear();
				}
				this.annotationList.remove(this.cb_removeNote.getSelectionModel().getSelectedItem());
				this.cb_removeNote.getSelectionModel().clearSelection();
			}
		}
	}
	
	@FXML
	public void saveChapter() {
		if(this.cb_chapter.getSelectionModel().getSelectedItem() != null) {
			this.cb_chapter.getSelectionModel().getSelectedItem().setDescription(ta_content.getText());
			new ChapterDAO().save(this.cb_chapter.getSelectionModel().getSelectedItem());
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Chapter saved");
			alert.setHeaderText("The chapter has been saved");
			alert.showAndWait();
		}
	}
	
	public void editAnnotation() throws IOException {
		App.setRoot("noteModal");
	}

	@FXML
	private void share() {
		AlertControl.mensajeAdvertencia("Lo sentimos", "Esta opcion esta en proceso, la veras pronto en acción");
	}
	
	@FXML
	private void exit() throws IOException {
		App.setRoot("firstScreen");
	}
	
	@FXML
	private void openAddCharacter() throws IOException{
		App.setRoot("addCharacterScreen");
	}
	
	@FXML
	private void openCharacters() throws IOException{
		App.setRoot("characterScreen");
	}


}
