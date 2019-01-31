package ua.nure.pihnastyi.practice6.part2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Part2 {

    private static final int MAX_ELEMENTS = 10_000;
    private static final int K = 3;

    public static void  removeByIndex(List<Object> list, final int k) {}
    public static void removeByIterator(List<Object> list, final int k) {}

    public static List<Object> init(List<Object> list) {
        // TODO add elements
        return list;
    }

    public static void main(String[] args) {
        List<Object> arrayList = init(new ArrayList<>());
        List<Object> linkedList = init(new LinkedList<>());

        System.out.println("=========== Indexed");
        // ...
        removeByIndex(arrayList, K);
        // ...
        removeByIndex(linkedList, K);
        // ...

        System.out.println("=========== Iterable");
        arrayList = init(new ArrayList<>());
        linkedList = init(new LinkedList<>());

        // ...
        removeByIterator(arrayList, K);
        // ...
        removeByIterator(linkedList, K);
        // ...
    }
}