package myRestIIQ5;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

@Path("myOAuthAPI")
public class MyOauthAPI {
	private static final Logger logger = Logger.getLogger(MyOauthAPI.class);

	@Context
	private HttpServletRequest httpRequest;
	
	@GET
	@Path("test2")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})	
	public void test2() throws IOException {		
		logger.info("test2 STARTED");		
		ValidateToken vt = new ValidateToken();		
		Map<String, Object> result = vt.validateToken(httpRequest);
		logger.info("validateToken:"+result);
		boolean success = (Boolean) result.get("success");		
		logger.info("test2 FINISHED");
		/*if (!success) {
			logger.error("Access Restricted: " + result.get("reason"));

			return Response.status(401).type(MediaType.APPLICATION_JSON).entity(result).build();

		}
//YOUR BUSINESS LOGIC GOES BELOW THIS LINE AND YOU RETURN SUCESS ALONG WITH THE RESPONSE JSON
		return Response.status(200).type(MediaType.APPLICATION_JSON).entity(result).build();
		*/
	}


}
