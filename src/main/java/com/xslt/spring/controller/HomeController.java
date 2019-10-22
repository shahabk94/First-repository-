package com.xslt.spring.controller;
 
import java.io.File;
import java.io.IOException;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xslt.spring.service.XSLTservice;
 
@Controller
public class HomeController {
 
    @RequestMapping(value="/",method = RequestMethod.GET)
    public ModelAndView goHome(HttpServletResponse response) throws IOException{
        return new ModelAndView("home");
   }
	@Autowired
	XSLTservice xslt;
     
    @RequestMapping(value="/viewXSLT")
    public ModelAndView viewXSLT(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        // builds absolute path of the XML file
        String xmlFile = "resources/feed1.xml";
        String contextPath = request.getServletContext().getRealPath(""); 
        return xslt.viewXSLT(xmlFile, contextPath);
    }
}