import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class SearchPage extends JPanel{
    
    private JTextField bar;
    private DefaultListModel<String> model;
    private JList<String> list;
    private JScrollPane res;

    public SearchPage()
    {
        this.setLayout(new GridLayout(0,1));
        bar = new JTextField();
        bar.setEditable(true);
        bar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        bar.setMaximumSize(new Dimension(Integer.MAX_VALUE, bar.getPreferredSize().height));
        this.add(bar);

        model = new DefaultListModel<>();
        list = new JList<>(model);

        res = new JScrollPane(list);
        // res.setVisible(false);
        // this.add(res);
        
        bar.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String text = bar.getText();
                
                if(text.equals(""))
                {
                    showList(new ArrayList<String>());
                }
                else
                {
                    ArrayList<String> results = findResults(text);
                    showList(results);
                }
                
            }
        });


    }

    private ArrayList<String> findResults(String text)
    {
        ArrayList<String> result = new ArrayList<String>(); 
        for(Activity ac : MainManager.allActivities)
        {
            if(ac.getName().toLowerCase().startsWith(text.toLowerCase()))
            {
                result.add(ac.getName());
            }
        }

        return result;
    }

    private void showList(ArrayList<String> result)
    {
        model.clear();
        if(result.size() > 0)
        {
            //res.setVisible(true);
            for(String s : result)
            {
                model.addElement(s);
            }
            this.add(res);
           
        }
        else
        {
            //res.setVisible(false);
            this.remove(res);
        }
        revalidate();
        repaint();
    }

}
