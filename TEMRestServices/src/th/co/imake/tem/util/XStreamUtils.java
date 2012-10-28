package th.co.imake.tem.util;

import th.co.imake.tem.dto.BaseDTO;
import th.co.imake.tem.dto.ResultDTO;
import th.co.imake.tem.dto.ResultMessage;
import th.co.imake.tem.dto.TemCallDetailRecord;
import th.co.imake.tem.dto.TemCompany;
import th.co.imake.tem.dto.TemMsIsdn;
import th.co.imake.tem.dto.TemMsIsdnPackageDetail;
import th.co.imake.tem.dto.TemPackageDetail;
import th.co.imake.tem.dto.TemPackageType;
import th.co.imake.tem.dto.TemProvider;
import th.co.imake.tem.dto.TemSpecialList;
import th.co.imake.tem.dto.TemType;

import com.thoughtworks.xstream.XStream;

@SuppressWarnings("rawtypes")
public class XStreamUtils {
	private static com.thoughtworks.xstream.XStream xstream =  new XStream(new com.thoughtworks.xstream.io.xml.Dom4JDriver());

	static{
		Class[] classes = new Class[13];
		classes[0] = ResultDTO.class;
		classes[1] = ResultMessage.class;
		classes[2] = BaseDTO.class;
		classes[3] = TemPackageDetail.class;
		classes[4] = TemPackageType.class;
		classes[5] = TemProvider.class;
		classes[6] = TemSpecialList.class;
		classes[7] = TemType.class;
		classes[8] = TemCallDetailRecord.class;
		classes[9] = TemCompany.class;
		classes[10] = TemMsIsdn.class;
		classes[11] = TemMsIsdnPackageDetail.class;
		classes[12] = Paging.class;
		xstream.processAnnotations(classes);
	} 
	public static com.thoughtworks.xstream.XStream getXstream() {
		return xstream;
	}
}
