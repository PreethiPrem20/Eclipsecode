package coreJava;

import org.testng.annotations.Test;

public class PS1 extends PS {
@Test
	public void testRun()
	{int a=3;
		// TODO Auto-generated method stub
	PS2 ps=new PS2(3);//Parameterized constructor
	doThis();
	System.out.println(ps.increment());
	System.out.println(ps.decrement());
	//PS3 ps1=new PS3(3);
	System.out.println(ps.multiplyThree());
	}

}
