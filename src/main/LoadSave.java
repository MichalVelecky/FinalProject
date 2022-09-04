package main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class LoadSave
{
    GamePanel gp;

    public LoadSave(GamePanel gp)
    {
        this.gp = gp;
    }

    public static BufferedImage getSpriteAtlas()
    {
        BufferedImage image = null;
        InputStream is = LoadSave.class.getClassLoader().getResourceAsStream("");
        try
        {
            assert is != null;
            image = ImageIO.read(is);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return image;
    }

    public static void CreateFile()
    {
        File txtFile = new File("res/testText.txt");
        try
        {
            txtFile.createNewFile();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}