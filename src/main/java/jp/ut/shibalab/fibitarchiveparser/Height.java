package jp.ut.shibalab.fibitarchiveparser;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class for Height
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Height extends ATimeValue {	
	/* ==============================================================
	 * instance fields
	 * ============================================================== */
	/** Height value */
	private int _height;
	

	/* ==============================================================
	 * constructors
	 * ============================================================== */
	/**
	 * initialization 
	 * @param dateTime date time string (MM/dd/yy HH:mm:ss)
	 * @param value Height count
	 */
	@JsonCreator
	protected Height(@JsonProperty("dateTime") String dateTime,
				     @JsonProperty("value")    int    value)
	{
		super(dateTime);
		_height = value;
	}
	
	
	/* ==============================================================
	 * instance methods
	 * ============================================================== */
	/**
	 * get Height value (mm) 
	 * @return Height value (mm)
	 */
	public int getHeight() {
		return _height;
	}
	
	@Override
	public String toString() {
		return String.format("(%s, %d)",getDateTime(), _height);
	}
}
