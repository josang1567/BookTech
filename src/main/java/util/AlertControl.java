package util;

import javafx.scene.control.Alert;

public class AlertControl {
	public static void mensajeError(String title, String context) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setHeaderText(null);
		alert.setTitle(title);
		alert.setContentText(context);
		alert.showAndWait();
}
	
	public static void mensajeAdvertencia(String title, String context) {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setHeaderText(null);
		alert.setTitle(title);
		alert.setContentText(context);
		alert.showAndWait();
}
}
