package ru.hakaton;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import lombok.RequiredArgsConstructor;
import ru.hakaton.service.ExcelService;

@RestController
@RequestMapping("/v1/excel")
@RequiredArgsConstructor
public class ExcelController {

    private final ExcelService service;

    @PreAuthorize("permitAll()")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void importExcel(@RequestParam MultipartFile file) throws IOException {
        var byteArrayInputStream = new ByteArrayInputStream(file.getBytes());
        service.importDataFromExcel(byteArrayInputStream);
    }
}
