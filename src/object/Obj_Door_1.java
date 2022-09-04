package object;

import entity.Entity;
import main.GamePanel;

public class Obj_Door_1 extends Entity
{
    /**
     * Door object consstructor
     * @param gp game panel
     */
    public Obj_Door_1(GamePanel gp)
    {
        super(gp);
        name = "Door_1";
        down1 = setup("/objects/door");
        collision = true;
    }
}