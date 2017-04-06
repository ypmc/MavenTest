package net.chengqiao.pojo;

import javax.xml.bind.annotation.XmlElement;

public class Result {
	private String response;
	private String url;
	private String status;

	public String getResponse() {
		return response;
	}

	@XmlElement
	public void setResponse(String response) {
		this.response = response;
	}

	public String getUrl() {
		return url;
	}

	@XmlElement
	public void setUrl(String url) {
		this.url = url;
	}

	public String getStatus() {
		return status;
	}

	@XmlElement
	public void setStatus(String status) {
		this.status = status;
	}

	public String toString() {
		return "status = " + status + ",url = " + url + ",response = " + response;
	}
}
