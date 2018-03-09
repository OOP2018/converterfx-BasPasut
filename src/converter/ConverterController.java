package converter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * UI controller for events and intializing
 * 
 * @author Pasut Kittiprapas
 *
 */
public class ConverterController {

	@FXML
	TextField tf1;
	@FXML
	TextField tf2;
	@FXML
	Button convert;
	@FXML
	Button clear;
	@FXML
	private ComboBox<Length> cb1;
	@FXML
	private ComboBox<Length> cb2;

	/**
	 * Handle the event when user click the button convert. It can convert 1
	 * unit into another units. If user input the invalid number, it also show
	 * the error, too.
	 * 
	 * @param event
	 */
	public void handleConvert(ActionEvent event) {
		double first = 0;
		double second = 0;
		settingColor(tf1, "black");
		settingColor(tf2, "black");
		try {
			if (tf1.getText().isEmpty()) {
				first = 0;
			} else {
				first = Double.parseDouble(tf1.getText().trim());
			}
		} catch (Exception e) {
			settingTextField(tf1);
		}

		if (tf2.getText().isEmpty()) {
			second = 0;
		} else {
			try {
				second = Double.parseDouble(tf2.getText().trim());
			} catch (Exception e) {
				settingTextField(tf2);
			}
		}

		// Get value of the unit in the first combo box.
		double unit1 = cb1.getValue().getValue();
		// Get value of the unit in the second combo box.
		double unit2 = cb2.getValue().getValue();
		
		String calFirstTf = String.format("%.4g", (second * unit2) / unit1);
		String calSecondTf = String.format("%.4g", (first * unit1) / unit2);

		if (first == 0 && second != 0) {
			tf1.setText(calFirstTf);
		} else if (second == 0 && first != 0) {
			tf2.setText(calSecondTf);
		} else if (second != 0 && first != 0) {
			if (tf1.isFocused()) {
				tf2.setText(calSecondTf);
			} else {
				tf1.setText(calFirstTf);
			}
		}

	}

	/**
	 * Handle the clear event. Clear all text field.
	 * 
	 * @param event
	 */
	public void handleClear(ActionEvent event) {
		tf1.clear();
		tf2.clear();
		settingColor(tf1, "black");
		settingColor(tf2, "black");
	}

	/**
	 * JavaFX calls the initialize() method of your controller when it creates
	 * the UI form, after the components have been created and @FXML annotated
	 * attributes have been set. It add the element the Length to the combobox.
	 *
	 */
	@FXML
	public void initialize() {
		if (cb1 != null) {
			cb1.getItems().addAll(Length.values());
			cb1.getSelectionModel().select(0);
		}

		if (cb2 != null) {
			cb2.getItems().addAll(Length.values());
			cb2.getSelectionModel().select(1);
		}

	}

	/**
	 * Set the error of text field.
	 * 
	 * @param tf
	 */
	public void settingTextField(TextField tf) {
		tf.setText("Invalid number");
		settingColor(tf, "red");
	}

	/**
	 * Set color of the error message text and normal number.
	 * 
	 * @param tf
	 * @param color
	 */
	public void settingColor(TextField tf, String color) {
		tf.setStyle(String.format("-fx-text-inner-color: %s;", color));
	}

}
