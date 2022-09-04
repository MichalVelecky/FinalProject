package main;

import entity.Entity;

import object.Obj_Heart;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI
{
    public String currentDialogue = "";
    GamePanel gp;
    Graphics2D g2;
    Font arial_40;
    BufferedImage heart_full, heart_half, heart_blank;
    public boolean messageOn = false;
    public String message = "";

    public int commandNum = 0;
    public boolean runGame;

    /**
     * UI construcotr - text, font settings
     * @param gp game panel
     */
    public UI(GamePanel gp)
    {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);

        Entity heart = new Obj_Heart(gp);
        heart_full = heart.image;
        heart_half = heart.image1;
        heart_blank = heart.image2;
    }

    /**
     * method for showing the message
     * @param text text of the message
     */
    public void schowMessage(String text)
    {
        message = text;
        messageOn = true;
    }

    /**
     * Graphical represantation - menu, title, player life, pause, dialogue
     * @param g2 graphics component
     */
    public void draw(Graphics2D g2)
    {
        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.black);

        if (gp.gameState == gp.titleState)
        {
            drawTitleScreen();
        }

        if (gp.gameState == gp.playState)
        {
            drawPlayerLife();
        }

        if (gp.gameState == gp.pauseState)
        {
            drawPlayerLife();
            drawPauseScreen();
        }

        if (gp.gameState == gp.dialogueState)
        {
            drawDialogueScreen();
        }

        if (gp.gameState == gp.deadState)
        {
            gp.ui.currentDialogue = "GAME OVER \npres ESC to continue";
            drawDialogueScreen();
        }

        if (gp.gameState == gp.winState)
        {
            gp.ui.currentDialogue = "Congratulation :) \npres ESC to continue";
            drawDialogueScreen();
        }
    }

    /**
     * Dialogue screen graphics
     */
    public void drawDialogueScreen()
    {
        int x = gp.tileSize * 2;
        int y = gp.tileSize / 2;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 4;
        drawSubWindow(x, y, width, height);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN));
        x += gp.tileSize;
        y += gp.tileSize;

        for (String line : currentDialogue.split("\n"))
        {
            g2.drawString(line, x, y);
            y += 40;
        }
    }

    public void drawSubWindow(int x, int y, int width, int height)
    {
        Color c = new Color(255, 255, 255, 204);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(0, 0, 0, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
    }

    /**
     * Method for players life graphics
     */
    private void drawPlayerLife()
    {
        int x = gp.tileSize / 2;
        int y = gp.tileSize / 2;
        int i = 0;
        while (i < gp.player.maxLife / 2)
        {
            g2.drawImage(heart_blank, x, y, null);
            i++;
            x += gp.tileSize;
        }

        x = gp.tileSize / 2;
        i = 0;

        while (i < gp.player.life)
        {
            g2.drawImage(heart_half, x, y, null);
            i++;
            if (i < gp.player.life)
            {
                g2.drawImage(heart_full, x, y, null);
            }
            i++;
            x += gp.tileSize;
        }
    }

    /**
     * Title screen graphics - text, font, color, size...
     */
    private void drawTitleScreen()
    {
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 80F));
        currentDialogue = "Run Forest, RUN!!!";
        int x = getXforCenteredText(currentDialogue);
        int y = gp.tileSize * 3;

        g2.setColor(Color.RED);
        g2.drawString(currentDialogue, x + 6, y + 6);

        g2.setColor(Color.WHITE);
        g2.drawString(currentDialogue, x, y);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 30F));
        g2.drawString("DEMO", getXforCenteredText("DEMO"), 190);

        x = gp.screenWidth / 2 - (gp.tileSize * 2) / 2;
        y += gp.tileSize * 2;
        g2.drawImage(gp.player.down1, x, y, gp.tileSize * 2, gp.tileSize * 2, null);

        if (!runGame)
        {
            currentDialogue = "NEW GAME";
        }
        else
        {
            currentDialogue = "RESUME GAME";
        }

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48F));
        x = getXforCenteredText(currentDialogue);
        y += gp.tileSize * 3.5;
        g2.drawString(currentDialogue, x, y);

        if (commandNum == 0)
        {
            g2.drawString(">", x - gp.tileSize, y);
        }

        if (!runGame)
        {
            currentDialogue = "LOAD GAME";
        }
        else
        {
            currentDialogue = "SAVE GAME";
        }

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48F));
        x = getXforCenteredText(currentDialogue);
        y += gp.tileSize;
        g2.drawString(currentDialogue, x, y);

        if (commandNum == 1)
        {
            g2.drawString(">", x - gp.tileSize, y);
        }

        currentDialogue = "QUIT";
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48F));
        x = getXforCenteredText(currentDialogue);
        y += gp.tileSize;
        g2.drawString(currentDialogue, x, y);

        if (commandNum == 2)
        {
            g2.drawString(">", x - gp.tileSize, y);
        }
    }

    // LuckyBoy
    /**
     * Pause screen graphics
     */
    public void drawPauseScreen()
    {
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = getYforCenteredText(text);

        g2.drawString(text, x, y + gp.tileSize + gp.tileSize / 2);
    }

    // LuckyBoy
    /**
     * method for centering the X axis of a text
     * @param text text
     * @return X coordinate
     */
    public int getXforCenteredText(String text)
    {
        int lenght = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return (gp.screenWidth - lenght) / 2;
    }

    // LuckyBoy
    /**
     * method for centering the Y axis of a text
     * @param text text
     * @return Y coordinate
     */
    public int getYforCenteredText(String text)
    {
        int height = (int) g2.getFontMetrics().getStringBounds(text, g2).getHeight();
        return (gp.screenHeight - height) / 2;
    }
}
