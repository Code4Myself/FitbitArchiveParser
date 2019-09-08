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
		System.out.printf("time duration: %.03f (sec)\n", (t1-t0)/1000d);
	}
	
	
	/** weight parser Test */
	@Test
	@DisplayName("testWeight")
	public void testWeight() throws Exception {
		File inputFile = new File( Weight.class.getClassLoader().getResources("weight-test.json").nextElement().getFile() );

		long t0 = System.currentTimeMillis();
		try {
			// parse JSON data ////////////////////////////
			ObjectMapper  jsonMapper = new ObjectMapper();
			Weight[]      weights    = jsonMapper.readValue(inputFile, Weight[].class);
			
			// export results /////////////////////////////
			Arrays.parallelSort(weights);
			for(Weight weight:weights) {
				System.out.println(weight);
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

	
	/** exercise parser Test */
	@Test
	@DisplayName("testExercise")
	public void testExercise() throws Exception {
		File inputFile = new File( Exercise.class.getClassLoader().getResources("exercise-test.json").nextElement().getFile() );

		long t0 = System.currentTimeMillis();
		try {
			// parse JSON data ////////////////////////////
			ObjectMapper  jsonMapper = new ObjectMapper();
			Exercise[]    exercises  = jsonMapper.readValue(inputFile, Exercise[].class);
			
			// export results /////////////////////////////
			Arrays.parallelSort(exercises);
			for(Exercise exercise:exercises) {
				System.out.println(exercise);
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
	

	/** badge parser Test */
	@Test
	@DisplayName("testBadge")
	public void testBadge() throws Exception {
		File inputFile = new File( Badge.class.getClassLoader().getResources("badge-test.json").nextElement().getFile() );

		long t0 = System.currentTimeMillis();
		try {
			// parse JSON data ////////////////////////////
			ObjectMapper jsonMapper = new ObjectMapper();
			Badge[]      badges     = jsonMapper.readValue(inputFile, Badge[].class);
			
			// export results /////////////////////////////
			Arrays.parallelSort(badges);
			for(Badge badge:badges) {
				System.out.println(badge);
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
