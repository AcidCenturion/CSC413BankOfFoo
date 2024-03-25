import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CustomerAddFrame extends JFrame{
    //JTEXT FIELDS
    private JTextField custName, custUserN, custEmail, custID;

    //CONSTRUCTORS
    public CustomerAddFrame() {
        setTitle("Customer Creation Form");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //JPANEL
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10,2));

        //JLABEL
        JLabel custNameLabel = new JLabel("Customer Name: ");
        custName = new JTextField();
        JLabel custUserNLabel = new JLabel("Customer Username: ");
        custUserN = new JTextField();
        JLabel custEmailLabel = new JLabel("Customer Email: ");
        custEmail = new JTextField();
        JLabel custIDLabel = new JLabel("Customer ID: ");
        custID = new JTextField();

        //ADD LABELS AND TEXT FIELDS TO PANEL
        panel.add(custNameLabel);
        panel.add(custName);
        panel.add(custUserNLabel);
        panel.add(custUserN);
        panel.add(custEmailLabel);
        panel.add(custEmail);
        panel.add(custIDLabel);
        panel.add(custID);

        //JBUTTON - SUBMIT FORM
        JButton submitButton = new JButton("Submit");

        submitButton.addActionListener((ActionEvent e) -> {
            String inpName = custName.getText();
            String inpUserN = custUserN.getText();
            String inpEmail = custEmail.getText();
            int inpID = Integer.parseInt(custID.getText());

            //create a customer object with the above field data
            Customer newCustomer = new Customer(inpName, inpUserN, inpEmail, inpID);

            //print result
            System.out.println("Created new Customer w/ JSwing: " + newCustomer);
        });

        panel.add(submitButton);

        add(panel);
        setVisible(true);
    }

    //RUN WINDOW
    public static void main(String[]args){
        new CustomerAddFrame();
    }
}
