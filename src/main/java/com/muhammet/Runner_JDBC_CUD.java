package com.muhammet;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Runner_JDBC_CUD {
    public static void main(String[] args) throws Exception{
        /**
         * JDBC, kullanımında ilk yapılması gereken iki sistem arasında
         * köprü görevi görecek olan(tercüman) Driver ın kullanıma alınmasıdır.
         * 1- Kullanılan veritabanına uygun jdbc driver eklenmelidir.
         * 2- Eklenen driver devreye alınmalıdır.
         */
        Driver.class.forName("org.postgresql.Driver");
        /**
         * Driver' a bağlantı yapabilmesi için gerekli olan parametreleri işlemek
         * gereklidir.
         * -> Bağlantı yapılacak Veritabanı sunucusunun ip adresi
         * -> Hangi port üzerinde yayın yapıyor ise port numarası
         * -> İşlem yapılacak olan Veritananının adı
         * -> Yetkilendirme için Kullanıcı adı ve Şifre
         * DİKKAT!! tüm sistemlerde(dillerde) veritabanına bağlantı işlemlerinde
         * Bağlantı Cümlesi(SQLConnection String) kullanılır. araştırma yaparken
         * bunu kullanınız.
         * Eğer kendi pc nizin postgresql ine bağlanacak iseniz;
         * - localhost <---> 127.0.0.1
         *
         */
        String baglantiAdresi = "jdbc:postgresql://localhost:5433/DbSatis";
        String kullaniciAdi = "postgres";
        String sifre = "root";
        Connection connection = DriverManager.getConnection(baglantiAdresi,kullaniciAdi,sifre);
        /**
         * Emir vermeye başlamalıyız.
         * SQL cümlesi vererek işlenmesini sağlamalıyız.
         */
        String SQL_INSERT = "insert into tbladres(musteriid,il,ilce,mahalle,adres)\n" +
                "values (52,'İstanbul','Kadıköy','Caminin yanı','İstanbul da bir yerler')";
        String SQL_DELETE = "delete from tbladres where id=44";
        String SQL_UPDATE = "update tbladres set musteriid=455, il='İZMİR' where id=33";
        /**
         * Hazırladığınız SQL cümlesini Driver ın taşıyabileceği hale getirmeniz, bir zarfa koymanız gerekli
         * bunun için java da cümle hazırlayıcısı kullanılır.
         */
        PreparedStatement pr = connection.prepareStatement(SQL_UPDATE);
        /**
         * Sürücüye hazırladığımız emri uygulaması gerektiğini belirmeliyiz.
         * hazırlanan cümlenin execute edilmesini sağlamalıyız.
         */
        pr.executeUpdate();
        /**
         * tüm işlemer sona erdikten sonra mutlaka açılan bağlantının sonlandırılması gerekmektedir.
         * çünkü bir DataBase connection havuzunda bir PC için 10 bağlantı sağlar sonraki bağlantılar
         * red edilir.
         */
        connection.close();
    }
}
