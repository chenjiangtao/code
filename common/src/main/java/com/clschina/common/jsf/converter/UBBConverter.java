package com.clschina.common.jsf.converter;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.clschina.common.util.CommonUtil;
import com.clschina.common.util.UBBDecoder;

 


public class UBBConverter implements Converter {

	private final static Log log = LogFactory.getLog(UBBConverter.class);

	public Object getAsObject(FacesContext context, UIComponent component, String s)
			throws ConverterException {
		log.trace("getAsObject, String is " + s);
		return s;
	}

	public String getAsString(FacesContext context, UIComponent component, Object obj)
			throws ConverterException {
		if(obj == null){
			log.trace("getAsString object is null");
			return null;
		}
		String orignal = obj.toString();
		if(orignal == null){
			orignal = "";
		}
		orignal = CommonUtil.htmlEncode(orignal);
		String html = UBBDecoder.decode(orignal);
		if(component instanceof HtmlOutputText){
			log.trace("component is instanceof HtmlOutputText, set escape to false.");
			((HtmlOutputText) component).setEscape(false);
		}else{
			log.debug("component is " + component.getClass().getName());
		}
		
		return CommonUtil.replace(html, "\n", "<br>");
	}
}
