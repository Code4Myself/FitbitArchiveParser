package jp.ut.shibalab.fibitarchiveparser;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class for distance consumption (approx. every 1 minute)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Distance extends ATimeValue {	
	/* ==============================================================
	 * instance fields
	 * ============================================================== */
	/** distance value */
	private int  _distance;
	

	/* ==============================================================
	 * constructors
	 * ============================================================== */
	/**
	 * initialization 
	 * @param dateTime date time string (MM/dd/yy HH:mm:ss)
	 * @param value distance count
	 */
	@JsonCreator
	protected Distance(@JsonProperty("dateTime") String dateTime,
				       @JsonProperty("value")    int    value)
	{
		super(dateTime);
		_distance = value;
	}
	
	
	/* ==============================================================
	 * instance methods
	 * ============================================================== */
	/**
	 * get distance value 
	 * @return distance value
	 */
	public double getDistance() {
		return _distance;
	}
	
	@Override
	public String toString() {
		return String.format("(%s, %d)", getDateTime(), _distance);
	}
	
	@Override
	public String toCsvString(String delim) {
		LocalDateTime ldt = LocalDateTime.ofInstant(getDateTime().toInstant(), ZoneId.systemDefault());
		return StringUtils.join(new String[] {ldt.format(DATETIME_FORMAT), 
											  String.valueOf(getDistance())}, 
								delim);
	}

}
