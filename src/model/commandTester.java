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

	/**
	 * @param root
	 * @param parser
	 * @param modelController
	 */
	public commandTester(Group root, Parser parser, ModelController modelController) {
		Button b1 = new Button("fd 50 test");
		root.getChildren().add(b1);
		b1.setOnAction(e -> fd50(parser, modelController));

	}



	private void fd50(Parser parser, ModelController control) {
	/*	String input;

		input = "fd 50";
		control.parse(input);

		Command tempCommand = control.getParser().getCommandFactory().createCommand("Forward");
		tempCommand.returnValue();*/
		Forward forward = new Forward(control.getData());
		forward.returnValue();

	}




}
