package AutomationFramework;

import org.testng.annotations.Test;

public class TestNGPrioritizing 
{
  @Test
  public void atest1() 
  {
   System.out.println("test1");
  }
  
  @Test 
  public void ctest4()
  {
	  System.out.println("test4");
  }
  
  @Test
  public void dtest3()
  {
	  System.out.println("test3");
  }
  
  @Test 
  public void btest2()
  {
	  System.out.println("test2");
	  
  }
}
