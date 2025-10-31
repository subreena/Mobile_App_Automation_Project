package config;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SeriesDatasetCSV {
    @DataProvider(name="SeriesDatasetCSV")
    public Object[][] getCSVData() throws IOException {
        String CSVFilepath = "./src/test/resources/series.csv";
        List<Object[]> data = new ArrayList<>();
                CSVParser csvParser = new CSVParser(new FileReader(CSVFilepath), CSVFormat.DEFAULT.withFirstRecordAsHeader());
                for (CSVRecord csvRecord: csvParser){
                    String expression = csvRecord.get("expression");
                    String expected = csvRecord.get("expected_answer");
                    data.add(new Object[]{expression,expected});
                }
                return data.toArray(new Object[0][]);
    }
}
