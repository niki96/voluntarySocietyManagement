package trn.logistics.knapsack.exporter;

import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.datatable.DataTable;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.springframework.stereotype.Component;
import trn.logistics.knapsack.dto.KnapsackSolution;
import trn.logistics.knapsack.dto.Vehicle;

import java.io.IOException;

@Component
@Slf4j
public class PdfExporter {

    public PDDocument createPdfFromKnapsack(KnapsackSolution kns) throws IOException {

        PDDocument mainDocument = new PDDocument();
        for (Vehicle vehicle : kns.getSelectedVehicles()) {
            PDPage myPage = new PDPage(PDRectangle.A4);
            //TODO add VEHICLE details to PDF
            //TODO Change Table to table with header

            BaseTable dataTable = createBaseTable(myPage, mainDocument);

            DataTable myTable = new DataTable(dataTable, myPage);
                myTable.addListToTable(vehicle.getContainedElementsListForPDF(), DataTable.NOHEADER);
                dataTable.draw();

            mainDocument.addPage(myPage);

            mainDocument.save(kns.getName() + ".pdf");

        }
        return mainDocument;
    }

    private BaseTable createBaseTable(PDPage myPage, PDDocument doc) throws IOException {
        float margin = 50;
        // starting y position is whole page height subtracted by top and bottom margin
        float yStartNewPage = myPage.getMediaBox().getHeight() - (2 * margin);
        // we want table across whole page width (subtracted by left and right margin ofcourse)
        float tableWidth = myPage.getMediaBox().getWidth() - (2 * margin);


        float yStart = yStartNewPage;
        float bottomMargin = 70;

        return new BaseTable(yStart, yStartNewPage, bottomMargin, tableWidth, margin, doc, myPage, true, true);
    }
}
