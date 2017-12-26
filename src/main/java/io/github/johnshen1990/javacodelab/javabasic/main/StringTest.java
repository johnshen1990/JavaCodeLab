package io.github.johnshen1990.javacodelab.javabasic.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Author: zhun.shen
 * Date: 2017-07-16 13:52
 * Description:
 */
public class StringTest {

    public static class User {
        String name;
        int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        String str1 = "China";
        String str2 = "China";
        System.out.println(str1 == str2); // true

        String str3 = new String("China");
        String str4 = new String("China");
        System.out.println(str1 == str3); // false
        System.out.println(str3 == str4); // false

        String str5 = str4.intern();
        System.out.println(str1 == str5); // true
        System.out.println(str3 == str5); // false
        System.out.println(str4 == str5); // false


        User zhangsan = new User("zhangsan", 15);
        User lisi = new User("lisi", 20);

        List<User> list = new ArrayList<>();
        list.add(zhangsan);
        list.add(lisi);
//
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            Integer i = iterator.next();
//        }
        for(User user :  list) {
            user.setAge(100);
        }


        for(User user : list) {
            System.out.println(user);
        }
    }
}
