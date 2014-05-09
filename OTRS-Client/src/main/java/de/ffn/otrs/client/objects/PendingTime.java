package de.ffn.otrs.client.objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 *  <PendingTime>
          <Year>?</Year>
          <Month>?</Month>
          <Day>?</Day>
          <Hour>?</Hour>
          <Minute>?</Minute>
       </PendingTime>
 * 
 * @author sk0007
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="PendingTime")
public class PendingTime {
	
	@XmlElement(name="Year", nillable=true)
	private Integer year;
	
	@XmlElement(name="Month", nillable=true)
	private Integer month;
	
	@XmlElement(name="Day", nillable=true)
	private Integer day;
	
	@XmlElement(name="Hour", nillable=true)
	private Integer hour;
	
	@XmlElement(name="Minute", nillable=true)
	private Integer minute;

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getHour() {
		return hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}

	public Integer getMinute() {
		return minute;
	}

	public void setMinute(Integer minute) {
		this.minute = minute;
	}
	
}
