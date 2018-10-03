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
abstract class Query {
        static final String
    CREATE =
            (
            "CREATE TABLE IF NOT EXISTS donor (" +
                    "id INTEGER ," +
                    "name varchar(30) NOT NULL," +
                    "blood_group varchar(3) NOT NULL," +
                    "gender TEXT,"+
                    "age INTEGER NOT NULL," +
                    "date_of_donation VARCHAR(25)"+
                    ");"
            ),
    ADD =
            (
            "INSERT INTO donor (id,name,blood_group,gender,age,date_of_donation) VALUES " +
                    "(?, ?, ?, ?, ?, ?);"
            ),
    
    DEL =
            (
            "DELETE FROM donor WHERE id = ? ;"
            ),
    GET =
            (
            "SELECT * FROM donor WHERE id = ?;"
            ),
    CLEANSLATE =
            (
            "DELETE FROM donor;"
            ),
    SELECT =
            (
            "SELECT * FROM donor;"
            );

    
}
