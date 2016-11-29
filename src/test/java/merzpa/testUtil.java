package merzpa;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class testUtil{
	
	Util ut;
	
	@Before
	public void erzeugeUtil(){
		ut = new Util();
	}
	
	@Test
	public void testIstErstesHalbjahr() {
		final int eingabe = 7;
		assertTrue("blabla", ut.istErstesHalbjahr(eingabe));
	}
}
