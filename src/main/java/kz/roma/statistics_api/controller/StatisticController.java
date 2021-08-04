package kz.roma.statistics_api.controller;

import kz.roma.statistics_api.dao.StatisticsRepo;
import kz.roma.statistics_api.dto.StatisticDto;
import kz.roma.statistics_api.dto.StockGateWayDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatisticController {
    @Autowired
    StatisticsRepo statisticsRepo;

    //Actual statistics on received message during the day

    @GetMapping(value = "v1/PLAZA-2/total-statistics/actual")
    public ResponseEntity<List<StatisticDto>> readActualStats() {
        List<StatisticDto> statisticDtoList = statisticsRepo.findActualTotal();
        return statisticDtoList != null && !statisticDtoList.isEmpty()
                ? new ResponseEntity<>(statisticDtoList, HttpStatus.OK)
                : new ResponseEntity<>(statisticDtoList, HttpStatus.NOT_FOUND);
    }

    // Information about all gateways and stocks

    @GetMapping(value = "v1/trader-office/stocks-gateways")
    public ResponseEntity<List<StockGateWayDto>> readStocksGateWay() {
        List<StockGateWayDto> stockGateWayDtoList = statisticsRepo.findStockGateway();
        return stockGateWayDtoList != null && !stockGateWayDtoList.isEmpty()
                ? new ResponseEntity<>(stockGateWayDtoList, HttpStatus.OK)
                : new ResponseEntity<>(stockGateWayDtoList, HttpStatus.NOT_FOUND);
    }


}
