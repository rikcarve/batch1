package ch.carve.batch1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/currency")
public class CurrencyConverterResource {

	@PersistenceContext
	EntityManager em;

	@GET
	@Path("rate")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRate(@QueryParam("currency") int currency) {
		CurrencyRate rate = em.createNamedQuery("CurrencyRate.getLatestByCurrency", CurrencyRate.class)
				.setParameter("currency", currency)
				.getSingleResult();
		return Response.ok(rate).build();
	}
	
	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		List<CurrencyRate> rates = em.createNamedQuery("CurrencyRate.getAll", CurrencyRate.class)
				.getResultList();
		return Response.ok(rates).build();
	}
}
