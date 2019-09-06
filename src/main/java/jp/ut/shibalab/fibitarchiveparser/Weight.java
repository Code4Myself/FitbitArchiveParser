package jp.ut.shibalab.fibitarchiveparser;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class for Weight data
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weight implements Comparable<Weight> {	
	/* ==============================================================
	 * instance fields
	 * ============================================================== */
	/** log ID */
	private long _logId;

	/** weight value */
	private double _weight;
	
	/** bmi value */
	private double _bmi;
	
	/** fat rate */
	private double _fat;
	
	/** dateTime */
	private Date _dateTime;
	
	/** source */
	private String _source;

	
	/* ==============================================================
	 * constructors
	 * ============================================================== */
	/**
	 * initialization 
	 * @param logId log id
	 * @param weight weight (pounds)
	 * @param bmi BMI
	 * @param fat fat rate
	 * @param date date (MM/dd/yy)
	 * @param time time (hh:mm:ss)
	 * @param source data source (web/API)
	 */
	@JsonCreator
	protected Weight(@JsonProperty("logId")  long logId,
					 @JsonProperty("weight") double weight,
					 @JsonProperty("bmi")    double bmi,
					 @JsonProperty("fat")    double fat, 
					 @JsonProperty("date")   String date,
					 @JsonProperty("time")   String time,
				     @JsonProperty("source") String source)
	{
		LocalDateTime ldt = LocalDateTime.parse(date +" " + time, DateTimeFormatter.ofPattern("MM/dd/yy HH:mm:ss"));
		_dateTime   =  Date.from( ldt.atZone(ZoneId.systemDefault()).toInstant() );
		
		_logId  = logId;
		_weight = weight;
		_bmi    = bmi;
		_fat    = fat;
		_source = source;
	}
	
	
	/* ==============================================================
	 * instance methods
	 * ============================================================== */
	/**
	 * get log ID
	 * @return log ID
	 */
	public long getLogId() {
		return _logId;
	}
	
	/**
	 * get weight (pounds)
	 * @return weight (pounds)
	 */
	public double getWeight() {
		return _weight;
	}
	
	/**
	 * get BMI
	 * @return BMI 
	 */
	public double getBmi() {
		return _bmi;
	}
	
	/**
	 * get fat rate
	 * @return fat rate 
	 */
	public double getFat() {
		return _fat;
	}
	
	/**
	 * get date time 
	 * @return date time
	 */
	public Date getDateTime() {
		return _dateTime;
	}
	
	/**
	 * get data source (web/API)
	 * @return data source 
	 */
	public String getSource() {
		return _source;
	}
	
	@Override
	public String toString() {
		return String.format("(%d, %f, %f, %f, %s, %s)", _logId, _weight, _bmi, _fat, _dateTime, _source);
	}
	
	@Override
	public int compareTo(Weight obj) {
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
