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
	private Command head;


	public ModelController(Stage stage){
		guiManager=new GUIManager(stage, this);
		root=guiManager.getRoot();
		this.initData();
		parser = new Parser();
		commandtester= new commandTester(root,parser,this);// for testing only

	}

	public Data getData(){
		return allData;
	}

	public Parser getParser() {
		return parser;
	}

	private void initData(){
		// TODO: Initial Data
		allData = new Data(root);
	}

	public void parse(String s){
		head = parser.parse(s);
	}

}
