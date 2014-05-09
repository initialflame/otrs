package de.ffn.otrs.client.objects;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * <DynamicField>
       <Name>?</Name>
       <!--1 or more repetitions:-->
       <Value>?</Value>
    </DynamicField>
 * 
 * @author sk0007
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="DynamicField")
public class DynamicField {
	
	
	@XmlElement(name="Name", nillable=true)
	private String name;
	
	@XmlElement(name="Value", nillable=true)
	private List<String> value;

	
	
	public DynamicField() {
		super();
	}

	public DynamicField(String nodename, String nodeValue) {
		this.name = nodename;
		addValue(nodeValue);
	}

	private void addValue(String nodeValue) {
		if(value == null)
			value = new ArrayList<String>();
		if(nodeValue != null)
			value.add(nodeValue);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getValue() {
		return value;
	}

	public void setValue(List<String> value) {
		this.value = value;
	}

}
