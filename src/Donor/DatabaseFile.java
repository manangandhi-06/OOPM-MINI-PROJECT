/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Donor;
import java.sql.*;

/**
 *
 * @author PARAG
 */
public class DatabaseFile {
      private PreparedStatement
            create_stm,
            select_stm,
            add_stm,
            cleanslate_stm,
            del_stm,
            get_stm;
          public DatabaseFile(){
        Connection conn;
        try {
          
            conn = DriverManager.getConnection("jdbc:sqlite:donor.db");
            
            create_stm = conn.prepareStatement(Query.CREATE);
            create_stm.executeUpdate();
            System.out.println("ho gaya");
            
            add_stm = conn.prepareStatement(Query.ADD);
            del_stm = conn.prepareStatement(Query.DEL);
            get_stm = conn.prepareStatement(Query.GET);
            select_stm = conn.prepareStatement(Query.SELECT);
            cleanslate_stm = conn.prepareStatement(Query.CLEANSLATE);
            
        }catch ( SQLException e ) {
            e.printStackTrace();
            System.exit(0);
        }
    }
    public void add(DonorModel donor1){
           try{
               add_stm.setInt(1,donor1.getId());
               add_stm.setString(2,donor1.getName());
               add_stm.setString(3,donor1.getBloodGroup());
               add_stm.setString(4,donor1.getGender());
               add_stm.setInt(5,donor1.getAge());
               add_stm.setString(6,donor1.getDate());
               add_stm.executeUpdate();
           }catch(SQLException e){
               e.printStackTrace();
           }
    } 
    public void delete(int id){
        try{
            del_stm.setInt(1,id);
            del_stm.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        }
    public DonorModel getDonor(int id){
        try{
            get_stm.setInt(1,id);
            ResultSet rs = get_stm.executeQuery();
            
            if(rs.next()){
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String blood_group = rs.getString("blood_group");
                String date_of_donation = rs.getString("date_of_donation");
                int age = rs.getInt("age");
                return new DonorModel(id,name,blood_group,gender,age,date_of_donation);    
            }
            else{
                return new DonorModel(-1,"","","",-1,"");
            } 
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
        
    }
    

      
    
