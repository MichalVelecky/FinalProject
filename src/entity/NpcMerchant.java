package entity;

import main.GamePanel;

public class NpcMerchant extends Entity
{
    /**
     * NPC merchant character constructor
     * @param gp game panel
     */
    public NpcMerchant(GamePanel gp)
    {
        super(gp);

        type = 4;
        direction = "down";
        speed = 1;
        getImageMerchant();
    }

    /**
     * Merchant Image setup
     */
    public void getImageMerchant()
    {
        up1 = setup("/merchant/merchant_up_1");
        up2 = setup("/merchant/merchant_up_2");
        down1 = setup("/merchant/merchant_down_1");
        down2 = setup("/merchant/merchant_down_2");
        left1 = setup("/merchant/merchant_left_1");
        left2 = setup("/merchant/merchant_left_2");
        right1 = setup("/merchant/merchant_right_1");
        right2 = setup("/merchant/merchant_right_2");
    }

    @Override
    public void setAction()
    {
        super.setAction();
    }
}
