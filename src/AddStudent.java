import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudent extends Container {
    JTextField nameF, surnameF, ageF;
    JButton addB, backB;

    public AddStudent(){
        setSize(500, 500);
        setLayout(null);

        nameF = new JTextField();
        nameF.setBounds(50, 50, 300, 30);
        add(nameF);

        surnameF = new JTextField();
        surnameF.setBounds(50, 90, 300, 30);
        add(surnameF);

        ageF = new JTextField();
        ageF.setBounds(50, 130, 300, 30);
        add(ageF);

        addB = new JButton("ADD");
        addB.setBounds(50, 170, 145, 30);
        addB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameF.getText();
                String surname = surnameF.getText();
                int age = Integer.parseInt(ageF.getText());
                PackageData pd = new PackageData(new Student(name, surname, age), "ADD");
                Client.connect(pd);

            }
        });
        add(addB);

        backB = new JButton("LIST");
        backB.setBounds(210, 170, 145, 30);
        backB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(backB);
    }
}
