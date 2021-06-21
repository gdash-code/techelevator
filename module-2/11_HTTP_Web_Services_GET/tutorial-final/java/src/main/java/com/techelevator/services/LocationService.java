package com.techelevator.services;

import com.techelevator.model.Location;
import org.springframework.web.client.RestTemplate;

public class LocationService {

    private String BASE_URL;
    private RestTemplate restTemplate = new RestTemplate();

    public LocationService(String url) {
        BASE_URL = url.lastIndexOf('/') == url.length() ? url : url + "/";
    }

    public Location[] getAll() {
        return restTemplate.getForObject(BASE_URL, Location[].class);
    }

    public Location getOne(int id) {
        return restTemplate.getForObject(BASE_URL + id, Location.class);
    }

}
