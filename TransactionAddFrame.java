import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransactionAddFrame extends JFrame implements ActionListener {
    //FIELDS
    private JTextField tranAmount;
    private JButton deposit, withdraw, transfer;

    //CONSTRUCTOR
    public TransactionAddFrame(){
        JPanel window = new JPanel();
        window.setLayout(new GridLayout(10,2));

        //heading
        JLabel heading = new JLabel("Make Transaction");
        heading.setBounds(10, 0, 200, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 14));
        window.add(heading);

        //transaction amount field
        JLabel amountLabel = new JLabel("Transaction Amount:");
        window.add(amountLabel);
        tranAmount = new JTextField();
        window.add(tranAmount);

        //deposit button
        deposit = new JButton("Make Deposit");
        deposit.setBounds(100, 200, 200, 40);
        deposit.addActionListener(this);
        window.add(deposit);

        //withdraw button
        withdraw = new JButton("Make Withdrawal");
        withdraw.setBounds(100, 250, 200, 40);
        withdraw.addActionListener(this);
        window.add(withdraw);

        //transfer button
        transfer = new JButton("Make Transfer");
        transfer.setBounds(100, 300, 200, 40);
        transfer.addActionListener(this);
        window.add(transfer);

        //window management
        add(window);
        setTitle("Add Account | Bank of Foo");
        setSize(400, 400);
        setLocation(300, 50);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //BUTTON LISTENERS
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == deposit){
            JOptionPane.showMessageDialog(null, "Function to Complete Deposit is WIP");
        }
        else if(e.getSource() == withdraw){
            JOptionPane.showMessageDialog(null, "Function to Complete Withdrawal is WIP");
        }
        else if(e.getSource() == transfer){
            JOptionPane.showMessageDialog(null, "Function to Complete Transfer is WIP");
        }
    }

    //RUN WINDOW
    public static void main (String[]args){
        new TransactionAddFrame();
    }
}
