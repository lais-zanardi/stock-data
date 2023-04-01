package zanardil;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RequiredArgsConstructor
@Component
public class AlphaVantageAPIClient {
    private final static String ENDPOINT = "http://{host}:{port}/api/alpha-vantage/{symbol}";
    private final EurekaClient eurekaClient;
    private final RestTemplate restTemplate;

    public boolean isAvaiable(String symbol) {
        InstanceInfo apiInstanceInfo = eurekaClient
                .getApplication("alpha-vantage-api")
                .getInstances()
                .stream()
                .findAny()
                .orElseThrow(() -> {
                    return new WebApplicationException("Alpha Vantage service is unavaiable", new Throwable() ,Response.Status.SERVICE_UNAVAILABLE);
                });

        return restTemplate
                .getForEntity(ENDPOINT, String.class, apiInstanceInfo.getHostName(), apiInstanceInfo.getPort(), symbol)
                .getStatusCode()
                .is2xxSuccessful();
    }
}

