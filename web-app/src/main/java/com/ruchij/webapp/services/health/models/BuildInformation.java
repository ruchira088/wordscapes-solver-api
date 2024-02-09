package com.ruchij.webapp.services.health.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZonedDateTime;

@Component
public class BuildInformation {
	@Value("${git.build.version}")
	private String buildVersion;

	@Value("${git.commit.id.abbrev}")
	private String gitCommit;

	@Value("${git.branch}")
	private String gitBranch;

	@Value("${git.build.time}")
	private String buildTimestamp;

	public String getBuildVersion() {
		return buildVersion;
	}

	public String getGitCommit() {
		return gitCommit;
	}

	public String getGitBranch() {
		return gitBranch;
	}

	public String getBuildTimestamp() {
		return buildTimestamp;
	}
}
