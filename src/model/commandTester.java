/**
 *
 */
package model;

import command.Forward;
import controller.ModelController;
import controller.Parser;
import javafx.scene.Group;
import javafx.scene.control.Button;

/**
 *
 * @author Sally Al
 *
 */
public class commandTester {


	public commandTester(Group root, Parser parser, ModelController modelController) {
		Button b1 = new Button("fd 50 test");
		root.getChildren().add(b1);
		b1.setOnAction(e -> fd50(parser, modelController));

	}



	private void fd50(Parser parser, ModelController control) {

		Forward forward = new Forward();
		forward.makeTurtle(control.getData().getTurtle(0).getMyImage());
		forward.returnValue();

	}




}
