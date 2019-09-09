package jp.ut.shibalab.fibitarchiveparser;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class for calorie consumption (approx. every 1 minute)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Calorie extends ATimeValue {	
	/* ==============================================================
	 * instance fields
	 * ============================================================== */
	/** calorie value */
	private double _calorie;
	

	/* ==============================================================
	 * constructors
	 * ============================================================== */
	/**
	 * initialization 
	 * @param dateTime date time string (MM/dd/yy HH:mm:ss)
	 * @param value calorie count
	 */
	@JsonCreator
	protected Calorie(@JsonProperty("dateTime") String dateTime,
				      @JsonProperty("value")    double value)
	{
		super(dateTime);
		_calorie = value;
	}
	
	
	/* ==============================================================
	 * instance methods
	 * ============================================================== */
	/**
	 * get calorie value 
	 * @return calorie value
	 */
	public double getCalorie() {
		return _calorie;
	}
	
	@Override
	public String toString() {
		return String.format("(%s, %f)", getDateTime(), _calorie);
	}
	
	@Override
	public String toCsvString(String delim) {
		LocalDateTime ldt = LocalDateTime.ofInstant(getDateTime().toInstant(), ZoneId.systemDefault());
		return StringUtils.join(new String[] {ldt.format(DATETIME_FORMAT), 
											  String.valueOf(getCalorie())}, 
								delim);
	}
}
