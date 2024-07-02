package com.example.NBP.Controllers;

import com.example.NBP.Models.Gold;
import com.example.NBP.Models.ResponseNBP;
import com.example.NBP.Services.NbpService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("nbpApi/")
public class NbpController{
    private final NbpService nbpService;

    public NbpController(NbpService nbpService)
    {
        this.nbpService = nbpService;
    }


    @Operation(summary = "Get exchange rate", description = "Get the average exchange rate for gold with date range")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse(responseCode = "400", description = "Limit extended", content = @Content),
            @ApiResponse(responseCode = "404", description = "Data not found bad date range or currecny",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Application error", content = @Content)
    })

    @GetMapping("/get/{startDate}/{endDate}")
    public ResponseNBP getAverageRate(
            @Parameter(description = "Start date (yyyy-MM-dd)") @PathVariable String startDate,
            @Parameter(description = "End date (yyyy-MM-dd)") @PathVariable String endDate) {
        LocalDate start = LocalDate.parse(startDate.trim(), DateTimeFormatter.ISO_DATE);
        LocalDate end = LocalDate.parse(endDate.trim(), DateTimeFormatter.ISO_DATE);
        return nbpService.getAverageGoldValue(start, end);
    }
}

