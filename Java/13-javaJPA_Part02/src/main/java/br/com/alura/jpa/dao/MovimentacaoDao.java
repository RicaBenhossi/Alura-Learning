package br.com.alura.jpa.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.MediaComData;

public class MovimentacaoDao {

    private EntityManager em;

    public MovimentacaoDao(EntityManager em) {
        this.em = em;
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
