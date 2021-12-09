open module controller {
	requires transitive javafx.controls;
	requires javafx.fxml;
	requires java.persistence;
	requires java.sql;

//	opens controller to javafx.fxml;

	exports controller;
}
