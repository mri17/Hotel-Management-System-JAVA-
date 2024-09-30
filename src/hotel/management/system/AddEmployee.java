package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField tfname, tfage, tfsalary, tfphone, tfnid, tfemail;
    JRadioButton rbmale, rbfemale;
    JButton save;
    JComboBox cbjob;

    AddEmployee() {

        setLayout(null);

        JLabel lblname = new JLabel("NAME");
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblname.setBounds(60, 30, 120, 30);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 30, 150, 30);
        add(tfname);

        JLabel lblage = new JLabel("AGE");
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblage.setBounds(60, 80, 150, 30);
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(200, 80, 150, 30);
        add(tfage);

        JLabel lblgender = new JLabel("GENDER");
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblgender.setBounds(60, 130, 150, 30);
        add(lblgender);

        rbmale = new JRadioButton("MALE");
        rbmale.setBackground(Color.WHITE);
        rbmale.setBounds(200, 130, 70, 30);
        add(rbmale);

        rbfemale = new JRadioButton("FEMALE");
        rbfemale.setBackground(Color.WHITE);
        rbfemale.setBounds(280, 130, 70, 30);
        add(rbfemale);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(rbmale);
         bg.add(rbfemale);
        
        

        JLabel lbljob = new JLabel("JOB");
        lbljob.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lbljob.setBounds(60, 180, 150, 30);
        add(lbljob);

        String course[] = {"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Waiter/Waitress", "Manager", "Accountant", "Chef"};
        cbjob = new JComboBox(course);
        cbjob.setBackground(Color.WHITE);
        cbjob.setBounds(200, 180, 150, 30);
        add(cbjob);

        JLabel lblslary = new JLabel("SALARY");
        lblslary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblslary.setBounds(60, 230, 120, 30);
        add(lblslary);

        tfsalary = new JTextField();
        tfsalary.setBounds(200, 230, 150, 30);
        add(tfsalary);

        JLabel lblphone = new JLabel("PHONE");
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblphone.setBounds(60, 280, 150, 30);
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(200, 280, 150, 30);
        add(tfphone);

        JLabel lblnid = new JLabel("NID");
        lblnid.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblnid.setBounds(60, 380, 120, 30);
        add(lblnid);

        tfnid = new JTextField();
        tfnid.setBounds(200, 380, 150, 30);
        add(tfnid);

        JLabel lblemail = new JLabel("EMAIL");
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblemail.setBounds(60, 330, 150, 30);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 330, 150, 30);
        add(tfemail);

        save = new JButton("SAVE");
        save.setBounds(200, 430, 150, 30);
        save.addActionListener(this);
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        
        add(save);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(380, 60, 450, 370);
        add(image);

        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 200, 850, 540);
        setVisible(true);

    }

    /*public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
        String nid = tfnid.getText();
        String email = tfemail.getText();
        
        String gender=null;
        
        if(rbmale.isSelected()){
            gender="Male";
            
        }else if(rbfemale.isSelected()){
            gender="Female";
            
        }
        
        String job=(String)cbjob.getSelectedItem();
        
        try{
            
            Conn conn=new Conn();
            
              String query = "insert into employee values( '"+name+"', '"+age+"', '"+gender+"','"+job+"', '"+salary+"', '"+phone+"','"+email+"', '"+nid+"')";
              
              conn.s.executeUpdate(query);
              
               JOptionPane.showMessageDialog(null,"Employee Added Successfully!!");
               
              setVisible(false);
            
        }catch(Exception e){
            e.printStackTrace();
        }

       

    }*/
    @Override
    public void actionPerformed(ActionEvent ae) {

        try {
            ValidityCheck.validateFields(tfname, tfage, rbmale, rbfemale, tfsalary, tfphone, tfemail, tfnid);
            String name = tfname.getText();
            String age = tfage.getText();
            String salary = tfsalary.getText();
            String phone = tfphone.getText();
            String nid = tfnid.getText();
            String email = tfemail.getText();
            String gender = rbmale.isSelected() ? "Male" : (rbfemale.isSelected() ? "Female" : "");
            String job=(String)cbjob.getSelectedItem();

            try{

                Conn conn=new Conn();

                String query = "insert into employee values( '"+name+"', '"+age+"', '"+gender+"','"+job+"', '"+salary+"', '"+phone+"','"+email+"', '"+nid+"')";

                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Employee Added Successfully!!");

                setVisible(false);

            }catch(Exception e){
                e.printStackTrace();
            }





            setVisible(false);
            setVisible(false);
        } catch (ValidationException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


    }

    public static void main(String[] args) {
        new AddEmployee();
    }

}
