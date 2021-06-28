package com.techelevator.services;

import org.springframework.stereotype.Component;

import com.techelevator.model.CatFact;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatFactService implements CatFactService {

	public static final String FACT_URL = "https://alexwohlbruck.github.io/cat-facts/docs/endpoints/facts.html";
	private final RestTemplate restTemplate = new RestTemplate();

	@Override
	public CatFact getFact() {
		CatFact catFact = null;
		try {
			catFact = restTemplate.getForObject(FACT_URL, CatFact.class);
		} catch (RestClientException ex) {
			System.out.println(ex.getRawStatusCode() + " : " + ex.getStatusText());
		} catch (ResourceAccessException)
		return null;
	}

}
