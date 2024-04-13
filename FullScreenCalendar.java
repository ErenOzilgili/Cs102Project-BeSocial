import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.*;
 
public class FullScreenCalendar extends JFrame {
 
  Calendar cal = new GregorianCalendar();
  JLabel label;
 
  FullScreenCalendar() {
 
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //this.setTitle("Swing Calandar");
    this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    this.setVisible(true);
 
 
    label = new JLabel();
    label.setHorizontalAlignment(SwingConstants.CENTER);
    label.setText("MY CALENDAR");
    label.setFont(new Font("Courier", Font.BOLD, 40));
    
    this.add(label,BorderLayout.NORTH);
 
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
    setFocusable(true);
    this.add(b1,BorderLayout.WEST);
    this.add(b2,BorderLayout.EAST);
    this.updateMonth();
 
  }
 
  void updateMonth() {
    cal.set(Calendar.DAY_OF_MONTH, 1);
 
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
      newLabel.setToolTipText(Integer.toString(day));
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
      JLabel newlabel = (JLabel)e.getSource();
      System.out.println(newlabel.getText());
    }
    public void mouseExited(MouseEvent e) {
      
    }
  }

  public static void main(String[] arguments) {
    JFrame.setDefaultLookAndFeelDecorated(false);
    FullScreenCalendar sc = new FullScreenCalendar();
  }
 
}