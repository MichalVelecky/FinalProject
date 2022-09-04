package object;

import entity.Entity;
import main.GamePanel;

public class Obj_Key extends Entity
{
    /**
     * Key object consstructor
     * @param gp game panel
     */
    public Obj_Key(GamePanel gp)
    {
        super(gp);
        name = "Key";
        down1 = setup("/objects/key");
    }
}
