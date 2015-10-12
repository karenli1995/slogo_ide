package controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import command.Command;
import javafx.stage.Stage;
import model.Data;
public class ParserTester {


	static String readFile(String path, Charset encoding)
			  throws IOException
			{
			  byte[] encoded = Files.readAllBytes(Paths.get(path));
			  return new String(encoded, encoding);
			}

	public static void main(String[] args) throws IOException {
		Parser parser = new Parser();
		String input = readFile("examples/simple/forward_complex2.logo", StandardCharsets.UTF_8);
		parser.parse(input);
		List<String[]> lol = parser.getCommandList();

		//Command tempCommand = control.getParser().getCommandFactory().createCommand("Constant");
		//tempCommand.returnValue();
	}
}

