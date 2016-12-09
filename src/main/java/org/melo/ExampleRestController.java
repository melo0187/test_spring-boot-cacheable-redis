package org.melo;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Created by CSCOLLO on 28.11.2016.
 */
@RestController
public class ExampleRestController {

    private HashMap<String, String> map = new HashMap<>();

    public ExampleRestController() {
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");
    }

    @Cacheable(cacheNames = "Values", key="#key")
    @RequestMapping(method = RequestMethod.GET)
    public String getValueByKey(@RequestParam(name = "key") String key) {
        System.out.println(String.format("Cache miss for key %1$s", key));
        return map.get(key);
    }
}
