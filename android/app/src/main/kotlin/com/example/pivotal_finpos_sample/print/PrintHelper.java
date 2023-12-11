package com.dynamictechnosoft.dynamic_erp.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.List;

import global.citytech.finpossmart.sdk.api.printer.PrintBase64Image;
import global.citytech.finpossmart.sdk.api.printer.PrintBitmap;
import global.citytech.finpossmart.sdk.api.printer.PrintMessage;
import global.citytech.finpossmart.sdk.api.printer.PrintRequest;
import global.citytech.finpossmart.sdk.api.printer.Printable;
import global.citytech.finpossmart.sdk.api.printer.Style;
import com.dynamictechnosoft.dynamic_erp.print.PrintDataModel;

import com.dynamictechnosoft.dynamic_erp.R;

/**
 * Created by BikashShrestha on 4/16/19.
 */
public class PrintHelper {

    public static PrintRequest preparePrintRequest(Context context,PrintDataModel printData ) {
        List<Printable> printMessages = new ArrayList<>();
        addPrintContent(printMessages, context, printData);

        // Fonts fonts = new Fonts("assets/Nexa-Book.ttf", "app/src/main/kotlin/com/dynamictechnosoft/pivotal_erp/print/assets/Nexa-Book.ttf", Fonts.FontSource.ASSET);

        //     PrintRequest printRequest = PrintRequest.Builder.newInstance(printMessages)
        //     .setFont(fonts)
        //     .setFeedPaperAfterPrinting(true)
        //     .build();
        //     return printRequest;
        return new PrintRequest (printMessages);
    }

    private static void addPrintContent(List<Printable> printables, Context context,PrintDataModel printData  ) {
        // printables.add(PrintMessage.getInstance("### Image Printing ###", SampleReceiptStyle.NORMAL.getStyle()));
        // Bitmap icon = BitmapFactory.decodeResource(context.getResources(), R.drawable.receipt_header_citytech);
        // printables.add(PrintBitmap.getInstance(icon));
        // String invoiceType = invoiceType; 
        String invoiceType = printData.invoiceType;
        String companyName = printData.companyName;
        String companyAddress = printData.companyAddress;
        String companyPanVat = printData.companyPanVat;
        String invoiceDate = printData.invoiceDate;
        String invoiceNo = printData.invoiceNo;
        String customerName = printData.customerName;
        String customerAddress = printData.customerAddress;
        String panVat = printData.panVat;
        String mobileNo = printData.mobileNo;
        String couponNo = printData.couponNo;
        String vehicleNo = printData.vehicleNo;
        String itemName = printData.itemName;
        String itemQuantity = printData.itemQuantity;
        String itemRate = printData.itemRate;
        String itemAmount = printData.itemAmount;
        String grossAmount = printData.grossAmount;
        String discount = printData.discount;
        String taxAmount = printData.taxAmount;
        String nonTaxAmount = printData.nonTaxAmount;
        String vatRate = printData.vatRate;
        String vat = printData.vat;
        String grandTotal = printData.grandTotal;
        String printDate = printData.printDate;
        String preparedBy = printData.preparedBy;
        String copyOfInvoice = printData.copyOfInvoice;
        String poweredBy = printData.poweredBy;
        String qrMessage = printData.qrMessage;
        String paymentMethods = printData.paymentMethods;
        String horizontalLine = "-------------------------------------------------------------------------------";
        List<String> titles = new ArrayList<String>() {{
            add("Item");
            add("QTY");
            add("Rate");
            add("Amount");
        }};
        List<String> rows = new ArrayList<String>() {{
                add(itemName);
                add(itemQuantity);
                add(itemRate);
                add(itemAmount);
            }};
        printables.add(PrintMessage.getInstance("", SampleReceiptStyle.NORMAL.getStyle()));

        // printables.add(PrintMessage.getInstance("### Single Text Printing ###", SampleReceiptStyle.NORMAL.getStyle()));
        printables.add(PrintMessage.getInstance(invoiceType, SampleReceiptStyle.LARGE.getStyle()));
        printables.add(PrintMessage.getInstance(companyName, SampleReceiptStyle.LARGE.getStyle()));
        printables.add(PrintMessage.getInstance(companyAddress, SampleReceiptStyle.NORMAL_ITALIC_CENTER.getStyle()));
        printables.add(PrintMessage.getInstance(companyPanVat, SampleReceiptStyle.NORMAL_ITALIC_CENTER.getStyle()));

        printables.add(PrintMessage.getInstance(horizontalLine, SampleReceiptStyle.NORMAL_CENTER.getStyle()));

        printables.add(PrintMessage.getInstance("Date: "+ invoiceDate, SampleReceiptStyle.NORMAL.getStyle()));
        printables.add(PrintMessage.getInstance("Invoice No: "+ invoiceNo, SampleReceiptStyle.NORMAL.getStyle()));
        printables.add(PrintMessage.getInstance("Customer: "+ customerName, SampleReceiptStyle.NORMAL.getStyle()));
        printables.add(PrintMessage.getInstance("Address: "+ customerAddress, SampleReceiptStyle.NORMAL.getStyle()));
        printables.add(PrintMessage.getInstance("Pan/Vat: "+ panVat, SampleReceiptStyle.NORMAL.getStyle()));
        printables.add(PrintMessage.getInstance("Mobile No: "+ mobileNo, SampleReceiptStyle.NORMAL.getStyle()));
        printables.add(PrintMessage.getInstance("Coupon No: "+ couponNo, SampleReceiptStyle.NORMAL.getStyle()));
        printables.add(PrintMessage.getInstance("Vehicle No: "+ vehicleNo, SampleReceiptStyle.NORMAL.getStyle()));
        printables.add(PrintMessage.getInstance("Payment Methods: "+ paymentMethods, SampleReceiptStyle.NORMAL.getStyle()));
        printables.add(PrintMessage.getInstance("", SampleReceiptStyle.NORMAL.getStyle()));
        printables.add(PrintMessage.getInstance(horizontalLine, SampleReceiptStyle.NORMAL_CENTER.getStyle()));
        int[] columnWidths = {30, 20, 20, 30};
                printables.add(PrintMessage.getMultiColumnInstance(titles,columnWidths, SampleReceiptStyle.NORMAL_CENTER.getStyle()));

        printables.add(PrintMessage.getInstance(horizontalLine, SampleReceiptStyle.NORMAL_CENTER.getStyle()));
        // printables.add(PrintMessage.getDoubleColumnInstance("2022-02-03","05:59 PM", SampleReceiptStyle.SMALL.getStyle()));
                printables.add(PrintMessage.getMultiColumnInstance(rows,columnWidths, SampleReceiptStyle.NORMAL_CENTER.getStyle()));
        printables.add(PrintMessage.getInstance(horizontalLine, SampleReceiptStyle.NORMAL_CENTER.getStyle()));

        printables.add(PrintMessage.getInstance("", SampleReceiptStyle.NORMAL.getStyle()));
        // printables.add(PrintMessage.getDoubleColumnInstance("Address ","Kamaladi, Kathmandu", SampleReceiptStyle.SMALL.getStyle()));
        // printables.add(PrintMessage.getDoubleColumnInstance("Address ","Kamaladi, Kathmandu", SampleReceiptStyle.NORMAL.getStyle()));
        // printables.add(PrintMessage.getDoubleColumnInstance("-","Address: Kamaladi, Kathmandu", SampleReceiptStyle.SMALL.getStyle()));
        printables.add(PrintMessage.getDoubleColumnInstance("-","Gross Amount: "+ grossAmount , SampleReceiptStyle.NORMAL.getStyle()));
        printables.add(PrintMessage.getDoubleColumnInstance("-","Discount: "+discount , SampleReceiptStyle.NORMAL.getStyle()));
        printables.add(PrintMessage.getDoubleColumnInstance("-","Tax Amount: "+taxAmount , SampleReceiptStyle.NORMAL.getStyle()));
        printables.add(PrintMessage.getDoubleColumnInstance("-","Non Tax Amount: "+nonTaxAmount , SampleReceiptStyle.NORMAL.getStyle()));
        printables.add(PrintMessage.getDoubleColumnInstance("-","VAT(13%): "+vat , SampleReceiptStyle.NORMAL.getStyle()));
        printables.add(PrintMessage.getDoubleColumnInstance("-","Grand Total: "+grandTotal , SampleReceiptStyle.NORMAL.getStyle()));

        printables.add(PrintMessage.getInstance(horizontalLine, SampleReceiptStyle.NORMAL_CENTER.getStyle()));


        printables.add(PrintMessage.getInstance("Print Date: "+printDate, SampleReceiptStyle.NORMAL_ITALIC_CENTER.getStyle()));
        printables.add(PrintMessage.getInstance("Prepared By: "+preparedBy, SampleReceiptStyle.NORMAL_ITALIC_CENTER.getStyle()));
        // printables.add(PrintMessage.getInstance("Print Date: "+printData, SampleReceiptStyle.NORMAL.getStyle()));
        printables.add(PrintMessage.getInstance(horizontalLine, SampleReceiptStyle.NORMAL_CENTER.getStyle()));
        printables.add(PrintMessage.getInstance("Powered by: "+poweredBy, SampleReceiptStyle.NORMAL_CENTER.getStyle()));

        // printables.add(PrintMessage.getInstance("### QR Code Printing ###", SampleReceiptStyle.NORMAL.getStyle()));
        printables.add(
                PrintMessage.getQRCodeInstance(qrMessage,
                0,
                Style.Align.CENTER
                )
        );

        // printables.add(PrintMessage.getInstance("", SampleReceiptStyle.NORMAL.getStyle()));

        // printables.add(PrintMessage.getInstance("### Base64 Image Printing ###", SampleReceiptStyle.NORMAL.getStyle()));
        // printables.add(PrintBase64Image.getInstance("iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAADa0lEQVR42u1Z30tTURy3ZpEJvdhLUEFBEVl/gPhYPva4R5/8ByKI0qC2Xha+VBii5YOJDQoUf0BJSsspm7hNU2zRHPPHrKZ3P+5+EDMcp/MZXbm73bt7J2znDDzw4e5uV8/nc873+znfe05NzWHjuBFCTBS1jGE6CPGjAEcDaZyP/EH6uYHiPMU5RkDfDWrcipKn15MU3SuJbOTlt3jMsrgd65iPVBToE30Hk9lILpfrBiddEdKPe3t7PZNbGWLx7ZDx9RRZFbNMgL7BYTKcJqIovqLUjmgKkJIllUqdXhZ+7+APw+nsLlWfo4KYAA0cLAsCWfoZE5xO5xk5V6WAWlz9fv+l3pVoAur//RPCEuAwvpEmL3xb4sjIyFU5V1UBMzMzl62+7TimkBcBweQueeBaF+12e6MhAe3zkQRvAu4618SBgYFrzAQI0Uz1Cvi+KpDb9yZI32tfyUKYC8hkdon1iSMvALj/aKokEcwFvP8Y2CefF/BwKi+qKgRshsUC8oB7Plw9IdTVM1dAHvdVlcRWm6MgdOSxPzz61VBSc5MDuCpdSUpqhzPEXkBfv5d09c6pjqjyO/nMAG/eLrEV8GX5V8GIfpgMaD77aTpUkiuVXYDS5yV0PpvNu5Da8xhx6TkIYpoDSEYleTmGx/yqI4w8KBY6FRGg5vNqwAwhzLirhdR8vvPprKYQrmoh5ejLfR6WiXs1EXq2WTEByhpHGc8Qo5yhgtmilquW5BUTIHcSAEmpZbFaswHoFXZlE4CFS05EvtLqWee+Q1EH4zaE9OwWq7GRsrpsAuSrr14YyWsfCUZttaw2qqxppDJCGllccf+fndLw42IdwMuJkYWM6zcyteQsBq0wY1qN6tVDUtIa8X1m7wMgh9lQej5KC4RaKWHD5cZW1e/MVVSAhcPN3Q6jm7sul+sKr9vrg4OD14sJyB8aDA0NnV3ezkStCwI3BxwdXoEsbEZiNpvtIjg6HI7aYkdMJwKBwLuJDZE8XowSqA+l/zAB+gb5ifUE8Xq9w5RbnZEzMlNzc3Ojx+MZ9YS24s89G8n26aB453MwWUmgT/TtXfsRd7vdY01NTQgfk9GTyjqKCy0tLTfa2tputba2MgH6vkkbuOiOvlKE2Ww+Tj/WU5xijHpwOdDBO5KFxt4xltBM2MPGSfsLR8WTg7cH7GwAAAAASUVORK5CYII="));
    }
}
