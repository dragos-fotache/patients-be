package patients.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import patients.model.Patient;

@Path("/")
public class RestService {
	
	@GET
	@Produces("application/json")
	@Path("/patients/login")
	public Response login(@HeaderParam("Authorization") String auth,
						  @Context HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		try {
			if (auth == null) {
				return Response
							.status(Response.Status.UNAUTHORIZED)
							.build();
			} else {
				boolean authorized = AuthenticationService.INSTANCE.checkAuthorization(auth);
				if (authorized) {
					session.setAttribute("authorized", true);
					return Response
							.status(Response.Status.OK)
							.entity("Login accepted")
							.build();
				} else {
					return Response
							.status(Response.Status.UNAUTHORIZED)
							.entity("Wrong login")
							.build();
				}
			}
		} catch (Exception e) {
			return Response
						.status(Response.Status.INTERNAL_SERVER_ERROR)
						.build();
		}
	}
	
	@GET
	@Produces("application/json")
	@Path("/patients/logout")
	public Response logout(@Context HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("authorized");
		
		return Response
				.status(Response.Status.OK)
				.entity("")
				.build();
		
	}
	
	@GET
	@Produces("application/json")
	@Path("/patients")
	public Response getPatients() {
		
		List<Patient> articles = PatientsService.INSTANCE.getArticles();
		
		return Response
				.status(Response.Status.OK)
				.entity(articles)
				.build();
	}
	
	
}
