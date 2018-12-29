package com.company.Model;

import java.util.ArrayList;
import java.util.List;

public class LongestWord {
    public int getWordLength() {
        return wordLength;
    }

    public void setWordLength(int wordLength) {
        this.wordLength = wordLength;
    }

    public List<String> getLongestWords() {
        return longestWords;
    }

    public void setLongestWords(List<String> longestWords) {
        this.longestWords = longestWords;
    }

    int wordLength;
    List<String> longestWords;
}
