package main;

import entity.Entity;

public class CollisionTester
{
    GamePanel gp;

    /**
     * Collision tester constructor
     * @param gp Game panel
     */
    public CollisionTester(GamePanel gp)
    {
        this.gp = gp;
    }

    /**
     * Method for entity collision position relative to map / tiles
     * @param entity entity
     */
    public void testTitle(Entity entity)
    {
        int entityLeftWorldX = entity.worldX + entity.colArea.x;
        int entityRightWorldX = entity.worldX + entity.colArea.x + entity.colArea.width;
        int entityTopWorldY = entity.worldY + entity.colArea.y;
        int entityBottomWorldY = entity.worldY + entity.colArea.y + entity.colArea.height;

        int entityLeftCol = entityLeftWorldX / gp.tileSize;
        int entityRightCol = entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY / gp.tileSize;
        int entityBottomRow = entityBottomWorldY / gp.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction) {
            case "up" -> {
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
            }
            case "down" -> {
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
            }
            case "left" -> {
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
            }
            case "right" -> {
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
            }
        }
    }

    /**
     * Method for entity and object collision position relative to objects
     * @param entity entity
     * @param player player
     * @return objekt type
     */
    public int testObject(Entity entity, boolean player)
    {
        int index = 999;
        for (int i = 0; i < gp.obj.length; i++)
        {
            if (gp.obj[i] != null)
            {
                entity.colArea.x = entity.worldX + entity.colArea.x;
                entity.colArea.y = entity.worldY + entity.colArea.y;

                gp.obj[i].colArea.x = gp.obj[i].worldX + gp.obj[i].colArea.x;
                gp.obj[i].colArea.y = gp.obj[i].worldY + gp.obj[i].colArea.y;

                switch (entity.direction)
                {
                    case "up":
                        entity.colArea.y -= entity.speed;
                        if (entity.colArea.intersects(gp.obj[i].colArea))
                        {
                            if (gp.obj[i].collision)
                            {
                                entity.collisionOn = true;
                            }
                            if (player)
                            {
                                index = i;
                            }
                        }
                        break;

                    case "down":
                        entity.colArea.y += entity.speed;
                        if (entity.colArea.intersects(gp.obj[i].colArea))
                        {
                            if (gp.obj[i].collision)
                            {
                                entity.collisionOn = true;
                            }
                            if (player)
                            {
                                index = i;
                            }
                        }
                        break;

                    case "left":
                        entity.colArea.x -= entity.speed;
                        if (entity.colArea.intersects(gp.obj[i].colArea))
                        {
                            if (gp.obj[i].collision)
                            {
                                entity.collisionOn = true;
                            }
                            if (player)
                            {
                                index = i;
                            }
                        }
                        break;

                    case "right":
                        entity.colArea.x += entity.speed;
                        if (entity.colArea.intersects(gp.obj[i].colArea))
                        {
                            if (gp.obj[i].collision)
                            {
                                entity.collisionOn = true;
                            }
                            if (player)
                            {
                                index = i;
                            }
                        }
                        break;
                }
                entity.colArea.x = entity.colAreaDefaultX;
                entity.colArea.y = entity.colAreaDefaultY;
                gp.obj[i].colArea.x = gp.obj[i].colAreaDefaultX;
                gp.obj[i].colArea.y = gp.obj[i].colAreaDefaultY;
            }
        }
        return index;
    }

    /**
     * Method for entity and object collision position relative to enemy
     * @param entity entity
     * @param target target
     * @return return the collision index
     */
    public int testEntity(Entity entity, Entity[] target)
    {
        int index = 999;

        for (int i = 0; i < target.length; i++)
        {
            if (target[i] != null)
            {
                entity.colArea.x = entity.worldX + entity.colArea.x;
                entity.colArea.y = entity.worldY + entity.colArea.y;

                target[i].colArea.x = target[i].worldX + target[i].colArea.x;
                target[i].colArea.y = target[i].worldY + target[i].colArea.y;

                switch (entity.direction)
                {
                    case "up":
                        entity.colArea.y -= entity.speed;
                        break;
                    case "down":
                        entity.colArea.y += entity.speed;
                        break;
                    case "left":
                        entity.colArea.x -= entity.speed;
                        break;
                    case "right":
                        entity.colArea.x += entity.speed;
                        break;
                }

                if (entity.colArea.intersects(target[i].colArea))
                {
                    if (target[i] != entity)
                    {
                        entity.collisionOn = true;
                        index = i;
                    }
                }

                entity.colArea.x = entity.colAreaDefaultX;
                entity.colArea.y = entity.colAreaDefaultY;
                target[i].colArea.x = target[i].colAreaDefaultX;
                target[i].colArea.y = target[i].colAreaDefaultY;
            }
        }
        return index;
    }

    /**
     * Method for entity and object collision position relative to player
     * @param entity entity
     * @return contact player
     */
    public boolean testPlayer(Entity entity)
    {
        boolean contactPlayer = false;

        entity.colArea.x = entity.worldX + entity.colArea.x;
        entity.colArea.y = entity.worldY + entity.colArea.y;

        gp.player.colArea.x = gp.player.worldX + gp.player.colArea.x;
        gp.player.colArea.y = gp.player.worldY + gp.player.colArea.y;

        switch (entity.direction)
        {
            case "up":
                entity.colArea.y -= entity.speed;
                break;
            case "down":
                entity.colArea.y += entity.speed;
                break;
            case "left":
                entity.colArea.x -= entity.speed;
                break;
            case "right":
                entity.colArea.x += entity.speed;
                break;
        }

        if (entity.colArea.intersects(gp.player.colArea))
        {
            entity.collisionOn = true;
            contactPlayer = true;
        }

        entity.colArea.x = entity.colAreaDefaultX;
        entity.colArea.y = entity.colAreaDefaultY;
        gp.player.colArea.x = gp.player.colAreaDefaultX;
        gp.player.colArea.y = gp.player.colAreaDefaultY;
        return contactPlayer;
    }
}