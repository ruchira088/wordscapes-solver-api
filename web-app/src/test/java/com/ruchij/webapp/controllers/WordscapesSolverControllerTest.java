package com.ruchij.webapp.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WordscapesSolverController.class)
class WordscapesSolverControllerTest {
	private static final String EXPECTED_JSON =
		"[\"moved\",\"demo\",\"dome\",\"dove\",\"mode\",\"move\",\"doe\",\"mod\",\"ode\",\"do\",\"em\",\"me\"]";

	@Autowired
	private MockMvc mvc;

	@Test
	void shouldReturnPossibleSolutionsForQueryParameters() throws Exception {
		MockHttpServletRequestBuilder requestBuilder =
			MockMvcRequestBuilders.get("/solver").queryParam("chars", "o", "m", "d", "e", "v");

		mvc.perform(requestBuilder)
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(content().json(EXPECTED_JSON, true));
	}

	@Test
	void shouldReturnPossibleSolutionsForPathParameter() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/solver/moved"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(content().json(EXPECTED_JSON, true));
	}

}