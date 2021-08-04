package kz.roma.statistics_api.dto;

public class StockGateWayDto {
    private String stockName;
    private String stockShortName;
    private String gateWayName;
    private String gateWayVersion;

    public StockGateWayDto(String stockName, String stockShortName, String gateWayName, String gateWayVersion) {
        this.stockName = stockName;
        this.stockShortName = stockShortName;
        this.gateWayName = gateWayName;
        this.gateWayVersion = gateWayVersion;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getStockShortName() {
        return stockShortName;
    }

    public void setStockShortName(String stockShortName) {
        this.stockShortName = stockShortName;
    }

    public String getGateWayName() {
        return gateWayName;
    }

    public void setGateWayName(String gateWayName) {
        this.gateWayName = gateWayName;
    }

    public String getGateWayVersion() {
        return gateWayVersion;
    }

    public void setGateWayVersion(String gateWayVersion) {
        this.gateWayVersion = gateWayVersion;
    }

    @Override
    public String toString() {
        return "StockGateWayDto{" +
                "stockName='" + stockName + '\'' +
                ", stockShortName='" + stockShortName + '\'' +
                ", gateWayName='" + gateWayName + '\'' +
                ", gateWayVersion='" + gateWayVersion + '\'' +
                '}';
    }
}
