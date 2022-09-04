package main;

import entity.NpcMerchant;
import entity.NpcPrincess;
import entity.NpcQuestGiver;
import monster.*;
import object.Obj_Boots;
import object.Obj_Chest;
import object.Obj_Door;
import object.Obj_Door_1;
import object.Obj_Door_2;
import object.Obj_Key;

public class Setter
{
    GamePanel gp;

    /**
     * Setter class constructor
     * @param gp game panel
     */
    public Setter(GamePanel gp)
    {
        this.gp = gp;
    }

    /**
     * Setting object on the map
     */
    public void setObject()
    {
        gp.obj[0] = new Obj_Key(gp);
        gp.obj[0].worldX = 44 * gp.tileSize;
        gp.obj[0].worldY = 5 * gp.tileSize;

        gp.obj[1] = new Obj_Key(gp);
        gp.obj[1].worldX = 43 * gp.tileSize;
        gp.obj[1].worldY = 42 * gp.tileSize;

        gp.obj[2] = new Obj_Key(gp);
        gp.obj[2].worldX = 7 * gp.tileSize;
        gp.obj[2].worldY = 39 * gp.tileSize;

        gp.obj[3] = new Obj_Door(gp);
        gp.obj[3].worldX = 2 * gp.tileSize;
        gp.obj[3].worldY = 41 * gp.tileSize;

        gp.obj[4] = new Obj_Door_1(gp);
        gp.obj[4].worldX = 40 * gp.tileSize;
        gp.obj[4].worldY = 34 * gp.tileSize;

        gp.obj[5] = new Obj_Door_2(gp);
        gp.obj[5].worldX = 4 * gp.tileSize;
        gp.obj[5].worldY = 7 * gp.tileSize;

        gp.obj[6] = new Obj_Chest(gp);
        gp.obj[6].worldX = 4 * gp.tileSize;
        gp.obj[6].worldY = 3 * gp.tileSize;

        gp.obj[7] = new Obj_Boots(gp);
        gp.obj[7].worldX = 30 * gp.tileSize;
        gp.obj[7].worldY = 44 * gp.tileSize;
    }

    /**
     * Setting location of NPCs on the map
     */
    public void setNPC()
    {
        gp.npc[0] = new NpcQuestGiver(gp);
        gp.npc[0].worldX = gp.tileSize * 20;
        gp.npc[0].worldY = gp.tileSize * 20;

        gp.npc[1] = new NpcPrincess(gp);
        gp.npc[1].worldX = gp.tileSize * 5;
        gp.npc[1].worldY = gp.tileSize * 5;

        gp.npc[2] = new NpcMerchant(gp);
        gp.npc[2].worldX = gp.tileSize * 26;
        gp.npc[2].worldY = gp.tileSize * 22;
    }

    /**
     * Setting monsters on the map
     */
    public void setMonster()
    {
        gp.monster[0] = new Skeleton(gp);
        gp.monster[0].worldX = gp.tileSize * 42;
        gp.monster[0].worldY = gp.tileSize * 41;

        gp.monster[1] = new Bandit(gp);
        gp.monster[1].worldX = gp.tileSize * 36;
        gp.monster[1].worldY = gp.tileSize * 9;

        gp.monster[2] = new Devil_knight(gp);
        gp.monster[2].worldX = gp.tileSize * 11;
        gp.monster[2].worldY = gp.tileSize * 12;

        gp.monster[3] = new Goblin(gp);
        gp.monster[3].worldX = gp.tileSize * 40;
        gp.monster[3].worldY = gp.tileSize * 32;

        gp.monster[4] = new Knight(gp);
        gp.monster[4].worldX = gp.tileSize * 29;
        gp.monster[4].worldY = gp.tileSize * 43;

        gp.monster[5] = new Zombie(gp);
        gp.monster[5].worldX = gp.tileSize * 2;
        gp.monster[5].worldY = gp.tileSize * 36;

        gp.monster[6] = new Slime_blue(gp);
        gp.monster[6].worldX = gp.tileSize * 5;
        gp.monster[6].worldY = gp.tileSize * 45;

        gp.monster[7] = new Slime_green(gp);
        gp.monster[7].worldX = gp.tileSize * 33;
        gp.monster[7].worldY = gp.tileSize * 10;

        gp.monster[8] = new Slime_red(gp);
        gp.monster[8].worldX = gp.tileSize * 25;
        gp.monster[8].worldY = gp.tileSize * 26;
    }
}
