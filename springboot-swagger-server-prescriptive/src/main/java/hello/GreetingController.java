package hello;

import io.swagger.annotations.ApiParam;
import io.swagger.api.GreetingApi;
import io.swagger.model.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController implements GreetingApi {

    private static final String template = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();

    private static final Logger log = LoggerFactory.getLogger(GreetingController.class);

    @Override
    public ResponseEntity<Greeting> greetingUsingDELETE(String name) {
        return null;
    }

    @Override
    @RequestMapping("/greeting") // DO NOT REMOVE THIS - GreetingApi only accepts application/json
    public ResponseEntity<Greeting> greetingUsingGET(@ApiParam(value = "name", defaultValue = "World") @Valid @RequestParam(value = "name", required = false, defaultValue="World") String name) {
        return new ResponseEntity<Greeting>(new Greeting()
                .id(counter.incrementAndGet())
                .content(String.format(template, name)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Greeting> greetingUsingHEAD(String name) {
        return null;
    }

    @Override
    public ResponseEntity<Greeting> greetingUsingOPTIONS(String name) {
        return null;
    }

    @Override
    public ResponseEntity<Greeting> greetingUsingPATCH(String name) {
        return null;
    }

    @Override
    public ResponseEntity<Greeting> greetingUsingPOST(String name) {
        return null;
    }

    @Override
    public ResponseEntity<Greeting> greetingUsingPUT(String name) {
        return null;
    }

}