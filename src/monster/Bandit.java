package monster;

import entity.Entity;
import main.GamePanel;

public class Bandit extends Entity
{
    /**
     * Bandit character constructor - life, speed, area settings
     * @param gp game panel
     */
    public Bandit(GamePanel gp)
    {
        super(gp);
        type = 2;
        name = "Bandit";
        speed = 3;
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
     * Bandit image getter
     */
    public void getImage()
    {
        up1 = setup("/bandit/bandit_up_1");
        up2 = setup("/bandit/bandit_up_2");
        down1 = setup("/bandit/bandit_down_1");
        down2 = setup("/bandit/bandit_down_2");
        left1 = setup("/bandit/bandit_left_1");
        left2 = setup("/bandit/bandit_left_2");
        right1 = setup("/bandit/bandit_right_1");
        right2 = setup("/bandit/bandit_right_2");

        upAttack1 = setup("/bandit/bandit_up_attack_1");
        upAttack2 = setup("/bandit/bandit_up_attack_2");
        downAttack1 = setup("/bandit/bandit_down_attack_1");
        downAttack2 = setup("/bandit/bandit_down_attack_2");
        leftAttack1 = setup("/bandit/bandit_left_attack_1");
        leftAttack2 = setup("/bandit/bandit_left_attack_2");
        rightAttack1 = setup("/bandit/bandit_right_attack_1");
        rightAttack2 = setup("/bandit/bandit_right_attack_2");
    }
}
