package com.ltp.gradesubmission;

import com.ltp.gradesubmission.Grade.GradeController;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
// Setup Class to run Integration Tests
@SpringBootTest
@AutoConfigureMockMvc // register MockMvc bean with default configurations
class GradeSubmissionApplicationTests {

	// Mock web requests to test various endpoints, Inject mockMvc into Spring Container
	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
		assertNotNull(mockMvc);
	}

	@Test
	public void showGradeFormTest() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/add");
		mockMvc.perform(request).andExpect(status().is2xxSuccessful())
			.andExpect(view().name("form"))
			.andExpect(model().attributeExists("grade"));
	}

	@Test
	public void showGradesTest() throws Exception {
		// build a mock request
		RequestBuilder request = MockMvcRequestBuilders.get("/grades");
		// perform the request and check for a status of 200 SUCCESS
		mockMvc.perform(request).andExpect(status().is2xxSuccessful())
			// expect the appropriate template view
			.andExpect(view().name("grades"))
			// expect the right model
			.andExpect(model().attributeExists("grades"));
	}

	@Test  // Test post request
	public void SuccessfulSubmissionTest() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.post("/addGrade")
				.param("name","James")
				.param("subject", "P.E")
				.param("score", "C-");
		mockMvc.perform(request)
			.andExpect(status().is3xxRedirection())
			.andExpect(redirectedUrl("/grades"));
	}

	@Test // Test post request for unsuccessful grade submissions
	public void  UnsuccessfulSubmissionTest() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.post("/addGrade")
			.param("name", "")
			.param("subject", "")
			.param("score", "");
		mockMvc.perform(request)
			.andExpect(status().is2xxSuccessful())
			.andExpect(view().name("form"));
	}
}
