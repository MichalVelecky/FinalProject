package main;

import entity.Entity;

//LuckyBoy
public class PositionEntity extends Entity
{
    /**
     * Current position constructor
     * @param gp game panel
     */
    public PositionEntity(GamePanel gp)
    {
        super(gp);
    }

    // LuckyBoy
    /**
     * Getter method for X coordinate of current position
     * @param entity entity
     * @return X of current position
     */
    public static int getCurrentXPositionEntity(Entity entity)
    {
        return entity.worldX;
    }

    // LuckyBoy
    /**
     * Getter method for Y coordinate of current position
     * @param entity entity
     * @return Y of curerent position
     */
    public static int getCurrentYPositionEntity(Entity entity)
    {
        return entity.worldY;
    }
}