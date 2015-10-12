/**
 *
 */
package model;

import java.util.ArrayList;
import java.util.List;

import command.turtleCommands.Backward;
import command.turtleCommands.Forward;
import command.turtleCommands.Left;
import command.turtleCommands.Right;
import controller.ModelController;
import javafx.scene.Group;
import javafx.scene.control.Button;

/**
 *
 * @author Sally Al
 *
 */

//this class is used for testing commands only

public class commandTester {

	List<Double> distance = new ArrayList<Double>();

	public commandTester(Group root, ModelController modelController) {

		Button b1 = new Button("fd 50 test");
		root.getChildren().add(b1);
		b1.setOnAction(e -> fd50(modelController));

		Button b2 = new Button("bk 50 test");
		b2.setLayoutX(b1.getLayoutX() + 50);
		root.getChildren().add(b2);
		b2.setOnAction(e -> bk50(modelController));

		Button b3 = new Button("Right 45 test");
		b3.setLayoutX(b2.getLayoutX() + 50);
		root.getChildren().add(b3);
		b3.setOnAction(e -> right(modelController));

		Button b4 = new Button("Left 45 test");
		b4.setLayoutX(b3.getLayoutX() + 50);
		root.getChildren().add(b4);
		distance.clear();
		distance.add((double) 45);
		b4.setOnAction(e -> left(modelController));
	}


	private void left(ModelController control) {
		Left right = new Left();
		right.makeTurtle(control.getData().getTurtle(0).getMyImage());
		right.execute(distance);
	}


	/**
	 * @param modelController
	 * @return
	 */
	private void right(ModelController control) {
		Right right = new Right();
		right.makeTurtle(control.getData().getTurtle(0).getMyImage());
		right.execute(distance);
	}


	private void bk50(ModelController control) {
		Backward backward = new Backward();
		backward.makeTurtle(control.getData().getTurtle(0).getMyImage());
		distance.clear();
		distance.add((double) 50);
		backward.execute(distance);
	}

	private void fd50(ModelController control) {

		Forward forward = new Forward();
		forward.makeTurtle(control.getData().getTurtle(0).getMyImage());
		distance.clear();
		distance.add((double) 50);
		forward.execute(distance);

	}

}
