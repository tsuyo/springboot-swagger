package hello;

import hello.swagger.api.GreetingControllerApi;
import hello.swagger.invoker.ApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GreetingConfig {

    private String basePath = "http://localhost:8080";

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public GreetingControllerApi greetingControllerApi() {
        return new GreetingControllerApi(apiClient());
    }

    @Bean
    public ApiClient apiClient() {
        return new ApiClient().setBasePath(basePath);
    }
}
