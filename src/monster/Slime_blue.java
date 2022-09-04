package monster;

import entity.Entity;
import main.GamePanel;

public class Slime_blue extends Entity
{
    /**
     * Blue Slime character constructor - life, speed, area settings
     * @param gp game panel
     */
    public Slime_blue(GamePanel gp)
    {
        super(gp);
        type = 2;
        name = "Slime_blue";
        speed = 1;
        maxLife = 2;
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
     * Blue slime image getter
     */
    public void getImage()
    {
        up1 = setup("/slime_blue/slime_blue_up_1");
        up2 = setup("/slime_blue/slime_blue_up_2");
        down1 = setup("/slime_blue/slime_blue_down_1");
        down2 = setup("/slime_blue/slime_blue_down_2");
        left1 = setup("/slime_blue/slime_blue_left_1");
        left2 = setup("/slime_blue/slime_blue_left_2");
        right1 = setup("/slime_blue/slime_blue_right_1");
        right2 = setup("/slime_blue/slime_blue_right_2");

        upAttack1 = setup("/slime_blue/slime_blue_up_attack_1");
        upAttack2 = setup("/slime_blue/slime_blue_up_attack_2");
        downAttack1 = setup("/slime_blue/slime_blue_down_attack_1");
        downAttack2 = setup("/slime_blue/slime_blue_down_attack_2");
        leftAttack1 = setup("/slime_blue/slime_blue_left_attack_1");
        leftAttack2 = setup("/slime_blue/slime_blue_left_attack_2");
        rightAttack1 = setup("/slime_blue/slime_blue_right_attack_1");
        rightAttack2 = setup("/slime_blue/slime_blue_right_attack_2");
    }
}
