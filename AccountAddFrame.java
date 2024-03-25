import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AccountAddFrame extends JFrame{
    //FIELDS
    private JTextField accName;

    //CONSTRUCTOR
    public AccountAddFrame(){
        JPanel window = new JPanel();
        window.setLayout(new GridLayout(10,2));

        //heading
        JLabel heading = new JLabel("Add Account");
        heading.setBounds(10, 0, 200, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 14));
        window.add(heading);

        //labels and text fields
        JLabel accNameLabel = new JLabel("Account Name:");
        window.add(accNameLabel);
        accName = new JTextField();
        window.add(accName);

        //submit button
        JButton submitButton = new JButton("Save Account");

        submitButton.addActionListener((ActionEvent e) -> {
            String inpName = accName.getText();
            //Account newAcc = new Account(inpName, );
        });

        window.add(submitButton);

        //window management
        add(window);
        setTitle("Add Account | Bank of Foo");
        setSize(400, 400);
        setLocation(300, 50);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //RUN WINDOW
    public static void main(String[]args){
        new AccountAddFrame();
    }
}
