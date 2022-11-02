package com.jio.eva.constants;

import com.jio.eva.utils.ReadPropertyFile;

public final class FrameworkConstants {

	/**
	 * variables should be declared final if not to be changes
	 * variables should be private if not be accessed/shared outside class
	 * use getter method to access variables
	 * final keyword to class.. so no one case extend this class
	 * to not create object of this class .. so created private constructor
	 */

	private FrameworkConstants()
	{
	}

	private static final String RESOURCESPATH = System.getProperty("user.dir")+"/src/test/resources";
	private static final String CONFIGFILEPATH = RESOURCESPATH + "/config/config.properties";

	private static final int PAGELOADTIMEOUT = 20;
	private static final int IMPLICITWAIT = 10;
	private static final int EXPLICITWAIT = 10; 

	private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir")+"/extent-test-output/";
	private static String extentReportFilePath="";


	public static String getExtentReportFilePath() {
		if(extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}

	private static String createReportPath() {
		if(ReadPropertyFile.get("overridereports").equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH + System.currentTimeMillis()+"/index.html";
		}
		else {
			return EXTENTREPORTFOLDERPATH + "/index.html";
		}
	}


	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}


	public static int getIMPLICITWAIT() {
		return IMPLICITWAIT;
	}


	public static int getPAGELOADTIMEOUT() {
		return PAGELOADTIMEOUT;
	}


	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}

}
