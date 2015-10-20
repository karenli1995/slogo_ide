package view.props;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import model.Data;
import model.SlogoObjects;
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

public class CurrentTurtleState extends VBox implements Observer{
	private static final int OFFSET_SPACE = 10;
	private Insets myInset = new Insets(OFFSET_SPACE);
	
	private List<Node> allElements;
	private Label myTitle;
	private ResourceBundle myResource;
	private int myTextAreaWidth = 100;
	private int myTextAreaHeight = 10;
	
	private TextArea myDisplayPos;
	private TextArea myDisplayHeading;
	private TextArea myDisplayPenPos;
	private TextArea myDisplayTurtVis;
	
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
		myDisplayPos = new TextArea();
		myDisplayPos.setPrefSize(myTextAreaWidth, myTextAreaHeight);
		myDisplayPos.setEditable(false);
		
		hb1.getChildren().addAll(turtlePos, myDisplayPos);

		allElements.add(turtlePos);
		allElements.add(myDisplayPos);

		return hb1;
	}
	
	private HBox addTurtHeading() {
		HBox hb1 = new HBox();
		Label turtleHeading = new Label(myResource.getString("TURTHEAD"));
		myDisplayHeading = new TextArea();
		myDisplayHeading.setPrefSize(myTextAreaWidth, myTextAreaHeight);
		myDisplayHeading.setEditable(false);

		
		hb1.getChildren().addAll(turtleHeading, myDisplayHeading);

		allElements.add(turtleHeading);
		allElements.add(myDisplayHeading);

		return hb1;
	}
	
	private HBox addPenPos() {
		HBox hb1 = new HBox();
		Label penPos = new Label(myResource.getString("PENPOS"));
		myDisplayPenPos = new TextArea();
		myDisplayPenPos.setPrefSize(myTextAreaWidth, myTextAreaHeight);
		myDisplayPenPos.setEditable(false);
		
		hb1.getChildren().addAll(penPos, myDisplayPenPos);

		allElements.add(penPos);
		allElements.add(myDisplayPenPos);

		return hb1;
	}
	
	private HBox addTurtVisibility() {
		HBox hb1 = new HBox();
		Label turtVisible = new Label(myResource.getString("TURTVISIBLE"));
		myDisplayTurtVis = new TextArea();
		myDisplayTurtVis.setPrefSize(myTextAreaWidth, myTextAreaHeight);
		myDisplayTurtVis.setEditable(false);
		
		hb1.getChildren().addAll(turtVisible, myDisplayTurtVis);

		allElements.add(turtVisible);
		allElements.add(myDisplayTurtVis);

		return hb1;
	}

	private void setAllMargins(List<Node> nodes) {
		for (Node n : nodes)
			HBox.setMargin(n, myInset);
	}

	
	@Override
	public void update(Observable o, Object arg) {
		Data otherSlogoObj = (Data) o;
		
		double currPosX = otherSlogoObj.getTurtle(0).getTrail().getX();
		double currPosY = otherSlogoObj.getTurtle(0).getTrail().getY();
		myDisplayPos.setText(currPosX + ", " + currPosY);
		
		double currRotAngle = otherSlogoObj.getTurtle(0).getRotationAngle() % 360;
		myDisplayHeading.setText(currRotAngle + "");
		
		String penPos = "Down";
		double currPenPos = otherSlogoObj.getTurtle(0).getPen().isDown();
		if(currPenPos == 1.0) penPos="Down";
		if(currPenPos == 0.0) penPos="Up";
		myDisplayPenPos.setText(penPos);
		
		String turtVis = "Visible";
		if (otherSlogoObj.getTurtle(0).getIsShowing() == true) turtVis="Visible";
		if (otherSlogoObj.getTurtle(0).getIsShowing() == false) turtVis="Invisible";
		myDisplayTurtVis.setText(turtVis);
	}
	
}
