package controller;

import data.Data;

public class Controller {
	private Data allData;
	private Parser parser;


	public Controller(){
		this.initData();
		parser = new Parser();
	}
	
	public Data getData(){
		return allData;
	}
	
	public Parser getParser() {
		return parser;
	}
	
	private void initData(){
		// TODO: Initial Data
		allData = new Data();
	}
	
	public void parse(String s){
		allData = parser.parse(s, allData);
	}
	
}
