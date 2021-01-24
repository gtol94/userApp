import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends Container {
    JButton addB, listB, exitB;

    public MainMenu(){
        setSize(500, 500);
        setLayout(null);
        addB = new JButton("ADD");
        addB.setBounds(50, 50, 300, 30);
        addB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(addB);
        listB = new JButton("LIST");
        listB.setBounds(50, 90, 300, 30);
        listB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(listB);

        exitB = new JButton("EXIT");
        exitB.setBounds(50, 130, 300, 30);
        exitB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exitB);
    }
}
