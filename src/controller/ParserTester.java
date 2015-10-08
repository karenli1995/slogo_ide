package controller;

public class ParserTester {
	public static void main(String[] args) {
		Parser parser = new Parser();
		String input = "fd sum sum sum sum 10 20 30 5 5";
		String[] example = parser.splitInput(input);
		for(int i = 0; i<example.length;i++){
			System.out.println(example[i]);
		}
		parser.testMatches(example, parser.getPatterns());
	}
}
