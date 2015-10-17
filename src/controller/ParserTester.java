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
		Data allData = new Data();
		Parser parser = new Parser();
		Traverser traverse = new Traverser();
		String input = readFile("examples/loops/circles.logo", StandardCharsets.UTF_8);
		List<ParseTreeNode<Command>> head = parser.parse(input);

		//Command tempCommand = control.getParser().getCommandFactory().createCommand("Constant");
		//tempCommand.returnValue();
	}
}

