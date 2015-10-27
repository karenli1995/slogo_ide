package view.props;

import java.util.ResourceBundle;
import controller.ModelController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import view.scene.TurtleScene;


public class PenProps extends AbstractProperties {

    PenProps (TurtleScene scene, ResourceBundle resource, ModelController controller) {
        super(scene, resource, controller);
    }

    @Override
    protected void createTab () {
        setText(myResource.getString("PENPROPTITLE"));
        VBox vb = new VBox();
        HBox hb1 = addPenColorLabel();
        HBox hb2 = addPenThicknessLabel();
        HBox hb3 = addPenPosLabel();
        HBox hb4 = addPenShapeLabel();

        setAllMargins(allElements);

        vb.getChildren().addAll(hb1, hb2, hb3, hb4);
        setContent(vb);
    }

    private HBox addPenColorLabel () {
        int mySceneId = myTurtleScene.getIdOfTab();

        HBox hb6 = new HBox();
        Label penColor = new Label(myResource.getString("PENC"));
        final ComboBox<Color> cbColors = new ColorComboBox();
        hb6.getChildren().addAll(penColor, cbColors);
        cbColors.setOnAction( (event) -> {
            for(int i = 0; i<myController.getMyScene().getTurtleData(mySceneId).activeTurtleListSize();i++){
                int turt = myController.getMyScene().getTurtleData(mySceneId).activeTurtleListValue(i);
            Color chosenColor = cbColors.getSelectionModel().getSelectedItem();
            myController.getMyScene().getTurtleData(mySceneId).getAllTurtles().get(turt).getPen()
                    .setColor(chosenColor);

            }});
        allElements.add(penColor);
        allElements.add(cbColors);

        return hb6;
    }

    private HBox addPenThicknessLabel () {
        int mySceneId = myTurtleScene.getIdOfTab();

        HBox hb8 = new HBox();
        Label thickLabel = new Label(myResource.getString("THICK"));
        ObservableList<Integer> thicks = FXCollections.observableArrayList(1, 2, 3, 4, 5);
        ComboBox<Integer> thicknesses = new ComboBox<Integer>(thicks);
        thicknesses.setOnAction( (e) -> {
            for(int i = 0; i<myController.getMyScene().getTurtleData(mySceneId).activeTurtleListSize();i++){
                int turt = myController.getMyScene().getTurtleData(mySceneId).activeTurtleListValue(i);
            Integer thick = thicknesses.getSelectionModel().getSelectedItem();
            myController.getMyScene().getTurtleData(mySceneId).getAllTurtles().get(turt).getPen()
                    .setThickness(thick);
            }});
        
        hb8.getChildren().addAll(thickLabel, thicknesses);

        allElements.add(thickLabel);
        allElements.add(thicknesses);

        return hb8;
    }

    private HBox addPenPosLabel () {
        int mySceneId = myTurtleScene.getIdOfTab();

        HBox hb8 = new HBox();
        Label penPosLabel = new Label(myResource.getString("PENPOS"));
        ObservableList<String> pos = FXCollections.observableArrayList("Up", "Down");
        ComboBox<String> positions = new ComboBox<String>(pos);
        positions.setOnAction( (e) -> {
            for(int i = 0; i<myController.getMyScene().getTurtleData(mySceneId).activeTurtleListSize();i++){
                int turt = myController.getMyScene().getTurtleData(mySceneId).activeTurtleListValue(i);
            String chosenPos = positions.getSelectionModel().getSelectedItem();
            if (chosenPos == "Up") {
                myController.getMyScene().getTurtleData(mySceneId).getAllTurtles().get(turt).getPen()
                        .setPenDown(0.0);
            }
            if (chosenPos == "Down") {
                myController.getMyScene().getTurtleData(mySceneId).getAllTurtles().get(turt).getPen()
                        .setPenDown(1.0);
            }
           }});
        
        hb8.getChildren().addAll(penPosLabel, positions);

        allElements.add(penPosLabel);
        allElements.add(positions);

        return hb8;
    }

    private HBox addPenShapeLabel () {
        HBox hb8 = new HBox();
        int mySceneId = myTurtleScene.getIdOfTab();
        Label penShapeLabel = new Label(myResource.getString("PENSH"));
        ObservableList<String> shape =
                FXCollections.observableArrayList("Solid", "Dashed", "Dotted");
        ComboBox<String> shapes = new ComboBox<String>(shape);
        shapes.setOnAction( (e) -> {
            for(int i = 0; i<myController.getMyScene().getTurtleData(mySceneId).activeTurtleListSize();i++){
                int turt = myController.getMyScene().getTurtleData(mySceneId).activeTurtleListValue(i);
            String chosenShape = shapes.getSelectionModel().getSelectedItem();
            if (chosenShape == "Solid") {
                myController.getMyScene().getTurtleData(mySceneId).getAllTurtles().get(turt).getPen()
                        .setDashes(1.0);
            }
            if (chosenShape == "Dashed") {
                myController.getMyScene().getTurtleData(mySceneId).getAllTurtles().get(turt).getPen()
                        .setDashes(5.0);
            }
            if (chosenShape == "Dotted") {
                myController.getMyScene().getTurtleData(mySceneId).getAllTurtles().get(turt).getPen()
                        .setDashes(2.0);
            }
            }});
        
        hb8.getChildren().addAll(penShapeLabel, shapes);

        allElements.add(penShapeLabel);
        allElements.add(shapes);

        return hb8;
    }
}
