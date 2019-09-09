package jp.ut.shibalab.fibitarchiveparser;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class for Heart rate object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HeartRate extends ATimeValue {
	/* ==============================================================
	 * static inner class
	 * ============================================================== */
	/** Heart Rate value */
	@JsonIgnoreProperties(ignoreUnknown = true)
	private static class Value {
		/** BPM value */
		@JsonProperty("bpm")
		private int _bpm;

		/** confidence */
		@JsonProperty("confidence")
		private int _confidence;
	}
	
	
	/* ==============================================================
	 * instance fields
	 * ============================================================== */
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
		super(dateTime);
		
		_bpm        = value._bpm;
		_confidence = value._confidence;
	}
	
	
	/* ==============================================================
	 * instance methods
	 * ============================================================== */	
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
		return String.format("(%s, %d, %d)", getDateTime(), _bpm, _confidence);
	}
	
	@Override
	public String toCsvString(String delim) {
		LocalDateTime ldt = LocalDateTime.ofInstant(getDateTime().toInstant(), ZoneId.systemDefault());
		return StringUtils.join(new String[] {ldt.format(DATETIME_FORMAT), 
											  String.valueOf(getBpm()), 
											  String.valueOf(getConfidence())}, 
								delim);
	}

}
