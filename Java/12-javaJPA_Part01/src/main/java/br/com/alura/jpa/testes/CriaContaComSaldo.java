package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

/*
 * CriaContaComSaldo
 */
public class CriaContaComSaldo {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setTitular("José");
        conta.setAgencia(12345);
        conta.setNumero(54321);
        conta.setSaldo(900.00);

        em.getTransaction().begin();

        em.persist(conta);

        em.getTransaction().commit();
        em.close(); // At this point the object is not managed anymore. The object is now DETACHED and is no longer automatically synced wuth bd.

        System.out.println("ID da conta da Márcia: " + conta.getId());
        conta.setSaldo(500.0);

        EntityManager em2 = emf.createEntityManager(); // Set up a new instance of the entity manager. oNoy

        em2.getTransaction().begin();

        em2.merge(conta); // MERGE gets a DETACHED object and transform it in MANAGED. It loads the values from DB, check for changes and apply these changes if it exists.

        em2.getTransaction().commit();

    }
}