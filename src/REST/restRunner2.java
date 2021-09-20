package REST;
import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.iface.Submit.Status;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.support.SoapUIException;



public class restRunner2 {

	@Test
	public void ApiTest2() throws IOException, SoapUIException, XmlException 
	{
		// TODO Auto-generated method stub
		
		
		WsdlProject project =new WsdlProject("C:\\Users\\M1070888\\Documents\\Employee.xml");
		for(int j=0;j<project.getTestSuiteCount();j++) {
			WsdlTestSuite testsuite=project.getTestSuiteAt(j);
			for(int i=0;i<testsuite.getTestCaseCount();i++) {
				
				WsdlTestCase testCase =testsuite.getTestCaseAt(i);
				TestRunner runner=testCase.run(new PropertiesMap(), false);
				System.out.println(runner.getStatus());
				Assert.assertEquals(String.valueOf(Status.FINISHED),String.valueOf(runner.getStatus()));
				
			}
		}
		
		

	}

}
