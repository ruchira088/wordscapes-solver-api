package com.ruchij.webapp.controllers;

import com.ruchij.webapp.services.health.MonitoringService;
import com.ruchij.webapp.services.health.models.ServiceInformation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/service", produces = MediaType.APPLICATION_JSON_VALUE)
public class ServiceController {
	private final MonitoringService monitoringService;

	public ServiceController(MonitoringService monitoringService) {
		this.monitoringService = monitoringService;
	}

	@GetMapping("/info")
	public ServiceInformation info() {
		return monitoringService.getServiceInformation();
	}

}
