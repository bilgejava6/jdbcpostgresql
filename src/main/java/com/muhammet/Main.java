package com.muhammet;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception{
       Driver.class.forName("org.postgresql.Driver");
       Connection connection = DriverManager
               .getConnection("jdbc:postgresql://localhost:5433/DbSatis?user=postgres&password=root");
       PreparedStatement pr = connection.prepareStatement("select * from tblmusteri order by id desc");
        /**
         * SQL sorguları neticesinde bir tablo dönüşü olacak ise, bu resultset şeklinde tablo olarak döner
         * burada öemli olan bu resultset içinde barındırılan dataların, satır satır okunması gerektiğidir.
         */
       ResultSet resultSet = pr.executeQuery();
        /**
         * satur satır okuma işlemini while ile yaparız. çünkü resultset içinde bulunan next() methodu
         * her seferinde bir satıra odaklanır.
         */
       while(resultSet.next()){
           /**
            * result set içinde bulunan methodlar ile tablo satırı içindeki kolonları seçebilir.
            * burada dikkat edilecek nokta, okumaya çalıştığınız sütunun tipi (long,int,string v.s.)dir
            * ayrıca okuyacağınız tablou sütununun ya index numarasını ya da adını vermeniz gereklidir.
            */
           long id = resultSet.getLong("id");
           String ad = resultSet.getString(2);
           System.out.println("id....: "+ id+ " - ad....: "+ ad);
       }
        connection.close();
    }
}