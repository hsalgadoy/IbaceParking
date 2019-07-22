package co.com.ceiba.parkingtest.test.integracion.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import co.com.ceiba.adn.parking.domain.model.Vehicle;
import co.com.ceiba.parkingtest.test.unitaria.databuilder.VehicleDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ParkingApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.yaml")
public class VehicleControllerIntTest {

	public static final String LISENCE_PLATE="RQG72E";
	public static final String LISENCE_PLATE_OPTIONAL="RQR45A";
	public static final int TYPE = 1;
	public static final long DISPLACEMENT=200;
	
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	private Vehicle vechile;
	private ObjectWriter objectWriter;
	
	
	@Before
	public void setUp() {
		mockMvc= MockMvcBuilders.webAppContextSetup(context).build();
		VehicleDataBuilder vehicleDataBuilder = new VehicleDataBuilder().withDisplacement(DISPLACEMENT).withLicensePlate(LISENCE_PLATE).withVehicleType(TYPE);
		vechile=vehicleDataBuilder.build();
		ObjectMapper objectMapper= new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
				
	}
	
	
	@Test
	public void saveVehicle() throws Exception{
		String vehicleJson = objectWriter.writeValueAsString(vechile);
		mockMvc.perform(post("/api/vehicle").contentType(MediaType.APPLICATION_JSON_UTF8).content(vehicleJson))
		.andDo(print()).andExpect(status().isCreated());
	}
	
	@Test
	public void vehicleByLicencePlate() throws Exception {
		mockMvc.perform(get("/api/vehicle/" + LISENCE_PLATE).contentType(MediaType.APPLICATION_JSON_UTF8)).andDo(print()).andExpect(status().isOk());
	}
}
