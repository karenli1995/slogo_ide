package controller;

import java.util.List;
<<<<<<< HEAD
import java.util.Map;
import java.util.ResourceBundle;

import model.Data;
import command.Command;
import command.CommandFactory;
import command.Constant;
import command.Forward;
import command.ListEnd;
import command.ListStart;
import command.Repeat;
import command.Right;

import command.CommandFactory;
import command.Constant;
import command.Forward;
import model.Data;

public class Parser {
	private String[] inputArray;
	private Patterner pattern;
	private List<String[]> commandList;
	private CommandFactory cf;
	private Command head;
	private Command currentNode;
	private Command nextNode;
	private Command nextNextNode;
	private ResourceBundle resources;
	private final String INPUT_RESOURCES = "resources/input";
	private Data allData;

    public Parser(Data allData){
    	this.allData= allData;
    	pattern = new Patterner();
    	cf = new CommandFactory(allData);
    	this.commandRegistration();
    	this.numInputs();
    }

    private void commandRegistration(){
    	cf.registerProduct("Forward", Forward.class);
    	cf.registerProduct("Constant", Constant.class);
    	cf.registerProduct("ListEnd", ListEnd.class);
    	cf.registerProduct("ListStart", ListStart.class);
    	cf.registerProduct("Repeat", Repeat.class);
    	cf.registerProduct("Right", Right.class);

    }

	public Data parse(String input, Data allData){
		Data newData = allData;
		this.createCommandList(this.removeComments(input));
		this.createParseTree();
		return newData;
	}

	
	private void createParseTree(){
		for(int i = 0; i< commandList.size(); i++){
			if(i == 0){
				this.createHeadNode();
			} else{
				String[] s = commandList.get(i);
				cf.createCommand(s[1]);
			}
			int numInputs = Integer.parseInt(resources.getString(currentNode.getClass().getSimpleName()));
			
		}
	}
	
	private void numInputs(){
		resources = ResourceBundle.getBundle(INPUT_RESOURCES);

	}
	
	private void createHeadNode(){
		head = cf.createCommand(commandList.get(0)[1]);
		currentNode = head;
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

