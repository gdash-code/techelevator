package com.techelevator.services;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.model.CatFact;

@Component
public class RestCatFactService implements CatFactService {

	private static final String API_URL = "https://cat-fact.herokuapp.com/facts/random";
	private RestTemplate restTemplate = new RestTemplate();


        public CatFact getFact() throws RestClientResponseException {
        //CatFact catFact = restTemplate.getForObject(API_URL, CatFact.class);
        CatFact catFact = new CatFact();
        catFact.setText("If only the API was still alive");
        return catFact;
    }

}
