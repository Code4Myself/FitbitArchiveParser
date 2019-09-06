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
public class TestFitbit {

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
				System.out.println(rate);
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
			for(Step step:steps) {
				System.out.println(step);
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
	@DisplayName("testSleep")
	public void testSleep() throws Exception {
		File inputFile = new File( Sleep.class.getClassLoader().getResources("sleep-test.json").nextElement().getFile() );

		long t0 = System.currentTimeMillis();
		try {
			// parse JSON data ////////////////////////////
			ObjectMapper jsonMapper = new ObjectMapper();
			Sleep[]      sleeps     = jsonMapper.readValue(inputFile, Sleep[].class);
			
			// export results /////////////////////////////
			Arrays.parallelSort(sleeps);
			for(Sleep sleep:sleeps) {
				System.out.println(sleep);
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
			for(Calorie calorie:calories) {
				System.out.println(calorie);
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
			for(Distance distance:distances) {
				System.out.println(distance);
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
}
