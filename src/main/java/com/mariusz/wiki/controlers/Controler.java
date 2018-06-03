package com.mariusz.wiki.controlers;

import com.mariusz.wiki.entities.Person;
import com.mariusz.wiki.services.PersonService;
import org.apache.commons.codec.digest.DigestUtils;

public class Controler {
    public void registerNewUser(String login, String pass, String uName) {
        PersonService service = new PersonService();

        Person user = new Person();

        String securePassword =  DigestUtils.sha256Hex(pass);;

        user.setName(uName);
        user.setLogin(login);
        user.setPass(securePassword);

        service.registerNewUser(user);

    }

    public Person checkCredentials(String login, String pass){
        PersonService service = new PersonService();
        String securePassword =  DigestUtils.sha256Hex(pass);
        return service.checkPassword(login,securePassword);

    }

    public boolean checkLoginUsage(String login){
        if (login.length()<=4) return false;

        PersonService service = new PersonService();
        return service.checkLoginUsage(login);
    }
}
