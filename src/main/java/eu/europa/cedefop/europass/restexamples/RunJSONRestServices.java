package eu.europa.cedefop.europass.restexamples;

public class RunJSONRestServices {

    public static void main(String[] args) {

        WebServicesRequests webReq = new WebServicesRequests();

        // JSON TO PDF CV
        webReq.setUrl("https://staging.europass.eworx.gr/rest/v1/document/to/pdf-cv");
        webReq.setFilename("europass-cv-example-v3.3.0");
        webReq.setFilenamePostfix("-json");
        webReq.setFrom("json");
        webReq.setTo("pdf");
        webReq.execute();

        // JSON TO PDF ESP
        webReq.setUrl("https://staging.europass.eworx.gr/rest/v1/document/to/pdf-esp");
        webReq.setFilename("europass-esp-example-v3.3.0");
        webReq.setFilenamePostfix("-json");
        webReq.setFrom("json");
        webReq.setTo("pdf");
        webReq.execute();

        // JSON TO PDF CV+ESP
        webReq.setUrl("https://staging.europass.eworx.gr/rest/v1/document/to/pdf");
        webReq.setFilename("europass-cv-esp-example-v3.3.0");
        webReq.setFilenamePostfix("-json");
        webReq.setFrom("json");
        webReq.setTo("pdf");
        webReq.execute();

        // JSON TO Word
        webReq.setUrl("https://staging.europass.eworx.gr/rest/v1/document/to/pdf");
        webReq.setFilename("europass-cv-esp-example-v3.3.0");
        webReq.setFilenamePostfix("-json");
        webReq.setFrom("json");
        webReq.setTo("doc");
        webReq.execute();

        // JSON TO ODT
        webReq.setUrl("https://staging.europass.eworx.gr/rest/v1/document/to/opendoc");
        webReq.setFilename("europass-cv-esp-example-v3.3.0");
        webReq.setFilenamePostfix("-json");
        webReq.setFrom("json");
        webReq.setTo("odt");
        webReq.execute();

        // JSON to XML CV
        webReq.setUrl("https://staging.europass.eworx.gr/rest/v1/document/to/xml-cv");
        webReq.setFilename("europass-cv-example-v3.3.0");
        webReq.setFilenamePostfix("-json");
        webReq.setFrom("json");
        webReq.setTo("xml");
        webReq.execute();

        // JSON to XML ESP
        webReq.setUrl("https://staging.europass.eworx.gr/rest/v1/document/to/xml-cv");
        webReq.setFilename("europass-esp-example-v3.3.0");
        webReq.setFilenamePostfix("-json");
        webReq.setFrom("json");
        webReq.setTo("xml");
        webReq.execute();

        // JSON to XML ESP
        webReq.setUrl("https://staging.europass.eworx.gr/rest/v1/document/to/xml");
        webReq.setFilename("europass-cv-example-v3.3.0");
        webReq.setFilenamePostfix("-json");
        webReq.setFrom("json");
        webReq.setTo("xml");
        webReq.execute();
    }

}
