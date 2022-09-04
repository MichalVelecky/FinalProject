package tile;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileManager
{
    GamePanel gp;
    public Tile[] tile;
    public int[][] mapTileNum;

    /**
     * Tile / map manager constructor - setting up the world
     * @param gp game panel
     */
    public TileManager(GamePanel gp)
    {
        this.gp = gp;
        tile = new Tile[100];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        loadMap("/res/maps/Map.txt");
        getTileImage();
    }

    /**
     * Tile image getter
     */
    public void getTileImage()
    {
        setup(1, "grass00", false);
        setup(2, "grass01", false);

        setup(3, "road00", false);
        setup(4, "road01", false);
        setup(5, "road02", false);

        setup(6, "sand", false);
        setup(7, "snow", false);
        setup(8, "cementery", false);

        setup(10, "stone01", true);
        setup(11, "stone01_snow", true);
        setup(12, "stone02", true);
        setup(13, "stone02_snow", true);

        setup(15, "tree01", true);
        setup(16, "tree02", true);
        setup(17, "tree03", true);
        setup(18, "tree04", true);

        setup(20, "water01", true);
        setup(21, "water02", true);
        setup(22, "water03", true);
        setup(23, "water04", true);
        setup(24, "water05", true);
        setup(25, "water06", true);
        setup(26, "water07", true);
        setup(27, "water08", true);
        setup(28, "water09", true);

        setup(31, "lava_sand02", true);
        setup(32, "lava_sand03", true);
        setup(33, "lava_sand04", true);
        setup(34, "lava_sand05", true);
        setup(35, "lava_sand06", true);
        setup(36, "lava_sand07", true);
        setup(37, "lava_sand08", true);
        setup(38, "lava_sand09", true);

        setup(40, "lava01", true);
        setup(41, "lava02", true);
        setup(42, "lava03", true);
        setup(43, "lava04", true);
        setup(44, "lava05", true);
        setup(45, "lava06", true);
        setup(46, "lava07", true);
        setup(47, "lava08", true);
        setup(48, "lava09", true);

        setup(50, "wall", true);
        setup(51, "earth", false);
        setup(52, "teleport01", false);
        setup(53, "teleport02", false);
        setup(54, "door_open", false);
        setup(55, "road_stone", false);
        setup(56, "bridge", false);
        setup(57, "floor", false);
        setup(58, "wall01", true);

        setup(60, "fence01", true);
        setup(61, "fence02", true);
        setup(62, "fence03", true);
        setup(63, "fence04", true);
        setup(64, "fence05", true);
        setup(65, "fence06", true);
        setup(66, "fence07", true);
        setup(67, "fence08", true);

        setup(70, "tombstone01", true);
        setup(71, "tombstone02", true);
        setup(72, "tombstone03", true);
        setup(73, "tombstone04", true);

        setup(74, "bed", false);
        setup(75, "candlestick", false);
        setup(76, "chair01", false);
        setup(77, "chair02", false);
        setup(78, "table", false);

        setup(80, "water10", true);
        setup(81, "water11", true);
        setup(82, "water12", true);
        setup(83, "water13", true);

        setup(90, "railing01", true);
        setup(91, "railing02", true);
        setup(92, "railing03", true);
        setup(93, "railing04", true);
        setup(94, "railing05", true);
        setup(95, "railing06", true);
        setup(96, "railing07", true);
        setup(97, "railing08", true);
    }

    /**
     * Map setup in tiles - utility, map resources
     * @param index resource index
     * @param imageName image name
     * @param collision colission value
     */
    public void setup(int index, String imageName, boolean collision)
    {
        UtilityTool uTool = new UtilityTool();
        try
        {
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/tiles/" + imageName + ".png")));
            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Method for loading of the map
     * @param filePath file path
     */
    public void loadMap(String filePath)
    {
        try
        {
            InputStream is = getClass().getResourceAsStream(filePath);
            assert is != null;
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
            while (col < gp.maxWorldCol && row < gp.maxWorldRow)
            {
                String line = br.readLine();

                while (col < gp.maxWorldCol)
                {
                    String[] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxWorldCol)
                {
                    col = 0;
                    row++;
                }
            }
            br.close();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method for the graphics of the world
     * @param g2 graphics component
     */
    public void draw(Graphics2D g2)
    {
        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow)
        {
            int tileNum = mapTileNum[worldCol][worldRow];

            int worldx = worldCol * gp.tileSize;
            int worldy = worldRow * gp.tileSize;
            int screenX = worldx - gp.player.worldX + gp.player.screenX;
            int screenY = worldy - gp.player.worldY + gp.player.screenY;
            g2.drawImage(tile[tileNum].image, screenX, screenY, null);

            worldCol++;

            if (worldCol == gp.maxWorldCol)
            {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
