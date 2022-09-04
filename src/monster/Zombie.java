package monster;

import entity.Entity;
import main.GamePanel;

public class Zombie extends Entity
{
    /**
     * Zombie character constructor - life, speed, area settings
     * @param gp game panel
     */
    public Zombie(GamePanel gp)
    {
        super(gp);
        type = 2;
        name = "Zombie";
        speed = 1;
        maxLife = 4;
        life = maxLife;
        colArea.x = 3;
        colArea.y = 18;
        colArea.width = 42;
        colArea.height = 30;
        colAreaDefaultX = colArea.x;
        colAreaDefaultY = colArea.y;
        getImage();
    }

    /**
     * Zombie image getter
     */
    public void getImage()
    {
        up1 = setup("/zombie/zombie_up_1");
        up2 = setup("/zombie/zombie_up_2");
        down1 = setup("/zombie/zombie_down_1");
        down2 = setup("/zombie/zombie_down_2");
        left1 = setup("/zombie/zombie_left_1");
        left2 = setup("/zombie/zombie_left_2");
        right1 = setup("/zombie/zombie_right_1");
        right2 = setup("/zombie/zombie_right_2");

        upAttack1 = up1;
        upAttack2 = up2;
        downAttack1 = down1;
        downAttack2 = down2;
        leftAttack1 = left1;
        leftAttack2 = left2;
        rightAttack1 = right1;
        rightAttack2 = right2;
    }
}
