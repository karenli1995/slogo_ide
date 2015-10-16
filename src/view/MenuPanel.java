package view;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

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

public class MenuPanel extends MenuBar{
	
	private Stage myStage;
	private FileChooser myFileChooser;
	private ModelController myController;
	
	public MenuPanel(Stage stage, ModelController controller){
        super();
        myController = controller;
		myFileChooser = new FileChooser();
		FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Java files (*.java)", "*.java");
		myFileChooser.getExtensionFilters().add(extensionFilter);
		myStage = stage;
        this.getMenus().addAll(fileMenu(myStage));
	}

	/**
	 * create file menu
	 * @return menu
	 */
	private Menu fileMenu(Stage stage) {
		Menu menu = new Menu("File");
		
		MenuItem open = new MenuItem("Open SLogo");
		open.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));
		open.setOnAction(e->{openSlogo();});
		
		MenuItem save = new MenuItem("Save SLogo");
		save.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
		save.setOnAction(e->{saveSlogo();});
		
		MenuItem exit = new MenuItem("Exit");
		exit.setAccelerator(KeyCombination.keyCombination("Ctrl+Q"));
		exit.setOnAction(e->{System.exit(0);});
		
		menu.getItems().addAll(open,save, new SeparatorMenuItem(), exit);
		
		return menu;
	}
	
	
	private void openSlogo() {
		myFileChooser.setTitle("Open Slogo File");
		File userDirectory = getDataDirectory();
		if(userDirectory.canRead()) {
			myFileChooser.setInitialDirectory(userDirectory);
		}
		File file = myFileChooser.showOpenDialog(myStage);

		try {
			if (file != null) {
				
			}
		} catch (Exception e) {
			//showError("Error!","Failed to load "+file.getName(),e);
		}
	}
	
	private void saveSlogo(){
		myFileChooser.setTitle("Save Slogo File");
		myFileChooser.showSaveDialog(myStage);
		
		try{
			//myFileChooser.
			//String fileName = myManager.save(getDataDirectory());
			//showInfo("File saved successfully","File name: "+fileName);
		}catch(Exception e){
			//showError("Save Exception","Failed to save current model as an XML",e);
		}
	}
	
	private File getDataDirectory(){
		File file = new File(System.getProperty("user.dir")+File.separator+"data");
		if(!file.exists()){
			file.mkdirs();
		}
		return file;
	}

//	protected void showError(String header,String content,Exception e){
//		Alert alert = new Alert(AlertType.ERROR);
//		alert.setTitle("Error");
//		alert.setHeaderText(header);
//		alert.setContentText(content);
//		
//		// Create expandable Exception.
//		Label label = new Label("The exception stacktrace was:");
//		StringWriter sw = new StringWriter();
//		e.printStackTrace(new PrintWriter(sw));
//		String exceptionText = sw.toString();
//		
//		TextArea textArea = new TextArea(exceptionText);
//		textArea.setEditable(false);
//		textArea.setWrapText(true);
//		
//		textArea.setMaxWidth(Double.MAX_VALUE);
//		textArea.setMaxHeight(Double.MAX_VALUE);
//		GridPane.setVgrow(textArea, Priority.ALWAYS);
//		GridPane.setHgrow(textArea, Priority.ALWAYS);
//
//		GridPane expContent = new GridPane();
//		expContent.setMaxWidth(Double.MAX_VALUE);
//		expContent.add(label, 0, 0);
//		expContent.add(textArea, 0, 1);
//
//		// Set expandable Exception into the dialog pane.
//		alert.getDialogPane().setExpandableContent(expContent);
//		alert.showAndWait();
//	}
}
