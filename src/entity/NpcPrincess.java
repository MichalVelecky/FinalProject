package entity;

import main.GamePanel;
import main.PositionEntity;

public class NpcPrincess extends NpcQuestGiver
{
    /**
     * NPC princess character constructor
     * @param gp game panel
     */
    public NpcPrincess(GamePanel gp)
    {
        super(gp);

        type = 3;
        direction = "down";
        speed = 1;
        getImagePrincess();
    }

    /**
     * Princess image setup
     */
    public void getImagePrincess()
    {
        up1 = setup("/princess/princess_up_1");
        up2 = setup("/princess/princess_up_2");
        down1 = setup("/princess/princess_down_1");
        down2 = setup("/princess/princess_down_2");
        left1 = setup("/princess/princess_left_1");
        left2 = setup("/princess/princess_left_2");
        right1 = setup("/princess/princess_right_1");
        right2 = setup("/princess/princess_right_2");
    }

    public void setAction()
    {
        super.setAction();
    }

    public void princessFollow()
    {
        int playerX = PositionEntity.getCurrentXPositionEntity(gp.player);
        int playerY = PositionEntity.getCurrentYPositionEntity(gp.player);
        int princessX = PositionEntity.getCurrentXPositionEntity(gp.npc[1]);
        int princessY = PositionEntity.getCurrentYPositionEntity(gp.npc[1]);

        if (playerX - princessX < 0)
        {
            gp.npc[1].direction = "left";
        }
        else if (playerX - princessX > 0)
        {
            gp.npc[1].direction = "right";
        }
        else if (playerY - princessY < 0)
        {
            gp.npc[1].direction = "up";
        }
        else if (playerY - princessY > 0)
        {
            gp.npc[1].direction = "down";
        }
    }
}
