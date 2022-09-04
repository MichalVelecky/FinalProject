package entity;

import main.GamePanel;

public class NpcQuestGiver extends Entity
{
    /**
     * NPC quest giver character constructor
     * @param gp game panel
     */
    public NpcQuestGiver(GamePanel gp)
    {
        super(gp);

        type = 1;
        direction = "down";
        speed = 1;
        getImageGandalf();
        setDialogue();
    }

    /**
     * Gandalf image setup
     */
    public void getImageGandalf()
    {
        up1 = setup("/gandalf/gandalf_up_1");
        up2 = setup("/gandalf/gandalf_up_2");
        down1 = setup("/gandalf/gandalf_down_1");
        down2 = setup("/gandalf/gandalf_down_2");
        left1 = setup("/gandalf/gandalf_left_1");
        left2 = setup("/gandalf/gandalf_left_2");
        right1 = setup("/gandalf/gandalf_right_1");
        right2 = setup("/gandalf/gandalf_right_2");
    }

    /**
     * Dialogue setter
     */
    public void setDialogue()
    {
        dialogues[0] = "Hello, Forest.\nRun away from all enemies\nand save the Princess\n(press R to continue!)";
        dialogues[1] = "Thank you :) \n(press ESC to continue!)";
        dialogues[2] = " ...\n(press R to continue!)";
    }

    public void setAction()
    {
        super.setAction();
    }

    /**
     * Method for 'speak' sound effect
     */
    public void speak()
    {
        gp.playSoundEffect(10);
        super.speak();
    }
}

