/**
 *
 */
package model;

import java.util.ArrayList;
import java.util.List;

import command.turtleCommands.Backward;
import command.turtleCommands.Forward;
import command.turtleCommands.SetPosition;
import command.turtleCommands.HideTurtle;
import command.turtleCommands.Left;
import command.turtleCommands.Right;
import command.turtleCommands.SetHeading;
import command.turtleCommands.ShowTurtle;
import command.turtleQueries.XCOR;
import controller.ModelController;
import javafx.scene.Group;
import javafx.scene.control.Button;

/**
 *
 * @author Sally Al
 *
 */

// this class is used for testing commands only

public class commandTester {

	List<Double> distance = new ArrayList<Double>();

	public commandTester(Group root, ModelController control) {

		Button b1 = new Button("fd 50 test");
		b1.setLayoutX(100);
		root.getChildren().add(b1);
		b1.setOnAction(e -> fd50(control));

		Button b2 = new Button("bk 50 test");
		b2.setLayoutX(b1.getLayoutX() + 50);
		root.getChildren().add(b2);
		b2.setOnAction(e -> bk50(control));

		Button b3 = new Button("Right 45 test");
		b3.setLayoutX(b2.getLayoutX() + 50);
		root.getChildren().add(b3);
		b3.setOnAction(e -> right(control));

		Button b4 = new Button("Left 45 test");
		b4.setLayoutX(b3.getLayoutX() + 50);
		root.getChildren().add(b4);
		b4.setOnAction(e -> left(control));

		Button b5 = new Button("Goto [20 20]");
		b5.setLayoutX(b4.getLayoutX() + 50);
		root.getChildren().add(b5);

		b5.setOnAction(e -> gotomathod(control));

		Button b6 = new Button("showT");
		b6.setLayoutX(b5.getLayoutX() + 50);
		root.getChildren().add(b6);

		b6.setOnAction(e -> show(control));

		Button b7 = new Button("hideT");
		b7.setLayoutX(b6.getLayoutX() + 50);
		root.getChildren().add(b7);
		b7.setOnAction(e -> hide(control));

		Button b8 = new Button("SetH");
		b8.setLayoutX(b7.getLayoutX() + 50);
		root.getChildren().add(b8);
		b8.setOnAction(e -> seth(control));

		Button b9 = new Button("XCOR");
		b9.setLayoutX(b8.getLayoutX() + 50);
		root.getChildren().add(b9);
		b9.setOnAction(e -> xcor(control));
	}


	private void xcor(ModelController control) {
		XCOR xcor = new XCOR();
		xcor.execute(null, control.getData());
	}

	private void seth(ModelController control) {
		SetHeading seth = new SetHeading();
		distance.clear();
		distance.add(90.0);
		seth.execute(distance, control.getData());
	}

	private void hide(ModelController control) {
		HideTurtle st = new HideTurtle();
		//Home st = new Home();
		distance.clear();
		st.execute(distance, control.getData());
	}

	private void show(ModelController control) {
		ShowTurtle st = new ShowTurtle();
		distance.clear();
		st.execute(distance, control.getData());

	}

	private void gotomathod(ModelController control) {
		SetPosition gotoclass = new SetPosition();
		distance.clear();
		distance.add((double) 20);
		distance.add((double) 20);
		gotoclass.execute(distance, control.getData());

	}

	private void left(ModelController control) {
		Left right = new Left();
		distance.clear();
		distance.add((double) 45);
		right.execute(distance, control.getData());
	}

	private void right(ModelController control) {
		Right right = new Right();
		right.execute(distance, control.getData());
	}

	private void bk50(ModelController control) {
		Backward backward = new Backward();

		distance.clear();
		distance.add((double) 50);
		backward.execute(distance, control.getData());
	}

	private void fd50(ModelController control) {

		Forward forward = new Forward();
		distance.clear();
		distance.add((double) 50);
		forward.execute(distance, control.getData());

	}

}
