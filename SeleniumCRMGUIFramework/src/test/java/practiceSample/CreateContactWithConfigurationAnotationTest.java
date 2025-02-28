package practiceSample;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateContactWithConfigurationAnotationTest {
	
	
	
		
		@BeforeMethod
		public void configBM() {
			System.out.println("execute BM");
		}
		
		@Test
		public void createContact() {
			System.out.println("execute createContactWithData");
			
		}
		
		@AfterMethod
		public void configAM() {
			System.out.println("execute AM");
		}
		@AfterClass
		public void configAC() {
			System.out.println("execute AC");
		}
	}


