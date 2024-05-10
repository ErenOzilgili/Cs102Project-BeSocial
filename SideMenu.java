import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * SideMenu
 */
public class SideMenu extends JFrame {

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
        initButton2();
        button3 = new JButton("Go to Profile Page");
        button4 = new JButton("Friends");
        button5 = new JButton("Calendar");
        button6 = new JButton("Log Out");
        button7 = new JButton("Add/Remove Friends");

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
        
        sidePanel.add(button6);
        sidePanel.add(Box.createVerticalGlue());

        sidePanel.add(button7);
        sidePanel.add(Box.createVerticalGlue());   
    }

    private void initButton2(){
        button2 = new JButton("BE SOCIAL");
        button2.setBackground(Color.CYAN);
        button2.setPreferredSize(new Dimension(300,70));
        button2.setBorderPainted(false);
        button2.setFont(new Font(button2.getText(), Font.BOLD, 25));
    }

    public void setSidePanelVisible(){
        if(sidePanel.isVisible()==false){
            sidePanel.setVisible(true);
            sidePanel.setBackground(Color.CYAN);
        }
        else{
            sidePanel.setVisible(false);
        }
    }

    class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            setSidePanelVisible();
        }
    }


    public static void main(String[] args) {
        JFrame frame = new SideMenu();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


}