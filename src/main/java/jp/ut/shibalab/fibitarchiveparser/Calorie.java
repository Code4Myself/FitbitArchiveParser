package jp.ut.shibalab.fibitarchiveparser;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class for calorie consumption (approx. every 1 minute)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Calorie implements Comparable<Calorie> {	
	/* ==============================================================
	 * instance fields
	 * ============================================================== */
	/** dateTime */
	private Date _dateTime;
	
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
		LocalDateTime ldt = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("MM/dd/yy HH:mm:ss"));
		_dateTime   = Date.from( ldt.atZone(ZoneId.systemDefault()).toInstant() );
		_calorie    = value;
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
	 * get calorie value 
	 * @return calorie value
	 */
	public double getCalorie() {
		return _calorie;
	}
	
	@Override
	public String toString() {
		return String.format("(%s, %f)",_dateTime, _calorie);
	}
	
	@Override
	public int compareTo(Calorie obj) {
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
