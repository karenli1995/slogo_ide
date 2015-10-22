package controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import command.CommandInterface;
import model.Data;
import model.Data_Turtle_Interface;

public class ParserTester {

	static String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}

	public static void main(String[] args) throws IOException {
		Data_Turtle_Interface allData = new Data();
		Parser parser = new Parser(allData);
		Traverser traverse = new Traverser();
		String input = readFile("examples/procedures_with_parameters/dash.logo", StandardCharsets.UTF_8);
		input= "fd 50";
		List<ParseTreeNode<CommandInterface>> head = parser.parse(input);

		// Command tempCommand =
		// control.getParser().getCommandFactory().createCommand("Constant");
		// tempCommand.returnValue();
	}
}
