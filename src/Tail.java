public class Tail {
    double length;
    List tail = new List();
    void appear(double x, double y, double dx, double dy){
        tail.cur = tail.head;
            if (tail.cur != null){
                clear_head(x, y, dx, dy);
                while(tail.cur.next != null) {
                    tail.cur.x = tail.cur.next.x;
                    tail.cur.y = tail.cur.next.y;
                    tail.cur.dx = tail.cur.next.dx;
                    tail.cur.dy = tail.cur.next.dy;
                    appear_alone(tail.cur.x, tail.cur.y, tail.cur.dx ,tail.cur.dy);
                    tail.cur = tail.cur.next;
                }

                tail.cur.x = x - dx;
                tail.cur.y = y - dy;
                tail.cur.dx = dx;
                tail.cur.dy = dy;
                //System.out.println(tail.cur.dx);
                appear_alone(tail.cur.x, tail.cur.y, tail.cur.dx, tail.cur.dy);
            }

    }
    void clear_head(double x, double y, double dx, double dy){

        if (Math.abs(dx) > Math.abs(dy)) {
            StdDraw.setPenColor(34, 177, 76);
            StdDraw.filledRectangle(x - dx, y, 2.5, 1.5);

            StdDraw.setPenColor(49, 86, 39);
            StdDraw.filledRectangle(x - dx, y + 2, 2.6, 0.6);
            StdDraw.filledRectangle(x - dx, y - 2, 2.6, 0.6);
        }
        else {
            StdDraw.setPenColor(34, 177, 76);
            StdDraw.filledRectangle(x, y - dy, 1.5, 2.5);

            StdDraw.setPenColor(49, 86, 39);
            StdDraw.filledRectangle(x + 2, y - dy, 0.6, 2.6);
            StdDraw.filledRectangle(x - 2, y - dy, 0.6, 2.6);
        }
    }


    void appear_alone(double x, double y, double dx, double dy){
        if (dx != 0 | dy != 0) {
            if (Math.abs(dx) < Math.abs(dy)) {
                StdDraw.setPenColor(34, 177, 76);
                StdDraw.filledRectangle(x, y, 1.5, 2.5);

                /*StdDraw.setPenColor(49, 86, 39);
                StdDraw.filledRectangle(x - 2.5, y, 1, 2.6);
                StdDraw.filledRectangle(x + 2.5, y, 1, 2.6);*/

                StdDraw.setPenColor(29, 148, 65);
                StdDraw.filledRectangle(x, y + 2 * dy / Math.abs(dy), 1.5, 0.5);
                //StdDraw.filledRectangle(x, y - 2, 1.5, 0.5);
            } else {
                StdDraw.setPenColor(34, 177, 76);
                StdDraw.filledRectangle(x, y, 2.5, 1.5);

                /*StdDraw.setPenColor(49, 86, 39);
                StdDraw.filledRectangle(x, y - 2.5, 2.6, 1);
                StdDraw.filledRectangle(x, y + 2.5, 2.6, 1);*/

                StdDraw.setPenColor(29, 148, 65);
                StdDraw.filledRectangle(x + 2 * dx / Math.abs(dx), y, 0.5, 1.5);
                //StdDraw.filledRectangle(x, y - 2, 1.5, 0.5);
            }
        }
    }

}
