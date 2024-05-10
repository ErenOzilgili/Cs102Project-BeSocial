import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * SideMenu
 */
public class SideMenu extends JPanel {

    private JPanel mainPanel;
    private JPanel sidePanel;
    private JButton button;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;

    private final int WIDTH = 600;
    private final int HEIGHT = 600;

    private final int BUTTON_WIDTH = 400;
    private final int BUTTON_HEIGHT = 70;

    public SideMenu(){
        initComponents();
    }

    private void initComponents() {
        setSize(WIDTH, HEIGHT);
        setLayout(new BorderLayout());
        mainPanel = new JPanel();
        sidePanel = new JPanel();
        mainPanel.setVisible(true);
        sidePanel.setVisible(false);
        mainPanel.setLayout(new BorderLayout());
        button = new JButton("->");
        ButtonListener l = new ButtonListener();
        button.addActionListener(l);
        mainPanel.add(button, BorderLayout.WEST);
        button.setBorderPainted(false);
        mainPanel.add(new JPanel(), BorderLayout.EAST);
        mainPanel.add(new JPanel(), BorderLayout.NORTH);
        mainPanel.add(new JPanel(), BorderLayout.SOUTH); 
        initButtons();
        addButtons();
        sidePanel.setPreferredSize(new Dimension(200, 200));
        add(mainPanel);
        add(sidePanel, BorderLayout.WEST);
    }

    private void initButtons(){
        Color n  =new Color(0,204,204);
        initButton2(n);

        button3 = new JButton("Go to Profile Page");
        button3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        button3.setBorder(new EtchedBorder(Color.ORANGE, Color.BLACK));
        button3.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        button3.setBackground(n);
        button3.setFont(new Font(button3.getText(), Font.PLAIN, 20));

        button4 = new JButton("Friends");
        button4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        button4.setBorder(new EtchedBorder(Color.ORANGE, Color.BLACK));
        button4.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        button4.setBackground(n);
        button4.setFont(new Font(button3.getText(), Font.PLAIN, 20));


        button5 = new JButton("Calendar");
        button5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        button5.setBorder(new EtchedBorder(Color.ORANGE, Color.BLACK));
        button5.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        button5.setBackground(n);
        button5.setFont(new Font(button3.getText(), Font.PLAIN, 20));


        button6 = new JButton("Log Out");
        button6.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        button6.setBorder(new EtchedBorder(Color.ORANGE, Color.BLACK));
        button6.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        button6.setBackground(n);
        button6.setFont(new Font(button3.getText(), Font.PLAIN, 20));


        button7 = new JButton("Add/Remove Friends");
        button7.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        button7.setBorder(new EtchedBorder(Color.ORANGE, Color.BLACK));
        button7.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        button7.setBackground(n);
        button7.setFont(new Font(button3.getText(), Font.PLAIN, 20));



    }

    private void addButtons(){
        BoxLayout b = new BoxLayout(sidePanel, BoxLayout.Y_AXIS);
        sidePanel.setLayout(b);

        sidePanel.add(button2);
        sidePanel.add(Box.createVerticalGlue());

        sidePanel.add(button3);
        sidePanel.add(Box.createVerticalGlue());

        sidePanel.add(button4);
        sidePanel.add(Box.createVerticalGlue());

        sidePanel.add(button5);
        sidePanel.add(Box.createVerticalGlue());
        
        sidePanel.add(button7);
        sidePanel.add(Box.createVerticalGlue());

        sidePanel.add(button6);
        sidePanel.add(Box.createVerticalGlue());   
    }

    private void initButton2(Color n){
        button2 = new JButton("BE SOCIAL");
        button2.setBackground(n);
        button2.setPreferredSize(new Dimension(300,70));
        button2.setBorderPainted(false);
        button2.setFont(new Font(button2.getText(), Font.BOLD, 25));
    }

    public void setSidePanelVisible(){
        if(sidePanel.isVisible()==false){
            sidePanel.setVisible(true);
            sidePanel.setBackground(new Color(0,204,204));
            button.setText("<-");
        }
        else{
            sidePanel.setVisible(false);
            button.setText("->");
        }
    }

    class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            setSidePanelVisible();
        }
    }

    public JButton getGoToPPButton(){
        return button3;
    }

    public JButton getFriendsButton(){
        return button4;
    }

    public JButton getCalendarButton(){
        return button5;
    }

    public JButton getLogOutButton(){
        return button6;
    }

    public JButton getAddOrRemoveFriendsButton(){
        return button7;
    }


}