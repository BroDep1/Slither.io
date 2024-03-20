import java.awt.*;

public class Menu {
    Menu(){
    }
    void start(){
        StdDraw.picture(45, 45, "Images/Play.png");
        int x = 1;
        while(x == 1) {
            while (StdDraw.mouseX() < 90 & StdDraw.mouseX() > 12 & StdDraw.mouseY() < 72 & StdDraw.mouseY() > 32) {
                if (StdDraw.isMousePressed() == true) {
                    return;
                }
            }
        }
    }
    void game_over(int score){
        StdDraw.picture(51, 50, "Images/Game Over.png", 110, 60);
        StdDraw.setPenColor(Color.black);
        Font font =  new Font("Rog fonts",1,72);
        StdDraw.setFont(font);
        StdDraw.textLeft(64, 39.5, String.valueOf(score));
    }
}
