package mini;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
ackage mini;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
/**

 **/
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.table.DefaultTableModel;
import Donor.DatabaseFile;
class UserTable extends JFrame {
    public int id1;
    DatabaseFile donor_manan=new DatabaseFile();
    Connection c;
    PreparedStatement pstmt;
    DefaultTableModel model;
    Container cnt = new Container();
    JTable jt = new JTable(model);
    public UserTable(String s2) throws SQLException, ClassNotFoundException

  {
      cnt.setLayout(new FlowLayout(FlowLayout.CENTER));
      model = new DefaultTableModel();
      model.addColumn("ID");
      model.addColumn("NAME");
      model.addColumn("BLOOD GRP");
      model.addColumn("GENDER");
      model.addColumn("AGE");
      model.addColumn("DATE");
      
      try
      {
       Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:donor.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");
      String sql = "SELECT * FROM donor WHERE blood_group='"+s2+"';";
      System.out.println(s2);
      pstmt = c.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery();
            while ( rs.next() ) {
       model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6)});
       System.out.println("heyy");
      }
      }catch(SQLException | ClassNotFoundException e)
      {
          System.out.println(e.getMessage());
      }
      c.close();
      jt = new JTable(model);
      JScrollPane pg = new JScrollPane(jt);
      cnt.add(pg);
             JLabel ii=new JLabel("ENTER ID:");
       JTextField idt=new JTextField(60);
       JButton b1=new JButton("SUBMIT");
      
       
    b1.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              
                if(e.getSource()== b1)
        {
            id1 =Integer.parseInt(idt.getText());
            System.out.println(id1);
            donor_manan.delete(id1);
        }
           }
       });
     
  
    
       cnt.add(ii);
    cnt.add(idt);
    cnt.add(b1);
    
   
      this.pack();
      this.setContentPane(cnt);
      
  }
}
  public class table2

  {   

  
   public static void main(String [] args) throws SQLException, ClassNotFoundException
   {
       String s2 = null;
       JFrame frame = new UserTable(s2);
       frame.setTitle("Demo");
       frame.setSize(500,300);
       frame.setLocationRelativeTo(null);
       frame.setVisible(true);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

  }