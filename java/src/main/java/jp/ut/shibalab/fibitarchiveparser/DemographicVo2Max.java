package jp.ut.shibalab.fibitarchiveparser;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class for 'demographic vo2 max'
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DemographicVo2Max extends ATimeValue {
	/* ==============================================================
	 * static inner class
	 * ============================================================== */
	/** Heart Rate value */
	@JsonIgnoreProperties(ignoreUnknown = true)
	private static class Value {
		/** demographicVO2Max */
		@JsonProperty("demographicVO2Max")
		private double _value;
		
		/** demographicVO2MaxError */
		@JsonProperty("demographicVO2MaxError")
		private double _error;
		
		/** filteredDemographicVO2Max */
		@JsonProperty("filteredDemographicVO2Max")
		private double _filteredValue;
		
		/** filteredDemographicVO2MaxError */
		@JsonProperty("filteredDemographicVO2MaxError")
		private double _filteredError;
	}
	
	
	/* ==============================================================
	 * instance fields
	 * ============================================================== */
	/** demographicVO2Max */
	private double _value;
	
	/** demographicVO2MaxError */
	private double _error;
	
	/** filteredDemographicVO2Max */
	private double _filteredValue;
	
	/** filteredDemographicVO2MaxError */
	private double _filteredError;
	
	
	/* ==============================================================
	 * constructors
	 * ============================================================== */
	/**
	 * initialization 
	 * @param dateTime date time string (MM/dd/yy HH:mm:ss)
	 * @param value demographic vo2 max value
	 */
	@JsonCreator
	protected DemographicVo2Max(@JsonProperty("dateTime") String dateTime,
					            @JsonProperty("value")    Value  value)
	{
		super(dateTime);
		
		_value = value._value;
		_error = value._error;
		_filteredValue = value._filteredError;
		_filteredError = value._filteredError;
	}
	
	
	/* ==============================================================
	 * instance methods
	 * ============================================================== */
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
	
	/**
	 * get filtered value 
	 * @return filtered value
	 */
	public double getFilteredValue() {
		return _filteredValue;
	}
	
	/**
	 * get filtered error value
	 * @return filtered error value
	 */
	public double getFilteredError() {
		return _filteredError;
	}
	
	@Override
	public String toString() {
		return String.format("(%s, %f, %f, %f, %f)",getDateTime(), getValue(), getError(), getFilteredValue(), getFilteredError()); 
	}
	
	@Override
	public String toCsvString(String delim) {
		LocalDateTime ldt = LocalDateTime.ofInstant(getDateTime().toInstant(), ZoneId.systemDefault());
		return StringUtils.join(new String[] {ldt.format(DATETIME_FORMAT),
											  String.valueOf(getValue()), 
											  String.valueOf(getError()), 
											  String.valueOf(getFilteredValue()), 
											  String.valueOf(getFilteredError()) }, 
								delim);
	}
}
