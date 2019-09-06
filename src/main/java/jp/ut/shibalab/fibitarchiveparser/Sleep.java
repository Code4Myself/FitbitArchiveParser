package jp.ut.shibalab.fibitarchiveparser;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class for Sleep
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Sleep implements Comparable<Sleep> {
	/* ==============================================================
	 * instance fields
	 * ============================================================== */
	/** log ID */
	private long _logId;
	
	/** date of sleep */
	private String _dateOfSleep;
	
	/** start Time */
	private Date _startTime;
	
	/** end time */
	private Date _endTime;
	
	/** duration(msec) */
	private long _duration;
	
	/** time to fall asleep (minute) */
	private int _toFallAsleep;
	
	/** time of asleep (minute) */
	private int _asleep;

	/** time of awake (minute) */
	private int _awake;
	
	/** time after wakeup (minute) */
	private int _afterWakeup;
	
	/** time in bed (minute?) */
	private int _timeInBed;
	
	/** efficiency (?) */
	private int _efficiency;
	
	/** type(?) */
	private String _type;
	
	/** info code(?) */
	private int _infoCode;
	
	/** levels */
	private Levels _levels;
	
	
	/* ==============================================================
	 * constructors
	 * ============================================================== */
	/**
	 * initialization 
	 * @param logid log id
	 * @param dateOfSleep date of sleep
	 * @param startTime start time string
	 * @param endTime end time string 
	 * @param duration duration 
	 * @param toFallAsleep time to fall asleep
	 * @param asleep asleep time
	 * @param awake awake time 
	 * @param afterWakeup time after wake-up
	 * @param timeInBed time in bed
	 * @param efficiency efficiency
	 * @param type type
	 * @param infoCode info code
	 * @param levels levels
	 */
	@JsonCreator
	private  Sleep(@JsonProperty("logId")               long   logid,
			       @JsonProperty("dateOfSleep")         String dateOfSleep,
				   @JsonProperty("startTime")           String startTime,
				   @JsonProperty("endTime")             String endTime,
				   @JsonProperty("duration")            long   duration, 
				   @JsonProperty("minutesToFallAsleep") int    toFallAsleep,
				   @JsonProperty("minutesAsleep")       int    asleep,
				   @JsonProperty("minutesAwake")        int    awake,
				   @JsonProperty("minutesAfterWakeup")  int    afterWakeup,
				   @JsonProperty("timeInBed")           int    timeInBed,
				   @JsonProperty("efficiency")          int    efficiency,
				   @JsonProperty("type")                String type,
				   @JsonProperty("infoCode")            int    infoCode,
				   @JsonProperty("levels")              Levels levels )
	{
		_logId       = logid;
		_dateOfSleep = dateOfSleep;
		
		DateTimeFormatter datetimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
		LocalDateTime     sldt = LocalDateTime.parse(startTime, datetimeFormatter);
		LocalDateTime     eldt = LocalDateTime.parse(endTime,   datetimeFormatter);
		_startTime    = Date.from( sldt.atZone(ZoneId.systemDefault()).toInstant() );
		_endTime      = Date.from( eldt.atZone(ZoneId.systemDefault()).toInstant() );

		_duration     = duration;
		_toFallAsleep = toFallAsleep;
		_asleep       = asleep;
		_awake        = awake;
		_afterWakeup  = afterWakeup;
		_timeInBed    = timeInBed;
		_efficiency   = efficiency;
		_type         = type;
		_infoCode     = infoCode;
		_levels       = levels;
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
	 * get date of sleep
	 * @return date of sleep
	 */
	public String getDate() {
		return _dateOfSleep;
	}
	
	/**
	 * get start time 
	 * @return start time
	 */
	public Date getStartTime() {
		return _startTime;
	}
	
	/**
	 * get end time 
	 * @return end time 
	 */
	public Date getEndTime() {
		return _endTime;
	}
	
	/**
	 * get duration (msec)
	 * @return duration
	 */
	public long getDuration() {
		return _duration;
	}
	
	/**
	 * get time to fall asleep (minutes)
	 * @return time to fall asleep
	 */
	public int getTimeToFallAsleep() {
		return _toFallAsleep;
	}
	
	/*+
	 * get time Asleep (minutes)
	 * @return asleep
	 */
	public int getTimeAsleep() {
		return _asleep;
	}
	
	/**
	 * get time awake(minutes)
	 * @return awake 
	 */
	public int getTimeAwake() {
		return _awake;
	}
	
	/**
	 * get time after wakeup(minutes)
	 * @return time after wake up
	 */
	public int getTimeAfterWakeup() {
		return _afterWakeup;
	}
	
	/**
	 * get time in bed
	 * @return time in bed(minutes)
	 */
	public int getTimeInBed() {
		return _timeInBed;
	}
	
	/**
	 * get efficiency
	 * @return efficiency
	 */
	public int getEfficiency() {
		return _efficiency;
	}
	
	/**
	 * get type 
	 * @return type(?)
	 */
	public String getType() {
		return _type;
	}
	
	/**
	 * get infoCode
	 * @return infoCode (?)
	 */
	public int getInfoCode() {
		return _infoCode;
	}
	
	/**
	 * get summary 
	 * @return summary 
	 */
	public Summary getSummary() {
		return _levels._summary;
	}
	
	/**
	 * get data
	 * @return data
	 */
	public Data[] getData() {
		return _levels._data;
	}
	
	@Override
	public String toString() {
		String str = new StringBuffer(getClass().getName()).append("\n")
							.append("\tlogid="              ).append(getLogId()           ).append("\n")
							.append("\tdateOfSleep="        ).append(getDate()            ).append("\n")
							.append("\tstartTime="          ).append(getStartTime()       ).append("\n")
							.append("\tendTime="            ).append(getEndTime()         ).append("\n")
							.append("\tduration="           ).append(getDuration()        ).append("\n")
							.append("\tminutesToFallAsleep=").append(getTimeToFallAsleep()).append("\n")
							.append("\tminutesAsleep="      ).append(getTimeAsleep()      ).append("\n")
							.append("\tminutesAwale="       ).append(getTimeToFallAsleep()).append("\n")
							.append("\tminutesAfterWakeup=" ).append(getTimeAsleep()      ).append("\n")
							.append("\ttimeInBed="          ).append(getTimeInBed()       ).append("\n")
							.append("\tefficiency="         ).append(getEfficiency()      ).append("\n")
							.append("\ttype="               ).append(getType()            ).append("\n")
							.append("\tinfoCode="           ).append(getInfoCode()        ).append("\n")
							.append("\tSummary="            ).append(getSummary()         ).append("\n")
							.append("\tData="               ).append(getData()            ).append("\n")
							.toString();
		
		return str;
	}
	
	@Override
	public int compareTo(Sleep obj) {
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
	/** class for Sleep level */
	@JsonIgnoreProperties(ignoreUnknown=true)
	private static class Levels {
		/** summary */
		@JsonProperty("summary")
		private Summary _summary;
		
		/* data */
		@JsonProperty("data")
		private Data[]  _data;
	}
	
	/** class for Sleep Summary */
	@JsonIgnoreProperties(ignoreUnknown=true)
	public static class Summary {
		/** restless summary */
		@JsonProperty("restless")
		private SummaryEntity _restless;
		
		/** awake summary */
		@JsonProperty("awake")
		private SummaryEntity _awake;
		
		/** asleep summary */
		@JsonProperty("asleep")
		private SummaryEntity _asleep;
		
		/**
		 * get restless summary 
		 * @return restless summary 
		 */
		public SummaryEntity getRestless() {
			return _restless;
		}
		
		/**
		 * get awake summary 
		 * @return awake summary 
		 */
		public SummaryEntity getAwake() {
			return _awake;
		}
		
		/**
		 * get asleep summary 
		 * @return asleep summary 
		 */
		public SummaryEntity getAsleep() {
			return _asleep;
		}
		
		@Override
		public String toString() {
			return String.format("(restless=%s, awake=%s, asleep=%s)", getRestless(), getAwake(), getAsleep());
		}
	}
	
	
	/** class for summary entity. restless/awake/asleep */
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class SummaryEntity {
		/** count */
		@JsonProperty("count")
		private int _count;
		
		/** minutes */
		@JsonProperty("minutes")
		private int _minutes;
		
		
		/**
		 * get count 
		 * @return count
		 */
		public int getCount() {
			return _count;
		}
		
		/**
		 * get minutes
		 * @return minutes
		 */
		public int getMinutes() {
			return _minutes;
		}
		
		@Override
		public String toString() {
			return String.format("(%d, %d)", _count, _minutes);
		}
	}
	
	
	/** Sleep data class */
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Data implements Comparable<Data> {
		/** date time value */
		private Date   _dateTime;

		/** level */
		private String _level;
		
		/** duration seconds */
		private int   _seconds;
		
		/**
		 * initialization 
		 * @param dateTime date time string ("yyyy-MM-dd'T'HH:mm:ss.SSS")
		 * @param level level string 
		 * @param seconds seconds
		 */
		@JsonCreator
		private Data(@JsonProperty("dateTime") String dateTime, 
					 @JsonProperty("level")    String level, 
					 @JsonProperty("seconds")  int    seconds) 
		{
			LocalDateTime ldt = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS"));
			_dateTime   =  Date.from( ldt.atZone(ZoneId.systemDefault()).toInstant() );
			_level      = level;
			_seconds    = seconds;
		}
		
		/**
		 * get date time 
		 * @return date time
		 */
		public Date getDateTime() {
			return _dateTime;
		}
		
		/**
		 * get level string 
		 * @return level string
		 */
		public String getLevel() {
			return _level;
		}
		
		/**
		 * get seconds
		 * @return seconds
		 */
		public int getSeconds() {
			return _seconds;
		}
		
		@Override
		public String toString() {
			return String.format("(%s, %s, %d)",_dateTime, _level, _seconds);
		}
		
		@Override
		public int compareTo(Data obj) {
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
}
