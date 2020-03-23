package com.saillen.study.data.structure.base;


import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * @author : saillen
 * @date: 2020/3/21
 **/

public class MyArrayListTest {

    MyList<String> a = new MyArrayList<String>(10);

    @Test
    public void size() {
        a.add("22");
        System.out.println(a.get(0));
        a.set(2,"22");
        a.remove(0);
        System.out.println(a.contains("22"));
        System.out.println(a.size() + "");
    }

    @Test
    public void contains() {
    }

    @Test
    public void add() {
    }

    @Test
    public void set() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void get() {
    }
}
