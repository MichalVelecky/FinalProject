package object;

import entity.Entity;
import main.GamePanel;

public class Obj_Heart extends Entity
{
    /**
     * Heart (life) object consstructor
     * @param gp game panel
     */
    public Obj_Heart(GamePanel gp)
    {
        super(gp);
        name = "Heart";
        image = setup("/objects/heart_full");
        image1 = setup("/objects/heart_half");
        image2 = setup("/objects/heart_blank");
    }
}
