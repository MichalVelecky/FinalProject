package monster;

import entity.Entity;
import main.GamePanel;

public class Skeleton extends Entity
{
    /**
     * Skeleton character constructor - life, speed, area settings
     * @param gp game panel
     */
    public Skeleton(GamePanel gp)
    {
        super(gp);
        type = 2;
        name = "Skeleton";
        speed = 2;
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
     * Skeleton image getter
     */
    public void getImage()
    {
        up1 = setup("/skeleton/skeleton_up_1");
        up2 = setup("/skeleton/skeleton_up_2");
        down1 = setup("/skeleton/skeleton_down_1");
        down2 = setup("/skeleton/skeleton_down_2");
        left1 = setup("/skeleton/skeleton_left_1");
        left2 = setup("/skeleton/skeleton_left_2");
        right1 = setup("/skeleton/skeleton_right_1");
        right2 = setup("/skeleton/skeleton_right_2");

        upAttack1 = setup("/skeleton/skeleton_up_attack_1");
        upAttack2 = setup("/skeleton/skeleton_up_attack_2");
        downAttack1 = setup("/skeleton/skeleton_down_attack_1");
        downAttack2 = setup("/skeleton/skeleton_down_attack_2");
        leftAttack1 = setup("/skeleton/skeleton_left_attack_1");
        leftAttack2 = setup("/skeleton/skeleton_left_attack_2");
        rightAttack1 = setup("/skeleton/skeleton_right_attack_1");
        rightAttack2 = setup("/skeleton/skeleton_right_attack_2");
    }
}
