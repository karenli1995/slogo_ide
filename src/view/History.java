package view;

import javafx.scene.control.ScrollPane;

public class History {
	ScrollPane myHistory;
	
	private int myHistoryX = 600;
	private int myHistoryY = 10;

	History(){
		myHistory = new ScrollPane();
		myHistory.setTranslateX(myHistoryX);
		myHistory.setTranslateY(myHistoryY);
	}
	
	
	public void getHistory(){
		
	}
	
}
