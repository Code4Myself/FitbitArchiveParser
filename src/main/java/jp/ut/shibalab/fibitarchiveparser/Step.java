package jp.ut.shibalab.fibitarchiveparser;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class for step count (approx. every 1 minute)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Step extends ATimeValue {	
	/* ==============================================================
	 * instance fields
	 * ============================================================== */
	/** Step value */
	private int _step;
	

	/* ==============================================================
	 * constructors
	 * ============================================================== */
	/**
	 * initialization 
	 * @param dateTime date time string (MM/dd/yy HH:mm:ss)
	 * @param value step count
	 */
	@JsonCreator
	protected Step(@JsonProperty("dateTime") String dateTime,
				   @JsonProperty("value")    int    value)
	{
		super(dateTime);
		_step = value;
	}
	
	
	/* ==============================================================
	 * instance methods
	 * ============================================================== */
	/**
	 * get step value 
	 * @return step value
	 */
	public int getStep() {
		return _step;
	}
	
	@Override
	public String toString() {
		return String.format("(%s, %d)", getDateTime(), _step);
	}
}
