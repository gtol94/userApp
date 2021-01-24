import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListStudent extends Container {
    public static JTextArea text;
    JButton listB, backB;

    public ListStudent(){
        setSize(500, 500);
        setLayout(null);

        text = new JTextArea();
        text.setBounds(50, 50, 300, 300);
        add(text);

        listB = new JButton("LIST");
        listB.setBounds(50, 360, 145, 30);
        listB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(listB);

        backB = new JButton("BACK");
        backB.setBounds(205, 360, 145, 30);
        backB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(backB);
    }
}
