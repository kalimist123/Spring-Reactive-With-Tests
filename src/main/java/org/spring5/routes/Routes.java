

package org.spring5.routes;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.spring5.handler.PatientTestHandler;
import org.spring5.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;

@Configuration
public class Routes {

	private UserHandler userHandler;
	private PatientTestHandler patientTestHandler;

	public Routes(UserHandler userHandler, PatientTestHandler patientTestHandler) {

		this.userHandler = userHandler;
		this.patientTestHandler = patientTestHandler;
	}

	@Bean
	public RouterFunction<?> shooterRouterFunction() {
		return

				route(GET("/api/patienttest").and(accept(MediaType.APPLICATION_JSON)), patientTestHandler::handleGetPatientTests)
						.andRoute(GET("/api/patienttest/{id}").and(accept(MediaType.APPLICATION_JSON)), patientTestHandler::handleGetPatientTestsById)
						.andRoute(GET("/api/user").and(accept(MediaType.APPLICATION_JSON)),userHandler::handleGetUsers)
						.andRoute(GET("/api/user/{id}").and(accept(MediaType.APPLICATION_JSON)), userHandler::handleGetUserById);





	}

}

