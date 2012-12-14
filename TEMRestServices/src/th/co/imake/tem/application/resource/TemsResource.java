package th.co.imake.tem.application.resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;

import th.co.imake.tem.constant.ServiceConstant;
import th.co.imake.tem.domain.TemCallDetailRecordPk;
import th.co.imake.tem.domain.TemMsIsdnPackageDetailPk;
import th.co.imake.tem.domain.TemSpecialListPk;
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
import th.co.imake.tem.service.TemService;
import th.co.imake.tem.util.XStreamUtils;

public class TemsResource extends BaseResource {

	private TemService temService;
	private com.thoughtworks.xstream.XStream xstream;

	public TemService getTemService() {
		return temService;
	}

	public void setTemService(TemService temService) {
		this.temService = temService;
	}

	public com.thoughtworks.xstream.XStream getXstream() {
		return xstream;
	}

	public void setXstream(com.thoughtworks.xstream.XStream xstream) {
		this.xstream = xstream;
	}

	@Get
	public org.restlet.representation.Representation represent()
			throws ResourceException {
		System.out
				.println("************************* TEM Resource Get *******************");
		ResultMessage resultMessage = new ResultMessage();
		resultMessage.setMaxRow("5");
		return export(resultMessage, XStreamUtils.getXstream());
	}

	@Post
	public org.restlet.representation.Representation acceptContact(
			org.restlet.representation.Representation entity)
			throws ResourceException {
		System.out
				.println("************************* TEM Resource Post *******************");

		InputStream in = null;
		ResultDTO resultDTO = null;
		String max_rows = "0";
		/*try {
			in = entity.getStream();
			BaseDTO baseDTO = null;
			Object baseObj = XStreamUtils.getXstream().fromXML(in);
			if (baseObj != null) {
				baseDTO = (BaseDTO) baseObj;
			}
			String serviceName = "";
			serviceName = baseDTO.getServiceName();
			System.out.println("serviceName=" + serviceName);
			if (ServiceConstant.TEM_CALL_DETAIL_RECORD_DELETE
					.equals(serviceName)) {
				TemCallDetailRecord temCallDetailRecordDTO = (TemCallDetailRecord)baseDTO;
				th.co.imake.tem.domain.TemCallDetailRecord temCallDetailRecord = new th.co.imake.tem.domain.TemCallDetailRecord();
//				temCallDetailRecord.setTcdrMsIsdnTo(temCallDetailRecordDTO.getTcdrMsIsdnTo());
				temCallDetailRecord.setTcdrUsedCount(temCallDetailRecordDTO.getTcdrUsedCount());
				
				TemCallDetailRecordPk temCallDetailRecordPk = new TemCallDetailRecordPk();
//				temCallDetailRecordPk.setTcdrMsIsdnFrom(temCallDetailRecordDTO.getTcdrMsIsdnFrom());
				temCallDetailRecordPk.setTcdrUsedTime(temCallDetailRecordDTO.getTcdrUsedTime());
				if(temCallDetailRecordDTO.getTemType() != null) {
					temCallDetailRecordPk.setTtId(temCallDetailRecordDTO.getTemType().getTtId());
				}
				temCallDetailRecord.setTemCallDetailRecordPk(temCallDetailRecordPk);
				temService.deleteTemCallDetailRecord(temCallDetailRecord);
			} else if (ServiceConstant.TEM_CALL_DETAIL_RECORD_SAVE
					.equals(serviceName)) {
				TemCallDetailRecord temCallDetailRecordDTO = (TemCallDetailRecord)baseDTO;
				th.co.imake.tem.domain.TemCallDetailRecord temCallDetailRecord = new th.co.imake.tem.domain.TemCallDetailRecord();
//				temCallDetailRecord.setTcdrMsIsdnTo(temCallDetailRecordDTO.getTcdrMsIsdnTo());
				temCallDetailRecord.setTcdrUsedCount(temCallDetailRecordDTO.getTcdrUsedCount());
				
				TemCallDetailRecordPk temCallDetailRecordPk = new TemCallDetailRecordPk();
//				temCallDetailRecordPk.setTcdrMsIsdnFrom(temCallDetailRecordDTO.getTcdrMsIsdnFrom());
				temCallDetailRecordPk.setTcdrUsedTime(temCallDetailRecordDTO.getTcdrUsedTime());
				if(temCallDetailRecordDTO.getTemType() != null) {
					temCallDetailRecordPk.setTtId(temCallDetailRecordDTO.getTemType().getTtId());
				}
				temCallDetailRecord.setTemCallDetailRecordPk(temCallDetailRecordPk);
				temService.insertTemCallDetailRecord(temCallDetailRecord);
			} else if (ServiceConstant.TEM_CALL_DETAIL_RECORD_SEARCH
					.equals(serviceName)) {
				TemCallDetailRecord temCallDetailRecordDTO = (TemCallDetailRecord)baseDTO;
				th.co.imake.tem.domain.TemCallDetailRecord temCallDetailRecord = new th.co.imake.tem.domain.TemCallDetailRecord();
//				temCallDetailRecord.setTcdrMsIsdnTo(temCallDetailRecordDTO.getTcdrMsIsdnTo());
				temCallDetailRecord.setTcdrUsedCount(temCallDetailRecordDTO.getTcdrUsedCount());
				
				TemCallDetailRecordPk temCallDetailRecordPk = new TemCallDetailRecordPk();
//				temCallDetailRecordPk.setTcdrMsIsdnFrom(temCallDetailRecordDTO.getTcdrMsIsdnFrom());
				temCallDetailRecordPk.setTcdrUsedTime(temCallDetailRecordDTO.getTcdrUsedTime());
				if(temCallDetailRecordDTO.getTemType() != null) {
					temCallDetailRecordPk.setTtId(temCallDetailRecordDTO.getTemType().getTtId());
				}
				temCallDetailRecord.setTemCallDetailRecordPk(temCallDetailRecordPk);
				List list = temService.searchTemCallDetailRecord(temCallDetailRecord, temCallDetailRecordDTO.getPaging());
				
				if (list != null && list.size() > 0) {
					resultDTO = new ResultDTO();
					List l = (List) list.get(0);
					int size = l.size();
					List result = new ArrayList(size);
					for (int i = 0; i < size; i++) {
						TemCallDetailRecord dto = new TemCallDetailRecord();
						th.co.imake.tem.domain.TemCallDetailRecord temCallDetailRecord2 = (th.co.imake.tem.domain.TemCallDetailRecord) l
								.get(i);
//						dto.setTcdrMsIsdnFrom(temCallDetailRecord2.getTemCallDetailRecordPk().getTcdrMsIsdnFrom());
//						dto.setTcdrMsIsdnTo(temCallDetailRecord2.getTcdrMsIsdnTo());
						dto.setTcdrUsedCount(temCallDetailRecord2.getTcdrUsedCount());
						dto.setTcdrUsedTime(temCallDetailRecord2.getTemCallDetailRecordPk().getTcdrUsedTime());
						TemType temType = new TemType();
						temType.setTtId(temCallDetailRecord2.getTemCallDetailRecordPk().getTtId());
						dto.setTemType(temType);
						result.add(dto);
					}
					resultDTO.setResultList(result);
					max_rows = (String) list.get(1);
				}
			} else if (ServiceConstant.TEM_CALL_DETAIL_RECORD_UPDATE
					.equals(serviceName)) {
				TemCallDetailRecord temCallDetailRecordDTO = (TemCallDetailRecord)baseDTO;
				th.co.imake.tem.domain.TemCallDetailRecord temCallDetailRecord = new th.co.imake.tem.domain.TemCallDetailRecord();
//				temCallDetailRecord.setTcdrMsIsdnTo(temCallDetailRecordDTO.getTcdrMsIsdnTo());
				temCallDetailRecord.setTcdrUsedCount(temCallDetailRecordDTO.getTcdrUsedCount());
				
				TemCallDetailRecordPk temCallDetailRecordPk = new TemCallDetailRecordPk();
//				temCallDetailRecordPk.setTcdrMsIsdnFrom(temCallDetailRecordDTO.getTcdrMsIsdnFrom());
				temCallDetailRecordPk.setTcdrUsedTime(temCallDetailRecordDTO.getTcdrUsedTime());
				if(temCallDetailRecordDTO.getTemType() != null) {
					temCallDetailRecordPk.setTtId(temCallDetailRecordDTO.getTemType().getTtId());
				}
				temCallDetailRecord.setTemCallDetailRecordPk(temCallDetailRecordPk);
				temService.updateTemCallDetailRecord(temCallDetailRecord);
			} else if (ServiceConstant.TEM_COMPANY_DELETE.equals(serviceName)) {
				TemCompany temCompanyDTO = (TemCompany) baseDTO;
				th.co.imake.tem.domain.TemCompany temCompany = new th.co.imake.tem.domain.TemCompany();
				temCompany.setTcId(temCompanyDTO.getTcId());
				temCompany.setTcName(temCompanyDTO.getTcName());
				temService.deleteTemCompany(temCompany);
			} else if (ServiceConstant.TEM_COMPANY_SAVE.equals(serviceName)) {
				TemCompany temCompanyDTO = (TemCompany) baseDTO;
				th.co.imake.tem.domain.TemCompany temCompany = new th.co.imake.tem.domain.TemCompany();
				temCompany.setTcId(temCompanyDTO.getTcId());
				temCompany.setTcName(temCompanyDTO.getTcName());
				temService.insertTemCompany(temCompany);
			} else if (ServiceConstant.TEM_COMPANY_SEARCH.equals(serviceName)) {
				TemCompany temCompanyDTO = (TemCompany) baseDTO;
				th.co.imake.tem.domain.TemCompany temCompany = new th.co.imake.tem.domain.TemCompany();
				temCompany.setTcId(temCompanyDTO.getTcId());
				temCompany.setTcName(temCompanyDTO.getTcName());
				List list = temService.searchTemCompany(temCompany,
						temCompanyDTO.getPaging());

				if (list != null && list.size() > 0) {
					resultDTO = new ResultDTO();
					List l = (List) list.get(0);
					int size = l.size();
					List result = new ArrayList(size);
					for (int i = 0; i < size; i++) {
						TemCompany dto = new TemCompany();
						th.co.imake.tem.domain.TemCompany temCompany2 = (th.co.imake.tem.domain.TemCompany) l
								.get(i);
						dto.setTcId(temCompany2.getTcId());
						dto.setTcName(temCompany2.getTcName());
						result.add(dto);
					}
					resultDTO.setResultList(result);
					max_rows = (String) list.get(1);
				}
			} else if (ServiceConstant.TEM_COMPANY_UPDATE.equals(serviceName)) {
				TemCompany temCompanyDTO = (TemCompany) baseDTO;
				th.co.imake.tem.domain.TemCompany temCompany = new th.co.imake.tem.domain.TemCompany();
				temCompany.setTcId(temCompanyDTO.getTcId());
				temCompany.setTcName(temCompanyDTO.getTcName());
				temService.updateTemCompany(temCompany);
			} else if (ServiceConstant.TEM_MSISDN_PACKAGE_DETAIL_DELETE
					.equals(serviceName)) {
				TemMsIsdnPackageDetail temMsIsdnPackageDetailDTO = (TemMsIsdnPackageDetail) baseDTO;
				th.co.imake.tem.domain.TemMsIsdnPackageDetail temMsIsdnPackageDetail = new th.co.imake.tem.domain.TemMsIsdnPackageDetail();
				TemMsIsdnPackageDetailPk temMsIsdnPackageDetailPk = new TemMsIsdnPackageDetailPk();
				temMsIsdnPackageDetailPk.setMsIsdn(temMsIsdnPackageDetailDTO
						.getMsIsdn());
				temMsIsdnPackageDetailPk.setTpdId(temMsIsdnPackageDetailDTO
						.getTemPackageDetail().getTpdId());
				temMsIsdnPackageDetail
						.setTemMsIsdnPackageDetailPk(temMsIsdnPackageDetailPk);
				temService.deleteTemMsIsdnPackageDetail(temMsIsdnPackageDetail);
			} else if (ServiceConstant.TEM_MSISDN_PACKAGE_DETAIL_SAVE
					.equals(serviceName)) {
				TemMsIsdnPackageDetail temMsIsdnPackageDetailDTO = (TemMsIsdnPackageDetail) baseDTO;
				th.co.imake.tem.domain.TemMsIsdnPackageDetail temMsIsdnPackageDetail = new th.co.imake.tem.domain.TemMsIsdnPackageDetail();
				TemMsIsdnPackageDetailPk temMsIsdnPackageDetailPk = new TemMsIsdnPackageDetailPk();
				temMsIsdnPackageDetailPk.setMsIsdn(temMsIsdnPackageDetailDTO
						.getMsIsdn());
				temMsIsdnPackageDetailPk.setTpdId(temMsIsdnPackageDetailDTO
						.getTemPackageDetail().getTpdId());
				temMsIsdnPackageDetail
						.setTemMsIsdnPackageDetailPk(temMsIsdnPackageDetailPk);
				temService.insertTemMsIsdnPackageDetail(temMsIsdnPackageDetail);
			} else if (ServiceConstant.TEM_MSISDN_PACKAGE_DETAIL_SEARCH
					.equals(serviceName)) {
				TemMsIsdnPackageDetail temMsIsdnPackageDetailDTO = (TemMsIsdnPackageDetail) baseDTO;
				th.co.imake.tem.domain.TemMsIsdnPackageDetail temMsIsdnPackageDetail = new th.co.imake.tem.domain.TemMsIsdnPackageDetail();
				TemMsIsdnPackageDetailPk temMsIsdnPackageDetailPk = new TemMsIsdnPackageDetailPk();
				temMsIsdnPackageDetailPk.setMsIsdn(temMsIsdnPackageDetailDTO
						.getMsIsdn());
				temMsIsdnPackageDetailPk.setTpdId(temMsIsdnPackageDetailDTO
						.getTemPackageDetail().getTpdId());
				temMsIsdnPackageDetail
						.setTemMsIsdnPackageDetailPk(temMsIsdnPackageDetailPk);
				List list = temService.searchTemMsIsdnPackageDetail(
						temMsIsdnPackageDetail,
						temMsIsdnPackageDetailDTO.getPaging());

				if (list != null && list.size() > 0) {
					resultDTO = new ResultDTO();
					List l = (List) list.get(0);
					int size = l.size();
					List result = new ArrayList(size);
					for (int i = 0; i < size; i++) {
						TemMsIsdnPackageDetail dto = new TemMsIsdnPackageDetail();
						th.co.imake.tem.domain.TemMsIsdnPackageDetail temMsIsdnPackageDetail2 = (th.co.imake.tem.domain.TemMsIsdnPackageDetail) l
								.get(i);
						if (temMsIsdnPackageDetail2
								.getTemMsIsdnPackageDetailPk() != null) {
							th.co.imake.tem.domain.TemMsIsdnPackageDetailPk temMsIsdnPackageDetailPk2 = temMsIsdnPackageDetail2
									.getTemMsIsdnPackageDetailPk();
							dto.setMsIsdn(temMsIsdnPackageDetailPk2.getMsIsdn());
							TemPackageDetail temPackageDetail = new TemPackageDetail();
							temPackageDetail.setTpdId(temMsIsdnPackageDetailPk2
									.getTpdId());
							dto.setTemPackageDetail(temPackageDetail);
						}
						result.add(dto);
					}
					resultDTO.setResultList(result);
					max_rows = (String) list.get(1);
				}
			} else if (ServiceConstant.TEM_MSISDN_PACKAGE_DETAIL_UPDATE
					.equals(serviceName)) {
				TemMsIsdnPackageDetail temMsIsdnPackageDetailDTO = (TemMsIsdnPackageDetail) baseDTO;
				th.co.imake.tem.domain.TemMsIsdnPackageDetail temMsIsdnPackageDetail = new th.co.imake.tem.domain.TemMsIsdnPackageDetail();
				TemMsIsdnPackageDetailPk temMsIsdnPackageDetailPk = new TemMsIsdnPackageDetailPk();
				temMsIsdnPackageDetailPk.setMsIsdn(temMsIsdnPackageDetailDTO
						.getMsIsdn());
				temMsIsdnPackageDetailPk.setTpdId(temMsIsdnPackageDetailDTO
						.getTemPackageDetail().getTpdId());
				temMsIsdnPackageDetail
						.setTemMsIsdnPackageDetailPk(temMsIsdnPackageDetailPk);
				temService.updateTemMsIsdnPackageDetail(temMsIsdnPackageDetail);
			} else if (ServiceConstant.TEM_MSISDN_DELETE.equals(serviceName)) {
				TemMsIsdn temMsIsdnDTO = (TemMsIsdn) baseDTO;
				th.co.imake.tem.domain.TemMsIsdn temMsIsdn = new th.co.imake.tem.domain.TemMsIsdn();
				temMsIsdn.setMsIsdn(temMsIsdnDTO.getMsIsdn());
				TemCompany temCompanyDTO = temMsIsdnDTO.getTemCompany();
				th.co.imake.tem.domain.TemCompany temCompany = new th.co.imake.tem.domain.TemCompany();
				temCompany.setTcId(temCompanyDTO.getTcId());
				temCompany.setTcName(temCompanyDTO.getTcName());
				temMsIsdn.setTemCompany(temCompany);
				temService.deleteTemMsIsdn(temMsIsdn);
			} else if (ServiceConstant.TEM_MSISDN_SAVE.equals(serviceName)) {
				TemMsIsdn temMsIsdnDTO = (TemMsIsdn) baseDTO;
				th.co.imake.tem.domain.TemMsIsdn temMsIsdn = new th.co.imake.tem.domain.TemMsIsdn();
				temMsIsdn.setMsIsdn(temMsIsdnDTO.getMsIsdn());
				TemCompany temCompanyDTO = temMsIsdnDTO.getTemCompany();
				th.co.imake.tem.domain.TemCompany temCompany = new th.co.imake.tem.domain.TemCompany();
				temCompany.setTcId(temCompanyDTO.getTcId());
				temCompany.setTcName(temCompanyDTO.getTcName());
				temMsIsdn.setTemCompany(temCompany);
				temService.insertTemMsIsdn(temMsIsdn);
			} else if (ServiceConstant.TEM_MSISDN_SEARCH.equals(serviceName)) {
				TemMsIsdn temMsIsdnDTO = (TemMsIsdn) baseDTO;
				th.co.imake.tem.domain.TemMsIsdn temMsIsdn = new th.co.imake.tem.domain.TemMsIsdn();
				temMsIsdn.setMsIsdn(temMsIsdnDTO.getMsIsdn());
				TemCompany temCompanyDTO = temMsIsdnDTO.getTemCompany();
				th.co.imake.tem.domain.TemCompany temCompany = new th.co.imake.tem.domain.TemCompany();
				temCompany.setTcId(temCompanyDTO.getTcId());
				temCompany.setTcName(temCompanyDTO.getTcName());
				temMsIsdn.setTemCompany(temCompany);
				List list = temService.searchTemMsIsdn(temMsIsdn,
						temMsIsdnDTO.getPaging());

				if (list != null && list.size() > 0) {
					resultDTO = new ResultDTO();
					List l = (List) list.get(0);
					int size = l.size();
					List result = new ArrayList(size);
					for (int i = 0; i < size; i++) {
						TemMsIsdn dto = new TemMsIsdn();
						th.co.imake.tem.domain.TemMsIsdn temMsIsdn2 = (th.co.imake.tem.domain.TemMsIsdn) l
								.get(i);
						dto.setMsIsdn(temMsIsdn2.getMsIsdn());
						if (temMsIsdn2.getTemCompany() != null) {
							TemCompany temCompanyDTO2 = new TemCompany();
							th.co.imake.tem.domain.TemCompany temCompany2 = temMsIsdn2
									.getTemCompany();
							temCompanyDTO2.setTcId(temCompany2.getTcId());
							temCompanyDTO2.setTcName(temCompany2.getTcName());
							dto.setTemCompany(temCompanyDTO2);
						}
						result.add(dto);
					}
					resultDTO.setResultList(result);
					max_rows = (String) list.get(1);
				}
			} else if (ServiceConstant.TEM_MSISDN_UPDATE.equals(serviceName)) {
				TemMsIsdn temMsIsdnDTO = (TemMsIsdn) baseDTO;
				th.co.imake.tem.domain.TemMsIsdn temMsIsdn = new th.co.imake.tem.domain.TemMsIsdn();
				temMsIsdn.setMsIsdn(temMsIsdnDTO.getMsIsdn());
				TemCompany temCompanyDTO = temMsIsdnDTO.getTemCompany();
				th.co.imake.tem.domain.TemCompany temCompany = new th.co.imake.tem.domain.TemCompany();
				temCompany.setTcId(temCompanyDTO.getTcId());
				temCompany.setTcName(temCompanyDTO.getTcName());
				temMsIsdn.setTemCompany(temCompany);
				temService.updateTemMsIsdn(temMsIsdn);
			} else if (ServiceConstant.TEM_PACKAGE_DETAIL_DELETE
					.equals(serviceName)) {
				TemPackageDetail temPackageDetailDTO = (TemPackageDetail) baseDTO;
				th.co.imake.tem.domain.TemPackageDetail temPackageDetail = new th.co.imake.tem.domain.TemPackageDetail();
				temPackageDetail.setTpdId(temPackageDetailDTO.getTpdId());
				temPackageDetail.setTpdName(temPackageDetailDTO.getTpdName());
				temPackageDetail.setTpdCallPrice(temPackageDetailDTO
						.getTpdCallPrice());
				temPackageDetail.setTpdSmsPrice(temPackageDetailDTO
						.getTpdSmsPrice());
				temPackageDetail.setTpdDataPrice(temPackageDetailDTO
						.getTpdDataPrice());
				TemPackageType temPackageTypeDTO = temPackageDetailDTO
						.getTemPackageType();
				th.co.imake.tem.domain.TemPackageType temPackageType = new th.co.imake.tem.domain.TemPackageType();
				temPackageType.setTptId(temPackageTypeDTO.getTptId());
				temPackageType.setTptName(temPackageTypeDTO.getTptName());
				temPackageDetail.setTemPackageType(temPackageType);
				temService.deleteTemPackageDetail(temPackageDetail);
			} else if (ServiceConstant.TEM_PACKAGE_DETAIL_SAVE
					.equals(serviceName)) {
				TemPackageDetail temPackageDetailDTO = (TemPackageDetail) baseDTO;
				th.co.imake.tem.domain.TemPackageDetail temPackageDetail = new th.co.imake.tem.domain.TemPackageDetail();
				temPackageDetail.setTpdId(temPackageDetailDTO.getTpdId());
				temPackageDetail.setTpdName(temPackageDetailDTO.getTpdName());
				temPackageDetail.setTpdCallPrice(temPackageDetailDTO
						.getTpdCallPrice());
				temPackageDetail.setTpdSmsPrice(temPackageDetailDTO
						.getTpdSmsPrice());
				temPackageDetail.setTpdDataPrice(temPackageDetailDTO
						.getTpdDataPrice());
				TemPackageType temPackageTypeDTO = temPackageDetailDTO
						.getTemPackageType();
				th.co.imake.tem.domain.TemPackageType temPackageType = new th.co.imake.tem.domain.TemPackageType();
				temPackageType.setTptId(temPackageTypeDTO.getTptId());
				temPackageType.setTptName(temPackageTypeDTO.getTptName());
				temPackageDetail.setTemPackageType(temPackageType);
				temService.insertTemPackageDetail(temPackageDetail);
			} else if (ServiceConstant.TEM_PACKAGE_DETAIL_SEARCH
					.equals(serviceName)) {
				TemPackageDetail temPackageDetailDTO = (TemPackageDetail) baseDTO;
				th.co.imake.tem.domain.TemPackageDetail temPackageDetail = new th.co.imake.tem.domain.TemPackageDetail();
				temPackageDetail.setTpdId(temPackageDetailDTO.getTpdId());
				temPackageDetail.setTpdName(temPackageDetailDTO.getTpdName());
				temPackageDetail.setTpdCallPrice(temPackageDetailDTO
						.getTpdCallPrice());
				temPackageDetail.setTpdSmsPrice(temPackageDetailDTO
						.getTpdSmsPrice());
				temPackageDetail.setTpdDataPrice(temPackageDetailDTO
						.getTpdDataPrice());
				TemPackageType temPackageTypeDTO = temPackageDetailDTO
						.getTemPackageType();
				th.co.imake.tem.domain.TemPackageType temPackageType = new th.co.imake.tem.domain.TemPackageType();
				temPackageType.setTptId(temPackageTypeDTO.getTptId());
				temPackageType.setTptName(temPackageTypeDTO.getTptName());
				temPackageDetail.setTemPackageType(temPackageType);
				List list = temService.searchTemPackageDetail(temPackageDetail,
						temPackageDetailDTO.getPaging());

				if (list != null && list.size() > 0) {
					resultDTO = new ResultDTO();
					List l = (List) list.get(0);
					int size = l.size();
					List result = new ArrayList(size);
					for (int i = 0; i < size; i++) {
						TemPackageDetail dto = new TemPackageDetail();
						th.co.imake.tem.domain.TemPackageDetail temPackageDetail2 = (th.co.imake.tem.domain.TemPackageDetail) l
								.get(i);
						dto.setTpdId(temPackageDetail2.getTpdId());
						dto.setTpdName(temPackageDetail2.getTpdName());
						dto.setTpdCallPrice(temPackageDetail2.getTpdCallPrice());
						dto.setTpdDataPrice(temPackageDetail2.getTpdDataPrice());
						dto.setTpdSmsPrice(temPackageDetail2.getTpdSmsPrice());
						if (temPackageDetail2.getTemPackageType() != null) {
							TemPackageType temPackageTypeDTO2 = new TemPackageType();
							th.co.imake.tem.domain.TemPackageType temPackageType2 = temPackageDetail2
									.getTemPackageType();
							temPackageTypeDTO2.setTptId(temPackageType2
									.getTptId());
							temPackageTypeDTO2.setTptName(temPackageType2
									.getTptName());
							dto.setTemPackageType(temPackageTypeDTO2);
						}
						result.add(dto);
					}
					resultDTO.setResultList(result);
					max_rows = (String) list.get(1);
				}
			} else if (ServiceConstant.TEM_PACKAGE_DETAIL_UPDATE
					.equals(serviceName)) {
				TemPackageDetail temPackageDetailDTO = (TemPackageDetail) baseDTO;
				th.co.imake.tem.domain.TemPackageDetail temPackageDetail = new th.co.imake.tem.domain.TemPackageDetail();
				temPackageDetail.setTpdId(temPackageDetailDTO.getTpdId());
				temPackageDetail.setTpdName(temPackageDetailDTO.getTpdName());
				temPackageDetail.setTpdCallPrice(temPackageDetailDTO
						.getTpdCallPrice());
				temPackageDetail.setTpdSmsPrice(temPackageDetailDTO
						.getTpdSmsPrice());
				temPackageDetail.setTpdDataPrice(temPackageDetailDTO
						.getTpdDataPrice());
				TemPackageType temPackageTypeDTO = temPackageDetailDTO
						.getTemPackageType();
				th.co.imake.tem.domain.TemPackageType temPackageType = new th.co.imake.tem.domain.TemPackageType();
				temPackageType.setTptId(temPackageTypeDTO.getTptId());
				temPackageType.setTptName(temPackageTypeDTO.getTptName());
				temPackageDetail.setTemPackageType(temPackageType);
				temService.updateTemPackageDetail(temPackageDetail);
			} else if (ServiceConstant.TEM_PACKAGE_TYPE_DELETE
					.equals(serviceName)) {
				TemPackageType temPackageTypeDTO = (TemPackageType) baseDTO;
				th.co.imake.tem.domain.TemPackageType temPackageType = new th.co.imake.tem.domain.TemPackageType();
				temPackageType.setTptId(temPackageTypeDTO.getTptId());
				temPackageType.setTptName(temPackageTypeDTO.getTptName());
				TemProvider temProviderDTO = temPackageTypeDTO.getTemProvider();
				th.co.imake.tem.domain.TemProvider temProvider = new th.co.imake.tem.domain.TemProvider();
				temProvider.setTpId(temProviderDTO.getTpId());
				temProvider.setTpName(temProviderDTO.getTpName());
				temPackageType.setTemProvider(temProvider);
				temService.deleteTemPackageType(temPackageType);
			} else if (ServiceConstant.TEM_PACKAGE_TYPE_SAVE
					.equals(serviceName)) {
				TemPackageType temPackageTypeDTO = (TemPackageType) baseDTO;
				th.co.imake.tem.domain.TemPackageType temPackageType = new th.co.imake.tem.domain.TemPackageType();
				temPackageType.setTptId(temPackageTypeDTO.getTptId());
				temPackageType.setTptName(temPackageTypeDTO.getTptName());
				TemProvider temProviderDTO = temPackageTypeDTO.getTemProvider();
				th.co.imake.tem.domain.TemProvider temProvider = new th.co.imake.tem.domain.TemProvider();
				temProvider.setTpId(temProviderDTO.getTpId());
				temProvider.setTpName(temProviderDTO.getTpName());
				temPackageType.setTemProvider(temProvider);
				temService.insertTemPackageType(temPackageType);
			} else if (ServiceConstant.TEM_PACKAGE_TYPE_SEARCH
					.equals(serviceName)) {
				TemPackageType temPackageTypeDTO = (TemPackageType) baseDTO;
				th.co.imake.tem.domain.TemPackageType temPackageType = new th.co.imake.tem.domain.TemPackageType();
				temPackageType.setTptId(temPackageTypeDTO.getTptId());
				temPackageType.setTptName(temPackageTypeDTO.getTptName());
				TemProvider temProviderDTO = temPackageTypeDTO.getTemProvider();
				th.co.imake.tem.domain.TemProvider temProvider = new th.co.imake.tem.domain.TemProvider();
				temProvider.setTpId(temProviderDTO.getTpId());
				temProvider.setTpName(temProviderDTO.getTpName());
				temPackageType.setTemProvider(temProvider);
				List list = temService.searchTemPackageType(temPackageType,
						temPackageTypeDTO.getPaging());

				if (list != null && list.size() > 0) {
					resultDTO = new ResultDTO();
					List l = (List) list.get(0);
					int size = l.size();
					List result = new ArrayList(size);
					for (int i = 0; i < size; i++) {
						TemPackageType dto = new TemPackageType();
						th.co.imake.tem.domain.TemPackageType temPackageType2 = (th.co.imake.tem.domain.TemPackageType) l
								.get(i);
						dto.setTptId(temPackageType2.getTptId());
						dto.setTptName(temPackageType2.getTptName());
						if (temPackageType2.getTemProvider() != null) {
							TemProvider temProviderDTO2 = new TemProvider();
							th.co.imake.tem.domain.TemProvider temProvider2 = temPackageType2
									.getTemProvider();
							temProviderDTO2.setTpId(temProvider2.getTpId());
							temProviderDTO2.setTpName(temProvider2.getTpName());
							dto.setTemProvider(temProviderDTO2);
						}
						result.add(dto);
					}
					resultDTO.setResultList(result);
					max_rows = (String) list.get(1);
				}
			} else if (ServiceConstant.TEM_PACKAGE_TYPE_UPDATE
					.equals(serviceName)) {
				TemPackageType temPackageTypeDTO = (TemPackageType) baseDTO;
				th.co.imake.tem.domain.TemPackageType temPackageType = new th.co.imake.tem.domain.TemPackageType();
				temPackageType.setTptId(temPackageTypeDTO.getTptId());
				temPackageType.setTptName(temPackageTypeDTO.getTptName());
				TemProvider temProviderDTO = temPackageTypeDTO.getTemProvider();
				th.co.imake.tem.domain.TemProvider temProvider = new th.co.imake.tem.domain.TemProvider();
				temProvider.setTpId(temProviderDTO.getTpId());
				temProvider.setTpName(temProviderDTO.getTpName());
				temPackageType.setTemProvider(temProvider);
				temService.updateTemPackageType(temPackageType);
			} else if (ServiceConstant.TEM_PROVIDER_DELETE.equals(serviceName)) {
				TemProvider temProviderDTO = (TemProvider) baseDTO;
				th.co.imake.tem.domain.TemProvider temProvider = new th.co.imake.tem.domain.TemProvider();
				temProvider.setTpId(temProviderDTO.getTpId());
				temProvider.setTpName(temProviderDTO.getTpName());
				temService.deleteTemProvider(temProvider);
			} else if (ServiceConstant.TEM_PROVIDER_SAVE.equals(serviceName)) {
				TemProvider temProviderDTO = (TemProvider) baseDTO;
				th.co.imake.tem.domain.TemProvider temProvider = new th.co.imake.tem.domain.TemProvider();
				temProvider.setTpId(temProviderDTO.getTpId());
				temProvider.setTpName(temProviderDTO.getTpName());
				temService.insertTemProvider(temProvider);
			} else if (ServiceConstant.TEM_PROVIDER_SEARCH.equals(serviceName)) {
				TemProvider temProviderDTO = (TemProvider) baseDTO;
				th.co.imake.tem.domain.TemProvider temProvider = new th.co.imake.tem.domain.TemProvider();
				temProvider.setTpId(temProviderDTO.getTpId());
				temProvider.setTpName(temProviderDTO.getTpName());
				List list = temService.searchTemProvider(temProvider,
						temProviderDTO.getPaging());

				if (list != null && list.size() > 0) {
					resultDTO = new ResultDTO();
					List l = (List) list.get(0);
					int size = l.size();
					List result = new ArrayList(size);
					for (int i = 0; i < size; i++) {
						TemProvider dto = new TemProvider();
						th.co.imake.tem.domain.TemProvider temProvider2 = (th.co.imake.tem.domain.TemProvider) l
								.get(i);
						dto.setTpId(temProvider2.getTpId());
						dto.setTpName(temProvider2.getTpName());
						result.add(dto);
					}
					resultDTO.setResultList(result);
					max_rows = (String) list.get(1);
				}
			} else if (ServiceConstant.TEM_PROVIDER_UPDATE.equals(serviceName)) {
				TemProvider temProviderDTO = (TemProvider) baseDTO;
				th.co.imake.tem.domain.TemProvider temProvider = new th.co.imake.tem.domain.TemProvider();
				temProvider.setTpId(temProviderDTO.getTpId());
				temProvider.setTpName(temProviderDTO.getTpName());
				temService.updateTemProvider(temProvider);
			} else if (ServiceConstant.TEM_SPECIAL_LIST_DELETE
					.equals(serviceName)) {
				TemSpecialList temSpecialListDTO = (TemSpecialList) baseDTO;
				th.co.imake.tem.domain.TemSpecialList temSpecialList = new th.co.imake.tem.domain.TemSpecialList();
				TemSpecialListPk temSpecialListPk = new TemSpecialListPk();
				temSpecialListPk.setTslMsisdn(temSpecialListDTO.getTslMsisdn());
				temSpecialListPk.setTslMsisdnFriend(temSpecialListDTO
						.getTslMsisdnFriend());
				temSpecialList.setTemSpecialListPk(temSpecialListPk);
				temService.deleteTemSpecialList(temSpecialList);
			} else if (ServiceConstant.TEM_SPECIAL_LIST_SAVE
					.equals(serviceName)) {
				TemSpecialList temSpecialListDTO = (TemSpecialList) baseDTO;
				th.co.imake.tem.domain.TemSpecialList temSpecialList = new th.co.imake.tem.domain.TemSpecialList();
				TemSpecialListPk temSpecialListPk = new TemSpecialListPk();
				temSpecialListPk.setTslMsisdn(temSpecialListDTO.getTslMsisdn());
				temSpecialListPk.setTslMsisdnFriend(temSpecialListDTO
						.getTslMsisdnFriend());
				temSpecialList.setTemSpecialListPk(temSpecialListPk);
				temService.insertTemSpecialList(temSpecialList);
			} else if (ServiceConstant.TEM_SPECIAL_LIST_SEARCH
					.equals(serviceName)) {
				TemSpecialList temSpecialListDTO = (TemSpecialList) baseDTO;
				th.co.imake.tem.domain.TemSpecialList temSpecialList = new th.co.imake.tem.domain.TemSpecialList();
				TemSpecialListPk temSpecialListPk = new TemSpecialListPk();
				temSpecialListPk.setTslMsisdn(temSpecialListDTO.getTslMsisdn());
				temSpecialListPk.setTslMsisdnFriend(temSpecialListDTO
						.getTslMsisdnFriend());
				temSpecialList.setTemSpecialListPk(temSpecialListPk);
				List list = temService.searchTemSpecialList(temSpecialList,
						temSpecialListDTO.getPaging());

				if (list != null && list.size() > 0) {
					resultDTO = new ResultDTO();
					List l = (List) list.get(0);
					int size = l.size();
					List result = new ArrayList(size);
					for (int i = 0; i < size; i++) {
						TemSpecialList dto = new TemSpecialList();
						th.co.imake.tem.domain.TemSpecialList temSpecialList2 = (th.co.imake.tem.domain.TemSpecialList) l
								.get(i);
						TemSpecialListPk temSpecialListPk2 = temSpecialList2
								.getTemSpecialListPk();
						if (temSpecialListPk2 != null) {
							dto.setTslMsisdn(temSpecialListPk2.getTslMsisdn());
							dto.setTslMsisdnFriend(temSpecialListPk2
									.getTslMsisdnFriend());
						}
						result.add(dto);
					}
					resultDTO.setResultList(result);
					max_rows = (String) list.get(1);
				}
			} else if (ServiceConstant.TEM_SPECIAL_LIST_UPDATE
					.equals(serviceName)) {
				TemSpecialList temSpecialListDTO = (TemSpecialList) baseDTO;
				th.co.imake.tem.domain.TemSpecialList temSpecialList = new th.co.imake.tem.domain.TemSpecialList();
				TemSpecialListPk temSpecialListPk = new TemSpecialListPk();
				temSpecialListPk.setTslMsisdn(temSpecialListDTO.getTslMsisdn());
				temSpecialListPk.setTslMsisdnFriend(temSpecialListDTO
						.getTslMsisdnFriend());
				temSpecialList.setTemSpecialListPk(temSpecialListPk);
				temService.updateTemSpecialList(temSpecialList);
			} else if (ServiceConstant.TEM_TYPE_DELETE.equals(serviceName)) {
				TemType temTypeDTO = (TemType) baseDTO;
				th.co.imake.tem.domain.TemType temType = new th.co.imake.tem.domain.TemType();
				temType.setTtId(temTypeDTO.getTtId());
				temType.setTtName(temTypeDTO.getTtName());
				temService.deleteTemType(temType);
			} else if (ServiceConstant.TEM_TYPE_SAVE.equals(serviceName)) {
				TemType temTypeDTO = (TemType) baseDTO;
				th.co.imake.tem.domain.TemType temType = new th.co.imake.tem.domain.TemType();
				temType.setTtId(temTypeDTO.getTtId());
				temType.setTtName(temTypeDTO.getTtName());
				temService.insertTemType(temType);
			} else if (ServiceConstant.TEM_TYPE_SEARCH.equals(serviceName)) {
				TemType temTypeDTO = (TemType) baseDTO;
				th.co.imake.tem.domain.TemType temType = new th.co.imake.tem.domain.TemType();
				temType.setTtId(temTypeDTO.getTtId());
				temType.setTtName(temTypeDTO.getTtName());
				List list = temService.searchTemType(temType,
						temTypeDTO.getPaging());

				if (list != null && list.size() > 0) {
					resultDTO = new ResultDTO();
					List l = (List) list.get(0);
					int size = l.size();
					List result = new ArrayList(size);
					for (int i = 0; i < size; i++) {
						TemType dto = new TemType();
						th.co.imake.tem.domain.TemType temType2 = (th.co.imake.tem.domain.TemType) l
								.get(i);
						dto.setTtId(temType2.getTtId());
						dto.setTtName(temType2.getTtName());
						result.add(dto);
					}
					resultDTO.setResultList(result);
					max_rows = (String) list.get(1);
				}
			} else if (ServiceConstant.TEM_TYPE_UPDATE.equals(serviceName)) {
				TemType temTypeDTO = (TemType) baseDTO;
				th.co.imake.tem.domain.TemType temType = new th.co.imake.tem.domain.TemType();
				temType.setTtId(temTypeDTO.getTtId());
				temType.setTtName(temTypeDTO.getTtName());
				temService.updateTemType(temType);
			}

			if (resultDTO != null) {
				ResultMessage vresultMessage = new ResultMessage();
				vresultMessage.setResultDTO(resultDTO);
				vresultMessage.setMaxRow(max_rows);
				return export(vresultMessage, XStreamUtils.getXstream());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
		return null;
	}
}
