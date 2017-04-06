package net.chengqiao.utils;

import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XmlUtils {
	@SuppressWarnings("unchecked")
	public static <T> T xmlToBean(Class<T> bean,File file){
		T s = null;
		try{
			JAXBContext context = JAXBContext.newInstance(bean);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			s = (T)unmarshaller.unmarshal(file);
		}catch(Exception e){
			e.printStackTrace();
		}
		return s;
	}
	
	public static <T> String beanToXml(T bean){
		String xmlStr = null;
		StringWriter writer = null;
		try{
			JAXBContext context = JAXBContext.newInstance(bean.getClass());
			Marshaller marshaller = context.createMarshaller();
			writer = new StringWriter();
			marshaller.marshal(bean, writer);
			xmlStr = writer.toString();
		}catch(Exception e){
			e.printStackTrace();
		}		
		return xmlStr;
	}
	public static <T> void beanToXml(String fileName,T bean){
		try{
			File file = new File(fileName);
			JAXBContext context = JAXBContext.newInstance(bean.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(bean,file);
			marshaller.marshal(bean, System.out);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
