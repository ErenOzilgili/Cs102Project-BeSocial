import java.util.*;
import java.util.concurrent.TimeUnit;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.*;
 
public class FullScreenCalendar extends JFrame {
  JPopupMenu popup;
  Calendar cal = new GregorianCalendar();
  JLabel label;
 
  FullScreenCalendar() {
 
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //this.setTitle("Swing Calandar");
    this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    this.setVisible(true);
 
    JPanel panel2 = new JPanel();
    panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
    label = new JLabel();
    label.setHorizontalAlignment(SwingConstants.CENTER);
    label.setText("MY CALENDAR");
    label.setFont(new Font("Courier", Font.BOLD, 40));
    label.setPreferredSize(new Dimension(350, 50));
    
    
    
 
    JButton b1 = new JButton("<-");
    b1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        cal.add(Calendar.MONTH, -1);
        updateMonth();
      }
    });
 
    JButton b2 = new JButton("->");
    b2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        cal.add(Calendar.MONTH, +1);
        updateMonth();
      }
    });

    JButton b3 = new JButton();
    b3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        mainPageButtonActionPerformed();
      }
    });

    panel2.add(Box.createHorizontalGlue());
    panel2.add(b1);
    panel2.add(label);
    panel2.add(b2);
    ImageIcon icon = new ImageIcon("photos/25694.png");
    Image image = icon.getImage(); // transform it 
    Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
    icon = new ImageIcon(newimg);  // transform it back
    b3.setIcon(icon);
    panel2.add(Box.createHorizontalGlue());
    panel2.add(b3);

    this.add(panel2,BorderLayout.NORTH);
    cal.set(Calendar.DAY_OF_MONTH, 1);
    this.add(new JPanel());
    this.updateMonth();
    this.setVisible(true);
  }
 
  public void updateMonth() {
    this.getContentPane().remove(1);
    String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
    int year = cal.get(Calendar.YEAR);
    label.setText(month + " " + year);
 
    int startDay = cal.get(Calendar.DAY_OF_WEEK);
    int numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
    
    JPanel panel = new JPanel(new GridLayout(0,7));
    String [] columns = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

    int i = startDay-1;

    for(int k = 0; k<7; k++){
      JLabel newLabel = new JLabel(columns[k],SwingConstants.CENTER);
      newLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      newLabel.setFont(new Font("Courier", Font.BOLD, 20));
      newLabel.addMouseListener(new MyMouseListener());
      panel.add(newLabel);

    }
    for(int j = 0; j<i%7; j++){
      JLabel newLabel = new JLabel("",SwingConstants.CENTER);
      newLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      newLabel.setFont(new Font("Courier", Font.BOLD, 20));
      newLabel.addMouseListener(new MyMouseListener());
      panel.add(newLabel);
    }
    for(int day=1;day<=numberOfDays;day++){
      JLabel newLabel = new JLabel(String.valueOf(day),SwingConstants.CENTER);
      newLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      newLabel.setFont(new Font("Courier", Font.BOLD, 20));
      newLabel.addMouseListener(new MyMouseListener());
      panel.add(newLabel);
      
    }
    for(int j = 0; j<(7-(i+numberOfDays)%7)%7; j++){
      JLabel newLabel = new JLabel("",SwingConstants.CENTER);
      newLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      newLabel.setFont(new Font("Courier", Font.BOLD, 20));
      newLabel.addMouseListener(new MyMouseListener());
      panel.add(newLabel);
    }
    this.add(panel,BorderLayout.CENTER);
    
  }
 
  private class MyMouseListener extends MouseAdapter {
    public void mouseEntered(MouseEvent e) {
      
    }
    public void mouseExited(MouseEvent e) {
      
    }

    public void mouseClicked(MouseEvent e) {
      if(((JLabel)e.getSource()).getText() != "" && !((JLabel)e.getSource()).getText().contains("day")) {
        popup = new JPopupMenu();
        popup.setBounds(1000, 100, 1000, 1000);
        popup.add(new JMenuItem("Sport Festival"));
        popup.add(new JMenuItem("Efe's Birthday"));
        popup.show((Component)e.getSource(), e.getX(), e.getY());
      }
    }   

  }

  private void mainPageButtonActionPerformed()
  {
    MainManager.openMainPage(this);
  }

  public static void main(String[] arguments) {
    JFrame.setDefaultLookAndFeelDecorated(false);
    FullScreenCalendar sc = new FullScreenCalendar();
  }
 
}