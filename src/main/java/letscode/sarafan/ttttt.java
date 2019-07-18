package letscode.sarafan;

import letscode.sarafan.domain.Message;

import java.util.*;

public class ttttt {

    public static void main(String[] args) {
        Message message = new Message();
        Message message2 = new Message();
        message.setText("text");
        message2.setText("Fac");
//        List <User> list = new ArrayList();
//        list.add(new User(1l, "ww"));
//        list.add(new User(6l, "ww"));
//        list.add(new User(3l, "ww"));
//        list.add(new User(3l, "dd"));
//        System.out.println(list);
//
////        list.sort((a, b) -> {
////            return b.getId().compareTo(a.getId());
////        });
//         String d ="sdgjjjdfvh";
//         d.replace("jjj", "");
//        System.out.println(d);


        long start, finish;
        start = System.currentTimeMillis();
        Set<Message> set =   check(message, message2);
        finish = System.currentTimeMillis();
        System.out.println(finish - start);

        start = System.currentTimeMillis();
        System.out.println(set.contains(message2));
        finish = System.currentTimeMillis();
        System.out.println(finish - start);


    }

    private static void cont(Message message, Message message2) {

    }

    public static Set<Message> check(Message message, Message message2) {
        Set<Message> set = new HashSet<>();
        for (int i = 0; i < 100000000; i++) {
            set.add(message);
        }
        set.add(message2);
        for (int i = 0; i < 100000000; i++) {
            set.add(message);
        }

        System.out.println(set.contains(message2));
        return set;
    }

}
