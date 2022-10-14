package com.ltp.contacts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ltp.contacts.pojo.Contact;
import com.ltp.contacts.repository.ContactRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest
@AutoConfigureMockMvc
class ContactsApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private ObjectMapper objectMapper;


	private Contact[] contacts = new Contact[] {
		new Contact("1", "Jon Snow", "123-123-1234"),
		new Contact("2", "Eminem", "123-123-1234"),
		new Contact("1", "Bruno Mars", "123-123-1234")
	};

	@BeforeEach
	void setup() {
		for(int i = 0; i < contacts.length; i++) {
			contactRepository.saveContact(contacts[i]);
		}
	}

	@AfterEach
	void clear() {
		contactRepository.getContacts().clear();
	}





	@Test
	void contextLoads() {
		assertNotNull(mockMvc);
	}

	@Test
	void getContacts() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/contacts/all");
		mockMvc.perform(request).andExpect(status().is2xxSuccessful())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.size()").value(contacts.length));
	}

	@Test
	public void getContactsByIdTest() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/contact/1");
		mockMvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.name").value(contacts[0].getName()))
			.andExpect(jsonPath("$.phoneNumber").value(contacts[0].getPhoneNumber()));
	}

	@Test
	public void contactNotFoundTest() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/contacts/64");
		mockMvc.perform(request)
			.andExpect(status().isNotFound());
	}

	@Test
	public void validContactCreation() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.post("/contacts/add")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(new Contact("Adele", "123-123-4321")));
		mockMvc.perform(request)
			.andExpect(status().isCreated());
	}

	@Test
	public void invalidContactCreationTest() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.post("/contacts/add")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(new Contact("", "")));
		mockMvc.perform(request)
			.andExpect(status().isBadRequest());
	}


}
