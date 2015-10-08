package controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ParserTester {
	
	
	static String readFile(String path, Charset encoding) 
			  throws IOException 
			{
			  byte[] encoded = Files.readAllBytes(Paths.get(path));
			  return new String(encoded, encoding);
			}
	
	public static void main(String[] args) throws IOException {
		Parser parser = new Parser();
		String input = readFile("examples/loops/circle.logo", StandardCharsets.UTF_8);
		String[] example = parser.splitInput(input);
		parser.getCommandMap();
	}
}
