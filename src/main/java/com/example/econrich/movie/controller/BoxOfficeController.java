package com.example.econrich.movie.controller;

import com.example.econrich.global.dto.GlobalResponse;
import com.example.econrich.movie.dto.BoxOfficeResponse;
import com.example.econrich.movie.service.BoxOfficeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/boxoffice")
public class BoxOfficeController {

    private final BoxOfficeService boxOfficeService;

    @GetMapping("/search")
    @Operation(summary = "공공데이터 해당 날짜의 박스 오피스 정보 조회 API")
    @Parameter(name = "targetDt", description = "날짜 입력, 오늘 날짜는 안됨, ex.20230822")
    @ApiResponse(responseCode = "200", description = "movieNm : 이름, openDt : 개봉일, audiAcc : 누적 관객수")
    public GlobalResponse searchBoxOffice(
            @RequestParam("targetDt") String targetDt) {

        List<BoxOfficeResponse> boxOfficeResponses =
                boxOfficeService.searchBoxOffice(targetDt);

        return GlobalResponse.success(boxOfficeResponses);
    }
}
