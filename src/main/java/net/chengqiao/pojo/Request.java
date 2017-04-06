package net.chengqiao.pojo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Request {
	private String url;
	private String cookie;
	private String encoding;
	private int id;
	public int getId() {
		return id;
	}
	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	@XmlElement
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCookie() {
		return cookie;
	}
	@XmlElement
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}
	public String getEncoding() {
		return encoding;
	}
	@XmlElement
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	
	public String toString(){
		return "id = "+id+",url = " + url+",cookie = " +cookie+",encoding = " + encoding;
	}
}
