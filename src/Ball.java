import java.awt.*;

public class Ball {
    double x;
    double y;
    double radius = 2;
    Ball(){
        appear();
        draw();
    }
    void appear(){
        x = (int) (Math.random() * 90 + 5);
        y = (int) (Math.random() * 90 + 5);
    }
    void clear(){
        StdDraw.setPenColor(49, 86, 39);
        StdDraw.filledCircle(x , y, radius+0.1);
    }
    void draw(){
        StdDraw.setPenColor(Color.YELLOW);
        StdDraw.filledCircle(x, y, radius);
    }
}
