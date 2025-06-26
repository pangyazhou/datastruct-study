package org.yzpang.chapter03.list;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomListTest {



    @Test
    void testArrayList() {
        int size = 800000;
        List<Integer> list = new ArrayList<>(size);
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("ArrayList create duration: " + (end - start));

        removeElementEven(list);
        start = System.currentTimeMillis();
        System.out.println("ArrayList remove duration: " + (start - end));
    }

    @Test
    void testLinkedList() {
        int size = 800000;
        List<Integer> list = new LinkedList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("LinkedList create duration: " + (end - start));

        removeElementEven(list);
        start = System.currentTimeMillis();
        System.out.println("LinkedList remove duration: " + (start - end));
    }

    private void removeElementEven(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }
    }
}