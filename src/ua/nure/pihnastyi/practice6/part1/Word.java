package ua.nure.pihnastyi.practice6.part1;

import java.util.Objects;

public class Word implements Comparable<Word>{
    private String word;
    private int frequency;
    private char[] value;

    public Word(String word){
        if(checkWord(word)){
            throw new IllegalArgumentException();
        }
        value = word.toCharArray();
        this.word = word;
        frequency = 1;

    }

    private boolean checkWord(String word) {
        return (word.contains(",") || word.contains("!") || word.contains(".") || word.contains("?"));
    }

    public void incrementFrequency(){
        frequency++;
    }

    public String getWord() {
        return word;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return frequency == word1.frequency &&
                Objects.equals(word, word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, frequency);
    }

    @Override
    public int compareTo(Word anotherString) {
        int freq1 = frequency;
        int freq2 = anotherString.frequency;

        if(freq2 == freq1){
            int len1 = value.length;
            int len2 = anotherString.value.length;
            int lim = Math.min(len1, len2);
            char v1[] = value;
            char v2[] = anotherString.value;
            int k = 0;
            while (k < lim) {
                char c1 = v1[k];
                char c2 = v2[k];
                if (c1 != c2) {
                    return c1 - c2;
                }
                k++;
            }
        }

        return freq2 - freq1;
    }

    @Override
    public String toString() {
        return word + " : " + frequency;
    }
}