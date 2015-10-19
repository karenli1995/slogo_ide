package view.props;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class CurrentTurtleState extends VBox{
	private static final int OFFSET_SPACE = 10;
	private Insets myInset = new Insets(OFFSET_SPACE);
	
	private List<Node> allElements;
	private Label myTitle;
	private ResourceBundle myResource;
	private int myTextAreaWidth = 100;
	private int myTextAreaHeight = 10;
	
	public CurrentTurtleState(Scene scene, ResourceBundle resource){
		myResource = resource;
		allElements = new ArrayList<Node>();
		this.setPrefWidth(scene.getWidth() / 7);
		myTitle = new Label(myResource.getString("CURRPROPS"));
		myTitle.setPrefWidth(scene.getWidth() / 7);
		myTitle.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, new CornerRadii(0), new Insets(0))));
		this.getChildren().add(myTitle);
		
		HBox hb1 = addTurtPosition();
		HBox hb2 = addTurtHeading();
		HBox hb3 = addPenPos();
		HBox hb4 = addTurtVisibility();
	
		setAllMargins(allElements);

		this.getChildren().addAll(hb1, hb2, hb3, hb4);
	}
	
	private HBox addTurtPosition() {
		HBox hb1 = new HBox();
		Label turtlePos = new Label(myResource.getString("TURTPOS"));
		TextArea displayPos = new TextArea();
		displayPos.setPrefSize(myTextAreaWidth, myTextAreaHeight);
		
		hb1.getChildren().addAll(turtlePos, displayPos);

		allElements.add(turtlePos);
		allElements.add(displayPos);

		return hb1;
	}
	
	private HBox addTurtHeading() {
		HBox hb1 = new HBox();
		Label turtleHeading = new Label(myResource.getString("TURTHEAD"));
		TextArea displayHeading = new TextArea();
		displayHeading.setPrefSize(myTextAreaWidth, myTextAreaHeight);
		
		hb1.getChildren().addAll(turtleHeading, displayHeading);

		allElements.add(turtleHeading);
		allElements.add(displayHeading);

		return hb1;
	}
	
	private HBox addPenPos() {
		HBox hb1 = new HBox();
		Label penPos = new Label(myResource.getString("PENPOS"));
		TextArea displayPenPos = new TextArea();
		displayPenPos.setPrefSize(myTextAreaWidth, myTextAreaHeight);
		
		hb1.getChildren().addAll(penPos, displayPenPos);

		allElements.add(penPos);
		allElements.add(displayPenPos);

		return hb1;
	}
	
	private HBox addTurtVisibility() {
		HBox hb1 = new HBox();
		Label turtVisible = new Label(myResource.getString("TURTVISIBLE"));
		TextArea displayTurtVis = new TextArea();
		displayTurtVis.setPrefSize(myTextAreaWidth, myTextAreaHeight);
		
		hb1.getChildren().addAll(turtVisible, displayTurtVis);

		allElements.add(turtVisible);
		allElements.add(displayTurtVis);

		return hb1;
	}

	private void setAllMargins(List<Node> nodes) {
		for (Node n : nodes)
			HBox.setMargin(n, myInset);
	}
	
}
