package co.com.ceiba.parkingtest.test.integracion.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import co.com.ceiba.adn.parking.ParkingApplication;
import co.com.ceiba.adn.parking.application.service.TicketService;
import co.com.ceiba.adn.parking.application.service.VehicleTypeService;
import co.com.ceiba.adn.parking.domain.model.Vehicle;
import co.com.ceiba.parkingtest.test.unitaria.databuilder.VehicleDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ParkingApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.yaml")
public class ParkingTicketControllerIntest {

	private static final String LICENCE_PLATE = "RQR45A";

	@Autowired
	private WebApplicationContext context;
	@Autowired
	TicketService service;
	@Autowired
	VehicleTypeService typeService;
	private MockMvc mockMvc;

	private Vehicle vehicle;
	private ObjectWriter objectWriter;

	@Before
	public void setUp() throws ParseException {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		VehicleDataBuilder vehicleBuilder = new VehicleDataBuilder().withVehicleType(2);
		vehicle = vehicleBuilder.build();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
	}

	@Test
	public void saveVehicleOut() throws Exception {
		mockMvc.perform(patch("/api/parking/outvehicle/" + LICENCE_PLATE).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isCreated());
	}

	@Test
	public void saveVehicleIn() throws Exception {
		String vehiculoJson = objectWriter.writeValueAsString(vehicle);
		mockMvc.perform(
				post("/api/parking/invehicle").contentType(MediaType.APPLICATION_JSON_UTF8).content(vehiculoJson))
				.andDo(print()).andExpect(status().isCreated());
	}
	
	public void listVehicles() throws Exception{
		mockMvc.perform(get("/api/parking/list").contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk());
	}

	
}
