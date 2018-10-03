package mini;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
/**

 *

 * @author gandh

 */
class UserList extends JFrame {
    Connection c;
    PreparedStatement pstmt;
    DefaultTableModel model;
    Container cnt = new Container();
    JTable jt = new JTable(model);
    public UserList() throws SQLException, ClassNotFoundException

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
      String sql = "SELECT * FROM donor";
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
      jt = new JTable(model);
      JScrollPane pg = new JScrollPane(jt);
      cnt.add(pg);
      this.pack();
      this.setContentPane(cnt);
  }
}
  public class table

  {
   public static void main(String [] args) throws SQLException, ClassNotFoundException
   {
       JFrame frame = new UserList();
       frame.setTitle("Demo");
       frame.setSize(500,300);
       frame.setLocationRelativeTo(null);
       frame.setVisible(true);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

  }