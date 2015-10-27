package view.turtles;



import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.scene.TurtleScene;


public class SlogoImage {
    private final Image myImage =
            new Image(getClass().getClassLoader().getResourceAsStream("Turtle.png"));
    private ImageView myImageView = new ImageView(myImage);

    private TurtleScene myTurtScene;

    private double myX;
    private double myY;

    public SlogoImage (TurtleScene turtlescene) {
        myTurtScene = turtlescene;
        setMyImage(myImageView);
        myX = 0;
        myY = 0;
    }
    
    public double setX (double x) {
        myX = x;
        return myX;
    }

    public double getX () {
        return myX;
    }

    public double setY (double y) {
        myY = y;
        return myY;
    }

    public double getY () {
        return myY;
    }

    public ImageView getMyImage () {
        return myImageView;
    }

    public void setMyImage (ImageView image) {
        myImageView = image;
        myImageView.setFitWidth(40);
        myImageView.setFitHeight(40);
    }

    public void changeTurtImage (ImageView image) {
        myTurtScene.removeChildren(myImageView);
        image.setFitHeight(40);
        image.setFitWidth(40);
        myImageView = image;
        myTurtScene.addChildren(image);
    }

    public Image getImage() {
        return myImage;
    }

    public void setRotation (double angle) {
        getMyImage().setRotate(angle);
    }

    public void showSlogoObject () {
        getMyImage().setVisible(true);
    }

    public void hideSlogoObject () {
        getMyImage().setVisible(false);
    }
}
