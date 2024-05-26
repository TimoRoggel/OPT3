package org.freezer;

import javax.print.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PrinterManager {
    private static final String PRODUCT_FILE_PATH = "producten.txt";

    // Methode om de productenlijst af te drukken
    public void printProductList() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(PRODUCT_FILE_PATH));
            StringBuilder sb = buildPrintableProductList(lines);
            print(sb.toString());
        } catch (IOException | PrintException e) {
            System.err.println(" " + e.getMessage());
        }
    }

    private StringBuilder buildPrintableProductList(List<String> lines) {
        StringBuilder sb = new StringBuilder();
        sb.append("Productenlijst:\n");
        for (String line : lines) {
            addFormattedProductInfo(sb, line);
        }
        return sb;
    }

    private void addFormattedProductInfo(StringBuilder sb, String line) {
        String[] parts = line.split(", ");
        if (parts.length >= 3) {
            String id = parts[0].split(": ")[1];
            String naam = parts[1].split(": ")[1];
            String datum = parts[2].split(": ")[1];
            sb.append(String.format("ID: %-8s Naam: %-20s Datum: %-20s\n", id, naam, datum));
        }
    }

    private void print(String printableText) throws PrintException {
        PrintService service = PrintServiceLookup.lookupDefaultPrintService();
        if (service != null) {
            DocPrintJob job = service.createPrintJob();
            InputStream is = new ByteArrayInputStream(printableText.getBytes());
            Doc doc = new SimpleDoc(is, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
            job.print(doc, null);
        } else {
            System.err.println("Geen printservices gevonden.");
        }
    }
}
