package practiceSample;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.generic.Fileutility.BaseClass;
//@Listeners(com.comcast.crm.listenerutility.listenerImplementationClass.class)
public class InvoiceTest extends BaseClass{
	
	@Test
	public void CreateInvoiceTest() {
		System.out.println("execute createinvoiceTest");
		String actTitle=driver.getTitle();
		AssertJUnit.assertEquals(actTitle, "Login");
		
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		
	}
	@Test
	public void createInvoiceWithContactTest() {
		System.out.println("execute createInvoicewithContactTest");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
	}

}
