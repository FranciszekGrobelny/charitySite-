package pl.coderslab.charity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;
import pl.coderslab.charity.model.Institution;

import java.net.URI;

@SpringBootApplication
public class CharityApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CharityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//            RestTemplate restTemplate = new RestTemplate();
//            restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor("a@a.pl", "admin"));
//            Institution institution = restTemplate.getForObject(URI.create("http://localhost:8080/api/institutions/4"), Institution.class);
//            System.out.println(institution.getDescription());


    }
}