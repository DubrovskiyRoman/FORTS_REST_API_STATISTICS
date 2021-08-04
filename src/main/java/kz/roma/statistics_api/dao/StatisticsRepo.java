package kz.roma.statistics_api.dao;

import kz.roma.statistics_api.dto.StatisticDto;
import kz.roma.statistics_api.dto.StockGateWayDto;

import java.util.List;

public interface StatisticsRepo {
    List<StatisticDto> findActualTotal();
    List<StockGateWayDto> findStockGateway();
}
