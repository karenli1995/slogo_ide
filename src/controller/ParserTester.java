/*package controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import command.Command;
public class ParserTester {


	static String readFile(String path, Charset encoding)
			  throws IOException
			{
			  byte[] encoded = Files.readAllBytes(Paths.get(path));
			  return new String(encoded, encoding);
			}

	public static void main(String[] args) throws IOException {
		ModelController control = new ModelController();
		String input = readFile("examples/loops/circle.logo", StandardCharsets.UTF_8);
		control.parse(input);
		List<String[]> lol = control.getParser().getCommandList();
		for(String[] s: lol){
			System.out.println(s[0]+", " + s[1]);
		}
		//Command tempCommand = control.getParser().getCommandFactory().createCommand("Constant");
		//tempCommand.returnValue();
	}
}
*/
