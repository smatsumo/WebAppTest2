package edu.umd.fcmd.analysis.data.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.umd.fcmd.analysis.data.*;

public class ConfigurationTest {
	private Configuration options1;
	private Configuration options2;
	private Configuration options3;
	private Option opt1;
	private Option opt2;
	@Before
	public void setUp() throws Exception
	{
		// opt = new Option(this.name,this.value); 
		options1 = new Configuration();
		options2 = new Configuration();
		options3 = new Configuration();
		opt1 = new Option("name1","value1");
		opt2 = new Option("name2","value2");
		//options.addOptions(opt1);
		//options.getOptions();
		options1.addOption(opt1);
		options1.addOption(opt2);
		options2.addOption(opt1);
		options2.addOption(opt2);
		options3.addOption(opt1);
		options3.addOption(opt1);
	}
	@After
	public void tearDwon() throws Exception
	{
		options1 = null;
		options2 = null;
		options3 = null;
		//System.out.println(options2.toString());
	}
	
	@Test
	public void testEquals() {
		//assertEquals(expected,actual)
		//Check same object
		assertEquals(true,options1.equals(options1));
		//Check 2 object that has same option
		assertEquals(true,options1.equals(options2));
		//Check 2 object that does not have same option
		assertEquals(false,options1.equals(options3));
		// Need to check for type of object
	}

	@Test
	public void testhashCode(){
		//Check same object return same hash
		assertEquals(options1.hashCode(),options1.hashCode());
		//Check 2 objects contain same option has same hash
		assertEquals(options1.hashCode(),options2.hashCode());
	}
	@Test
	public void testcompareTo(){
		//options 4 contains [name1,value1],[name2,value2],[name1,value1]
		Configuration options4 = new Configuration();
		options4.addOption(opt1);
		options4.addOption(opt2);
		options4.addOption(opt1);
		assertEquals(0,options1.compareTo(options2));
		assertEquals(true,options1.compareTo(options4)>0);
		assertEquals(true,options4.compareTo(options1)<0);
	}
	@Test
	public void testgetOption(){
		ArrayList<Option> testarray= new ArrayList<Option>();
		testarray.add(opt1);
		testarray.add(opt2);
		assertEquals(testarray,options1.getOptions());
		testarray=null;
	}
	@Test
	public void testaddOption(){
		Option testopt = new Option ("name_add","value_add");
		options1.addOption(testopt);
		assertEquals(testopt,options1.getOptions().get(2));
	
	}
	@Test
	public void testsubsumes(){
		Configuration testsub = new Configuration();
		testsub.addOption(opt2);
		testsub.addOption(opt2);
		testsub.addOption(opt1);
		//System.out.println(options4.toString());
		//System.out.println(options1.toString());
		assertEquals(true,options1.subsumes(options2));
		assertEquals(true,testsub.subsumes(options1));
		assertEquals(false,options1.subsumes(testsub));
		testsub=null;
	}
	@Test
	public void testtoString(){
		
		String test = opt1.toString()+" "+opt2.toString();
		assertEquals(test,options1.toString());
		//System.out.println(it.toString());
		//it.next();
		//System.out.println(it.toString());
	}
}
