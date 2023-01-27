package com.muhammet;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Runner_MusteriEkleme {
    public static void main(String[] args) {
        System.out.println("******************************");
        System.out.println("******  MÜŞTERİ EKLEME  ******");
        System.out.println("******************************");
        System.out.println();
        String ad,soyad,email,telefon,cinsiyet;
        int yas=0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Müşteri adı................: ");
        ad = sc.nextLine();
        System.out.print("Müşteri soyad..............: ");
        soyad = sc.nextLine();
        System.out.print("Müşteri email..............: ");
        email = sc.nextLine();
        System.out.print("Müşteri telefon............: ");
        telefon = sc.nextLine();
        System.out.print("Müşteri cinsiyet...........: ");
        cinsiyet = sc.nextLine();
        sc = new Scanner(System.in);
        System.out.print("Müşteri yas................: ");
        yas = sc.nextInt();
        save(ad,soyad,email,telefon,cinsiyet,yas);
        System.out.println("KAYIT BAŞARI İLE EKLENDİ.");
    }

    private static void save(String ad,String soyad,String email,String telefon,String cinsiyet, int yas){
        try{
            Driver.class.forName("org.postgresql.Driver");
            Connection connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5433/DbSatis?user=postgres&password=root");
            String SQL_INSERT = "insert into tblmusteri(ad,soyad,email,telefon,cinsiyet,yas) " +
                    "values('"+ad+"','"+soyad+"','"+email+"','"+telefon+"','"+cinsiyet+"',"+yas+")";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.executeUpdate();
            connection.close();
        }catch (Exception exception){
            System.out.println("Bir hata oldu....: "+ exception.getLocalizedMessage());
        }
    }
}
