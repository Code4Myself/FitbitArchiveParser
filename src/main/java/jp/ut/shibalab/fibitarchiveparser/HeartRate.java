package jp.ut.shibalab.fibitarchiveparser;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class for Heart rate object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HeartRate implements Comparable<HeartRate> {
	/* ==============================================================
	 * static inner class
	 * ============================================================== */
	/** Heart Rate value */
	@JsonIgnoreProperties(ignoreUnknown = true)
	private static class Value {
		/** BPM value */
		@JsonProperty("bpm")
		private int bpm;

		/** confidence */
		@JsonProperty("confidence")
		private int confidence;
	}
	
	
	/* ==============================================================
	 * instance fields
	 * ============================================================== */
	/** dateTime */
	private Date _dateTime;
	
	/** BPM value */
	private int _bpm;
	
	/** confidence value */
	private int _confidence;
	
	
	/* ==============================================================
	 * constructors
	 * ============================================================== */
	/**
	 * initialization 
	 * @param dateTime date time string (MM/dd/yy HH:mm:ss)
	 * @param value Heart rate value
	 */
	@JsonCreator
	protected HeartRate(@JsonProperty("dateTime") String dateTime,
						@JsonProperty("value")    Value  value)
	{
		LocalDateTime ldt = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("MM/dd/yy HH:mm:ss"));
		_dateTime   =  Date.from( ldt.atZone(ZoneId.systemDefault()).toInstant() );
		
		_bpm        = value.bpm;
		_confidence = value.confidence;
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
	 * get BPM 
	 * @return BPM
	 */
	public int getBpm() {
		return _bpm;
	}
	
	/**
	 * get confidence
	 * @return confidence
	 */
	public int getConfidence() {
		return _confidence;
	}
	
	@Override
	public String toString() {
		return String.format("(%s, %d, %d)",_dateTime, _bpm, _confidence);
	}
	
	@Override
	public int compareTo(HeartRate obj) {
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
