package object;

import entity.Entity;
import main.GamePanel;

public class Obj_Teleport extends Entity
{
    /**
     * Teleport object consstructor
     * @param gp game panel
     */
    public Obj_Teleport(GamePanel gp)
    {
        super(gp);
        name = "Teleport";
        down1 = setup("/objects/teleport02");
    }
}
