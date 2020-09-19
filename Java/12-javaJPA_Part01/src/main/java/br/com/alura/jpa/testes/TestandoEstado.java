package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TestandoEstado {
    public static void main(String[] args) {
        // This is a JAVA BIN. JAVA BIN is a common and ordinary java class wit default constructor, getters and setters.

        // JPA named the state of these kind of object TRANSIENT
        // TRANSIENT is an object thatexists in memory, doesn't have an ID but is a candidate to be a MANAGED.
        Conta conta = new Conta();
        conta.setTitular("Natalia");
        conta.setAgencia(1234);
        conta.setNumero(54321);
        conta.setSaldo(1101.0);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Here, the object is transformed from TRANSIENT state to MANAGED
        em.persist(conta);

        // Here, the object is transformed from MANAGED state to REMOVE.
        em.remove(conta);

        em.getTransaction().commit();
    }
}