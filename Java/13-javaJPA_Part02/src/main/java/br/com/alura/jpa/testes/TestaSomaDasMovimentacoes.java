package br.com.alura.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.dao.MovimentacaoDao;

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

    }
}
