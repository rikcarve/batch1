package ch.carve.batch1;

import java.util.List;
import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
public class CurrencyItemWriter extends AbstractItemWriter {

    @PersistenceContext
    EntityManager em;

    @Override
    public void writeItems(List list) {
        System.out.println("writeItems: " + list);
        for (Object currencyRate : list) {
            em.persist(currencyRate);
        }
    }
}
