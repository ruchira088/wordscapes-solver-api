package com.ruchij.webapp.services.health.models;

import java.time.Instant;

public record ServiceInformation(
	String serviceName,
	String serviceVersion,
	Instant currentTimestamp,
	String javaVersion,
	String gitBranch,
	String gitCommit,
	String buildTimestamp
) {
}
