import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

public class MainPageFrame extends JFrame{

    private JPanel centerPanel;//Center part of this frame
    private JPanel southPanel;//South part of this frame
    private JPanel westPanel;//West part of this frame
    private JPanel eastPanel;//East part of this frame
    private JPanel centerFirstCol;//This panel forms the first column of the center panel which is 1 x 2 in size.
    private JPanel centerSecondCol;//This panel forms the second column of the center panel which is 1 x 2 in size.

    public MainPageFrame(){

        this.setTitle("Main Page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*
         * Following three lines make this frame cover the whole screen.
         */
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        //this.setUndecorated(true); --> This code makes the upper bar invisible (Like a full screen).

        //------------------------
        //Center of the Frame
        //------------------------

        /*
         * This will consist of 1 x 2 grid.
         * In the first column of this grid, there
         * will be a calender section 
         * and a chatting section that has put into one panel.
         * Second column of the grid will fully consist of the
         * activity panel.
         */

        //This panel will be placed in center in this frame.
        //We will replace the firstCol (First Column) and secondCol (Second Column)
        //panels inside this larger panel.
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1, 2));

        //This panel will be holding calendar and chats.
        centerFirstCol = new JPanel();
        //centerFirsCol.add(CalendarPanel);
        //centerFirstCol.add(ChatPanel);
        centerFirstCol.setBackground(Color.BLUE);//Just for now
        /*
         * Do add the panels
         */


        //This panel will be holding activity panel.
        centerSecondCol = new ActivityPanel();
        //centerSecondCol.setBackground(Color.YELLOW);//Just for now
        /*
         * Do add the panels
         */

        
        //Adding first and second column to the center panel
        //and afterwards adding this panel at the center of this frame.
        centerPanel.add(centerFirstCol);
        centerPanel.add(centerSecondCol);
        this.add(centerPanel, BorderLayout.CENTER);


        //------------------------
        //------------------------
        //------------------------

        //------------------------
        //South of the Frame
        //------------------------

        /*
         * Activity line will be added (Optional, as far as the last drawing we have made shows). 
         */

        southPanel = new JPanel();
        southPanel.setBackground(Color.BLACK);//Just for now



        //This panel will be placed in south in this frame.
        this.add(southPanel, BorderLayout.SOUTH);

        //------------------------
        //------------------------
        //------------------------


        //------------------------
        //West of the Frame
        //------------------------

        /*
         * There will be a openable menu bar.
         * Maybe, whenever we open the menu up, we can
         * adjust the size of the other panels
         */

        westPanel = new JPanel();
        westPanel.setBackground(Color.GREEN);//Just for now

        //This panel will be placed in west in this frame.
        this.add(westPanel, BorderLayout.WEST);


        //------------------------
        //------------------------
        //------------------------



        //------------------------
        //East of the Frame
        //------------------------

        /*
         * There will be a profile section,
         * recommended section and friend or chatting section.
         */

        eastPanel = new JPanel();
        eastPanel.setBackground(Color.GRAY);//Just for now

        //This panel will be placed in east in this frame.
        this.add(eastPanel, BorderLayout.EAST);

        //------------------------
        //------------------------
        //------------------------

    }

}