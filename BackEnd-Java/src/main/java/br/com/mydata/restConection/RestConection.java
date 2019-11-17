package br.com.mydata.restConection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestConection{

	@Autowired
	private RestTemplate restTemplate;
	
	public Object post(String url, Object body, Object objetoDeResposta) {
		Object object = restTemplate.postForObject(url, body, objetoDeResposta.getClass());
		return object;
	}
}
