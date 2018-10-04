/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Donor;

/**
 *
 * @author PARAG
 */
public class DonorModel {
    private final String name,blood_group,gender,date_of_donation;
    private final int age,id;
    public DonorModel(int id,String name,String blood_group,String gender,int age,String date_of_donation)
    {
        this.name=name;
        this.blood_group=blood_group;
        this.gender=gender;
        this.age=age;
        this.id=id;
        this.date_of_donation=date_of_donation;
    }

    public DonorModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String getName()
            {
                return this.name;
            }
    
      public String getBloodGroup()
            {
                return this.blood_group;
            }
       public String getGender()
            {
                return this.gender;
            }
        public int getAge()
            {
                return this.age;
            }
        public int getId()
            {
                return this.id;
            }
        
       public String getDate()
            {
                return this.date_of_donation;
            }
        
}
