package controller;

import model.Model;
import model.Turtle;

public class ViewController {
	
	Model myModel;
	
	public ViewController(Model model){
		myModel = model;
	}
	
	public Model getModel(){
		return myModel;
	}
	
	public Turtle getDefaultTurtle(){
		return myModel.getTurtle(0);
	}

}
