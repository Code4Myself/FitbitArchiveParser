package jp.ut.shibalab.fibitarchiveparser;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class for Sleep
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Sleep implements Comparable<Sleep>, ICsv {
	/* ==============================================================
	 * static methods
	 * ============================================================== */
	/**
	 * get CSV header
	 * @return csv header line
	 */
	public static String getCsvHeader() { 
		return getCsvHeader("\t");
	}
	
	/**
	 * get CSV header 	
	 * @param delim delimiter 
	 * @return csv header line
	 */
	public static String getCsvHeader(String delim) { 
		String[] tokens = new String[] {
			"logId",
			"date", 
			"start_time",
			"end_time",
			"duration",
			"timeToFallAsleep",
			"timeAsleep",
			"timeAwake",
			"timeAfterWakeup",
			"timeInBed",
			"efficiency",
			"type",
			"infoCode",
			"summary",
			"data"
		};
		return StringUtils.join(tokens,delim);
	}
	
	/* ==============================================================
	 * instance fields
	 * ============================================================== */
	/** log ID */
	private Long _logId;
	
	/** date of sleep */
	private String _dateOfSleep;
	
	/** start Time */
	private Date _startTime;
	
	/** end time */
	private Date _endTime;
	
	/** duration(msec) */
	private Long _duration;
	
	/** time to fall asleep (minute) */
	private Integer _toFallAsleep;
	
	/** time of asleep (minute) */
	private Integer _asleep;

	/** time of awake (minute) */
	private Integer _awake;
	
	/** time after wakeup (minute) */
	private Integer _afterWakeup;
	
	/** time in bed (minute?) */
	private Integer _timeInBed;
	
	/** efficiency (?) */
	private Integer _efficiency;
	
	/** type(?) */
	private String _type;
	
	/** info code(?) */
	private Integer _infoCode;
	
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
	private  Sleep(@JsonProperty("logId")               Long    logid,
			       @JsonProperty("dateOfSleep")         String  dateOfSleep,
				   @JsonProperty("startTime")           String  startTime,
				   @JsonProperty("endTime")             String  endTime,
				   @JsonProperty("duration")            Long    duration, 
				   @JsonProperty("minutesToFallAsleep") Integer toFallAsleep,
				   @JsonProperty("minutesAsleep")       Integer asleep,
				   @JsonProperty("minutesAwake")        Integer awake,
				   @JsonProperty("minutesAfterWakeup")  Integer afterWakeup,
				   @JsonProperty("timeInBed")           Integer timeInBed,
				   @JsonProperty("efficiency")          Integer efficiency,
				   @JsonProperty("type")                String  type,
				   @JsonProperty("infoCode")            Integer infoCode,
				   @JsonProperty("levels")              Levels  levels )
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
							.append("\tminutesAwale="       ).append(getTimeAwake()       ).append("\n")
							.append("\tminutesAfterWakeup=" ).append(getTimeAfterWakeup() ).append("\n")
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
	public String toCsvString() {
		return toCsvString("\t");
	}
	
	@Override
	public String toCsvString(String delim) { 
		LocalDateTime ldtST= LocalDateTime.ofInstant(getStartTime().toInstant(), ZoneId.systemDefault());
		LocalDateTime ldtED= LocalDateTime.ofInstant(getEndTime().toInstant(),   ZoneId.systemDefault());
//		ldt.format(DATETIME_FORMAT);
		
		String[] tokens = new String[] {
			_logId        != null ? String.valueOf( _logId ) : EMPTY, 
			_dateOfSleep  != null ? _dateOfSleep             : EMPTY, 
			ldtST.format(ICsv.DATETIME_FORMAT), 
			ldtED.format(ICsv.DATETIME_FORMAT), 
			_duration     != null ? String.valueOf( _duration ) : EMPTY, 
			_toFallAsleep != null ? String.valueOf( _toFallAsleep ) : EMPTY, 
			_asleep       != null ? String.valueOf( _asleep )       : EMPTY, 
			_awake        != null ? String.valueOf( _awake )        : EMPTY, 
			_afterWakeup  != null ? String.valueOf( _afterWakeup )  : EMPTY, 
			_timeInBed    != null ? String.valueOf( _timeInBed )    : EMPTY, 
			_efficiency   != null ? String.valueOf( _efficiency )   : EMPTY, 
			_type         != null ? _type                           : EMPTY, 
			_infoCode     != null ? String.valueOf( _infoCode )     : EMPTY, 
			getSummary()  != null ? getSummary().toCsvString()      : EMPTY,
			getData()     != null ? StringUtils.join(getData(),";") : EMPTY
		};
		
		return StringUtils.join(tokens,delim);
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
	public static class Summary implements ICsv {
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
		
		@Override
		public String toCsvString() {
			return toCsvString(";");
		}
		
		@Override
		public String toCsvString(String delim) { 
			String[] tokens = new String[] {
				getRestless() != null ? getRestless().toCsvString() : EMPTY, 
				getAwake() != null    ? getAwake().toCsvString()    : EMPTY, 
				getAsleep() != null   ? getAsleep().toCsvString()   : EMPTY
			};
			
			return StringUtils.join(tokens, delim);
		}
	}
	
	
	/** class for summary entity. restless/awake/asleep */
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class SummaryEntity implements ICsv {
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
		
		@Override
		public String toCsvString() {
			return toCsvString("|");
		}
		
		@Override
		public String toCsvString(String delim) { 
			return String.format("%d%s%d",_count,delim,_minutes);
		}
	}
	
	
	/** Sleep data class */
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Data implements Comparable<Data>, ICsv {
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
		public String toCsvString() {
			return toCsvString("|");
		}
		
		@Override
		public String toCsvString(String delim) { 
			LocalDateTime ldt= LocalDateTime.ofInstant(_dateTime.toInstant(), ZoneId.systemDefault());
			
			return String.format("%s%s%s%s%d",ldt.format(DATETIME_FORMAT),delim,_level,delim,_seconds);
		}
		
		@Override
		public String toString() {
			return toCsvString();
//			return String.format("(%s, %s, %d)",_dateTime, _level, _seconds);
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
