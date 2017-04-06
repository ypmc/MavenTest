package net.chengqiao.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="root")
public class Results {
	private List<Result> results;

	public List<Result> getResults() {
		return results;
	}
	@XmlElementWrapper(name = "results")
	@XmlElement(name="result")
	public void setResults(List<Result> results) {
		this.results = results;
	}
}
