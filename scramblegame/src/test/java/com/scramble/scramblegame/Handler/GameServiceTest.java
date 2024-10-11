package com.scramble.scramblegame.Handler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    @Test
    void mixWordTest() {

        GameService gameService = new GameService();
        String result = gameService.mixWord("Banana");
        System.out.println(result);
        assertNotNull(result);
    }

    @Test
    void correctWordReturnTest(){
        GameService gameService = new GameService();

        String result = gameService.newRandomWord();

        assertNotNull(result, "The word should not be null");
        System.out.println(result);
    }


}