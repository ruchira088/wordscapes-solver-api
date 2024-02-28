package com.ruchij.webapp.services.health;

import com.ruchij.webapp.services.health.models.ServiceInformation;

public interface MonitoringService {
	ServiceInformation getServiceInformation();
}
