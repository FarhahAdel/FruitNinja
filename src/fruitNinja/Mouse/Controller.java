package fruitNinja.Mouse;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Controller implements Initializable{
    @FXML
    private Canvas canvas;

    EventHandler<MouseEvent> mouseMovement;
    List<Sprite> fruits = new ArrayList<>();
    AnimationTimer timer;
    @FXML
    private ImageView img;
    Random random;
    GraphicsContext gc;
    final Image[] image = {null};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        random = new Random();
        gc=canvas.getGraphicsContext2D();
        generate();
        timer = new AnimationTimer() {

            @Override
            public void handle(long now) {

                for (Sprite s : fruits) {
                    s.move(now);
                }
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

                if (fruits.isEmpty()) {
                    generate();
                } else {
                    for (Sprite s : fruits) {
                        if (!s.hasMovedOffScreen())
                            s.render(gc);
                    }
                    Iterator<Sprite> iter = fruits.iterator();

                    while (iter.hasNext()) {
                        Sprite str = iter.next();
                        if (str.hasMovedOffScreen()) {
                            iter.remove();
                            str.resetObject(random.nextDouble() * 800, random.nextDouble() * 800);
                            str.render(gc);
                        }
                    }

                }
            }

        };

       timer.start();
        Image finalImage = image[0];
        mouseMovement= new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                for (int i=0;i<fruits.size();i++){
                    double CurrentFruitXLocation = fruits.get(i).getXlocation();
                    double CurrentFruitYLocation = fruits.get(i).getYlocation();
                    if(event.getX()>=CurrentFruitXLocation&&event.getX()<=CurrentFruitXLocation+finalImage.getWidth()&&event.getY()>=CurrentFruitYLocation&& event.getY()<=CurrentFruitYLocation+ finalImage.getHeight()&&!fruits.get(i).isSliced())
                    {
                        fruits.get(i).slice(new Image(getClass().getResource("straw_2.png").toExternalForm()));
                    }
                }
            }
        };


        canvas.setOnMouseDragged(mouseMovement);

    }
    private void generate()
    { //generate wave
        for(int i =0;i<5;i++)
        {
            double XLoc=100+(random.nextDouble()*800);
            double YLoc=Math.random() * (900 - 800 + 1) + 800;
            image[0] = new Image(getClass().getResource("straw_1.png").toExternalForm());
            Sprite fruit = new Sprite(XLoc,YLoc, image[0],10);
            fruits.add(fruit);
            fruit.render(gc);
        }
    }
}