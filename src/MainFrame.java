import javax.swing.*;

public class MainFrame extends JFrame {
    public static MainMenu menu;
    public static ListStudent listGui;
    public static AddStudent addGui;

    public MainFrame(){
        setSize(500, 500);
        setLayout(null);

        menu = new MainMenu();
        menu.setVisible(true);
        add(menu);

        listGui = new ListStudent();
        listGui.setVisible(false);
        add(listGui);

        addGui = new AddStudent();
        addGui.setVisible(false);
        add(listGui);
    }


}
