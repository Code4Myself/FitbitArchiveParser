package jp.ut.shibalab.fibitarchiveparser;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * class for test
 */
public class TestFitbitTimeValue {

	/** HeartRate parser Test */
	@Test
	@DisplayName("testHeartRate")
	public void testHeartRate() throws Exception {
		File inputFile = new File( HeartRate.class.getClassLoader().getResources("heart_rate-test.json").nextElement().getFile() );

		long t0 = System.currentTimeMillis();
		try {
			// parse JSON data ////////////////////////////
			ObjectMapper    jsonMapper = new ObjectMapper();
			HeartRate[]     rates      = jsonMapper.readValue(inputFile, HeartRate[].class);
			
			// export results /////////////////////////////
			Arrays.parallelSort(rates);
			for(HeartRate rate:rates) {
				System.out.println(rate.toCsvString());
			}
		}
		catch(JsonMappingException|JsonParseException exp) {
			exp.printStackTrace();
		}
		catch(IOException exp) { 
			exp.printStackTrace();
		}
		long t1 = System.currentTimeMillis();
		System.out.printf("time duration: %.03f (sec) ", (t1-t0)/1000d);
	}
	
	/** steps parser Test */
	@Test
	@DisplayName("testStep")
	public void testStep() throws Exception {
		File inputFile = new File( Step.class.getClassLoader().getResources("steps-test.json").nextElement().getFile() );

		long t0 = System.currentTimeMillis();
		try {
			// parse JSON data ////////////////////////////
			ObjectMapper    jsonMapper = new ObjectMapper();
			Step[]     steps      = jsonMapper.readValue(inputFile, Step[].class);
			
			// export results /////////////////////////////
			Arrays.parallelSort(steps);
			System.out.println("(Step)");
			for(Step step:steps) {
				System.out.println(step.toCsvString());
			}
		}
		catch(JsonMappingException|JsonParseException exp) {
			exp.printStackTrace();
		}
		catch(IOException exp) { 
			exp.printStackTrace();
		}
		long t1 = System.currentTimeMillis();
		System.out.printf("time duration: %.03f (sec) \n", (t1-t0)/1000d);
	}
	
	
	/** calories parser Test */
	@Test
	@DisplayName("testCalorie")
	public void testCalorie() throws Exception {
		File inputFile = new File( Calorie.class.getClassLoader().getResources("calories-test.json").nextElement().getFile() );

		long t0 = System.currentTimeMillis();
		try {
			// parse JSON data ////////////////////////////
			ObjectMapper  jsonMapper = new ObjectMapper();
			Calorie[]     calories   = jsonMapper.readValue(inputFile, Calorie[].class);
			
			// export results /////////////////////////////
			Arrays.parallelSort(calories);
			System.out.println("(Calories)");
			for(Calorie calorie:calories) {
				System.out.println(calorie.toCsvString());
			}
		}
		catch(JsonMappingException|JsonParseException exp) {
			exp.printStackTrace();
		}
		catch(IOException exp) { 
			exp.printStackTrace();
		}
		long t1 = System.currentTimeMillis();
		System.out.printf("time duration: %.03f (sec)\n", (t1-t0)/1000d);
	}
	
	
	/** distance parser Test */
	@Test
	@DisplayName("testDistance")
	public void testDistance() throws Exception {
		File inputFile = new File( Distance.class.getClassLoader().getResources("distance-test.json").nextElement().getFile() );

		long t0 = System.currentTimeMillis();
		try {
			// parse JSON data ////////////////////////////
			ObjectMapper  jsonMapper = new ObjectMapper();
			Distance[]    distances  = jsonMapper.readValue(inputFile, Distance[].class);
			
			// export results /////////////////////////////
			Arrays.parallelSort(distances);
			System.out.println("(Distance)");
			for(Distance distance:distances) {
				System.out.println(distance.toCsvString());
			}
		}
		catch(JsonMappingException|JsonParseException exp) {
			exp.printStackTrace();
		}
		catch(IOException exp) { 
			exp.printStackTrace();
		}
		long t1 = System.currentTimeMillis();
		System.out.printf("time duration: %.03f (sec)\n", (t1-t0)/1000d);
	}
	
	
	/** altitude parser Test */
	@Test
	@DisplayName("tesAtltitude")
	public void testAltitude() throws Exception {
		File inputFile = new File( Altitude.class.getClassLoader().getResources("altitude-test.json").nextElement().getFile() );

		long t0 = System.currentTimeMillis();
		try {
			// parse JSON data ////////////////////////////
			ObjectMapper  jsonMapper = new ObjectMapper();
			Altitude[]    altitudes  = jsonMapper.readValue(inputFile, Altitude[].class);
			
			// export results /////////////////////////////
			Arrays.parallelSort(altitudes);
			System.out.println("(Altitude)");
			for(Altitude altitude:altitudes) {
				System.out.println(altitude.toCsvString());
			}
		}
		catch(JsonMappingException|JsonParseException exp) {
			exp.printStackTrace();
		}
		catch(IOException exp) { 
			exp.printStackTrace();
		}
		long t1 = System.currentTimeMillis();
		System.out.printf("time duration: %.03f (sec)\n", (t1-t0)/1000d);
	}
	
	
	/** Height parser Test */
	@Test
	@DisplayName("testHeight")
	public void testHeight() throws Exception {
		File inputFile = new File( Height.class.getClassLoader().getResources("height-test.json").nextElement().getFile() );

		long t0 = System.currentTimeMillis();
		try {
			// parse JSON data ////////////////////////////
			ObjectMapper  jsonMapper = new ObjectMapper();
			Height[]      heights    = jsonMapper.readValue(inputFile, Height[].class);
			
			// export results /////////////////////////////
			Arrays.parallelSort(heights);
			System.out.println("(Height)");
			for(Height height:heights) {
				System.out.println(height.toCsvString());
			}
		}
		catch(JsonMappingException|JsonParseException exp) {
			exp.printStackTrace();
		}
		catch(IOException exp) { 
			exp.printStackTrace();
		}
		long t1 = System.currentTimeMillis();
		System.out.printf("time duration: %.03f (sec)\n", (t1-t0)/1000d);
	}
	
	
	/** LightlyActiveMinute parser Test */
	@Test
	@DisplayName("testLightlyActiveMinute")
	public void testLightlyActiveMinute() throws Exception {
		File inputFile = new File( LightlyActiveMinute.class.getClassLoader().getResources("lightly_active_minutes-test.json").nextElement().getFile() );

		long t0 = System.currentTimeMillis();
		try {
			// parse JSON data ////////////////////////////
			ObjectMapper           jsonMapper           = new ObjectMapper();
			LightlyActiveMinute[]  lightlyActiveMinutes = jsonMapper.readValue(inputFile, LightlyActiveMinute[].class);
			
			// export results /////////////////////////////
			Arrays.parallelSort(lightlyActiveMinutes);
			System.out.println("(LightlyActiveMinute)");
			for(LightlyActiveMinute lightlyActiveMinute:lightlyActiveMinutes) {
				System.out.println(lightlyActiveMinute.toCsvString());
			}
		}
		catch(JsonMappingException|JsonParseException exp) {
			exp.printStackTrace();
		}
		catch(IOException exp) { 
			exp.printStackTrace();
		}
		long t1 = System.currentTimeMillis();
		System.out.printf("time duration: %.03f (sec)\n", (t1-t0)/1000d);
	}
	

	/** ModeratelyActiveMinute parser Test */
	@Test
	@DisplayName("testModeratelyActiveMinute")
	public void testModeratelyActiveMinute() throws Exception {
		File inputFile = new File( ModeratelyActiveMinute.class.getClassLoader().getResources("moderately_active_minutes-test.json").nextElement().getFile() );

		long t0 = System.currentTimeMillis();
		try {
			// parse JSON data ////////////////////////////
			ObjectMapper             jsonMapper           = new ObjectMapper();
			ModeratelyActiveMinute[] moderatelyActiveMinutes = jsonMapper.readValue(inputFile, ModeratelyActiveMinute[].class);
			
			// export results /////////////////////////////
			Arrays.parallelSort(moderatelyActiveMinutes);
			System.out.println("(ModeratelyActiveMinute)");
			for(ModeratelyActiveMinute moderatelyActiveMinute:moderatelyActiveMinutes) {
				System.out.println(moderatelyActiveMinute.toCsvString());
			}
		}
		catch(JsonMappingException|JsonParseException exp) {
			exp.printStackTrace();
		}
		catch(IOException exp) { 
			exp.printStackTrace();
		}
		long t1 = System.currentTimeMillis();
		System.out.printf("time duration: %.03f (sec)\n", (t1-t0)/1000d);
	}


	/** VeryActiveMinute parser Test */
	@Test
	@DisplayName("testVeryActiveMinute")
	public void testVeryActiveMinute() throws Exception {
		File inputFile = new File( VeryActiveMinute.class.getClassLoader().getResources("very_active_minutes-test.json").nextElement().getFile() );

		long t0 = System.currentTimeMillis();
		try {
			// parse JSON data ////////////////////////////
			ObjectMapper       jsonMapper        = new ObjectMapper();
			VeryActiveMinute[] veryActiveMinutes = jsonMapper.readValue(inputFile, VeryActiveMinute[].class);
			
			// export results /////////////////////////////
			Arrays.parallelSort(veryActiveMinutes);
			System.out.println("(VeryActiveMinute)");
			for(VeryActiveMinute veryActiveMinute:veryActiveMinutes) {
				System.out.println(veryActiveMinute.toCsvString());
			}
		}
		catch(JsonMappingException|JsonParseException exp) {
			exp.printStackTrace();
		}
		catch(IOException exp) { 
			exp.printStackTrace();
		}
		long t1 = System.currentTimeMillis();
		System.out.printf("time duration: %.03f (sec)\n", (t1-t0)/1000d);
	}
	

	/** SedentaryMinute parser Test */
	@Test
	@DisplayName("testSedentaryMinute")
	public void testSedentaryMinute() throws Exception {
		File inputFile = new File( SedentaryMinute.class.getClassLoader().getResources("Sedentary_minutes-test.json").nextElement().getFile() );

		long t0 = System.currentTimeMillis();
		try {
			// parse JSON data ////////////////////////////
			ObjectMapper      jsonMapper       = new ObjectMapper();
			SedentaryMinute[] sedentaryMinutes = jsonMapper.readValue(inputFile, SedentaryMinute[].class);
			
			// export results /////////////////////////////
			Arrays.parallelSort(sedentaryMinutes);
			System.out.println("(SedentaryMinute)");
			for(SedentaryMinute sedentaryMinute:sedentaryMinutes) {
				System.out.println(sedentaryMinute.toCsvString());
			}
		}
		catch(JsonMappingException|JsonParseException exp) {
			exp.printStackTrace();
		}
		catch(IOException exp) { 
			exp.printStackTrace();
		}
		long t1 = System.currentTimeMillis();
		System.out.printf("time duration: %.03f (sec)\n", (t1-t0)/1000d);
	}
	
	
	/** RestingHeartRate parser Test */
	@Test
	@DisplayName("testRestingHeartRate")
	public void testRestingHeartRate() throws Exception {
		File inputFile = new File( RestingHeartRate.class.getClassLoader().getResources("resting_heart_rate-test.json").nextElement().getFile() );

		long t0 = System.currentTimeMillis();
		try {
			// parse JSON data ////////////////////////////
			ObjectMapper       jsonMapper        = new ObjectMapper();
			RestingHeartRate[] restingHeartRates = jsonMapper.readValue(inputFile, RestingHeartRate[].class);
			
			// export results /////////////////////////////
			Arrays.parallelSort(restingHeartRates);
			System.out.println("(RestingHeartRate)");
			for(RestingHeartRate restingHeartRate:restingHeartRates) {
				System.out.println(restingHeartRate.toCsvString());
			}
		}
		catch(JsonMappingException|JsonParseException exp) {
			exp.printStackTrace();
		}
		catch(IOException exp) { 
			exp.printStackTrace();
		}
		long t1 = System.currentTimeMillis();
		System.out.printf("time duration: %.03f (sec)\n", (t1-t0)/1000d);
	}	
	
	
	/** RestingHeartRate parser Test */
	@Test
	@DisplayName("testDemographicVo2Max")
	public void testDemographicVo2Max() throws Exception {
		File inputFile = new File( DemographicVo2Max.class.getClassLoader().getResources("demographic_vo2_max-test.json").nextElement().getFile() );

		long t0 = System.currentTimeMillis();
		try {
			// parse JSON data ////////////////////////////
			ObjectMapper        jsonMapper        = new ObjectMapper();
			DemographicVo2Max[] demographicVo2Maxs = jsonMapper.readValue(inputFile, DemographicVo2Max[].class);
			
			// export results /////////////////////////////
			Arrays.parallelSort(demographicVo2Maxs);
			System.out.println("(DemographicVo2Max)");
			for(DemographicVo2Max demographicVo2Max:demographicVo2Maxs) {
				System.out.println(demographicVo2Max.toCsvString());
			}
		}
		catch(JsonMappingException|JsonParseException exp) {
			exp.printStackTrace();
		}
		catch(IOException exp) { 
			exp.printStackTrace();
		}
		long t1 = System.currentTimeMillis();
		System.out.printf("time duration: %.03f (sec)\n", (t1-t0)/1000d);
	}
	

	/** TimeInHeartRateZone parser Test */
	@Test
	@DisplayName("testTimeInHeartRateZone")
	public void testTimeInHeartRateZone() throws Exception {
		File inputFile = new File( TimeInHeartRateZone.class.getClassLoader().getResources("time_in_heart_rate_zones-test.json").nextElement().getFile() );

		long t0 = System.currentTimeMillis();
		try {
			// parse JSON data ////////////////////////////
			ObjectMapper          jsonMapper        = new ObjectMapper();
			TimeInHeartRateZone[] timeInHeartRateZones = jsonMapper.readValue(inputFile, TimeInHeartRateZone[].class);
			
			// export results /////////////////////////////
			Arrays.parallelSort(timeInHeartRateZones);
			System.out.println("(TimeInHeartRateZone)");
			for(TimeInHeartRateZone timeInHeartRateZone:timeInHeartRateZones) {
				System.out.println(timeInHeartRateZone.toCsvString());
			}
		}
		catch(JsonMappingException|JsonParseException exp) {
			exp.printStackTrace();
		}
		catch(IOException exp) { 
			exp.printStackTrace();
		}
		long t1 = System.currentTimeMillis();
		System.out.printf("time duration: %.03f (sec)\n", (t1-t0)/1000d);
	}	
}
