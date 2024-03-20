public class FPS {
    Ball MyBall = new Ball();
    Slither MySlither = new Slither();
    Menu menu = new Menu();
    int delay;
    int score;
    double sum_ball = MyBall.radius + 2.5;
    int a = 0;
    void fps(){
        MySlither.tail.tail.add_last(score);
        delay = 200;
        while (a != 1){
            MySlither.control();
            MySlither.move();
            StdDraw.show(delay);
            good_compare();
            bad_compare();
            bad_compare_wall();
            if (a == 1){
                return;
            }
        }
        menu.game_over(score);
    }
    void bad_compare_wall(){
        if (MySlither.x + 2.5 >= 100 | MySlither.x - 2.5 <= 0 | MySlither.y + 2.5 >= 100 | MySlither.y - 2.5 <= 0){
            while (MySlither.tail.tail.head.x <= 100 | MySlither.tail.tail.head.x >= 0 | MySlither.tail.tail.head.y <= 100 | MySlither.tail.tail.head.y >= 0){
                MySlither.move();
                StdDraw.show(delay);
                menu.game_over(score);
            }

        }
    }
    void bad_compare(){
        MySlither.tail.tail.cur_ch = MySlither.tail.tail.head;
        if (MySlither.tail.tail.cur_ch.next != null) {
            while (MySlither.tail.tail.cur_ch.next.next != null) {
                if (Math.abs(MySlither.x - MySlither.tail.tail.cur_ch.x) <= 2.5 & Math.abs(MySlither.y - MySlither.tail.tail.cur_ch.y) <= 2.5) {
                    menu.game_over(score);
                    a = 1;
                }
                MySlither.tail.tail.cur_ch = MySlither.tail.tail.cur_ch.next;
            }
        }
    }
    void good_compare(){
        if (Math.abs(MySlither.x - MyBall.x) <= sum_ball & Math.abs(MySlither.y - MyBall.y) <= sum_ball){
            score++;
            MySlither.tail.tail.add_last(score);
            MyBall.clear();
            good_compare_check();
            if (delay > 50) {
                delay = (int) (0.97 * delay);
            }
        }
    }
    void good_compare_check(){
        MyBall.appear();
        MySlither.tail.tail.cur_ch = MySlither.tail.tail.head;
        while (MySlither.tail.tail.cur_ch != null){
            if (Math.abs(MyBall.x - MySlither.tail.tail.cur_ch.x) <= sum_ball & Math.abs(MyBall.y - MySlither.tail.tail.cur_ch.y) <= sum_ball){
                good_compare_check();
            }
            else{
                MySlither.tail.tail.cur_ch = MySlither.tail.tail.cur_ch.next;
            }
        }
        MyBall.draw();
        MySlither.tail.tail.cur_ch = MySlither.tail.tail.head;
    }

}
