import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class HomePage extends JFrame implements ActionListener{
    //JBUTTONS
    private JButton showAccs, addAcc, editAcc, delAcc;

    //CONSTRUCTOR
    public HomePage() {
        //setup window and background
        setLayout(null);
        ImageIcon source = new ImageIcon(ClassLoader.getSystemResource("icons/penguinSplash.jpg"));
        Image resizeImg = source.getImage().getScaledInstance(1000, 630, Image.SCALE_DEFAULT);
        ImageIcon bg = new ImageIcon(resizeImg);
        JLabel window = new JLabel(bg);
        window.setBounds(0, 0, 1100, 630);
        add(window);

        //header
        JLabel heading = new JLabel("Welcome to the Bank of Foo");
        heading.setBounds(100, 100, 400, 40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        window.add(heading);

        //button to show all accounts
        showAccs = new JButton("Show All Accounts");
        showAccs.setBounds(100, 200, 200, 40);
        showAccs.addActionListener(this);
        window.add(showAccs);

        //button to add an account
        addAcc = new JButton("Add New Account");
        addAcc.setBounds(100, 250, 200, 40);
        addAcc.addActionListener(this);
        window.add(addAcc);

        //button to modify an account
        editAcc = new JButton("Update Account");
        editAcc.setBounds(100, 300, 200, 40);
        editAcc.addActionListener(this);
        window.add(editAcc);

        //button to delete and account
        delAcc = new JButton("Delete Account");
        delAcc.setBounds(100, 350, 200, 40);
        delAcc.addActionListener(this);
        window.add(delAcc);

        //window management
        setTitle("Home | Bank of Foo");
        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //BUTTON LISTENERS
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == showAccs){
            JOptionPane.showMessageDialog(null, "Function to Show All Accounts is WIP");
        }
        else if(e.getSource() == addAcc){
            new AccountAddFrame();
        }
        else if(e.getSource() == editAcc){
            JOptionPane.showMessageDialog(null, "Function to Edit Accounts is WIP");
        }
        else if(e.getSource() == delAcc){
            JOptionPane.showMessageDialog(null, "Function to Delete Accounts is WIP");
        }
    }

    //RUN WINDOW
    public static void main(String[]args){
        new HomePage();
    }
}
