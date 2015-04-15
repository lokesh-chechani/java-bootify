package demo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;




@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BootifySampleApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0") // "0" here has the special meaning here -- instruct Spring boot to scan the host environment and run the embeded we server on random available port.
///
public class BootifySampleApplicationTests {

	
	private RestTemplate restTemplate;
	private String url;
	
	@Value("${local.server.port}")
	private int port;
	
	
	
	@Before
	public void getReady(){
		restTemplate = new TestRestTemplate();
		url= "http://localhost:"+port+"/hello";
	}
	
	@Test
	public void testHello() {
		ResponseEntity<String> actualResponse = restTemplate.getForEntity(url, String.class);
		String expected = "Bootifying, Hello world!!";
		assertThat(actualResponse.getBody(), is(expected));
	}
	
	@Test
	@Ignore
	public void testFailure() {
		ResponseEntity<String> actualResponse = restTemplate.getForEntity(url, String.class);
		String expected = "Bootifying, bye bye world!!";
		assertThat(actualResponse.getBody(), is(expected));
	}

}
