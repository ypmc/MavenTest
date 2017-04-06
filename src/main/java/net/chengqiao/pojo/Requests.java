package net.chengqiao.pojo;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "root")
public class Requests {
	private ArrayList<Request> requests;


	public void addRequest(Request request){
		if(requests == null){
			requests = new ArrayList<Request>();
		}
		requests.add(request);
	}


	public ArrayList<Request> getRequests() {
		return requests;
	}

	@XmlElementWrapper(name="requests")
	@XmlElement(name="request")
	public void setRequests(ArrayList<Request> requests) {
		this.requests = requests;
	}
	
}
