package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;

public class TestaRelatorioDasMovimentacoes {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();
        // region Notes about JOIN FETCH
        // When you just "select c from Conta c" you are loading info from Movimentacao using Lazyness or Eager (see Conta.java)
        // To avoid the N+1 problem (see Conta.java), we can set de relationship with Movimentaco directly in select statement using
        //    JOIN FETCH on FK field.
        // * The LEFT is used because we need all Conta (table at left side), even if they doesn't have
        // register on Movimentacao.
        // endregion
        String jpql = "select c from Conta c left join fetch c.movimentacoes";
        TypedQuery<Conta> query = em.createQuery(jpql, Conta.class);

        List<Conta> contas = query.getResultList();
        for (Conta conta : contas) {
            System.out.println("-".repeat(120));
            System.out.println("Titular: " + conta.getTitular());
            System.out.println("Agência: " + conta.getAgencia());
            System.out.println("C/C: " + conta.getNumero());
            System.out.println("Movimentações: " + conta.getmovimentacoes());
        }
    }
}
