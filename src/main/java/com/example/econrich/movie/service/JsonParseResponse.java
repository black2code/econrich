package com.example.econrich.movie.service;

import com.example.econrich.global.error.ErrorCode;
import com.example.econrich.global.exception.CustomException;
import com.example.econrich.movie.dto.BoxOfficeResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JsonParseResponse {

    public List<BoxOfficeResponse> parseResponse(String responseBody) {
        List<BoxOfficeResponse> boxOfficeResponses = new ArrayList<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(responseBody);

            JsonNode boxOfficeResultNode = rootNode.get("boxOfficeResult");
            JsonNode dailyBoxOfficeList = boxOfficeResultNode.get("dailyBoxOfficeList");

            for (JsonNode movieNode : dailyBoxOfficeList) {
                String movieNm = movieNode.get("movieNm").asText();
                String openDt = movieNode.get("openDt").asText();
                String audiAcc = movieNode.get("audiAcc").asText();

                BoxOfficeResponse boxOfficeResponse = new BoxOfficeResponse(movieNm, openDt, audiAcc);
                boxOfficeResponses.add(boxOfficeResponse);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(ErrorCode.ERROR_PARSING_JSON_RESPONSE);
        }

        return boxOfficeResponses;
    }
}
