package dat3.adventurexp.api;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;


//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ActivityControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetActivitiesEndpoint() {
        port = 9003;
        // Arrange

        // Act
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/activities", String.class);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        // Add more assertions as needed
    }

    // Write more tests for other endpoints as needed
}
