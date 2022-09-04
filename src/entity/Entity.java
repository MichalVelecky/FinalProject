package entity;

import main.GamePanel;
import main.PositionEntity;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Entity
{
    GamePanel gp;
    public int worldX, worldY;
    public int speed;
    public int dialogNumber = 0;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2,
            upAttack1, upAttack2, downAttack1, downAttack2, leftAttack1, leftAttack2, rightAttack1, rightAttack2;
    public String direction = "down";
    public int type;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle colArea = new Rectangle(0, 0, 48, 48);
    public int colAreaDefaultX, colAreaDefaultY;
    public boolean collisionOn = false;
    public int actionCounter = 0;
    public BufferedImage image, image1, image2;

    public String name;
    public boolean collision = false;
    public boolean invincible = false;
    public int invincibleCounter = 0;
    public String[] dialogues = new String[20];

    public int maxLife;
    public int life;

    /**
     * Entity constructor
     * @param gp game panel
     */
    public Entity(GamePanel gp)
    {
        this.gp = gp;
    }

    /**
     * Method for setting the entity into active state
     */
    public void setAction()
    {
        follow();
        if (Objects.equals(gp.player.princessState, "follow"))
        {
            gp.npcPrincess.princessFollow();
        }
        randomMovement();
    }

    /**
     * Method for random movement
     */
    private void randomMovement()
    {
        actionCounter++;
        if (actionCounter == 120)
        {
            Random random = new Random();
            int i = random.nextInt(100) + 1;
            if (i <= 25)
            {
                direction = "up";
            }
            if (i > 25 && i <= 50)
            {
                direction = "down";
            }
            if (i > 50 && i <= 75)
            {
                direction = "left";
            }
            if (i > 75 && i <= 100)
            {
                direction = "right";
            }
            actionCounter = 0;
        }
    }

    /**
     * Method for adjusting monsters following the player
     */
    private void follow()
    {
        for (int i = 0; i < 9; i++)
        {
            int playerX = PositionEntity.getCurrentXPositionEntity(gp.player);
            int playerY = PositionEntity.getCurrentYPositionEntity(gp.player);
            int monsterX = PositionEntity.getCurrentXPositionEntity(gp.monster[i]);
            int monsterY = PositionEntity.getCurrentYPositionEntity(gp.monster[i]);

            if (Math.abs(playerX - monsterX) <= 250 && Math.abs(playerY - monsterY) <= 250)
            {
                if (playerX - monsterX < 0)
                {
                    gp.monster[i].direction = "left";
                }
                else if (playerX - monsterX > 0)
                {
                    gp.monster[i].direction = "right";
                }
                else if (playerY - monsterY < 0)
                {
                    gp.monster[i].direction = "up";
                }
                else if (playerY - monsterY > 0)
                {
                    gp.monster[i].direction = "down";
                }
            }
        }
    }

    /**
     * Method for dialogues
     */
    public void speak()
    {
        gp.ui.currentDialogue = dialogues[0];

        switch (gp.player.direction)
        {
            case "up":
                direction = "down";
                break;
            case "down":
                direction = "up";
                break;
            case "left":
                direction = "right";
                break;
            case "right":
                direction = "left";
                break;
        }
    }

    /**
     * method for updating the game
     */
    public void update()
    {
        setAction();
        collisionOn = false;
        gp.ctester.testTitle(this);
        gp.ctester.testObject(this, false);
        gp.ctester.testEntity(this, gp.npc);
        gp.ctester.testEntity(this, gp.monster);
        gp.ctester.testPlayer(this);

        boolean contactPlayer = gp.ctester.testPlayer(this);

        if (this.type == 2 && contactPlayer)
        {
            if (!gp.player.invincible)
            {
                gp.player.life -= 1;
                gp.playSoundEffect(8);
                gp.player.invincible = true;

                if (gp.player.life <= 0)
                {
                    gp.gameState = gp.deadState;
                    gp.playSoundEffect(9);
                    gp.ui.runGame = false;
                }
            }
        }

        if (Objects.equals(gp.player.princessState, "follow"))
        {
            if (this.type == 3 && contactPlayer)
            {
                gp.gameState = gp.winState;
                gp.stopMusic();
                gp.playSoundEffect(12);
                gp.ui.runGame = false;
            }
        }

        collisionFalseIsMove();
    }

    void collisionFalseIsMove()
    {
        if (!collisionOn)
        {
            switch (direction)
            {
                case "up":
                    worldY -= speed;
                    break;
                case "down":
                    worldY += speed;
                    break;
                case "left":
                    worldX -= speed;
                    break;
                case "right":
                    worldX += speed;
                    break;
            }
        }
        spriteCounter++;

        if (spriteCounter > 13)
        {
            if (spriteNum == 1)
            {
                spriteNum = 2;
            }
            else if (spriteNum == 2)
            {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }

    /**
     * Attack and move graphics
     * @param g2 graphics component
     */
    public void draw(Graphics2D g2)
    {
        for (int i = 0; i <= 8; i++)
        {
            if (Math.abs(PositionEntity.getCurrentXPositionEntity(gp.player) -
                    PositionEntity.getCurrentXPositionEntity(gp.monster[i])) < 100
            && Math.abs(PositionEntity.getCurrentYPositionEntity(gp.player) -
                    PositionEntity.getCurrentYPositionEntity(gp.monster[i])) < 100)
            {
                drawAttack(g2);
            }
            else
            {
                drawMove(g2);
            }
        }
    }

    /**
     * method for specific graphics of movement
     * @param g2 graphic component
     */
    public void drawMove(Graphics2D g2)
    {
        movieOrAttack(g2, up1, up2, down1, down2, left1, left2, right1, right2);
    }

    /**
     * method for specific graphics of attack
     * @param g2 graphics component
     */
    public void drawAttack(Graphics2D g2)
    {
        movieOrAttack(g2, upAttack1, upAttack2, downAttack1, downAttack2, leftAttack1, leftAttack2, rightAttack1, rightAttack2);
    }

    private void movieOrAttack(Graphics2D g2, BufferedImage up1, BufferedImage up2, BufferedImage down1, BufferedImage down2,
                               BufferedImage left1, BufferedImage left2, BufferedImage right1, BufferedImage right2)
    {
        BufferedImage image = null;
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX + gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY + gp.tileSize < gp.player.worldY + gp.player.screenY)
        {
            switch (direction)
            {
                case "up":
                    if (spriteNum == 1)
                    {
                        image = up1;
                    }
                    if (spriteNum == 2)
                    {
                        image = up2;
                    }
                    break;

                case "down":
                    if (spriteNum == 1)
                    {
                        image = down1;
                    }
                    if (spriteNum == 2)
                    {
                        image = down2;
                    }
                    break;

                case "left":
                    if (spriteNum == 1)
                    {
                        image = left1;
                    }
                    if (spriteNum == 2)
                    {
                        image = left2;
                    }
                    break;

                case "right":
                    if (spriteNum == 1)
                    {
                        image = right1;
                    }
                    if (spriteNum == 2)
                    {
                        image = right2;
                    }
                    break;
            }
            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }
    }

    /**
     * Method to handle and manipulate the image data
     * @param imageName image name
     * @return image
     */
    public BufferedImage setup(String imageName)
    {
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try
        {
            image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("res" + imageName + ".png")));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return image;
    }
}
