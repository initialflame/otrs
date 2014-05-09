package de.ffn.otrs.client;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility for converting java data types to xml-schema and back
 *
 * @author Gregor Tudan
 */
class XSDTypeConverter {

	private static final Logger LOG = LoggerFactory.getLogger(XSDTypeConverter.class);

	/**
	 * Returns the xsd simple Type for the given Object
	 * Only supports simple types!
	 * <br/>
	 * defaults to xsd:string
	 *
	 * @param obj object to get type for
	 * @return xsd:simple type
	 */
	static String simpleTypeForObject(Object obj) {
		if (obj instanceof String) {
			return "xsd:string";
		} else if (obj instanceof Long) {
			return "xsd:long";
		} else if (obj instanceof Integer) {
			return "xsd:integer";
		} else if (obj instanceof Boolean) {
			return "xsd:boolean";
		} else if (obj instanceof Date) {
			return "xsd:date";
		} else if (obj instanceof Float) {
			return "xsd:float";
		} else {
			return "xsd:string";
		}
	}

	/**
	 * Given a string and an xsd-Type, this will convert the string back to a java object
	 *
	 * @param obj     the string to convert
	 * @param xsdType the xsd-type
	 * @return java object matching the given type
	 */
	static Object convertXSDToObject(String obj, String xsdType) {
		xsdType = xsdType.toLowerCase();
		
		if("xsd:string".equals(xsdType)) {
			return obj;
		} else if("xsd:long".equals(xsdType)) {
			return Long.valueOf(obj);
		} else if("xsd:integer".equals(xsdType)) {
			return Integer.valueOf(obj);
		} else if("xsd:int".equals(xsdType)) {
			return Integer.valueOf(obj);
		} else if("xsd:float".equals(xsdType)) {
			return Float.valueOf(obj);
		} else if("xsd:boolean".equals(xsdType)) {
			return Boolean.valueOf(obj);
		} else if("xsd:decimal".equals(xsdType)) {
			return Long.valueOf(obj);
		} else if("xsd:date".equals(xsdType)) {
			try {
				return new SimpleDateFormat("yyyy-MM-dd").parse(obj);
			} catch (ParseException e) {
				LOG.error("Failed to parse date: {}", obj, e);
			}
		} else if("xsd:base64binary".equals(xsdType)) {
			return new String(Base64.decodeBase64(obj.getBytes()), StandardCharsets.UTF_8);
		} else {
			return obj;//Cannot convert
		}
		return obj;
	}
}