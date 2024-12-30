package utils;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.WriteApi;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;

public class InfluxDBUtil {
    private static final String TOKEN = "-79gfhpDzhFwC3f0XMkbvzxv_6-esZNboysj2TMFi4PQlnMWNSV8QbNU9OV46Ymy7a-tUY4BkVuBZS9L7aVi4w==";
    private static final String ORG = "demoblaze";
    private static final String BUCKET = "test_metrics";
    private static final String URL = "http://localhost:8086";

    private static InfluxDBClient influxDBClient;

    static {
        influxDBClient = InfluxDBClientFactory.create(URL, TOKEN.toCharArray(), ORG, BUCKET);
    }

    public static void writeMetric(String testName, long duration, boolean status) {
        Point point = Point.measurement("test_results")
            .addField("test_name", testName)
            .addField("duration_ms", duration)
            .addField("status", status ? "PASS" : "FAIL")
            .time(System.currentTimeMillis(), WritePrecision.MS);

        try (WriteApi writeApi = influxDBClient.getWriteApi()) {
            writeApi.writePoint(point);
        }
    }

    public static void close() {
        if (influxDBClient != null) {
            influxDBClient.close();
        }
    }
}
