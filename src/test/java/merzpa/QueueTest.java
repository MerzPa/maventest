package merzpa;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class QueueTest{
	
	Queue qu;
	
	@Before
	public void erzeugeQueue(){
		qu=new Queue(3);
	}
	@Test
	public void testQueue(){
		try{
			Queue qq = new Queue(0);
			fail("Exception nicht geworfen");
		}catch(IllegalArgumentException e){
			
		}
	}
	
	@Test
	public void testEnqueue(){
		qu.enqueue(1);
		qu.enqueue(2);
		qu.enqueue(3);
		qu.enqueue(4);
		assertTrue(qu.queue[2]==4);
	}
	
	@Test
	public void testDequeue(){
		try{
			qu.dequeue();
			fail("Erwartete exception nicht geworfen");
			
		}catch(IllegalStateException e){
			
		}
	}
	@Test
	public void testDeque2(){
		qu.enqueue(1);
		qu.enqueue(2);
		assertTrue(qu.dequeue()==1);
	}
	
	
}
