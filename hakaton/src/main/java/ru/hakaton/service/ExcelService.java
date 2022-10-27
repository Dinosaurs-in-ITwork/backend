package ru.hakaton.service;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.stream.StreamSupport;

import ru.hakaton.model.ApartmentDto;
import ru.hakaton.utils.ExcelUtil;

@Service
public class ExcelService {

    @Transactional
    public void importDataFromExcel(ByteArrayInputStream byteArrayInputStream) throws IOException {
        var workBook = new XSSFWorkbook(byteArrayInputStream);
        var sheet = workBook.getSheetAt(0);
        var rows = StreamSupport.stream(sheet.spliterator(), false).toList();


        rows
                .forEach(row -> {
                    if (row.getRowNum() == 4) {
                        var location = ExcelUtil.getStringValue(row.getCell(0));
                        var numberOfRooms = ExcelUtil.getStringValue(row.getCell(1));
                        var segment = ExcelUtil.getStringValue(row.getCell(2));
                        var numberOfHouseFloors = ExcelUtil.getStringValue(row.getCell(3));
                        var wallMaterial = ExcelUtil.getStringValue(row.getCell(4));
                        var floor = ExcelUtil.getStringValue(row.getCell(5));
                        var square = ExcelUtil.getStringValue(row.getCell(6));
                        var squareOfKitchen = ExcelUtil.getStringValue(row.getCell(7));
                        var balconyPresence = ExcelUtil.getStringValue(row.getCell(8));
                        var distanceFromMetro = ExcelUtil.getStringValue(row.getCell(9));
                        var repairStatus = ExcelUtil.getStringValue(row.getCell(10));

                        ApartmentDto.builder()
                                .location(location)
                                .numberOfRooms(Integer.valueOf(numberOfRooms))
                                .segment(segment)
                                .numberOfHouseFloors(Integer.valueOf(numberOfHouseFloors))
                                .wallMaterial(wallMaterial)
                                .floor(Integer.valueOf(floor))
                                .square(Double.valueOf(square))
                                .squareOfKitchen(Double.valueOf(squareOfKitchen))
                                .balconyPresence(Boolean.valueOf(balconyPresence))
                                .distanceFromMetroInMin(Integer.valueOf(distanceFromMetro))
                                .repairStatus(repairStatus);
                    }
                });
    }
}
