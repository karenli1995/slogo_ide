package view.settings;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ResourceBundle;

import controller.ModelController;
import javafx.animation.Animation.Status;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Data;

public class MenuPanel extends MenuBar {

	private Stage myStage;
	private FileChooser myFileChooser;
	private ModelController myController;
	private ResourceBundle myResource;

	public MenuPanel(Stage stage, ModelController controller, ResourceBundle resource) {
		super();
		myResource = resource;
		myController = controller;
		myFileChooser = new FileChooser();
		FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Java files (*.java)", "*.java");
		myFileChooser.getExtensionFilters().add(extensionFilter);
		myStage = stage;
		this.getMenus().addAll(fileMenu(myStage));
	}

	/**
	 * create file menu
	 * 
	 * @return menu
	 */
	private Menu fileMenu(Stage stage) {
		Menu menu = new Menu(myResource.getString("FILE"));

		MenuItem open = new MenuItem(myResource.getString("OPEN"));
		open.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));
		open.setOnAction(e -> {
			openSlogo();
		});

		MenuItem save = new MenuItem(myResource.getString("SAVE"));
		save.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
		save.setOnAction(e -> {
			saveSlogo();
		});

		MenuItem help = new MenuItem(myResource.getString("HELP"));
		help.setAccelerator(KeyCombination.keyCombination("Ctrl+H"));
		help.setOnAction(e -> {
			openHelp();
		});

		MenuItem exit = new MenuItem(myResource.getString("EXIT"));
		exit.setAccelerator(KeyCombination.keyCombination("Ctrl+Q"));
		exit.setOnAction(e -> {
			System.exit(0);
		});

		menu.getItems().addAll(open, save, help, new SeparatorMenuItem(), exit);

		return menu;
	}

	private void openSlogo() {
		myFileChooser.setTitle(myResource.getString("OPEN"));
		File userDirectory = getDataDirectory();
		if (userDirectory.canRead()) {
			myFileChooser.setInitialDirectory(userDirectory);
		}
		File file = myFileChooser.showOpenDialog(myStage);

		try {
			if (file != null) {

			}
		} catch (Exception e) {
			// showError("Error!","Failed to load "+file.getName(),e);
		}
	}

	private void saveSlogo() {
		myFileChooser.setTitle(myResource.getString("SAVE"));
		myFileChooser.showSaveDialog(myStage);

		try {
			// myFileChooser.
			// String fileName = myManager.save(getDataDirectory());
			// showInfo("File saved successfully","File name: "+fileName);
		} catch (Exception e) {
			// showError("Save Exception","Failed to save current model as an
			// XML",e);
		}
	}

	public void openHelp() {
		File html = new File("HelpPage.html");
		try {
			Desktop.getDesktop().browse(html.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private File getDataDirectory() {
		File file = new File(System.getProperty("user.dir") + File.separator + "data");
		if (!file.exists()) {
			file.mkdirs();
		}
		return file;
	}

	// protected void showError(String header,String content,Exception e){
	// Alert alert = new Alert(AlertType.ERROR);
	// alert.setTitle("Error");
	// alert.setHeaderText(header);
	// alert.setContentText(content);
	//
	// // Create expandable Exception.
	// Label label = new Label("The exception stacktrace was:");
	// StringWriter sw = new StringWriter();
	// e.printStackTrace(new PrintWriter(sw));
	// String exceptionText = sw.toString();
	//
	// TextArea textArea = new TextArea(exceptionText);
	// textArea.setEditable(false);
	// textArea.setWrapText(true);
	//
	// textArea.setMaxWidth(Double.MAX_VALUE);
	// textArea.setMaxHeight(Double.MAX_VALUE);
	// GridPane.setVgrow(textArea, Priority.ALWAYS);
	// GridPane.setHgrow(textArea, Priority.ALWAYS);
	//
	// GridPane expContent = new GridPane();
	// expContent.setMaxWidth(Double.MAX_VALUE);
	// expContent.add(label, 0, 0);
	// expContent.add(textArea, 0, 1);
	//
	// // Set expandable Exception into the dialog pane.
	// alert.getDialogPane().setExpandableContent(expContent);
	// alert.showAndWait();
	// }
}