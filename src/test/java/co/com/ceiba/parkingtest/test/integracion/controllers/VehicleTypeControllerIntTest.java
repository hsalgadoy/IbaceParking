package co.com.ceiba.parkingtest.test.integracion.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import co.com.ceiba.adn.parking.ParkingApplication;
import co.com.ceiba.adn.parking.domain.model.Vehicle;
import co.com.ceiba.adn.parking.domain.model.VehicleType;
import co.com.ceiba.parkingtest.test.unitaria.databuilder.VehicleDataBuilder;
import co.com.ceiba.parkingtest.test.unitaria.databuilder.VehicleTypeDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ParkingApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.yaml")
public class VehicleTypeControllerIntTest {

	public static final int TYPE_ID = 3;
	public static final int MOTO_ID = 1;
	public static final String TYPE_DESC = "Bicicleta";
	public static final long DAY_PRICE = 2000;
	public static final long HOUR_PRICE = 200;

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;
	private VehicleType type;
	private ObjectWriter objectWriter;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		VehicleTypeDataBuilder typeBuilder = new VehicleTypeDataBuilder().withDayValue(DAY_PRICE)
				.withDisplacementCost(0).withHourValue(HOUR_PRICE).withIdVehicleType(TYPE_ID).withParkingSpace(20)
				.withSpaceAviable(20);
		type = typeBuilder.build();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
	}

	@Test
	public void saveType() throws Exception {
		String tipoJson = objectWriter.writeValueAsString(type);
		mockMvc.perform(post("/api/type").contentType(MediaType.APPLICATION_JSON_UTF8).content(tipoJson)).andDo(print())
				.andExpect(status().isCreated());
	}

	
		
	
}
