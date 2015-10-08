package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.AbstractMap.SimpleEntry;
import java.util.Enumeration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Parser {
	public static final String DEFAULT_RESOURCES = "resources.languages/";
    private List<Entry<String, Pattern>> patterns;
	private String[] inputArray;
    
    public Parser(){
    	this.initPattern();
    }
	
	private void initPattern(){
	       // create a list of things to check
        patterns = new ArrayList<>();
        // these are more specific, so add them first to ensure they are checked first
        patterns.addAll(makePatterns(DEFAULT_RESOURCES + "English"));
        patterns.addAll(makePatterns(DEFAULT_RESOURCES + "Syntax"));
	}
	
    public List<Entry<String, Pattern>> getPatterns() {
		return patterns;
	}


	
	public String[] splitInput(String input){
		inputArray = input.split("\\p{Space}");
		return inputArray;
	}
	
    private List<Entry<String, Pattern>> makePatterns (String syntax) {
        ResourceBundle resources = ResourceBundle.getBundle(syntax);
        List<Entry<String, Pattern>> patterns = new ArrayList<>();
        Enumeration<String> iter = resources.getKeys();
        while (iter.hasMoreElements()) {
            String key = iter.nextElement();
            String regex = resources.getString(key);
            patterns.add(new SimpleEntry<String, Pattern>(key,
                         // THIS IS THE KEY LINE
                         Pattern.compile(regex, Pattern.CASE_INSENSITIVE)));
        }
        return patterns;
    }
    
    private boolean match (String input, Pattern regex) {
        // THIS IS THE KEY LINE
        return regex.matcher(input).matches();
        // basic strings can match also, but not using a Pattern (thus not ignore case)
        // return input.matches(regex);
    }
    
    public void testMatches (String[] tests, List<Entry<String, Pattern>> patterns) {
        for (String s : tests) {
            boolean matched = false;
            if (s.trim().length() > 0) {
                for (Entry<String, Pattern> p : patterns) {
                    if (match(s, p.getValue())) {
                        System.out.println(String.format("%s matches %s", s, p.getKey()));
                        matched = true;
                        break;
                    }
                }
                if (! matched) {
                    System.out.println(String.format("%s not matched", s));
                }
            }
        }
        System.out.println();
    }
	
}

