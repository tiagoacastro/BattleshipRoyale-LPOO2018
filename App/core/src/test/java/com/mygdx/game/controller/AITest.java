package com.mygdx.game.controller;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.BattleShip;
import com.mygdx.game.view.DifficultyStage;
import com.mygdx.game.view.GameScreen;

import org.junit.Test;

import static org.junit.Assert.*;

public class AITest {

    @Test
    public void EasyModeWin() {
        EasyBehaviour behaviour = new EasyBehaviour();

        BoardController board= new BoardController();

        int cells = BoardController.getDimension() * BoardController.getDimension();
        for (int i = 0; i < cells; i++){
            behaviour.shoot(board);
        }
    }

    @Test
    public void HardModeWin() {
        HardBehaviour behaviour = new HardBehaviour();

        BoardController board= new BoardController();

        int cells = BoardController.getDimension() * BoardController.getDimension();
        for (int i = 0; i < cells; i++){
            behaviour.shoot(board);
        }
    }

    @Test
    public void CrazyModeWin() {
        HardBehaviour behaviour = new HardBehaviour();

        BoardController board= new BoardController();

        int cells = BoardController.getDimension() * BoardController.getDimension();
        for (int i = 0; i < cells; i++){
            behaviour.shoot(board);
        }
    }
}