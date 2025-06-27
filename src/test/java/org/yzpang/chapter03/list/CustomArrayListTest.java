package org.yzpang.chapter03.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayListTest {
    private CustomArrayList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new CustomArrayList<>();
    }

    @Test
    void get() {
        list.add(1);
        list.add(2);
        list.add(3);
        Integer num = list.get(2);
        assertEquals(3, num);
    }

    @Test
    void set() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.set(2, 10);
        assertEquals(3, list.size());
        assertEquals(10, list.get(2));
    }

    @Test
    void remove() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.remove(2));
        assertEquals(2, list.size());
    }

    @Test
    void add() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
        list.add(1, 6);
        assertEquals(4, list.size());
        assertEquals(6, list.get(1));
        assertEquals(2, list.get(2));
    }

    @Test
    void listIterator() {
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer num = iterator.next();
            System.out.println(num);
        }
    }

    @Test
    void size() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
    }

    @Test
    void isEmpty() {
        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());
    }

    @Test
    void clear() {
        list.add(1);
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }
}