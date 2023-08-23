package com.example.econrich.movie.dto;

import lombok.Getter;

@Getter
public class BoxOfficeResponse {
    private String movieNm;
    private String openDt;      // 영화의 개봉일
    private String audiAcc;     // 누적 관객수

    public BoxOfficeResponse(String movieNm, String openDt, String audiAcc){
        this.movieNm = movieNm;
        this.openDt = openDt;
        this.audiAcc = audiAcc;
    }
}
