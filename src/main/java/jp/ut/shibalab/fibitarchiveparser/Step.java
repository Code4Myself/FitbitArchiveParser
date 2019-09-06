package jp.ut.shibalab.fibitarchiveparser;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class for step count (approx. every 1 minute)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Step implements Comparable<Step> {	
	/* ==============================================================
	 * instance fields
	 * ============================================================== */
	/** dateTime */
	private Date _dateTime;
	
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
		LocalDateTime ldt = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("MM/dd/yy HH:mm:ss"));
		_dateTime   =  Date.from( ldt.atZone(ZoneId.systemDefault()).toInstant() );
		_step       = value;
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
	 * get step value 
	 * @return step value
	 */
	public int getStep() {
		return _step;
	}
	
	@Override
	public String toString() {
		return String.format("(%s, %d)",_dateTime, _step);
	}
	
	@Override
	public int compareTo(Step obj) {
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
