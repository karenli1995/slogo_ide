package controller;

import model.Model;
import model.Turtle;

public class ViewController {
	
	Model myModel;
	
	public ViewController(Model model){
		myModel = model;
	}
	
	public Turtle getDefaultTurtle(){
		return myModel.getTurtle(0);
	}

}
