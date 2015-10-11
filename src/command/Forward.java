package command;

import java.text.DecimalFormat;

import javafx.scene.image.ImageView;
import model.Data;

public class Forward extends Command{


private ImageView myTurtle;
	public Forward(Data allData) {
		super(allData);
		myTurtle= allData.getTurtle(0).getMyImage();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void returnValue() {
		execute( 50, 1) ;
		System.out.println("forward works");
	}
	double RoundTo2Decimals(double val) {
		DecimalFormat df2 = new DecimalFormat("###.##");
		return Double.valueOf(df2.format(val));
	}

	public void execute(int distance, int sign) {
		double tempXLocation;
		double tempYLocation;

		double degrees = myTurtle.getRotate();
		double radians = Math.toRadians(degrees);
		tempXLocation = RoundTo2Decimals(Math.sin(radians));
		tempYLocation = RoundTo2Decimals(Math.cos(radians));
		if (tempXLocation == 0.0 || tempXLocation == -0.0) {
			tempXLocation = myTurtle.getLayoutX();
		} else {
			tempXLocation = myTurtle.getLayoutX() + (distance / Math.sin(radians));
		}
		if (tempYLocation == 0.0 || tempYLocation == -0.0) {
			tempYLocation=(myTurtle.getLayoutY());
		} else {
			tempYLocation = myTurtle.getLayoutY() + (-distance / Math.cos(radians));
		}
		myTurtle.setLayoutX(tempXLocation);
		myTurtle.setLayoutY(tempYLocation);
	}



}
