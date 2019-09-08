package jp.ut.shibalab.fibitarchiveparser;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class for Resting Heart Rate
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestingHeartRate extends ATimeValue {
	/* ==============================================================
	 * static inner class
	 * ============================================================== */
	/** Heart Rate value */
	@JsonIgnoreProperties(ignoreUnknown = true)
	private static class Value {
		/** date */
		@JsonProperty("date")
		private String _date;

		/** value */
		@JsonProperty("value")
		private double _value;
		
		/** error */
		@JsonProperty("error")
		private double _error;
	}
	
	
	/* ==============================================================
	 * instance fields
	 * ============================================================== */
	/** date */
	private String _date;

	/** value */
	private double _value;
	
	/** error */
	private double _error;
	
	
	/* ==============================================================
	 * constructors
	 * ============================================================== */
	/**
	 * initialization 
	 * @param dateTime date time string (MM/dd/yy HH:mm:ss)
	 * @param value resting heart rate value
	 */
	@JsonCreator
	protected RestingHeartRate(@JsonProperty("dateTime") String dateTime,
					           @JsonProperty("value")    Value  value)
	{
		super(dateTime);
		
		_date  = value._date;
		_value = value._value;
		_error = value._error;
	}
	
	
	/* ==============================================================
	 * instance methods
	 * ============================================================== */
	/**
	 * get Date 
	 * @return Date
	 */
	public String getDate() {
		return _date;
	}
	
	/**
	 * get value 
	 * @return value
	 */
	public double getValue() {
		return _value;
	}
	
	/**
	 * get error  value
	 * @return error value
	 */
	public double getError() {
		return _error;
	}
	
	@Override
	public String toString() {
		return String.format("(%s, %s, %f, %f)",getDateTime(), _date, _value, _error);
	}
}
