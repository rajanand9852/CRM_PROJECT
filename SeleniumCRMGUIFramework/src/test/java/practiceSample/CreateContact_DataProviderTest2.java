package practiceSample;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DataProviderTest2 {
	public class CreateContact_DataProviderTest {
		@Test(dataProvider = "getData")
		public void createContactTest(String firstName,String lastName,long phoneNumber) {
			System.out.println("FirstName:"+firstName+", LastName:" + lastName +",PhoneNumber:"+phoneNumber);
			
		}
		@DataProvider
		public Object[][] getData(){
			Object[][] objArr=new Object[3][3];
			objArr[0][0]="deepak";
			objArr[0][1]="hr";
			objArr[0][2]=9852530376l;
			
			objArr[1][0]="sam";
			objArr[1][1]="raj";
			objArr[1][2]=9852530376l;
			
			objArr[2][0]="Zishan";
			objArr[2][1]="rahul";
			objArr[2][2]=9852530376l;
			return objArr;
		}


}
}
