package eu.europa.cedefop.europass.restexamples;

public class RunXMLRestServices {

    public static void main(String[] args) {

        WebServicesRequests webReq = new WebServicesRequests();

        // XML TO PDF CV // ENGLISH
        webReq.setUrl("https://staging.europass.eworx.gr/rest/v1/document/to/pdf-cv");
        webReq.setFilename("europass-cv-example-v3.3.0");
        webReq.setFilenamePostfix("-xml");
        webReq.setFrom("xml");
        webReq.setTo("pdf");
        webReq.setLanguage("en");
        webReq.execute();

        // XML TO PDF ESP // FRENCH
        webReq.setUrl("https://staging.europass.eworx.gr/rest/v1/document/to/pdf-esp");
        webReq.setFilename("europass-esp-example-v3.3.0");
        webReq.setFilenamePostfix("-xml");
        webReq.setFrom("xml");
        webReq.setTo("pdf");
        webReq.setLanguage("fr");
        webReq.execute();

        // XML TO PDF CV+ESP // ITALIAN
        webReq.setUrl("https://staging.europass.eworx.gr/rest/v1/document/to/pdf");
        webReq.setFilename("europass-cv-esp-example-v3.3.0");
        webReq.setFilenamePostfix("-xml");
        webReq.setFrom("xml");
        webReq.setTo("pdf");
        webReq.setLanguage("it");
        webReq.execute();

        // XML TO Word
        webReq.setUrl("https://staging.europass.eworx.gr/rest/v1/document/to/word");
        webReq.setFilename("europass-cv-esp-example-v3.3.0");
        webReq.setFilenamePostfix("-xml");
        webReq.setFrom("xml");
        webReq.setTo("doc");
        webReq.execute();

        // XML TO ODT
        webReq.setUrl("https://staging.europass.eworx.gr/rest/v1/document/to/opendoc");
        webReq.setFilename("europass-cv-esp-example-v3.3.0");
        webReq.setFilenamePostfix("-xml");
        webReq.setFrom("xml");
        webReq.setTo("odt");
        webReq.execute();

        // XML TO JSON
        webReq.setUrl("https://staging.europass.eworx.gr/rest/v1/document/to/json");
        webReq.setFilename("europass-cv-esp-example-v3.3.0");
        webReq.setFilenamePostfix("-xml");
        webReq.setFrom("xml");
        webReq.setTo("json");
        webReq.execute();

        // XML Upgrade
        webReq.setUrl("https://staging.europass.eworx.gr/rest/v1/document/upgrade");
        webReq.setFilename("europass-cv-example-v2.0");
        webReq.setFilenamePostfix("-xml-v3");
        webReq.setFrom("xml");
        webReq.setTo("xml");
        webReq.execute();

        //XML Extraction
        webReq.setUrl("https://staging.europass.eworx.gr/rest/v1/document/extraction");
        webReq.setFilename("CV-Europass-20171212-Smith-EN");
        webReq.setFilenamePostfix("-xml");
        webReq.setFrom("pdf");
        webReq.setTo("xml");
        webReq.execute();

    }
}
