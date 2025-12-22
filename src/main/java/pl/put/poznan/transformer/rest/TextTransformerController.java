package pl.put.poznan.transformer.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.TextTransformer;
import java.util.Arrays;

@RestController
@RequestMapping("/") // Zmieniamy mapowanie bazowe, usuwamy {text} z poziomu klasy
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    @RequestMapping(path = "/{text}", method = RequestMethod.GET, produces = "application/json")
    public String get(@PathVariable String text,
                      @RequestParam(value="transforms", defaultValue="upper,escape") String[] transforms) {

        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        TextTransformer transformer = new TextTransformer(transforms);
        return "{\"result\": \"" + transformer.transform(text) + "\"}";
    }

    @RequestMapping(path = "/transform", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public TransformationResponse post(@RequestBody TransformationRequest request) {

        // log the parameters
        logger.debug(request.getText());
        logger.debug(Arrays.toString(request.getTransforms()));

        // perform the transformation, you should run your logic here, below is just a silly example
        TextTransformer transformer = new TextTransformer(request.getTransforms());
        String result = transformer.transform(request.getText());
        return new TransformationResponse(result);
    }
}