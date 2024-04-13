import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
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
    label.setFont(new Font("Courier", Font.BOLD, 20));
    
    this.add(label,BorderLayout.NORTH);
 
    /*JButton b1 = new JButton("<-");
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
    });*/
 
    this.updateMonth();
 
  }
 
  void updateMonth() {
    cal.set(Calendar.DAY_OF_MONTH, 1);
 
    String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
    int year = cal.get(Calendar.YEAR);
    label.setText("MY CALENDAR");
 
    int startDay = cal.get(Calendar.DAY_OF_WEEK);
    int numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
    
    JPanel panel = new JPanel(new GridLayout(0,7));
    String [] columns = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};

    int i = startDay-1;

    for(int k = 0; k<7; k++){
      panel.add(new JButton(columns[k]));
    }
    for(int j = 0; j<i%7; j++){
      panel.add(new JButton(""));
    }
    for(int day=1;day<=numberOfDays;day++){
      panel.add(new JButton(""+day));   
      i = i + 1;
    }
    for(int j = 0; j<7-i%7; j++){
      panel.add(new JButton(""));
    }
    this.add(panel,BorderLayout.CENTER);
 
  }
 
  public static void main(String[] arguments) {
    JFrame.setDefaultLookAndFeelDecorated(false);
    FullScreenCalendar sc = new FullScreenCalendar();
  }
 
}