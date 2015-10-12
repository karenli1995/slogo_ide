package controller;

import java.util.List;
import java.util.ResourceBundle;

import command.Command;
import command.CommandFactory;
import command.turtleCommands.Forward;
import command.CommandFactory;

public class Parser {
	private String[] inputArray;
	private Patterner pattern;
	private List<String[]> commandList;
	private CommandFactory cf;
	private ResourceBundle resources;
	private final String INPUT_RESOURCES = "resources/input";
	private ParseTreeNode head;

    public Parser(){
    	pattern = new Patterner();
    	cf = new CommandFactory();
    	this.commandRegistration();
    	this.numInputs();
    }

    private void commandRegistration(){
    	cf.registerProduct("Forward", Forward.class);
    	/*cf.registerProduct("Constant", Constant.class);
    	cf.registerProduct("ListEnd", ListEnd.class);
    	cf.registerProduct("ListStart", ListStart.class);
    	cf.registerProduct("Repeat", Repeat.class);
    	cf.registerProduct("Right", Right.class);*/

    }


	public ParseTreeNode parse(String input){ 
		this.createCommandList(this.removeComments(input));
		this.createParseTree(1);
		return head;
	}


	
	private void createParseTree(int i){
		

	}

	private void numInputs(){
		resources = ResourceBundle.getBundle(INPUT_RESOURCES);

	}

	private void createHeadNode(){
		head = new ParseTreeNode<Command>(cf.createCommand(commandList.get(0)[1]));
	}



    private void createCommandList(String[] input){
    	commandList = pattern.matchSplitCommand(input, pattern.getPatterns());
    }

    private void createCommandList(String input){
		String[] example = this.splitInput(input);
    	commandList = pattern.matchSplitCommand(example, pattern.getPatterns());
    }

    private String removeComments(String input){
    	String[] lines = input.split(System.getProperty("line.separator"));
    	StringBuilder modifiedString = new StringBuilder();
    	for(String s: lines){
    		if(!s.contains("#")){
    			modifiedString.append(s);
    			modifiedString.append(System.getProperty("line.separator"));
    		}
    	}
    	return modifiedString.toString();
    }

	public String[] splitInput(String input){
		inputArray = input.split("\\p{Space}");
		return inputArray;
	}

	public List<String[]> getCommandList(){
		return commandList;
	}

	public Patterner getPattern() {
		return pattern;
	}

	public CommandFactory getCommandFactory(){
		return cf;
	}
}

