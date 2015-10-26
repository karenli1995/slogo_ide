package view.shapes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import controller.ModelController;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import view.scene.TurtleScene;


public class StraightLine extends AbstractShape {
    protected List<Line> myAllShapes = new ArrayList<Line>();

    public StraightLine (TurtleScene turtlescene, ModelController controller) {
        super(turtlescene, controller);
        Line myRecentLine = new Line();
        myAllShapes.add(myRecentLine);
    }

    public List<Line> getAllLines () {
        return myAllShapes;
    }

    @Override
    public ArrayList<Line> drawShape (List<Point2D> currTrailList,
                                      List<Double> currPenStatus,
                                      List<String> penColors,
                                      List<Integer> penThicks,
                                      List<Double> penDash) {
        int mySceneId = myTurtScene.getIdOfTab();
        ArrayList<Line> ret = new ArrayList<Line>();
        for (int i = 0; i < currTrailList.size() - 1; i++) {
            if (currPenStatus.get(i + 1) == 1.0) {
                Point2D point1 = translateForScreen(currTrailList.get(i));
                Point2D point2 = translateForScreen(currTrailList.get(i + 1));
                // System.out.println(point1.getY() + " " + point2.getY());
                Line recentLine =
                        new Line(point1.getX(), point1.getY(), point2.getX(), point2.getY());
                recentLine.setStroke(Color.web(penColors.get(i)));
                recentLine.setStrokeWidth(penThicks.get(i));
                // if (penDash.get(i) != 0.0) {
                recentLine.getStrokeDashArray().add(0, penDash.get(i));
                // }
                myAllShapes.add(recentLine);
                ret.add(recentLine);
            }
        }
        return ret;
        // should call getAllTrails from the Data instead?
    }

}
