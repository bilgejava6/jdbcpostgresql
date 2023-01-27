package com.muhammet;

import com.muhammet.repository.MusteriRepository;
import com.muhammet.repository.entity.Musteri;

public class Runner_Repository {
    public static void main(String[] args) {
        MusteriRepository repository = new MusteriRepository();
        //repository.delete(1059l);
        //repository.save(new Musteri(0l,"Muhammet","HOCA",            "","","",33,null,null,1));
        //repository.findAll().forEach(System.out::println);
        System.out.println(repository.findById(1060l).toString());
    }
}
