package monster;

import entity.Entity;
import main.GamePanel;

public class Slime_green extends Entity
{
    /**
     * Green slime character constructor - life, speed, area settings
     * @param gp game panel
     */
    public Slime_green(GamePanel gp)
    {
        super(gp);
        type = 2;
        name = "Slime_green";
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
     * Green slime image getter
     */
    public void getImage()
    {
        up1 = setup("/slime_green/slime_green_up_1");
        up2 = setup("/slime_green/slime_green_up_2");
        down1 = setup("/slime_green/slime_green_down_1");
        down2 = setup("/slime_green/slime_green_down_2");
        left1 = setup("/slime_green/slime_green_left_1");
        left2 = setup("/slime_green/slime_green_left_2");
        right1 = setup("/slime_green/slime_green_right_1");
        right2 = setup("/slime_green/slime_green_right_2");

        upAttack1 = setup("/slime_green/slime_green_up_attack_1");
        upAttack2 = setup("/slime_green/slime_green_up_attack_2");
        downAttack1 = setup("/slime_green/slime_green_down_attack_1");
        downAttack2 = setup("/slime_green/slime_green_down_attack_2");
        leftAttack1 = setup("/slime_green/slime_green_left_attack_1");
        leftAttack2 = setup("/slime_green/slime_green_left_attack_2");
        rightAttack1 = setup("/slime_green/slime_green_right_attack_1");
        rightAttack2 = setup("/slime_green/slime_green_right_attack_2");
    }
}
