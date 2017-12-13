package eu.europa.cedefop.europass.restexamples;

import java.util.HashMap;
import java.util.Map;

public class ExecuteRestServices {

    private static final String DEFAULT_LANGUAGE = "en";
    private static final String DEFAULT_REST_URL = "https://europass.cedefop.europa.eu/rest";
    private static Map restActionMap = new HashMap<String, String>();

    public static void main(String[] args) throws Exception {

        initMapRestActionsArray();
        final String type = System.getProperty("type");
        final String inputFile = System.getProperty("inputPathFile");
        final String outputFile = System.getProperty("outputPathFile");

        String baseRestUrl = System.getProperty("baseRestUrl");
        String language = System.getProperty("language");

        if (language == null) {
            language = DEFAULT_LANGUAGE;
        }
        if (baseRestUrl == null) {
            baseRestUrl = DEFAULT_REST_URL;
        }
        throwExceptionWhenEmptyArgs(inputFile, outputFile, type);

        final WebServicesRequests webServicesRequests = new WebServicesRequests();
        webServicesRequests.setLanguage(language);
        webServicesRequests.setInputFile(inputFile);
        webServicesRequests.setOutputFile(outputFile);
        webServicesRequests.setType((String) restActionMap.get(type));
        webServicesRequests.setUrl(baseRestUrl);

        webServicesRequests.execute();
    }

    private static void throwExceptionWhenEmptyArgs(final String inputFile,
                                                    final String outputFile,
                                                    final String type)  throws Exception{

        if (inputFile == null) {
            throw new Exception("Input path file not provided");
        }
        if (outputFile == null) {
            throw new Exception("Output path file not provided");
        }
        if (type == null || !restActionMap.containsKey(type)) {
            throw new Exception("Rest action not provided/supported");
        }
    }

    private static void initMapRestActionsArray() {
        restActionMap.put("xml-to-pdf-cv-esp", "/v1/document/to/pdf");
        restActionMap.put("xml-to-pdf-esp-only", "/v1/document/to/pdf-esp");
        restActionMap.put("xml-to-pdf-cv-only", "/v1/document/to/pdf-cv");
        restActionMap.put("xml-to-doc", "/v1/document/to/word");
        restActionMap.put("xml-to-odt", "/v1/document/to/opendoc");
        restActionMap.put("xml-to-json", "/v1/document/to/json");
        restActionMap.put("xml-upgrade", "/v1/document/upgrade");
        restActionMap.put("extract-xml", "/v1/document/extraction");

        restActionMap.put("json-to-pdf-cv-esp", "/v1/document/to/pdf");
        restActionMap.put("json-to-pdf-esp-only", "/v1/document/to/pdf-esp");
        restActionMap.put("json-to-pdf-cv-only", "/v1/document/to/pdf-cv");
        restActionMap.put("json-to-doc", "/v1/document/to/word");
        restActionMap.put("json-to-odt", "/v1/document/to/opendoc");
        restActionMap.put("json-to-xml-cv", "/v1/document/to/xml-cv");
        restActionMap.put("json-to-xml-esp", "/v1/document/to/xml-esp");
        restActionMap.put("json-to-xml", "/v1/document/to/xml");
    }
}
