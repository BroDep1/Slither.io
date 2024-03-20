import java.awt.*;

public class Slither {
    double x;
    double y;
    double dx;
    double dy;
    Tail tail = new Tail();

    void appear(double x, double y, double dx, double dy){

        if (Math.abs(dx) > Math.abs(dy)) {
            dx = dx/Math.abs(dx);

            StdDraw.setPenColor(34, 177, 76);
            StdDraw.filledSquare(x, y, 2.5);

            StdDraw.setPenColor(49, 86, 39);
            StdDraw.filledRectangle(x + 1.3 * dx, y + 2.1, 1.25, 0.6);
            StdDraw.filledRectangle(x + 1.3 * dx, y - 2.1, 1.25, 0.6);

            //StdDraw.setPenColor(Color.red);
            //StdDraw.filledRectangle(x + 3 * dx, y, 0.5, 0.3);

            StdDraw.setPenColor(Color.BLACK);
            StdDraw.filledSquare(x - 1.1 * dx, y + 1.1, 0.4);
            StdDraw.filledSquare(x - 1.1 * dx, y - 1.1, 0.4);

            StdDraw.setPenColor(0, 70, 0);
            StdDraw.filledCircle(x + 1.8 * dx, y + 0.6, 0.3);
            StdDraw.filledCircle(x + 1.8 * dx, y - 0.6, 0.3);
        }
        else{
            dy = dy/Math.abs(dy);

            StdDraw.setPenColor(34, 177, 76);
            StdDraw.filledSquare(x, y, 2.5);

            StdDraw.setPenColor(49, 86, 39);
            StdDraw.filledRectangle(x - 2.1, y + 1.3 * dy, 0.6, 1.25);
            StdDraw.filledRectangle(x + 2.1, y + 1.3 * dy, 0.6, 1.25);

            //StdDraw.setPenColor(Color.red);
            //StdDraw.filledRectangle(x , y + 3 * dy, 0.3, 0.5);

            StdDraw.setPenColor(Color.BLACK);
            StdDraw.filledSquare(x + 1.1, y - 1.1 * dy, 0.4);
            StdDraw.filledSquare(x - 1.1, y - 1.1 * dy, 0.4);

            StdDraw.setPenColor(0, 70, 0);
            StdDraw.filledCircle(x + 0.6, y + 1.8 * dy, 0.3);
            StdDraw.filledCircle(x - 0.6, y + 1.8 * dy, 0.3);
        }
    }
    Slither(){
        x = (int) (Math.random() * 90 + 5);
        y = (int) (Math.random() * 90 + 5);

        if (Math.random() > Math.random()){
            if (Math.random() > Math.random()){
                dx = 5;
            }
            else{
                dx = -5;
            }
        }
        else{
            if (Math.random() > Math.random()){
                dy = 5;
            }
            else {
                dy = -5;
            }
        }
        appear(x, y, dx, dy);
    }
    void move(){
        x = x + dx;
        y = y + dy;
        appear(x, y, dx, dy);
        tail.appear(x, y, dx, dy);
        clear();

    }
    void clear(){
        StdDraw.setPenColor(49, 86, 39);
        if(tail.tail.head != null) {
            StdDraw.filledRectangle(tail.tail.head.x, tail.tail.head.y, 2.6, 2.6);
        }
        else{
            StdDraw.filledRectangle(x - dx, y - dy, 2.6, 2.6);
        }
    }
    void control(){
            if (StdDraw.hasNextKeyTyped()){
                    char ch = StdDraw.nextKeyTyped();
                    if (ch == 'w' & dy == 0){
                        StdDraw.setPenColor(49, 86, 39);
                        StdDraw.filledRectangle(x, y - 2.1, 2.5, 0.6);
                        StdDraw.filledRectangle(x + 2 * dx/Math.abs(dx), y, 0.6, 1.6);
                        x = x - dx/Math.abs(dx);
                        y = y + 1;
                        dy = 5;
                        dx = 0;

                    }
                    else {
                        if (ch == 's' & dy == 0){
                            StdDraw.setPenColor(49, 86, 39);
                            StdDraw.filledRectangle(x, y + 2.1, 2.5, 0.6);
                            StdDraw.filledRectangle(x + 2 * dx/Math.abs(dx), y, 0.6, 1.6);
                            x = x - dx/Math.abs(dx);
                            y = y - 1;
                            dy = -5;
                            dx = 0;
                        }
                        else{
                            if (ch == 'a' & dx == 0){
                                StdDraw.setPenColor(49, 86, 39);
                                StdDraw.filledRectangle(x + 2.1, y, 0.6, 2.5);
                                StdDraw.filledRectangle(x, y + 2 * dy/Math.abs(dy), 1.6, 0.6);
                                x = x - 1;
                                y = y - dy/Math.abs(dy);
                                dx = -5;
                                dy = 0;
                            }
                            else{
                                if (ch == 'd' & dx == 0){
                                    StdDraw.setPenColor(49, 86, 39);
                                    StdDraw.filledRectangle(x - 2.1, y, 0.6, 2.5);
                                    StdDraw.filledRectangle(x, y + 2 * dy/Math.abs(dy), 1.6, 0.6);
                                    x = x + 1;
                                    y = y - dy/Math.abs(dy);
                                    dx = 5;
                                    dy = 0;
                                }
                            }
                        }
                    }
                }

    }
}
