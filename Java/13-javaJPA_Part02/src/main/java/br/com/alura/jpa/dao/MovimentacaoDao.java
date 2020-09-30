package br.com.alura.jpa.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.alura.jpa.modelo.MediaComData;
import br.com.alura.jpa.modelo.Movimentacao;

public class MovimentacaoDao {

    private EntityManager em;

    public MovimentacaoDao(EntityManager em) {
        this.em = em;
    }

    public List<Movimentacao> getMovimentacoesFiltradasPorData(Integer filterDay, Integer filterMonth, Integer filterYear) {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Movimentacao> query = builder.createQuery(Movimentacao.class);

        Root<Movimentacao> root = query.from(Movimentacao.class);

        // As we have more than one predicate, we need and array or list to store it.
        List<Predicate> predicates = new ArrayList<>();

        if (filterDay != null) {
            // Predicates are the filter we do in our queries.
            // So we need to compare the value on BD with the value we receive as a parameter. To do this we use builder.EQUAL
            // As we'll use BD functions to filter the day, month and year from our date field (data) we must use
            // builder funtions that receives the function you want to use, the class of data type, and the field we're using'
            Predicate predicate = builder.equal(builder.function("day", Integer.class, root.get("data")), filterDay);
            // As the scope of var predicate above is only here, we've to store it in our predicate list.
            predicates.add(predicate);
        }
        if (filterMonth != null) {
            Predicate predicate = builder.equal(builder.function("month", Integer.class, root.get("data")), filterMonth);
            predicates.add(predicate);
        }
        if (filterYear != null) {
            Predicate predicate = builder.equal(builder.function("year", Integer.class, root.get("data")), filterYear);
            predicates.add(predicate);
        }

        query.where((Predicate[]) predicates.toArray(new Predicate[0]));

        TypedQuery<Movimentacao> typedQuery = em.createQuery(query);

        return typedQuery.getResultList();
    }

    public List<MediaComData> getMediaDiariaDasMovimentacoes() {

        TypedQuery<MediaComData> query = em.createNamedQuery("MediaDiariaDasMovimentacoes", MediaComData.class);
        return query.getResultList();
    }

    public BigDecimal getSomaDasMovimentacoes() {

        // Print the sum of all values in Movimentacao. Retusn is always a BigDecimal.
        TypedQuery<BigDecimal> querySum = em.createNamedQuery("SomaMovimentacoes", BigDecimal.class);

        return querySum.getSingleResult();
    }
}
