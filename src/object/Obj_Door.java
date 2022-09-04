package object;

import entity.Entity;
import main.GamePanel;

public class Obj_Door extends Entity
{
    /**
     * Door object consstructor
     * @param gp game panel
     */
    public Obj_Door(GamePanel gp)
    {
        super(gp);
        name = "Door";
        down1 = setup("/objects/door");
        collision = true;
    }
}