package eu.europa.cedefop.europass.restexamples;

public class ExecuteRestServices {

    private static final String DEFAULT_LANGUAGE = "en";
    private static final String DEFAULT_REST_URL = "https://staging.europass.eworx.gr/rest";

    public static void main(String[] args) throws Exception {

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
        webServicesRequests.setType(type);
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
        if (type == null) {
            throw new Exception("Rest action not provided");
        }
    }

}
