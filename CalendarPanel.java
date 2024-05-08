import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import java.awt.*;

public class CalendarPanel extends JPanel{
    
    Calendar cal = new GregorianCalendar();

    public CalendarPanel(){
        String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, java.util.Locale.US);
        this.setLayout(new BorderLayout());
        JLabel monthLabel = new JLabel(month, SwingConstants.CENTER);
        monthLabel.setFont(new Font("Courier", Font.BOLD, 40));
        this.add(monthLabel, BorderLayout.NORTH);
        JPanel dayPanel = new JPanel(new GridLayout(0, 7));


    int startDay = cal.get(Calendar.DAY_OF_WEEK);
    int numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    
    JPanel panel = new JPanel(new GridLayout(0,7));
    String [] columns = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

    int i = startDay-1;

    for(int k = 0; k<7; k++){
      JLabel newLabel = new JLabel(columns[k],SwingConstants.CENTER);
      newLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      newLabel.setFont(new Font("Courier", Font.BOLD, 20));
      panel.add(newLabel);

    }
    for(int j = 0; j<i%7; j++){
      JLabel newLabel = new JLabel("",SwingConstants.CENTER);
      newLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      newLabel.setFont(new Font("Courier", Font.BOLD, 20));
      panel.add(newLabel);
    }
    for(int day=1;day<=numberOfDays;day++){
      final int day2 = day;
      JLabel newLabel = new JLabel(String.valueOf(day),SwingConstants.CENTER){
        @Override
        public void paintComponent(Graphics g) {
          for(Activity act : MainManager.user.enrolledActivities){
            java.sql.Date date = act.getDate();
            java.sql.Date clickedDate = new java.sql.Date(cal.getTime().getTime());
            clickedDate.setTime(clickedDate.getTime() + TimeUnit.DAYS.toMillis(day2-1));
            if(date.toString().equals(clickedDate.toString())){
              Random rand = new Random((clickedDate.toString() + MainManager.user.userName + day2).hashCode());  
              g.setColor(new Color(rand.nextInt(196) + 60 ,rand.nextInt(196) + 60,rand.nextInt(196) + 60));
              g.fillOval(getWidth()/2-25, getHeight()/2-25, 50, 50);
              break;
            }
          }
          super.paintComponent(g);
        }
      };
      newLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      newLabel.setFont(new Font("Courier", Font.BOLD, 20));
      panel.add(newLabel); 
    }
    for(int j = 0; j<(7-(i+numberOfDays)%7)%7; j++){
      JLabel newLabel = new JLabel("",SwingConstants.CENTER);
      newLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      newLabel.setFont(new Font("Courier", Font.BOLD, 20));
      panel.add(newLabel);
    }
    this.add(panel,BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new CalendarPanel());
        frame.setVisible(true);
    }

}
