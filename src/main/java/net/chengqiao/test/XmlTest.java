package net.chengqiao.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;

import net.chengqiao.pojo.Request;
import net.chengqiao.pojo.Requests;
import net.chengqiao.pojo.Result;
import net.chengqiao.pojo.Results;
import net.chengqiao.utils.HttpUtils;
import net.chengqiao.utils.XmlUtils;

public class XmlTest {

	private static Logger logger = Logger.getLogger(XmlTest.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logger.debug("Main Entry");
		try{
			String fileName = "request.xml";
			String outFileName = "result.xml";
			File file = new File(fileName);
			Requests requests = XmlUtils.xmlToBean(Requests.class, file);
			ArrayList<Request> reqlist = new ArrayList<Request>();
			ArrayList<Result> rlist = new ArrayList<Result>();
			reqlist = requests.getRequests();
			Iterator<Request> iter = reqlist.iterator();
			
			Results results = new Results();
			while(iter.hasNext()){
				Request request = iter.next();
				logger.debug(request);
				Result result = HttpUtils.isValid(request.getUrl(), request.getCookie(), request.getEncoding());
				rlist.add(result);
				logger.debug(result);
			}
			results.setResults(rlist);
			XmlUtils.beanToXml(outFileName,results);
		}catch(Exception e){
			e.printStackTrace();
		}
		logger.debug("Main End");
	}

}
