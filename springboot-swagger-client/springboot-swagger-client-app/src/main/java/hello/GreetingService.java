package hello;

import hello.swagger.api.GreetingControllerApi;
import hello.swagger.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Autowired
    private GreetingControllerApi greetingControllerApi;

    public Greeting greeting(String name) {
        return greetingControllerApi.greetingUsingGET(name);
    }
}
