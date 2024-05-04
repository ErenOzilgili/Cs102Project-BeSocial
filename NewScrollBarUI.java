import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class NewScrollBarUI extends BasicScrollBarUI{

     @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        g.setColor(Color.WHITE);
        g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);

    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        g.setColor(Color.GRAY);
        g.fillRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height);

        g.setColor(Color.WHITE);
        int spaceAbove = 30;
        g.fillRect(thumbBounds.x + thumbBounds.width / 5, thumbBounds.y + spaceAbove, thumbBounds.width - (2 * (thumbBounds.width / 5)), thumbBounds.height - 2 * spaceAbove);

        g.setColor(Color.BLACK);
        int height = 6;
        g.fillRect(thumbBounds.x + thumbBounds.width / 3, thumbBounds.y + (thumbBounds.height / 2) - ((height / 2) + 2 * height), thumbBounds.width - 2 * thumbBounds.width / 3, height);
        g.fillRect(thumbBounds.x + thumbBounds.width / 3, thumbBounds.y + (thumbBounds.height / 2) - (height / 2), thumbBounds.width - 2 * thumbBounds.width / 3, height);
        g.fillRect(thumbBounds.x + thumbBounds.width / 3, thumbBounds.y + (thumbBounds.height / 2) - ((height / 2) - 2 * height), thumbBounds.width - 2 * thumbBounds.width / 3, height);
    }
    
}
