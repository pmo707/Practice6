package ua.nure.pihnastyi.practice6.part1;


import java.util.*;


public class WordContainer {
    private List<Word> words;

    public WordContainer() {
        this.words = new ArrayList<>();
    }

    public void add(String s) {
        boolean flagAdd = true;
        for (Word word : words) {
            if (s.equalsIgnoreCase(word.getWord())) {
                word.incrementFrequency();
                flagAdd = false;
            }
        }
        if (flagAdd) {
            words.add(new Word(s));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Word word : words) {
            sb.append(word).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public void sort(Comparator<Word> comparator) {
        words.sort(comparator);
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in, "cp1251");
        WordContainer wc = new WordContainer();
        String s = "";
        while (true) {
            s = in.next();
            if ("stop".equals(s)) {
                break;
            }
            wc.add(s);
        }


        Comparator<Word> comparator = Word::compareTo;
        wc.sort(comparator);
        in.close();
        System.out.print(wc);
    }
}
