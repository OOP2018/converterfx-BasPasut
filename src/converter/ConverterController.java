package converter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
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
	private ComboBox<Units> cb1;
	@FXML
	private ComboBox<Units> cb2;
	@FXML
	private Menu menu;
	@FXML
	private MenuItem length;
	@FXML
	private MenuItem weight;
	@FXML
	private MenuItem temperature;
	@FXML
	private MenuItem currency;
	@FXML
	private MenuItem exit;

	private final String BLACK = "black";

	/**
	 * Handle the event when user click the button convert. It can convert 1
	 * unit into another units. If user input the invalid number, it also show
	 * the error, too.
	 * 
	 * @param event
	 */
	public void handleConvert(ActionEvent event) {
		boolean checkTF1 = true;
		boolean checkTF2 = true;
		double first = 0;
		double second = 0;
		setAllTextFieldColor(BLACK);
		try {
			if (tf1.getText().isEmpty()) {
				first = 0;
				checkTF1 = true;
			} else {
				first = Double.parseDouble(tf1.getText().trim());
				checkTF1 = false;
			}
		} catch (Exception e) {
			settingTextField(tf1);
		}

		if (tf2.getText().isEmpty()) {
			second = 0;
			checkTF2 = true;
		} else {
			try {
				second = Double.parseDouble(tf2.getText().trim());
				checkTF2 = false;
			} catch (Exception e) {
				settingTextField(tf2);
			}
		}

		// Get value of the unit in the first combo box.
		Units unit1 = cb1.getValue();
		// Get value of the unit in the second combo box.
		Units unit2 = cb2.getValue();

		String calFirstTf = cb1.getSelectionModel().getSelectedItem().convert(unit2, unit1, second);
		String calSecondTf = cb2.getSelectionModel().getSelectedItem().convert(unit1, unit2, first);

		if (checkTF1 && !checkTF2) {
			tf1.setText(calFirstTf);
		} else if (checkTF2 && !checkTF1) {
			tf2.setText(calSecondTf);
		} else if (!checkTF1 && !checkTF2) {
			if (tf1.isFocused() || convert.isFocused()) {
				setAllTextFieldColor(BLACK);
				tf2.setText(calSecondTf);
			} else if (tf2.isFocused() || convert.isFocused()) {
				setAllTextFieldColor(BLACK);
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
		setAllTextFieldColor(BLACK);
	}

	/**
	 * JavaFX calls the initialize() method of your controller when it creates
	 * the UI form, after the components have been created and @FXML annotated
	 * attributes have been set. It add the element from the menubar to the
	 * combobox, depend on which unit types that user choose.
	 *
	 */
	@FXML
	public void initialize() {

		Length[] len = Length.values();
		Temperature[] temp = Temperature.values();
		Currency[] cur = Currency.values();
		Weight[] wei = Weight.values();

		if (cb1 != null) {
			cb1.getItems().clear();
			cb1.getItems().addAll(len);
			cb1.getSelectionModel().select(0);
		}
		if (cb2 != null) {
			cb2.getItems().clear();
			cb2.getItems().addAll(len);
			cb2.getSelectionModel().select(1);
		}

		weight.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				handleClear(event);
				if (cb1 != null) {
					cb1.getItems().clear();
					cb1.getItems().addAll(wei);
					cb1.getSelectionModel().select(0);
				}
				if (cb2 != null) {
					cb2.getItems().clear();
					cb2.getItems().addAll(wei);
					cb2.getSelectionModel().select(1);
				}

			}
		});

		currency.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				handleClear(event);
				if (cb1 != null) {
					cb1.getItems().clear();
					cb1.getItems().addAll(cur);
					cb1.getSelectionModel().select(0);
				}
				if (cb2 != null) {
					cb2.getItems().clear();
					cb2.getItems().addAll(cur);
					cb2.getSelectionModel().select(1);
				}

			}
		});

		temperature.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				handleClear(event);
				if (cb1 != null) {
					cb1.getItems().clear();
					cb1.getItems().addAll(temp);
					cb1.getSelectionModel().select(0);
				}
				if (cb2 != null) {
					cb2.getItems().clear();
					cb2.getItems().addAll(temp);
					cb2.getSelectionModel().select(1);
				}

			}
		});

		length.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				handleClear(event);
				if (cb1 != null) {
					cb1.getItems().clear();
					cb1.getItems().addAll(len);
					cb1.getSelectionModel().select(0);
				}
				if (cb2 != null) {
					cb2.getItems().clear();
					cb2.getItems().addAll(len);
					cb2.getSelectionModel().select(1);
				}

			}
		});

		exit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
			}

		});
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

	/**
	 * Set the color of all text field.
	 */
	public void setAllTextFieldColor(String color) {
		settingColor(tf1, color);
		settingColor(tf2, color);
	}

}
