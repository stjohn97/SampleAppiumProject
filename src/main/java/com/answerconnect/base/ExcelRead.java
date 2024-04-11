package com.answerconnect.base;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelRead {
    private static final Logger logger = LoggerFactory.getLogger(ExcelRead.class);
    private static final String SPREADSHEET_ID = "1AeovIrXxTeV4wBoFnJldyNndgq8PgzR_LGqqMhON7UI";
    private static final String CREDENTIALS_FILE_PATH = "/Users/stefan/Desktop/AppiumContainerChange/bc-mobile-419913-942485138aeb.json";
    private static final String APPLICATION_NAME = "AnswerConnect";
    private static final List<String> SCOPES = Arrays.asList(SheetsScopes.SPREADSHEETS_READONLY);
    private static final List<String> RELEVANT_SHEET_IDS = Arrays.asList("578466460", "1611756632", "2059695331", "63379492", "577482265", "1417484212");

    private static Sheets sheetsService;
    private static final Map<String, String> dataCache = new HashMap<>();

    static {
        try {
            sheetsService = getSheetsService();
        } catch (IOException | GeneralSecurityException e) {
            logger.error("Error initializing Google Sheets connection: {}", e.getMessage(), e);
        }
    }

    private static Sheets getSheetsService() throws IOException, GeneralSecurityException {
        logger.debug("Credentials file path: {}", CREDENTIALS_FILE_PATH);
        InputStream in = new FileInputStream(CREDENTIALS_FILE_PATH);
        logger.debug("Credentials file loaded"); // Add this line

        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(GsonFactory.getDefaultInstance(), new InputStreamReader(in));
        logger.debug("Client secrets loaded");
        Credential credential = new GoogleCredential.Builder()
                .setTransport(GoogleNetHttpTransport.newTrustedTransport())
                .setJsonFactory(GsonFactory.getDefaultInstance())
                .setClientSecrets(clientSecrets)
                .build()
                .createScoped(SCOPES);

        return new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(), GsonFactory.getDefaultInstance(), credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }


    private static String searchSheetsForKey(String key) throws IOException, GeneralSecurityException {
        String range = "A1:B"; // Update this with the range within your specific sheet

        for (String sheetId : RELEVANT_SHEET_IDS) {
            ValueRange response = sheetsService.spreadsheets().values()
                    .get(SPREADSHEET_ID, sheetId + "!" + range)
                    .execute();

            List<List<Object>> values = response.getValues();
            if (values == null || values.isEmpty()) {
                continue; // Skip to next sheet if no data
            }

            for (List row : values) {
                if (row.size() >= 2 && row.get(0).toString().equals(key)) {
                    return row.get(1).toString(); // Value found
                }
            }
        }
        return null;
    }

    public static String getData(String key) {
        String value = dataCache.get(key);
        if (value == null) {
            try {
                value = searchSheetsForKey(key);
                if (value != null) {
                    dataCache.put(key, value);
                } else {
                    return ""; // Or any default value you prefer
                }
            } catch (IOException | GeneralSecurityException e) {
                logger.error("Error fetching data: {}", e.getMessage());
                return ""; // Or a default value
            }
        }
        return value;
    }

}
