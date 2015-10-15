package controller;

import command.Command;
import javafx.scene.Group;
import javafx.stage.Stage;
import model.Data;
import model.commandTester;
import view.GUIManager;

public class ModelController {

	private Data allData;
	private Parser parser;
	private GUIManager guiManager;
	private Group root;
	private commandTester commandtester;
	private ParseTreeNode tree;

	public ModelController(Stage stage) {
		this.initData();
		guiManager = new GUIManager(stage, this);
		root = guiManager.getRoot();
//		root.getChildren().add(this.getData().getTurtle(0).getMyImage());
//		root.getChildren().add(this.allData.getLine());
		parser = new Parser();
		//commandtester = new commandTester(root, this);// for testing only

	}

	public Data getData() {
		return allData;
	}

	public Parser getParser() {
		return parser;
	}

	private void initData() {
		allData = new Data();
	}

	public void parse(String s) {
		tree = parser.parse(s);
	}

	public void iterateTreeInOrder() {
		this.iterateTreeInOrder(tree);
	}

	private void iterateTreeInOrder(ParseTreeNode<Command> node) {
		if (node == null)
			return;

		for (ParseTreeNode<Command> childNode : node.getChildren()) {
			this.iterateTreeInOrder(childNode);
		}

	}

}
