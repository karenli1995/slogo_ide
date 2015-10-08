package controller;

import java.io.File;
import java.util.AbstractMap.SimpleEntry;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class Patterner {
	private static final String RESOURCES_PATH = "src/resources/languages/";
	private static final String DEFAULT_RESOURCES = "resources.languages/";

	private List<Entry<String, Pattern>> patterns;

	public Patterner(){
		this.initPattern();
	}

	private void initPattern(){
		// create a list of things to check
		patterns = new ArrayList<>();
		// these are more specific, so add them first to ensure they are checked first
		File[] folder = new File(RESOURCES_PATH).listFiles();
		for(File f: folder){
			patterns.addAll(makePatterns(DEFAULT_RESOURCES + f.getName().split("\\.")[0]));
		}
//		patterns.addAll(makePatterns(DEFAULT_RESOURCES + "English"));
//		patterns.addAll(makePatterns(DEFAULT_RESOURCES + "Syntax"));
//		patterns.addAll(makePatterns(DEFAULT_RESOURCES + "Chinese"));
//		patterns.addAll(makePatterns(DEFAULT_RESOURCES + "French"));
//		patterns.addAll(makePatterns(DEFAULT_RESOURCES + "German"));
//		patterns.addAll(makePatterns(DEFAULT_RESOURCES + "Italian"));
//		patterns.addAll(makePatterns(DEFAULT_RESOURCES + "Portuguese"));
//		patterns.addAll(makePatterns(DEFAULT_RESOURCES + "Russian"));
//		patterns.addAll(makePatterns(DEFAULT_RESOURCES + "Spanish"));

	}

	public List<Entry<String, Pattern>> getPatterns() {
		return patterns;
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

	public Map<String, String> matchSplitCommand (String[] tests, List<Entry<String, Pattern>> patterns) {
		Map<String, String> tempMap = new HashMap<>();
		for (String s : tests) {
			boolean matched = false;
			if (s.trim().length() > 0) {
				for (Entry<String, Pattern> p : patterns) {
					if (match(s, p.getValue())) {
						System.out.println(String.format("%s matches %s", s, p.getKey()));
						tempMap.put(s, p.getKey());
						matched = true;
						break;
					}
				}
				if (! matched) {
					// TODO error
					System.out.println(String.format("%s not matched", s));
				}
			}
		}
		System.out.println();
		return tempMap;
	}

}

