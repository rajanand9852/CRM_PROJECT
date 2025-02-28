package practiceSample;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.comcast.crm.generic.Fileutility.BaseClass;

public class InvoiceTestRetryAnalyzer extends BaseClass{
	@Test(retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerImp.class)
	public void CreateInvoiceTest() {
		System.out.println("execute createinvoiceTest");
		String actTitle=driver.getTitle();
		AssertJUnit.assertEquals(actTitle, "Login");
		
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");

}
}
