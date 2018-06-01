package com.mygdx.game.utility;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Class for producing buttons with the style we desire
 */
public class ButtonFactory {
    private static FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));;
    private static FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
    private static BitmapFont font;
    /**
     * ButtonFactory constructor that sets up the font
     */
    public ButtonFactory() {
        parameter.size = 80;
        parameter.color = Color.LIGHT_GRAY;
        parameter.borderColor = Color.BLACK;
        parameter.borderWidth = 1;
        parameter.shadowOffsetX = 2;
        parameter.shadowOffsetY = 2;
        parameter.shadowColor = Color.DARK_GRAY;
        font = generator.generateFont(parameter);
    }
    /**
     * Creator for a brand new text button
     * @param text  text
     * @param size  text size
     * @return  text button
     */
    static public TextButton createButton(String text, int size) {

        parameter.size = size;
        font = generator.generateFont(parameter);
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = font;
        return new TextButton(text, style);
    }
}
