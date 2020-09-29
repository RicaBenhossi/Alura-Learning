package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


public class TesteMediaDiariaDasMovimentacoes {
    public static void main(String[] args) {
        int repeatSeparator = 120;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        // Print the average (avg) of values on Movimentacao gruoped by date
        String jpql = "select avg(m.valor) from Movimentacao m group by day(m.data), month(m.data), year(m.data) ";

        TypedQuery<Double> query = em.createQuery(jpql,Double.class);
        List<Double> mediaDasMovimentacoes = query.getResultList();

        // But here we've a problem: we can't print the date. So we have the average value but we can't print the day that
        // the averagebelongs to;
        System.out.println("=".repeat(repeatSeparator));
        for (Double media : mediaDasMovimentacoes) {
            System.out.println("A media das movimentações é: " + media);
        }

        // To solve the problem, we must bring other infos in our select: the day and month.
        jpql = "select avg(m.valor), day(m.data), month(m.data) from Movimentacao m group by day(m.data), month(m.data), year(m.data) ";

        // If we run the select above using TypedQuery <Double> we'll get an exception because now we've more than 1 result
        // in our query and these results are not double. So we need a more generic type of query.
        Query query2 = em.createQuery(jpql);
        // NOTE Getting results of multiple types
        // In order to store these multityped result we can use an Object array that is a more generic type.
        // Altough it is not the best form of doing because, as the Object is too generiic, we have to properly convert its infos
        // Thats why we got an warning on query2.GetResultList() because this method can't garantee that it will
        // return an Objetct List. If it can't cast it automatically, we'll get a Class Cast Exception.
        List<Object[]> mediaDasMovimentacoes2 = query2.getResultList();

        System.out.println("=".repeat(repeatSeparator));
        for (Object[] resultado : mediaDasMovimentacoes2) {
            System.out.println(
                "A média das movimentações do dia " + resultado[1] + "/" + resultado[2] + " é: " + resultado[0]);
        }
    }

}
