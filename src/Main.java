public class Main {

    public static void main(String[] args) {
        Map menu_map = new Map();
        Menu menu =  new Menu();

        menu.start();

        Map map = new Map();
        FPS fps = new FPS();
        fps.fps();

        menu.game_over(fps.score);
    }
}
