package com.jio.eva.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.schemas.vmldrawing.XmlDocument;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.SuiteRunner;

import com.jio.eva.dataprovider.DataProviderWithExcel;

import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.config.XmlPathConfig;

public class MethodInterceptor implements IMethodInterceptor{

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

		List<IMethodInstance> result = new ArrayList<IMethodInstance>();
		
		try {
			List<Map<String, Object>> list = new DataProviderWithExcel().getRunnerData();
			List<String> iterationlist = new ArrayList<>();
		//	int priority = 0 - (list.size() - methods.size());
		
		/*	for (int i=0; i<list.size(); i++) {
				for(int j=0; j<methods.size();j++) {
					
					if(methods.get(j).getMethod().getMethodName().equals(list.get(i).get("testname"))) {
						
						if (!iterationlist.contains(list.get(i).get("testname").toString()))
						{
					//		priority++;
						//	iterationlist.clear();
						//}
						
							iterationlist.add(list.get(i).get("testname").toString());

							methods.get(i).getMethod().setPriority(i);
							methods.get(i).getMethod().setInterceptedPriority(i);
							priority++;
						}	
					//		System.out.println(methods.get(j).getMethod().getMethodName() + " || Priority: " + methods.get(i).getMethod().getPriority());
							
							System.out.println(methods.get(j).getMethod().getMethodName() +" || " + list.get(i).get("testname") +" || "  //+ priority + " || "
							//+ methods.get(j)
									);
							
							//priority++;

					//		methods.get(i).getMethod().setPriority(i);
					//		methods.get(i).getMethod().setInterceptedPriority(i);
							
							result.add(methods.get(j));
					break;
					}
				}
			}	*/
			

			// create local list and add test method name
			// check if it already present in list and compare with n-1
			
			System.out.println("getName: " + context.getName());
			System.out.println("getSuite: " + context.getCurrentXmlTest().getSuite().getName());

			for (int i=0; i<list.size(); i++) {
				for(int j=0; j<methods.size();j++) {
					
					if(list.get(i).get("testname").equals(methods.get(j).getMethod().getMethodName()) && list.get(i).get("Cycles").equals(context.getName())) {
			
				//		methods.get(j).getMethod().setPriority(i);
				//		methods.get(j).getMethod().grou(i);
						
							result.add(methods.get(j));
					//	}
					//	else {
					//		result.add(0, methods.get(j));
					//	}
						
						System.out.println(methods.get(j).getMethod().getMethodName() + " || Priority: " + methods.get(j).getMethod().getPriority() + " || " + methods.get(j));
							
					break;
					}
				}
				}
			
			/*
			for (IMethodInstance m : methods) {
			    Test test = m.getMethod().getConstructorOrMethod().getAnnotation(Test.class);
			    Set<String> groups = new HashSet<String>();
			    for (String group : test.groups()) {
			      groups.add(group);
			    }
			    if (groups.contains("fast")) {
			      result.add(0, m);
			    }
			    else {
			      result.add(m);
			    }
			  }
			  return result;

			*/
			
		} 
		catch (Exception e) {
			
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

}
