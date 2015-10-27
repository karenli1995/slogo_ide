package view.settings;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ColorAlert extends Dialog {
	
	private ArrayList<String> myColors = SlogoProperties.getColorArray();
	private GridPane myGridPane = new GridPane();
	private ButtonType myOKer;
	
	public ColorAlert() {
		super();
		this.setHeaderText("Color Array");
		for(int i = 0; i<myColors.size();i++){
			myGridPane.add(new Label(new Integer(i).toString()),1,i);
			Rectangle rect = new Rectangle(20,20);
			rect.setFill(Color.web(myColors.get(i)));
			myGridPane.add(rect, 2, i);
		}
		this.getDialogPane().setContent(myGridPane);
		addOk();
	}
	
	private void addOk(){
		myOKer = new ButtonType("Okay", ButtonData.OK_DONE);
		this.getDialogPane().getButtonTypes().add(myOKer);
	}

}
