package jp.ut.shibalab.fibitarchiveparser;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * abstract class for date time value 
 */
public abstract class ATimeValue implements Comparable<ATimeValue>, ICsv {
	/* ==============================================================
	 * instance fields
	 * ============================================================== */
	/** dateTime */
	private Date _dateTime;
	

	/* ==============================================================
	 * constructors
	 * ============================================================== */
	/**
	 * initialization 
	 * @param dateTime date time string (MM/dd/yy HH:mm:ss)
	 */
	protected ATimeValue(String dateTime) {
		LocalDateTime ldt = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("MM/dd/yy HH:mm:ss"));
		_dateTime  =  Date.from( ldt.atZone(ZoneId.systemDefault()).toInstant() );
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
		
	@Override
	public int compareTo(ATimeValue obj) {
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
	
	@Override
	public String toCsvString() {
		return toCsvString("\t");
	}
}
