package br.com.alura.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import br.com.alura.jpa.dao.MovimentacaoDao;
import br.com.alura.jpa.modelo.Movimentacao;

public class TestaSomaDasMovimentacoes {
    public static void main(String[] args) {
        int repeatSeparator = 120;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        System.out.println("=".repeat(repeatSeparator));
        // NOTE Dependency Injection.
        // region
        // This is DEPENDENCY INJECTION. Movimentacao Dao DEPENDS on a entity manager to work. So, the method has
        // a constructor that receive this Entity Manager. This forces who call these methods to provide an
        // Entity Manager instead of the MovimentacaoDao control its own dependencies (control inversion).
        // endregion
        BigDecimal somaDasMovimentacoes = new MovimentacaoDao(em).getSomaDasMovimentacoes();
        System.out.println("A soma de todas as movimentações registradas é de: " + somaDasMovimentacoes);

        // NOTE Criteria Query
        System.out.println("=".repeat(repeatSeparator));

        // Criteria Builder is an interface, so we need to get a implementation of it.
        // In this case, we'll get te EntityManager implementation.
        CriteriaBuilder builder = em.getCriteriaBuilder();
        // The Criteria query receives the class of the return of our query. Sum returns BigDecimal
        CriteriaQuery<BigDecimal> query = builder.createQuery(BigDecimal.class);

        // This is the main or ROOT of our query. It will be where the data comes from.
        Root<Movimentacao> root = query.from(Movimentacao.class);

        // Here we'll get the expression that executes the sum.
        // Our builder will get the sum of root (Movimentacao.class) using the atribute VALOR
        Expression<BigDecimal> sum = builder.sum(root.<BigDecimal>get("valor"));
        // Now we passa the expression sum to perform the select.
        query.select(sum);

        // Done that, we pass the query to a typedquery to be executed by JPA.
        TypedQuery<BigDecimal> typedQuery = em.createQuery(query);

        System.out.println("(Criteria) A soma de todas as movimentações registradas é de: " + typedQuery.getSingleResult());

    }
}
