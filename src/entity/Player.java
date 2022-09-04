package entity;

import main.GamePanel;
import main.Keyboard;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity
{
    Keyboard key;
    public final int screenX;
    public final int screenY;
    public int playerKey = 0;
    public int playerKey1 = 1;
    public int playerKey2 = 2;
    public int playerKey3 = 3;
    int standCounter = 0;
    public String princessState = "";

    /**
     * player constructor
     * @param gp graphics component
     * @param key keybord keys
     */
    public Player(GamePanel gp, Keyboard key)
    {
        super(gp);
        this.key = key;
        setDefaultValues();
        getPlayerImage();
        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);
        colArea = new Rectangle();
        colArea.x = 8;
        colArea.y = 15;
        colAreaDefaultX = colArea.x;
        colAreaDefaultY = colArea.y;
        colArea.width = 27;
        colArea.height = 27;
    }

    /**
     * Setting the values to default
     */
    public void setDefaultValues()
    {
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 3;
        direction = "down";
        maxLife = 6;
        life = maxLife;
    }

    /**
     * Player image getter method
     */
    public void getPlayerImage()
    {
        up1 = setup("/player/boy_up_1");
        up2 = setup("/player/boy_up_2");
        down1 = setup("/player/boy_down_1");
        down2 = setup("/player/boy_down_2");
        left1 = setup("/player/boy_left_1");
        left2 = setup("/player/boy_left_2");
        right1 = setup("/player/boy_right_1");
        right2 = setup("/player/boy_right_2");
    }

    /**
     * method for updating the game
     */
    public void update()
    {
        if (key.upPressed || key.downPressed ||
                key.leftPressed || key.rightPressed)
        {
            if (key.upPressed)
            {
                direction = "up";
            }
            else if (key.downPressed)
            {
                direction = "down";
            }
            else if (key.leftPressed)
            {
                direction = "left";
            }
            else
            {
                direction = "right";
            }

            collisionOn = false;
            gp.ctester.testTitle(this);

            int objIndex = gp.ctester.testObject(this, true);
            pickUpObject(objIndex);

            int monsterIndex = gp.ctester.testEntity(this, gp.monster);
            contactMonster(monsterIndex);

            int npcIndex = gp.ctester.testEntity(this, gp.npc);
            interactNPC(npcIndex);

            collisionFalseIsMove();
        }
        else
        {
            standCounter++;

            if (standCounter == 20)
            {
                spriteNum = 1;
                standCounter = 0;
            }
        }
        if (invincible)
        {
            invincibleCounter++;
            if (invincibleCounter > 60)
            {
                invincible = false;
                invincibleCounter = 0;
            }
        }
    }

    /**
     * method for NPC interaction with the player
     * @param i NPC type
     */
    private void interactNPC(int i)
    {
        if (i != 999)
        {
            gp.gameState = gp.dialogueState;
            if (i == 0)
            {
                gp.npc[i].speak();
            }
            else
            {
                gp.gameState = gp.playState;
            }
        }
    }

    /**
     * method for taking the damage after contact with the monster / invincible settings
     * @param i monster type
     */
    public void contactMonster(int i)
    {
        if (i != 999)
        {
            if (!invincible)
            {
                life -= 1;
                invincible = true;
            }
        }
    }

    /**
     * Method for picking up the object, i.e. keys
     * @param i objeck type
     */
    public void pickUpObject(int i)
    {
        if (i != 999)
        {
            String objectName = gp.obj[i].name;
            switch (objectName)
            {
                case "Key":
                    gp.playSoundEffect(1);
                    playerKey++;
                    gp.obj[i] = null;
                    gp.ui.schowMessage("You got a key!");
                    break;

                case "Door":
                    if (playerKey == playerKey1)
                    {
                        gp.playSoundEffect(2);
                        gp.obj[i] = null;
                        gp.ui.schowMessage("You opened door!");
                    }
                    else
                    {
                        gp.playSoundEffect(5);
                        gp.ui.schowMessage("You need a key!");
                    }
                    break;

                case "Door_1":
                    if (playerKey == playerKey2)
                    {
                        gp.playSoundEffect(2);
                        gp.obj[i] = null;
                        gp.ui.schowMessage("You opened door!");
                    }
                    else
                    {
                        gp.playSoundEffect(5);
                        gp.ui.schowMessage("You need a key!");
                    }
                    break;

                case "Door_2":
                    if (playerKey == playerKey3)
                    {
                        gp.playSoundEffect(2);
                        gp.obj[i] = null;
                        gp.ui.schowMessage("You opened door!");
                    }
                    else
                    {
                        gp.playSoundEffect(5);
                        gp.ui.schowMessage("You need a key!");
                    }
                    break;

                case "Boots":
                    gp.playSoundEffect(4);
                    speed += 1;
                    gp.obj[i] = null;
                    gp.ui.schowMessage("Speed up!");
                    break;

                case "Chest":
                    gp.playSoundEffect(13);
                    gp.obj[i] = null;
                    gp.ui.schowMessage("You opened chest!");

                    princessState = "follow";
            }
        }
    }

    /**
     * Player movement graphical setup
     * @param g2 graphics component
     */
    public void draw(Graphics2D g2)
    {
        BufferedImage image = null;

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
        g2.drawImage(image, screenX, screenY, null);
    }
}
