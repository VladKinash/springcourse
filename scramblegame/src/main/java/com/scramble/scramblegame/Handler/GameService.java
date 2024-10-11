package com.scramble.scramblegame.Handler;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameService {

    public String originalWord;
    public String scrambledWord;

    public String getOriginalWord(){
        return originalWord;
    }

    public String getScrambledWord(){
        return scrambledWord;
    }

    GameService(){
        restartGame();
    }

    public void restartGame(){
        originalWord = newRandomWord();
        scrambledWord = mixWord(originalWord);
    }

    //Randomly chooses a word from an existing array with strings
    public String newRandomWord(){
        Random random = new Random();
        String[] stringArray = {"apple", "banana", "cherry", "date", "elderberry"};

        int min = 0;
        int max = stringArray.length;

        return stringArray[random.nextInt(max - min) + min];
    }

    //Uses Knuth shuffle algorithm to mix the chars of the string
    public String mixWord(String word){
        Random random = new Random();
        char[] wordArray = word.toCharArray();
        int randomIndex;
        char temp;

        for(int i = wordArray.length - 1; i > 0; i--){
            randomIndex = random.nextInt(i + 1);
            temp = wordArray[i];
            wordArray[i] = wordArray[randomIndex];
            wordArray[randomIndex] = temp;
        }

        System.out.println(wordArray);
        return String.valueOf(wordArray);
    }

    //validates whether user input == original unscrambled word
    public boolean validateGuess(String guess, String Original){
        return guess.equals(Original);
    }


}
