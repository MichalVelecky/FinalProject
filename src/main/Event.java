package main;

import java.awt.*;

public class Event
{
    GamePanel gp;
    Rectangle eventRect;
    int previousEventX, previousEventY;

    /**
     * Event method constructor
     * @param gp game panel
     */
    public Event(GamePanel gp)
    {
        this.gp = gp;
        eventRect = new EventRect();
        eventRect.x = 23;
        eventRect.y = 23;
        eventRect.width = 2;
        eventRect.height = 2;
        previousEventX = eventRect.x;
        previousEventY = eventRect.y;
    }
}