package view.props;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;
import view.GUIManager;
import view.TurtleScene;

public class SceneProps extends Tab{
	private static final int OFFSET_SPACE = 10;
    private Insets myInset = new Insets(OFFSET_SPACE);
    private TurtleScene myTurtleScene;
    private GUIManager myGUI;
    private ResourceBundle myResource;
	
	private List<Node> allElements;
	
	public SceneProps(TurtleScene scene, GUIManager gui, ResourceBundle resource){
		myResource = resource;
		myGUI = gui;
		myTurtleScene = scene;
		allElements = new ArrayList<Node>();
		createSceneTab();
	}

	private void createSceneTab() {
		this.setText(myResource.getString("SCENE"));
		VBox vb = new VBox();
		HBox hb2 = addBGColorLabel();
		
		setAllMargins(allElements);
		
		vb.getChildren().addAll(hb2);
		
		this.setContent(vb);
	}
	
	private HBox addBGColorLabel(){
		HBox hb7 = new HBox();
		Label background = new Label(myResource.getString("BACKGROUNDC"));
		
		ComboBox<Color> cmbColors = new ComboBox<Color>();
		cmbColors.getItems().addAll(
		     Color.AQUAMARINE,
		     Color.CADETBLUE,
		     Color.AZURE);

		cmbColors.setCellFactory(new Callback<ListView<Color>, ListCell<Color>>() {
		     @Override public ListCell<Color> call(ListView<Color> p) {
		         return new ListCell<Color>() {
		             private final Rectangle rectangle;
		             { 
		                 setContentDisplay(ContentDisplay.GRAPHIC_ONLY); 
		                 rectangle = new Rectangle(10, 10);
		             }
		             
		             @Override protected void updateItem(Color item, boolean empty) {
		                 super.updateItem(item, empty);
		                 
		                 if (item == null || empty) {
		                     setGraphic(null);
		                 } else {
		                     rectangle.setFill(item);
		                     setGraphic(rectangle);
		                 }
		            }
		       };
		   }
		});
		 
		cmbColors.setOnAction((event) -> {
		    Color chosenColor = (Color) cmbColors.getSelectionModel().getSelectedItem();
		    Canvas currCanvas = (Canvas) myTurtleScene.getSelectionModel().getSelectedItem().getContent();
		    
		    myTurtleScene.getCurrTab().setColor(currCanvas.getGraphicsContext2D(), currCanvas, chosenColor);
		    System.out.println("ComboBox Action (selected: " + chosenColor.toString().toUpperCase() + ")");
		});
		 
		
		hb7.getChildren().addAll(background, cmbColors);
		
		allElements.add((Node) background);
		allElements.add((Node) cmbColors);
		
		return hb7;
	}
	
	private void setAllMargins(List<Node> nodes){
		for (Node n : nodes) HBox.setMargin(n, myInset);
	}
}
