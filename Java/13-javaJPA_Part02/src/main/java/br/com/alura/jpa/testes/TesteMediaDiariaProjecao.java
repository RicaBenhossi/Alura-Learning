package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.MediaComData;

public class TesteMediaDiariaProjecao {
    public static void main(String[] args) {
        int repeatSeparator = 120;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();
        // To solve the problem on TesteMediaDiariaDasMovimentacoes.java, we create a new class MediaComData.


        // region Print the average (avg) of values on Movimentacao gruoped by date
        // JPA allows us to instance a new object right into de select of a query.
        // But we need to pass all the qualified name of the object
        // We have to do this because the result of the query ha different types (Double and Integer)
        // So we need an object that can hold these types so we van get the values while iterate it.
        // endregion
        String jpql = "select new br.com.alura.jpa.modelo.MediaComData(avg(m.valor), day(m.data), month(m.data)) from Movimentacao m group by day(m.data), month(m.data), year(m.data) ";

        // This new class will be our Type here and will deal properly with the different types.
        TypedQuery<MediaComData> query = em.createQuery(jpql, MediaComData.class);
        List<MediaComData> mediaDasMovimentacoes = query.getResultList();

        System.out.println("=".repeat(repeatSeparator));
        for (MediaComData resultado : mediaDasMovimentacoes) {
            System.out.println(
                "A média das movimentações do dia " + resultado.getDia() + "/" + resultado.getMes() + " é: " + resultado.getValor());
        }
    }

}
