package net.gw2state.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiFetchingClient {

    private final RestTemplate restTemplate;

    @Autowired
    public ApiFetchingClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String fetchData(String ApiEndpoint, String ApiKey) {
        try {
            return restTemplate.getForObject(ApiEndpoint + "?access_token=" + ApiKey, String.class);
        } catch (HttpClientErrorException exception) {
            System.err.println("Error fetching data from API: " + exception.getMessage());
            return null;
        }
    }
}
