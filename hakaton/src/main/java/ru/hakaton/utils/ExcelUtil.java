package ru.hakaton.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.NumberToTextConverter;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ExcelUtil {

    public static String getStringValue(Cell cell) {
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC ->
                DateUtil.isCellDateFormatted(cell)
                        ? String.valueOf(cell.getLocalDateTimeCellValue())
                        : NumberToTextConverter.toText(cell.getNumericCellValue());
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            case FORMULA -> cell.getCellFormula();

            default -> "";
        };
    }
}
