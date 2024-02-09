package com.ruchij.webapp.controllers;

import com.ruchij.webapp.services.health.HealthService;
import com.ruchij.webapp.services.health.models.ServiceInformation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/health", produces = MediaType.APPLICATION_JSON_VALUE)
public class HealthController {
	private final HealthService healthService;

	public HealthController(HealthService healthService) {
		this.healthService = healthService;
	}

	@GetMapping("/info")
	public ServiceInformation info() {
		return healthService.getServiceInformation();
	}

}
