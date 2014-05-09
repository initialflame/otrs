package de.ffn.otrs.client.objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Attachment>
       <Content>cid:61886944659</Content>
       <ContentType>?</ContentType>
       <Filename>?</Filename>
    </Attachment>
 * 
 * @author sk0007
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Article")
public class Attachment {
	
	@XmlElement(name="Content", nillable=false)
	private byte[] content;
	
	@XmlElement(name="ContentType", nillable=false)
	private String contentType;
	
	@XmlElement(name="Filename", nillable=false)
	private String filename;

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
}
