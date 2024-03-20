class List{
    Node head;
    Node cur;
    Node cur_ch;
    int count = 0;
    List(){

    }

    List(int[] arr){
        for (int j : arr) {
            add_last(j);
        }
    }

    List(int n, int def){
        for (int i = 0; i < n; i++) {
            add_last(def);
        }
    }

    void add_first(int a){
        Node new_Node= new Node();
        new_Node.value= a;
        new_Node.next=head;
        head = new_Node;
        count++;
    }
    void add_last(int a) {
        Node cur = head;
        Node new_Node = new Node();
        new_Node.value = a;

        if (cur != null) {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new_Node;
        } else {
            head = new_Node;
        }
        count++;
    }
    void add_i (int a, int i){
        Node cur = head;
        Node new_Node = new Node();
        new_Node.value = a;
        int cur_i = 0;
        if (i < 2){
            add_first(a);
        } else {
            if (i > count){
                add_last(a);
            }
            else {
                while (cur_i != i - 2) {
                    cur = cur.next;
                    cur_i++;
                }
                new_Node.next = cur.next;
                cur.next = new_Node;
            }
        }
        count++;
    }
    int amount(){
        int count_slow = 0;
        Node box = head;

        if (box != null) {

            while (box != null) {

                count_slow++;
                box = box.next;

            }

        }
        return count_slow;
    }
    int amount_fast(){
        return count;
    }
    void print(String sep){
        Node tmp = head;
        while(tmp!=null){
            System.out.print(tmp.value+ sep);
            tmp=tmp.next;}
        System.out.println();
    }

}