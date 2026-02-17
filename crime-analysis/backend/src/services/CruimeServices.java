package com.jayanth.crime.service;

import com.jayanth.crime.model.CrimeRecord;
import com.opencsv.CSVReader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.util.*;

@Service
public class CrimeService {

    public List<CrimeRecord> processCSV(MultipartFile file) throws Exception {

        CSVReader reader = new CSVReader(
                new InputStreamReader(file.getInputStream())
        );

        List<String[]> rows = reader.readAll();
        List<CrimeRecord> records = new ArrayList<>();

        for (int i = 1; i < rows.size(); i++) {
            String[] row = rows.get(i);
            String district = row[0];
            int value = Integer.parseInt(row[1]);
            records.add(new CrimeRecord(district, value));
        }

        records.sort((a, b) -> b.getValue() - a.getValue());

        return records.subList(0, Math.min(10, records.size()));
    }
}
