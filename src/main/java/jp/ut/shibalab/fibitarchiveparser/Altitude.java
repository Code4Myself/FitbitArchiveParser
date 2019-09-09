package jp.ut.shibalab.fibitarchiveparser;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class for Altitude
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Altitude extends ATimeValue {	
	/* ==============================================================
	 * instance fields
	 * ============================================================== */
	/** altitude value */
	private int _altitude;
	

	/* ==============================================================
	 * constructors
	 * ============================================================== */
	/**
	 * initialization 
	 * @param dateTime date time string (MM/dd/yy HH:mm:ss)
	 * @param value altitude count
	 */
	@JsonCreator
	protected Altitude(@JsonProperty("dateTime") String dateTime,
				       @JsonProperty("value")    int    value)
	{
		super(dateTime);
		_altitude = value;
	}
	
	
	/* ==============================================================
	 * instance methods
	 * ============================================================== */
	/**
	 * get altitude value 
	 * @return altitude value
	 */
	public int getAltitude() {
		return _altitude;
	}
	
	@Override
	public String toString() {
		return String.format("(%s, %d)", getDateTime(), _altitude);
	}
	
	
	@Override
	public String toCsvString(String delim) {
		LocalDateTime ldt = LocalDateTime.ofInstant(getDateTime().toInstant(), ZoneId.systemDefault());
		return StringUtils.join(new String[] {ldt.format(DATETIME_FORMAT), String.valueOf(getAltitude())}, 
								delim);
	}
}
