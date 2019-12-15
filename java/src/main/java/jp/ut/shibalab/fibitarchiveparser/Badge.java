package jp.ut.shibalab.fibitarchiveparser;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class for Badge data
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Badge implements Comparable<Badge>, ICsv {	
	/* ==============================================================
	 * instance fields
	 * ============================================================== */
	/** encoded ID */
	private String _encodedId;

	/** badge Type */
	private String _badgeType;
	
	/** value */
	private int    _value;
	
	/** times achieved */
	private int    _timesAchieved;
	
	/** dateTime(but date only) */
	private String _dateTime;
	
	/** name */
	private String _name;
	
	/** short name */
	private String _shortName;
	
	/** earned message */
	private String _earnedMessage;
	
	/** description */
	private String _description;

	/** category */
	private String _category;
	
	/** share text */
	private String _shareText;
	
	
	/* ==============================================================
	 * constructors
	 * ============================================================== */

	@JsonCreator
	protected Badge(@JsonProperty("encodedId")      String encodedId,
			        @JsonProperty("badgeType")      String badgeType, 
			        @JsonProperty("value")          int    value,
			        @JsonProperty("timeAchieved")   int    timesAchieved, 
			        @JsonProperty("dateTime")       String dateTime,
			        @JsonProperty("name")           String name,
			        @JsonProperty("shortName")      String shortName,
			        @JsonProperty("earnedMessage")  String earnedMessage, 
			        @JsonProperty("description")    String description,
			        @JsonProperty("category")       String category, 
			        @JsonProperty("shareText")      String shareText )
	{
		_encodedId     = encodedId;
		_badgeType     = badgeType;
		_value         = value;
		_timesAchieved = timesAchieved;
		_dateTime      = dateTime;
		_name          = name;
		_shortName     = shortName;
		_earnedMessage = earnedMessage;
		_description   = description;
		_category      = category;
		_shareText     = shareText;
	}
	
	
	/* ==============================================================
	 * instance methods
	 * ============================================================== */
	/**
	 * get encoded ID
	 * @return encoded ID
	 */
	public String getEncodedId() {
		return _encodedId;
	}
	
	/**
	 * get badge Type
	 * @return badge type
	 */
	public String getBadgeType() {
		return _badgeType;
	}
	
	/**
	 * get value
	 * @return value 
	 */
	public int getValue() {
		return _value;
	}
	
	/**
	 * get times achieved
	 * @return times achieved
	 */
	public int getTimesAchieved () {
		return _timesAchieved;
	}
	
	/**
	 * get date time
	 * @return date time
	 */
	public String getDateTime() {
		return _dateTime;
	}
	
	/**
	 * get name
	 * @return name
	 */
	public String getName() {
		return _name;
	}
	
	/**
	 * get short name
	 * @return short name
	 */
	public String getShortName() {
		return _shortName;
	}
	
	/**
	 * get earned message
	 * @return earned message
	 */
	public String getEarnedMessage() {
		return _earnedMessage;
	}
	
	/**
	 * get description 
	 * @return description 
	 */
	public String getDescription() {
		return _description;
	}
	
	/**
	 * get category 
	 * @return category 
	 */
	public String getCategory() {
		return _category;
	}
	
	/**
	 * get share text
	 * @return share text
	 */
	public String getShareText() {
		return _shareText;
	}
	
	@Override
	public String toString() {
		return String.format("(%s, %s, %d, %d, %s, %s, %s, %s, %s, %s, %s)", 
							getEncodedId(),   getBadgeType(), getValue(),     getTimesAchieved(), 
							getDateTime(),    getName(),      getShortName(), getEarnedMessage(), 
							getDescription(), getCategory(),  getShareText()  );
	}
	
	@Override
	public int compareTo(Badge obj) {
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
	
	@Override
	public String toCsvString(String delim) {
		return StringUtils.join(new String[] {getEncodedId(),
											  getBadgeType(), 
											  String.valueOf(getValue()), 
											  String.valueOf(getTimesAchieved()), 
											  getDateTime(), 
											  getName(), 
											  getShortName(), 
											  getEarnedMessage(), 
											  getDescription(), 
											  getCategory(), 
											  getShareText()  }, 
								delim);
	}
}
