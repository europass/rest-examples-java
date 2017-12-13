package eu.europa.cedefop.europass.restexamples;

public class ExecuteRestServices {

    private static final String DEFAULT_LANGUAGE = "en";
    private static final String DEFAULT_REST_URL = "https://staging.europass.eworx.gr/rest";

    public static void main(String[] args) {

        String type = System.getProperty("type");
        String inputFile = System.getProperty("inputFile");
        String outputFile = System.getProperty("outputFile");
        String baseRestUrl = System.getProperty("baseRestUrl");
        String language = System.getProperty("language");

        if (language == null) {
            language = DEFAULT_LANGUAGE;
        }
        if (baseRestUrl == null) {
            baseRestUrl = DEFAULT_REST_URL;
        }

        final WebServicesRequests webServicesRequests = new WebServicesRequests();
        webServicesRequests.setLanguage(language);
        webServicesRequests.setInputFile(inputFile);
        webServicesRequests.setOutputFile(outputFile);
        webServicesRequests.setType(type);
        webServicesRequests.setUrl(baseRestUrl);

        webServicesRequests.execute();
    }

}
