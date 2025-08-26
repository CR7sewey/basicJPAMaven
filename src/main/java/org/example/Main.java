package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Pessoa p1 = new Pessoa(1, "Teste 1", 25);
        Pessoa p2 = new Pessoa(2, "Teste 2", 26);
        Pessoa p3 = new Pessoa(3, "Teste 3", 27);

        // Persistencia para db
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploJPA");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);

        em.getTransaction().commit();
        em.close();
        emf.close();


    }
}