package ua.nure.pihnastyi.practice6.part1;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class WordContainer {
    private List<Word> words;

    public WordContainer(){
        this.words =  new ArrayList<>();
    }

    public void add(String s){
       boolean flagAdd = true;
        for (Word word : words){
            if(s.equalsIgnoreCase(word.getWord())){
                word.incrementFrequency();
                flagAdd = false;
            }
        }
        if (flagAdd){
            words.add(new Word(s));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Word word:words){
            sb.append(word).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public void sort(){
        Collections.sort(words);
    }




}
