package ch.carve.batch1;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "CURRENCY_RATE")
@NamedQueries({
	@NamedQuery(name = "CurrencyRate.getAll", query = "SELECT c FROM CurrencyRate c"),
	@NamedQuery(name = "CurrencyRate.getLatestByCurrency", query = "SELECT c FROM CurrencyRate c WHERE c.currencyCode = :currency AND c.version = (SELECT MAX(c2.version) FROM CurrencyRate c2 WHERE c.currencyCode = c2.currencyCode)")
})
public class CurrencyRate {
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="CURRENCY_CODE")
	private int currencyCode;

	@Column(name="VERSION")
	private int version;

	@Column(name="RATE")
	private float rate;

	@Column(name="SOME_DATE")
	private Date date;

	public int getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(int currencyCode) {
		this.currencyCode = currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = Integer.valueOf(currencyCode);
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public void setRate(String rate) {
		this.rate = Float.valueOf(rate);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
