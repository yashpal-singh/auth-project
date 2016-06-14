/**
 * 
 */
package com.ig.ecommsolution.auth.controller;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yashpal.Singh
 *
 */
@RestController
@RequestMapping("/convert")
public class ConvertorController {

	@RequestMapping(value = "/json", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String convertToJSON(@RequestBody String str) {
		try {
			JSONObject xmlJSONObj = XML.toJSONObject(str);
			return xmlJSONObj.toString();
			// JSON objJson = new XMLSerializer().read(str);
			// return objJson.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

//	@RequestMapping(value = "/xml", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
//	public String convertToXML(@RequestBody String str) {
//		try {
//			JSONObject xmlJSONObj = XML.toJSONObject(str);
//			return xmlJSONObj.toString();
//			// String objXML = new
//			// XMLSerializer().write(JSONSerializer.toJSON(str));
//			// return objXML;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "";
//	}

}
