package com.saillen.study.jvm.gc;

/**
 * -XX:-DoEscapeAnalysis -XX:-EliminateAllocations -XX:-UseTLAB
 *
 * -XX:PrintFlagsFinal
 *
 * @author : saillen
 * @date: 2020/4/23
 **/
public class TestTLABDemo {

    static class User {
        String name;
        int id;

        User(String name, int id) {
            this.name = name;
            this.id = id;
        }
    }

    public static void allocation(int id) {
        new User("name:" + id, id);
    }

    public static void main(String[] args) {
        long started = System.currentTimeMillis();
        for (int i = 0; i < 10_000_000; i++) {
            allocation(i);
        }
        System.out.println(System.currentTimeMillis() - started);
    }


}
