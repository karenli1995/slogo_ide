package controller;

import java.util.List;
import java.util.Map;

import data.Data;

public class Parser {
	private String[] inputArray;
	private Patterner pattern;
	private List<String[]> commandList;
    
    public Parser(){
    	pattern = new Patterner();
    }
    
	public Patterner getPattern() {
		return pattern;
	}
	
	public Data parse(String input, Data allData){
		Data newData = allData;
		this.createCommandList(this.removeComments(input));
		return newData;
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
	
}

