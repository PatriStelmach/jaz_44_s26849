package com.example.NBP.Services;

import com.example.NBP.Models.GoldValue;
import com.example.NBP.Models.Gold;
import com.example.NBP.Models.Rate;
import com.example.NBP.Models.ResponseNBP;
import com.example.NBP.NbpRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Service
public class NbpService {

    private final RestTemplate restTemplate;
    private final NbpRepository nbpRepository;

    public NbpService(RestTemplate restTemplate, NbpRepository nbpRepository) {
        this.restTemplate = restTemplate;
        this.nbpRepository = nbpRepository;

    }

    public ResponseNBP getAverageGoldValue(LocalDate dateStartS, LocalDate dateEndS)
    {
        String nbpApiUrl = String.format( "http://api.nbp.pl/api/cenyzlota/%s/%s", dateStartS, dateEndS);
        ResponseNBP response = restTemplate.getForObject(nbpApiUrl,ResponseNBP.class);
        response.setAvgRate(calculateAvgRate(response));

        Gold gold = Gold.GOLD;
        GoldValue goldValue = new GoldValue(null, gold, dateStartS, dateEndS, response.getAvgRate(), Instant.now());
        nbpRepository.save(goldValue);

        return response;
    }

    public double calculateAvgRate(ResponseNBP response) {
        List<Rate> rates = response.getRates();
        if (rates == null || rates.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (Rate rate : rates) {
            sum += rate.getCena();
        }
        return sum / rates.size();
    }




}
