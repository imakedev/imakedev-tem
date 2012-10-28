package th.co.imake.tem.application.resource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.ParserConfigurationException;

import org.restlet.data.MediaType;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ServerResource;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import th.co.imake.tem.dto.ResultMessage;

public abstract class BaseResource extends ServerResource {
	
	protected static final String DATE_FORMAT = "yyyy-MM-dd";
	protected String HOST = "";
	protected String PATH_REF = "";

 

	public Representation export( ResultMessage resultMessage,
			com.thoughtworks.xstream.XStream xstream) {

		 
		JsonRepresentation representation = null;

		javax.xml.parsers.DocumentBuilderFactory dbf = javax.xml.parsers.DocumentBuilderFactory
				.newInstance();
		dbf.setNamespaceAware(true);
		javax.xml.parsers.DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	/*	xstream
				.processAnnotations(ResultDTO.class);// or
		xstream
		.processAnnotations(VResultMessage.class);*/
																					// xstream.autodetectAnnotations(true);
																					// (Auto-detect
																					// Annotations)
	//	xstream.autodetectAnnotations(true);
		String xml = xstream.toXML(resultMessage);
		Document document = null;
		InputStream in = null;
		try {
			in = new ByteArrayInputStream(xml.getBytes("UTF-8"));
			document = db.parse(in);
		} catch (UnsupportedEncodingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

//		document.normalizeDocument();
//		try {
			representation = new JsonRepresentation(resultMessage);
			// MediaType.TEXT_XML);
//					MediaType.APPLICATION_ATOM_XML);
//		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		representation.setDocument(document);
		//getResponse().setEntity(representation);
		return representation;
	}

	 
}
