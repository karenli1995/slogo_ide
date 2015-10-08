package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.AbstractMap.SimpleEntry;
import java.util.Enumeration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Parser {
	public static final String DEFAULT_RESOURCES = "resources.languages/";
    private List<Entry<String, Pattern>> patterns;
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

