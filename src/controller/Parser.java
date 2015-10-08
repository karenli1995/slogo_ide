package controller;

import java.util.Map;

public class Parser {
	private String[] inputArray;
	private Patterner pattern;
	private Map<String, String> commandMap;
    
    public Parser(){
    	pattern = new Patterner();
    }
    
	public Patterner getPattern() {
		return pattern;
	}
	
    private void createCommandMap(String[] input){
    	commandMap = pattern.matchSplitCommand(input, pattern.getPatterns());
    }
    
    private void createCommandMap(String input){
		String[] example = this.splitInput(input);
    	commandMap = pattern.matchSplitCommand(example, pattern.getPatterns());
    }
    
	public String[] splitInput(String input){
		inputArray = input.split("\\p{Space}");
		return inputArray;
	}
	
	public Map<String, String> getCommandMap(){
		return commandMap;
	}
	
}

