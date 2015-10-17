package model;

import javafx.scene.paint.Color;

public class Pen extends AbstractPen { // class with properties of the path


	public Pen() {
		super(Color.BLACK, 1, 0, 1.0);
	}

	public Pen(AbstractPen pen) {
		super(pen.myColor, pen.myThickness, pen.myDashSparsity, pen.myStatus);
	}

}