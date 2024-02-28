package com.ruchij.webapp.services.health;

import com.ruchij.webapp.services.health.models.BuildInformation;
import com.ruchij.webapp.services.health.models.ServiceInformation;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.util.Properties;

@Service
public class MonitoringServiceImpl implements MonitoringService {
	private final String serviceName = "wordscapes-solver-api";
	private final String serviceVersion;
	private final String javaVersion;
	private final String gitBranch;
	private final String gitCommit;
	private final String buildTimestamp;

	private final Clock clock;

	public MonitoringServiceImpl(BuildInformation buildInformation, Properties properties, Clock clock) {
		this.serviceVersion = buildInformation.getBuildVersion();
		this.gitBranch = buildInformation.getGitBranch();
		this.gitCommit = buildInformation.getGitCommit();
		this.javaVersion = properties.getProperty("java.version", "unknown");
		this.buildTimestamp = buildInformation.getBuildTimestamp();
		this.clock = clock;
	}

	@Override
	public ServiceInformation getServiceInformation() {
		return new ServiceInformation(
			serviceName,
			serviceVersion,
			clock.instant(),
			javaVersion,
			gitBranch,
			gitCommit,
			buildTimestamp
		);
	}

}
