package edu.umd.fcmd.analysis.data.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.umd.fcmd.analysis.data.Option;

public class OptionTest {
	private String name = "name";
	private String value = "value";
	private Option opt;
	private Option opt2;
	private Option opt3;
	private Option opt4;
	private HashSet<Option> set;
	private List<Option> list;
	@Before
	public void setUp() throws Exception
	{
		 opt = new Option(name,value); 
		 opt2 = new Option(name,value);
		 opt3 = new Option("name2","value2");
		 set = new HashSet<Option>();
		 list = new ArrayList<Option>();
		 set.add(opt);
		 set.add(opt3);
		 list.add(opt);
		 list.add(opt3);
	}
	@After
	public void tearDwon() throws Exception
	{
		opt = null;
		opt2 = null;
		opt3 = null;
		set=null;
		list=null;
	}
	@Test
	public void testhashCode(){
	//Test same object return same hash code
	assertEquals(opt.hashCode(),opt.hashCode());
	// Test Equal object must have equal hash code
	assertEquals(opt.hashCode(),opt2.hashCode());
	//assetEquals();
	opt2.setName(null);
	opt2.setValue(null);
	assertNotEquals(opt.hashCode(),opt2.hashCode());
	Iterator it = set.iterator();
	assertEquals(it.next().hashCode(),opt.hashCode());
	assertEquals(it.next().hashCode(),opt3.hashCode());
	}
	@Test
	public void testEquals() throws Exception{
		//assertEquals(expected,actual)
		List<Option> options = new ArrayList<Option>();
		options.add(opt);
		if(name==null||value==null){
			throw new NullPointerException("name or value is null");
		}
		assertEquals(true,opt.equals(opt));
		assertEquals(true,opt.equals(opt2));
		assertEquals(false,opt.equals(opt3));
		assertEquals(false,opt.equals(null));
		opt2.setName(name+"A");
		opt2.setValue(name+"B");
		assertEquals(false,opt.equals(options));
	}
	@Test
	public void testGetName(){
		assertEquals(name,opt.getName());
	}
	@Test
	public void testGetValue(){
		assertEquals(value,opt.getValue());
	}
	@Test
	public void testSetName(){
		opt.setName("testname");
		assertEquals("testname",opt.getName());
	}
	@Test
	public void testSetValue(){
		opt.setValue("testvalue");
		assertEquals("testvalue",opt.getValue());
	}
	@Test
	public void testConstructor(){
		Option opt_l = new Option("test_name","test_value");
		assertEquals("test_name",opt_l.getName());
		assertEquals("test_value",opt_l.getValue());
	}
	@Test
	public void testcompareTo(){
		String name2 = "name2";
		String value2 = "value2";
		int x;
		opt2.setName(name2);
		opt2.setName(value2);
		x = opt.compareTo(opt2);
		assertEquals(true,x<0);
		assertEquals(0,opt.compareTo(opt));
		String name3 = "nam";
		String value3 = "valu";
		opt2.setName(name3);
		opt2.setValue(value3);
		x = opt.compareTo(opt2);
		assertEquals(true,x>0);
		//assertEquals(0,opt.compareTo(opt2));
		
	}
	@Test
	public void testtoString(){
		assertEquals(name+"="+value,opt.toString());
	}

}

