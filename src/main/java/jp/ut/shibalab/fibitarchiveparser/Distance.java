package jp.ut.shibalab.fibitarchiveparser;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class for distance consumption (approx. every 1 minute)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Distance implements Comparable<Distance> {	
	/* ==============================================================
	 * instance fields
	 * ============================================================== */
	/** dateTime */
	private Date _dateTime;
	
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
		LocalDateTime ldt = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("MM/dd/yy HH:mm:ss"));
		_dateTime   = Date.from( ldt.atZone(ZoneId.systemDefault()).toInstant() );
		_distance   = value;
	}
	
	
	/* ==============================================================
	 * instance methods
	 * ============================================================== */
	/**
	 * get date time 
	 * @return date time
	 */
	public Date getDateTime() {
		return _dateTime;
	}
	
	/**
	 * get distance value 
	 * @return distance value
	 */
	public double getDistance() {
		return _distance;
	}
	
	@Override
	public String toString() {
		return String.format("(%s, %d)",_dateTime, _distance);
	}
	
	@Override
	public int compareTo(Distance obj) {
		if( obj == null ) { 
    		return 1;
    	}
    	if( obj.getDateTime() == null ) {
    		return 1;
    	}
    	if( this == obj ) {
    		return 0;
    	}
    	if( getDateTime() == null ) {
    		return -1;
    	}
    	
    	return getDateTime().compareTo(obj.getDateTime());
	}
}
