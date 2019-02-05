package ua.nure.pihnastyi.practice6.part2;

import java.util.*;

public class Part2 {

    private static final int MAX_ELEMENTS = 10_000;
    private static final int K = 3;

    public static long removeByIndex(List<Object> list, final int k) {
        long startTime = System.currentTimeMillis();
        int listIndex = 0;
        int index = 1;
        while (list.size() > 1) {
            if (listIndex >= list.size()) {
                listIndex = 0;
            }
            if (index == k) {
                list.remove(listIndex);
                index = 1;
                continue;
            }
            listIndex++;
            index++;
        }
        return System.currentTimeMillis() - startTime;
    }

    public static long removeByIterator(List<Object> list, final int k) {
        long startTime = System.currentTimeMillis();
        int listIndex = 0;
        int index = 1;
        Iterator iterator = list.iterator();
        while (list.size() > 1) {
            if (listIndex >= list.size()) {
                iterator = list.iterator();
            }
            while (iterator.hasNext()) {
                if (index == k && list.size() > 0) {

                    iterator.next();
                    iterator.remove();
                    index = 1;
                    break;

                }
                iterator.next();
                listIndex++;
                index++;

            }

        }
        return System.currentTimeMillis() - startTime;
    }

    public static List<Object> init(List<Object> list) {
        for (int i = 0; i < MAX_ELEMENTS; i++) {
            list.add("People number: " + i);
        }
        return list;
    }

    public static void main(String[] args) {
        long resultTime;


        System.out.println("=========== Indexed");
        List<Object> arrayList = init(new ArrayList<>());
        List<Object> linkedList = init(new LinkedList<>());

        resultTime = removeByIndex(arrayList, K);
        System.out.println(resultTime);
        resultTime = removeByIndex(linkedList, K);
        System.out.println(resultTime);

        System.out.println("=========== Iterable");
        arrayList = init(new ArrayList<>());
        linkedList = init(new LinkedList<>());

        resultTime = removeByIterator(arrayList, K);
        System.out.println(resultTime);
        resultTime = removeByIterator(linkedList, K);
        System.out.println(resultTime);
    }
}