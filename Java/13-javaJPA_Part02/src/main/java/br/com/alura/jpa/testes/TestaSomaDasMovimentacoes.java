package br.com.alura.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestaSomaDasMovimentacoes {
    public static void main(String[] args) {
        int repeatSeparator = 120;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        // Print the sum of all values in Movimentacao. Retusn is always a BigDecimal.
        String jpql = "select sum(m.valor) from Movimentacao m";
        TypedQuery<BigDecimal> querySum = em.createQuery(jpql, BigDecimal.class);

        System.out.println("=".repeat(repeatSeparator));
        BigDecimal somaDasMovimentacoes = querySum.getSingleResult();
        System.out.println("A soma de todas as movimentações registradas é de: " + somaDasMovimentacoes);

    }
}
