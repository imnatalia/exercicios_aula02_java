package service;

import java.lang.reflect.Field;
import java.util.List;

public class CsvExportService {
    public String exportToCsv(List<?> data) {
        StringBuilder csvBuilder = new StringBuilder();
        if (data == null || data.isEmpty()) {
            return csvBuilder.toString();
        }

        Field[] fields = data.get(0).getClass().getDeclaredFields();

        for (Field field : fields) {
            csvBuilder.append(field.getName()).append(",");
        }
        csvBuilder.setLength(csvBuilder.length() - 1);
        csvBuilder.append("\n");

        for (Object obj : data) {
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    Object value = field.get(obj);
                    csvBuilder.append(value != null ? value.toString() : "").append(",");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            csvBuilder.setLength(csvBuilder.length() - 1);
            csvBuilder.append("\n");
        }

        return csvBuilder.toString();
    }
}