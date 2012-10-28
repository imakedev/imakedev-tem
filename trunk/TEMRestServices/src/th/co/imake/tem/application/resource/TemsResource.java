package th.co.imake.tem.application.resource;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;

import th.co.imake.tem.dto.ResultMessage;
import th.co.imake.tem.util.XStreamUtils;

public class TemsResource extends BaseResource {
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
		System.out.println("************************* TEM Resource Post *******************");
		ResultMessage resultMessage = new ResultMessage();
		resultMessage.setMaxRow("5");
		return export(resultMessage, XStreamUtils.getXstream());
	}
}
