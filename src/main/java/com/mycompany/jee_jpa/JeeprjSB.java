/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jee_jpa;

import static java.lang.Integer.parseInt;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author benja
 */
@Stateless
public class JeeprjSB {

    @PersistenceContext
    EntityManager em;
    
    public List getUsers() {
        Query q = em.createNamedQuery("Credentials.findAll");
        return q.getResultList();
    }

    public Credentials getUserByLogin(String login) {
        Credentials user = (Credentials) em.find(Credentials.class, login);
        return user;
    }

    public List getEmployees() {
        Query q = em.createNamedQuery("Jeeprj.findAll");
        return q.getResultList();
    }

    public Jeeprj getEmployeeById(String id) {
        Jeeprj employee = (Jeeprj) em.find(Jeeprj.class, parseInt(id));
        return employee;
    }

    public void updateEmployee(String id,
            String name,
            String firstname,
            String telHome,
            String telMob,
            String telPro,
            String address,
            String postalcode,
            String city,
            String email) {
        Jeeprj employee = (Jeeprj) em.find(Jeeprj.class, parseInt(id));
        employee.setName(name);
        employee.setFirstname(firstname);
        employee.setTelhome(telHome);
        employee.setTelmob(telMob);
        employee.setTelpro(telPro);
        employee.setPostalcode(postalcode);
        employee.setAdress(address);
        employee.setCity(city);
        employee.setEmail(email);
    }

    public void addEmployee(String id,
            String name,
            String firstname,
            String telHome,
            String telMob,
            String telPro,
            String address,
            String postalcode,
            String city,
            String email) {
        Jeeprj employee = new Jeeprj();
        employee.setName(name);
        employee.setFirstname(firstname);
        employee.setTelhome(telHome);
        employee.setTelmob(telMob);
        employee.setTelpro(telPro);
        employee.setPostalcode(postalcode);
        employee.setAdress(address);
        employee.setCity(city);
        employee.setEmail(email);

        em.persist(employee);
    }

    public void deleteEmployee(String id) {
        Jeeprj employee = em.find(Jeeprj.class, parseInt(id));
        em.remove(employee);
    }
}
