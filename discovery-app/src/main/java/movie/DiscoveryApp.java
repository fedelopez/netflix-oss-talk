package movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class DiscoveryApp {

    public DiscoveryApp(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    private final RestTemplate restTemplate;

    @GetMapping("/topgrossing/{year}")
    String getTopGrossingMovie(@PathVariable Integer year) {
        URI uri = UriComponentsBuilder.fromUriString("//resilient-movie-app/movies/" + year).build().toUri();
        return restTemplate.getForObject(uri, String.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryApp.class, args);
    }
}

