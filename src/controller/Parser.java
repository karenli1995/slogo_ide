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
	private Map<String, String> commandToType;
    
    public Parser(){
    	pattern = new Patterner();
    }
    
	public Patterner getPattern() {
		return pattern;
	}
	
    public void createCommandMap(String[] input){
    	commandToType = pattern.matchSplitCommand(input, pattern.getPatterns());
    }
    
    public void createCommandMap(String input){
		String[] example = this.splitInput(input);
    	commandToType = pattern.matchSplitCommand(example, pattern.getPatterns());
    }
    
	public String[] splitInput(String input){
		inputArray = input.split("\\p{Space}");
		return inputArray;
	}
	
}

