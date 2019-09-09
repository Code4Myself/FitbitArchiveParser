package jp.ut.shibalab.fibitarchiveparser;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class for moderately active minutes
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ModeratelyActiveMinute extends ATimeValue {	
	/* ==============================================================
	 * instance fields
	 * ============================================================== */
	/** active minute value */
	private int _activeMinutes;
	

	/* ==============================================================
	 * constructors
	 * ============================================================== */
	/**
	 * initialization 
	 * @param dateTime date time string (MM/dd/yy HH:mm:ss)
	 * @param value active minutes
	 */
	@JsonCreator
	protected ModeratelyActiveMinute(@JsonProperty("dateTime") String dateTime,
				                     @JsonProperty("value")    int    value)
	{
		super(dateTime);
		_activeMinutes = value;
	}
	
	
	/* ==============================================================
	 * instance methods
	 * ============================================================== */
	/**
	 * get active minute value 
	 * @return active minute value
	 */
	public int getActiveMinutes() {
		return _activeMinutes;
	}
	
	@Override
	public String toString() {
		return String.format("(%s, %d)", getDateTime(), _activeMinutes);
	}
	
	@Override
	public String toCsvString(String delim) {
		LocalDateTime ldt = LocalDateTime.ofInstant(getDateTime().toInstant(), ZoneId.systemDefault());
		return StringUtils.join(new String[] {ldt.format(DATETIME_FORMAT), 
											  String.valueOf(getActiveMinutes())}, 
								delim);
	}

}
