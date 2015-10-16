package view;

import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import javafx.scene.control.ButtonBar.ButtonData;

public class LangDialog extends Dialog {
	
	protected ButtonType myOKer;

	public LangDialog(){
		super();
		this.setHeaderText("Language");
		addOk();
		Label lang = new Label("Language: ");
		ObservableList<String> languages = 
			    FXCollections.observableArrayList(
			        "Chinese",
			        "English",
			        "French",
			        "German",
			        "Italian",
			        "Portuguese",
			        "Russian",
			        "Spanish"
			    );
		ComboBox<String> languageChoice = new ComboBox<String>(languages);
		languageChoice.setValue("English");
		GridPane grid = new GridPane();
		grid.add(lang, 0, 0);
		grid.add(languageChoice, 1, 0);
		this.getDialogPane().setContent(grid);
		this.setResultConverter(new Callback<ButtonType,ResourceBundle>(){
			public ResourceBundle call(ButtonType ok){
				if(ok == myOKer){
					ResourceBundle ret = ResourceBundle.getBundle("resources.languages/" + languageChoice.getValue());
					return ret;
				}
				return null;
	}
		});
	}
			
	
	private void addOk(){
		myOKer = new ButtonType("Okay", ButtonData.OK_DONE);
		this.getDialogPane().getButtonTypes().add(myOKer);
	}
}
