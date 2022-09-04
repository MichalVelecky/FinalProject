package monster;

import entity.Entity;
import main.GamePanel;

public class Devil_knight extends Entity
{
    /**
     * Devil knight character constructor - life, speed, area settings
     * @param gp game panel
     */
    public Devil_knight(GamePanel gp)
    {
        super(gp);
        type = 2;
        name = "Devil_knight";
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
     * Devil knight image getter
     */
    public void getImage()
    {
        up1 = setup("/devil_knight/devil_knight_up_1");
        up2 = setup("/devil_knight/devil_knight_up_2");
        down1 = setup("/devil_knight/devil_knight_down_1");
        down2 = setup("/devil_knight/devil_knight_down_2");
        left1 = setup("/devil_knight/devil_knight_left_1");
        left2 = setup("/devil_knight/devil_knight_left_2");
        right1 = setup("/devil_knight/devil_knight_right_1");
        right2 = setup("/devil_knight/devil_knight_right_2");

        upAttack1 = setup("/devil_knight/devil_knight_up_attack_1");
        upAttack2 = setup("/devil_knight/devil_knight_up_attack_2");
        downAttack1 = setup("/devil_knight/devil_knight_down_attack_1");
        downAttack2 = setup("/devil_knight/devil_knight_down_attack_2");
        leftAttack1 = setup("/devil_knight/devil_knight_left_attack_1");
        leftAttack2 = setup("/devil_knight/devil_knight_left_attack_2");
        rightAttack1 = setup("/devil_knight/devil_knight_right_attack_1");
        rightAttack2 = setup("/devil_knight/devil_knight_right_attack_2");
    }
}
