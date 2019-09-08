package jp.ut.shibalab.fibitarchiveparser;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class for `time in heart rate zone`
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeInHeartRateZone extends ATimeValue {
	/* ==============================================================
	 * static inner class
	 * ============================================================== */
	/* value */
	@JsonIgnoreProperties(ignoreUnknown = true)
	private static class Value {
		/** value */
		@JsonProperty("value")
		private ValuesInZones _value;
	}
	
	/* time value in heart rate zone */
	@JsonIgnoreProperties(ignoreUnknown = true)
	private static class ValuesInZones {
		/** IN_DEFAULT_ZONE_1 */
		@JsonProperty("IN_DEFAULT_ZONE_1")
		private double _inDefaultZone1;

		/** BELOW_DEFAULT_ZONE_1 */
		@JsonProperty("BELOW_DEFAULT_ZONE_1")
		private double _belowDefaultZone1;
		
		/** IN_DEFAULT_ZONE_2 */
		@JsonProperty("IN_DEFAULT_ZONE_2")
		private double _inDefaultZone2;
		
		/** IN_DEFAULT_ZONE_3 */
		@JsonProperty("IN_DEFAULT_ZONE_3")
		private double _inDefaultZone3;
	}
	
	
	/* ==============================================================
	 * instance fields
	 * ============================================================== */
	/** IN_DEFAULT_ZONE_1 */
	private double _inDefaultZone1;

	/** BELOW_DEFAULT_ZONE_1 */
	private double _belowDefaultZone1;
	
	/** IN_DEFAULT_ZONE_2 */
	private double _inDefaultZone2;
	
	/** IN_DEFAULT_ZONE_3 */
	private double _inDefaultZone3;
	
	
	/* ==============================================================
	 * constructors
	 * ============================================================== */
	/**
	 * initialization 
	 * @param dateTime date time string (MM/dd/yy HH:mm:ss)
	 * @param value time in heart rate zone value
	 */
	@JsonCreator
	protected TimeInHeartRateZone(@JsonProperty("dateTime") String dateTime,
					              @JsonProperty("value")    Value  value)
	{
		super(dateTime);
		
		_inDefaultZone1    = value._value._inDefaultZone1;
		_inDefaultZone2    = value._value._inDefaultZone2;
		_inDefaultZone3    = value._value._inDefaultZone3;
		_belowDefaultZone1 = value._value._belowDefaultZone1;
	}
	
	
	/* ==============================================================
	 * instance methods
	 * ============================================================== */
	/**
	 * get value in default zone 1 
	 * @return value in default zone 1
	 */
	public double getDefaultZone1() {
		return _inDefaultZone1;
	}
	
	/**
	 * get value in default zone 2
	 * @return value in default zone 2
	 */
	public double getDefaultZone2() {
		return _inDefaultZone2;
	}
	
	/**
	 * get value in default zone 3
	 * @return value in default zone 3
	 */
	public double getDefaultZone3() {
		return _inDefaultZone3;
	}
	
	/**
	 * get value before default zone 1
	 * @return value before default zone 1
	 */
	public double getBeforeDefaultZone1() {
		return _belowDefaultZone1;
	}
	
	@Override
	public String toString() {
		return String.format("(%s, %f, %f, %f, %f)",getDateTime(), getDefaultZone1(), getDefaultZone2(), getDefaultZone3(), getBeforeDefaultZone1()); 
	}
}
