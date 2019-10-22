package com.xslt.spring.service;

import java.io.File;
import java.io.IOException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class XSLTservice {


	    public ModelAndView viewXSLT(String xmlFile,String contextPath ) throws IOException {
	        // builds absolute path of the XML file
	        String xmlFilePath = contextPath + File.separator + xmlFile;
	        Source source = new StreamSource(new File(xmlFilePath));
	        // adds the XML source file to the model so the XsltView can detect
	        ModelAndView model = new ModelAndView("XSLTView");
	        model.addObject("xmlSource", source);
	         
	        return model;
	    }
	
}
