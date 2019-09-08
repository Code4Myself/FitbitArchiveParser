package jp.ut.shibalab.fibitarchiveparser;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class for Exercise data
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Exercise implements Comparable<Exercise> {
	/* ==============================================================
	 * instance fields
	 * ============================================================== */
	/** log ID */
	private long _logId;

	/** activity name */
	private String _activityName;
	
	/** activity type Id */
	private int    _activityTypeId;
	
	/** activity level list */
	private ActivityLevel[] _activityLevels;
	
	/** average heart rate */
	private int    _averageHeartRate;
	
	/** calories */
	private int    _calories;
	
	/** duration */
	private int    _duration;
	
	/** active duration */
	private int    _activeDuration;
	
	/** steps */
	private int    _steps;
	
	/** log type */
	private String _logType;
	
	/** manual value flags */
	private ManualValuesSpecified _manualValues;
	
	/** heart rate zone list */
	private HeartRateZone[] _heartRateZones;
	 
	/** last modified time stamp */
	private Date   _lastModified;
	
	/** start time */
	private Date   _startTime;
	
	/** original start time */
	private Date   _originalStartTime;
	
	/** original duration (msec) */
	private int    _originalDuration;
	
	/** elevation gain (m) */
	private double _elevationGain;
	
	/** has GPS */
	private boolean _hasGps;
	
	/** should fetch details */
	private boolean _shouldFetchDetails;
	

	/* ==============================================================
	 * instance methods
	 * ============================================================== */
	/**
	 * initialization 
	 * @param logId log id
	 * @param activityName activity name
	 * @param activityTypeId activity type Id
	 * @param activityLevels activity levels
	 * @param averageHeartRate average heart rate
	 * @param calories calories
	 * @param duration duration
	 * @param activeDuration active duration
	 * @param steps steps 
	 * @param logType log type
	 * @param manualValues manual values
	 * @param heartRateZones heart rate zones
	 * @param lastModified last modified (MM/dd/yy HH:mm:ss)
	 * @param startTime start time (MM/dd/yy HH:mm:ss)
	 * @param originalStartTime original start time (MM/dd/yy HH:mm:ss)
	 * @param originalDuration original duration (msec)
	 * @param elevationGain elevation gain (m?)
	 * @param hasGps has GPS data
	 * @param shouldFetchDetails should fetch detail
	 */
	@JsonCreator
	private Exercise(@JsonProperty("logId")                 long                  logId, 
					 @JsonProperty("activityName")          String                activityName,
					 @JsonProperty("activityTypeId")        int                   activityTypeId, 
					 @JsonProperty("activityLevel")         ActivityLevel[]       activityLevels, 
					 @JsonProperty("averageHeartRate")      int                   averageHeartRate,
					 @JsonProperty("calories")              int                   calories,
					 @JsonProperty("duration")              int                   duration, 
					 @JsonProperty("activieDuration")       int                   activeDuration,
					 @JsonProperty("steps")                 int                   steps, 
					 @JsonProperty("logType")               String                logType, 
					 @JsonProperty("manualValuesSpecified") ManualValuesSpecified manualValues, 
					 @JsonProperty("heartRateZones")        HeartRateZone[]       heartRateZones, 
					 @JsonProperty("lastModified")          String                lastModified, 
					 @JsonProperty("startTime")             String                startTime, 
					 @JsonProperty("originalStartTime")     String                originalStartTime, 
					 @JsonProperty("originalDuration")      int                   originalDuration, 
					 @JsonProperty("elevationGain")         double                elevationGain, 
					 @JsonProperty("hasGps")                boolean               hasGps, 
					 @JsonProperty("shouldFetchDetails")    boolean               shouldFetchDetails )
	{
		_logId            = logId;
		_activityName     = activityName;
		_activityTypeId   = activityTypeId;
		_activityLevels   = activityLevels;
		_averageHeartRate = averageHeartRate;
		_calories         = calories;
		_duration         = duration;
		_activeDuration   = activeDuration;
		_steps            = steps;
		_logType          = logType;
		_manualValues     = manualValues;
		_heartRateZones   = heartRateZones;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy HH:mm:ss");
		_lastModified       = Date.from( LocalDateTime.parse(lastModified,      formatter).atZone(ZoneId.systemDefault()).toInstant() );
		_startTime          = Date.from( LocalDateTime.parse(startTime,         formatter).atZone(ZoneId.systemDefault()).toInstant() );
		_originalStartTime  = Date.from( LocalDateTime.parse(originalStartTime, formatter).atZone(ZoneId.systemDefault()).toInstant() );
		
		_originalDuration   = originalDuration;
		_elevationGain      = elevationGain;
		_hasGps             = hasGps;
		_shouldFetchDetails = shouldFetchDetails;
	}
	
	
	/* ==============================================================
	 * instance methods
	 * ============================================================== */
	/**
	 * get log Id
	 * @return log Id
	 */
	public long getLogId() {
		return _logId;
	}
	
	/**
	 * get activity name
	 * @return activity name
	 */
	public String getActivityName() {
		return _activityName;
	}
	
	/**
	 * get activity type ID
	 * @return activity type ID
	 */
	public int getActivityTypeId() {
		return _activityTypeId;
	}
	
	/**
	 * get activity levels
	 * @return activity levels
	 */
	public ActivityLevel[] getActivityLevels() {
		return _activityLevels;
	}
	
	/**
	 * get average heart rate (bpm)
	 * @return average heart rate (bpm)
	 */
	public int getAverageHeartRate() {
		return _averageHeartRate;
	}
	
	/**
	 * get calories(kcal)
	 * @return calories(kcal)
	 */
	public int getCalories() {
		return _calories;
	}
	
	/**
	 * get duration (msec)
	 * @return duration (msec)
	 */
	public int getDuration() {
		return _duration;
	}
	
	/**
	 * get active duration (msec)
	 * @return active duration (msec)
	 */
	public int getActiveDuration() {
		return _activeDuration;
	}
	
	/**
	 * get steps
	 * @return steps
	 */
	public int getSteps() {
		return _steps;
	}
	
	/**
	 * get log type (auto_detected/...)
	 * @return log type
	 */
	public String getLogType() {
		return _logType;
	}
	
	/**
	 * check if 'calories' is manually specified value
	 * @return result
	 */	
	public boolean hasManualValueOfCalories() {
		return _manualValues != null ? _manualValues.hasManualValueOfCalories() : false;
	}
	
	/**
	 * check if 'distance' is manually specified value
	 * @return result
	 */
	public boolean hasManualValueOfDistance() {
		return _manualValues != null ? _manualValues.hasManualValueOfDistance() : false;
	}
	
	/**
	 * check if 'steps' is manually specified value
	 * @return result
	 */
	public boolean hasManualValueOfSteps() {
		return _manualValues != null ? _manualValues.hasManualValueOfSteps() : false;
	}
	
	/**
	 * get heart rate zones
	 * @return heart rate zones
	 */
	public HeartRateZone[] getHeartRateZones() {
		return _heartRateZones;
	}
	
	/**
	 * get last modified
	 * @return last modified
	 */
	public Date getLastModified() {
		return _lastModified;
	}
	
	/**
	 * get start time 
	 * @return start time
	 */
	public Date getStartTime() {
		return _startTime;
	}
	
	/**
	 * get original start time
	 * @return original start time
	 */
	public Date getOriginalStartTime() {
		return _originalStartTime;
	}
	
	/**
	 * get original duration (msec) 
	 * @return original duration
	 */
	public int getOriginalDuration() {
		return _originalDuration;
	}
	
	/**
	 * get elevation gain (m?)
	 * @return elevation gain
	 */
	public double getElevationGain() {
		return _elevationGain;
	}
	
	/**
	 * check if this data has GPS
	 * @return result
	 */
	public boolean hasGps() {
		return _hasGps;
	}
	
	/**
	 * check if this data should fetch details
	 * @return result
	 */
	public boolean shouldFetchDetails() {
		return _shouldFetchDetails;
	}
	
	@Override
	public String toString() {
		String str = new StringBuffer(getClass().getName()).append("\n")
						.append("\tlogid="                ).append(getLogId()            ).append("\n")
						.append("\tactivityName="         ).append(getActivityName()     ).append("\n")
						.append("\tactivityTypeId="       ).append(getActivityTypeId()   ).append("\n")
						.append("\tactivityLevel="        ).append(getActivityLevels()   ).append("\n")
						.append("\taverageHeartRate="     ).append(getAverageHeartRate() ).append("\n")
						.append("\tcalories="             ).append(getCalories()         ).append("\n")
						.append("\tduration="             ).append(getDuration()         ).append("\n")
						.append("\tactiveDuration="       ).append(getActiveDuration()   ).append("\n")
						.append("\tsteps="                ).append(getSteps()            ).append("\n")
						.append("\tlogType="              ).append(getLogType()          ).append("\n")
						.append("\tmanualValuesSpecified=").append(_manualValues         ).append("\n")
						.append("\theartRateZone="        ).append(getHeartRateZones()   ).append("\n")
						.append("\tlastModified="         ).append(getLastModified()     ).append("\n")
						.append("\tstartTime="            ).append(getStartTime()        ).append("\n")
						.append("\toriginalStartTime="    ).append(getOriginalStartTime()).append("\n")
						.append("\toriginalDuration="     ).append(getOriginalDuration() ).append("\n")
						.append("\televationGain="        ).append(getElevationGain()    ).append("\n")
						.append("\thasGps="               ).append(hasGps()              ).append("\n")
						.append("\tshouldFetchDetails="   ).append(shouldFetchDetails()  ).append("\n")
						.toString();
		
		return str;
	}
	
	@Override
	public int compareTo(Exercise obj) {
		if( obj == null ) { 
    		return 1;
    	}
    	if( obj.getStartTime() == null ) {
    		return 1;
    	}
    	if( this == obj ) {
    		return 0;
    	}
    	if( getStartTime() == null ) {
    		return -1;
    	}
    	
    	return getStartTime().compareTo(obj.getStartTime());
	}
	
	
	/* ==============================================================
	 * static inner class
	 * ============================================================== */
	/** class for activity level */
	@JsonIgnoreProperties(ignoreUnknown=true)	
	private static class ActivityLevel {
		/** minutes */
		@JsonProperty("minutes")
		private int _minutes;
		
		/** activity level name */
		@JsonProperty("name")
		private String _name;

		
		/**
		 * get minutes
		 * @return minutes
		 */
		public int getMinutes() {
			return _minutes;
		}
		
		/**
		 * get activity level name (very/fairly/lightly/sedentary) 
		 * @return activity name
		 */
		public String getName() {
			return _name;
		}
		
		@Override
		public String toString() {
			return String.format("(%d, %s)", getMinutes(), getName());
		}
	}
	
	/** class for manual specified flag */
	@JsonIgnoreProperties(ignoreUnknown=true)
	private static class ManualValuesSpecified { 
		/** flag of manual specified: calories */
		@JsonProperty("calories")
		private boolean _calories;
		
		/** flag of manual specified: distance */
		@JsonProperty("distance")
		private boolean _distance;
		
		/** flag of manual specified: step */
		@JsonProperty("steps")
		private boolean _steps;
		
		
		/**
		 * check if 'calories' is manually specified value
		 * @return result
		 */
		public boolean hasManualValueOfCalories() {
			return _calories;
		}
		
		/**
		 * check if 'distance' is manually specified value
		 * @return result
		 */
		public boolean hasManualValueOfDistance() {
			return _distance;
		}
		
		/**
		 * check if 'steps' is manually specified value
		 * @return result
		 */
		public boolean hasManualValueOfSteps() {
			return _steps;
		}
		
		@Override
		public String toString() {
			return String.format("(%b, %b, %b)", hasManualValueOfCalories(), hasManualValueOfDistance(), hasManualValueOfSteps());
		}
	}
	
	
	/** class for Heart Rate Zone */
	@JsonIgnoreProperties(ignoreUnknown=true)
	private static class HeartRateZone {
		/** name */
		@JsonProperty("name")
		private String _name;
		
		/** minimum */
		@JsonProperty("min")
		private int    _min;
		
		/** max */
		@JsonProperty("max")
		private int    _max;
		
		/** minutes */
		@JsonProperty("minutes")
		private int    _minutes;
		
		
		/**
		 * get name
		 * @return name
		 */
		public String getName() {
			return _name;
		}
		
		/**
		 * get minimum value
		 * @return minimum value
		 */
		public int getMin() {
			return _min;
		}
		
		/**
		 * get max value
		 * @return max value
		 */
		public int getMax() { 
			return _max;
		}
		
		/**
		 * get minutes(duration?)
		 * @return minutes
		 */
		public int getMinutes() { 
			return _minutes;
		}
		
		@Override
		public String toString() { 
			return String.format("(%s, %d, %d, %d)", getName(), getMin(), getMax(), getMinutes());
		}
	}
}
