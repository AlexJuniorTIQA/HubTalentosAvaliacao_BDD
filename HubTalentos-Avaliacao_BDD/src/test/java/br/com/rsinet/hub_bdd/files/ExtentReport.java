//package br.com.rsinet.hub_bdd.files;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//
//public class ExtentReport {
//
//	ExtentReports extensao;
//	ExtentTest logger;
//
//	public void getReport(String nameReport) {
//
//		//ExtentHtmlReporter reporte = new ExtentHtmlReporter("./Reports/" + nameReport + ".html");
//
//	    
//
//		ExtentHtmlReporter reporte = new ExtentHtmlReporter("./Reports/cadastroCliente.html");
//		extensao = new ExtentReports();
//
//		extensao.attachReporter(reporte);
//
//		logger = extensao.createTest(nameReport);
//		
//		extensao.flush();
//
//	}
//
//}
