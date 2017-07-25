package com.stanimiriliev.chaptersix.processsentence;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Process the words in a sentence
 * @author Stanimir Iliev
 * @since 25.07.2017
 */
public class ProcessSentence {

    /**
     * Returns string which contains how many times every word is encountered
     * @param src the source string
     * @return the string with the information
     */
    public String commonWord(String src){
        String words[] = src.split(" ");
        StringBuilder output = new StringBuilder();
        List<String> passedWords = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            if (!passedWords.contains(words[i])) {
                passedWords.add(words[i]);
                int count = 0;
                for (int j = 0; j < words.length; j++) {
                    if (words[j].equals(words[i])) {
                        count++;
                    }
                }
                output.append(words[i] + ": " + count + ", ");
            }
        }
        return output.substring(0, output.length() - 2);//  Removes last comma
    }

    /**
     * Returns string which contains how many times every letter is encountered
     * @param src the source string
     * @return the letter which is encountered the most
     */
    public char commonLetter(String src){
        char letters[] = src.toCharArray();
        List<Character> passedLetters = new ArrayList<>();
        Map<Character, Integer> dict = new LinkedHashMap<>();
        for(char letter : letters){
            if(!passedLetters.contains(letter)) {
                passedLetters.add(letter);
                int count = 0;
                for(int i = 0; i < letters.length; i++){
                    if(letter == letters[i]){
                        count++;
                    }
                }
                dict.put(letter, count);
            }
        }
        char maxValue = ' ';
        int maxCount = 0;
        for(char letter : passedLetters){
            if(dict.get(letter) > maxCount){
                maxCount = dict.get(letter);
                maxValue = letter;
            }
        }
        return maxValue;
    }
}