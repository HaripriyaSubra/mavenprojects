package com.maven.demo.MavenDemoProj;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
	App app = new App();

	
  @Test
  public void shouldAnswerWithTrue() {
    assertTrue(true);
  }
  @Test
    public void addTest() {
    	int result = app.add(5, 8);
    	assertEquals(result,13);
    	
    	
    
  }
}
