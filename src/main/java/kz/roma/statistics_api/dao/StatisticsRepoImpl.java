package kz.roma.statistics_api.dao;

import kz.roma.statistics_api.dto.StatisticDto;
import kz.roma.statistics_api.dto.StockGateWayDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class StatisticsRepoImpl implements StatisticsRepo {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    String SQL_STOCK_GATEWAY_INFO = "SELECT st.name, st.short_name, " +
            "gw.gate_way_name,  gw.version " +
            "FROM gate_way AS gw " +
            "JOIN stocks AS st " +
            "on gw.stock_id=st.id";

    String SQL_TOTAL_STATISTICS_ACTUAL = "SELECT gt.`gate_way_name`, " +
            "COUNT(st.`object_row_id`), mt.`message_name` " +
            "FROM Statistics AS st " +
            "JOIN gate_way AS gt " +
            "ON gt.`id`= st.`gate_way_id` " +
            "JOIN message_type AS mt " +
            "ON st.`message_id`=mt.`id` " +
            "WHERE DATE(st.`downloaded`)=CURDATE() " +
            "GROUP BY mt.`message_name`";

    @Override
    public List<StatisticDto> findActualTotal() {
        return namedParameterJdbcTemplate.query(SQL_TOTAL_STATISTICS_ACTUAL, (rs, rowNum) ->
                new StatisticDto(rs.getString("mt.message_name"), rs.getString("gt.gate_way_name"),
                        rs.getInt("count(st.`object_row_id`)"), LocalDateTime.now()));
    }

    @Override
    public List<StockGateWayDto> findStockGateway() {
        return namedParameterJdbcTemplate.query(SQL_STOCK_GATEWAY_INFO, (rs, rowNum)->
        new StockGateWayDto(rs.getString("st.name"), rs.getString("st.short_name"),
                            rs.getString("gw.gate_way_name"), rs.getString("gw.version")));
    }
}
