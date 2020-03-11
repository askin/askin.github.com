---
Title: Java ile Oracle Veritabanına bağlanmak.
Date: 2010-11-08T20:29:00+03:00
Author: Aşkın Özgür
Category: Programlama
Tags: ["database", "Java", "oracle"]
Slug: java-ile-oracle-veritabanina-baglanmak
Status: published
---

Öncelikle http://www.oracle.com/technetwork/database/enterprise-edition/jdbc101040-094982.html adresinden classes12.jar dosyasını indiriyoruz.

Bu dosyayı bir dizine atıp, içeriğini bu dizine çıkartıyoruz. Bu dizini classpath değişkeninde belirtip kodlamaya başlıyoruz.

```java
import java.io.*;
import java.sql.*;

public class OraThin {                                                                                                                                                                
    public static void main(String[] args) {                                                                                                                                          
        try {                                                                                                                                                                         
            Connection con = null;
            Class.forName("oracle.jdbc.driver.OracleDriver");              
            con=DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:dbname",
                "username",
                "password");
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM KISI");

            String name;
            String surname;

            while(rs.next()) {
                name    = rs.getString("AD");
                surname = rs.getString("SOYAD");

                System.out.println("Name: " + name + ", Surmame: " + surname);
            }

            s.close();
            con.close();
        } catch(Exception e){e.printStackTrace();}
    }
} 
```
