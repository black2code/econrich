package com.example.econrich.movie.service;

import com.example.econrich.movie.dto.BoxOfficeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class BoxOfficeService {

    private static final String API_KEY = "0b322b632916dd978fff1fa2ef00e186";
    private static final String API_URL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";

    private final RestTemplate restTemplate;
    private final JsonParseResponse jsonParseResponse;

    @Autowired
    public BoxOfficeService(RestTemplate restTemplate, JsonParseResponse jsonParseResponse) {
        this.restTemplate = restTemplate;
        this.jsonParseResponse = jsonParseResponse;
    }

    public List<BoxOfficeResponse> searchBoxOffice (String targetDt) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(API_URL)
                .queryParam("key", API_KEY)
                .queryParam("targetDt", targetDt);

        ResponseEntity<String> response = restTemplate.getForEntity(builder.toUriString(), String.class);
        String responseBody = response.getBody();
        System.out.println(responseBody);

        List<BoxOfficeResponse> boxOfficeResponses = jsonParseResponse.parseResponse(responseBody);
        return boxOfficeResponses;
    }

}
