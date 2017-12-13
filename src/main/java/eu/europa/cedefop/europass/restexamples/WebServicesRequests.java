package eu.europa.cedefop.europass.restexamples;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

public class WebServicesRequests {

    private String language;
    private String inputFile;
    private String outputFile;
    private String type;
    private String url;
    private Map restActionMap = new HashMap<String, String>();

    public WebServicesRequests() {
        mapRestActionsWithArgType();
    }

    private void mapRestActionsWithArgType() {
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

    public void execute() {

        try {

            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null,
                new TrustManager[]{ new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() { return null; }
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {}
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {}
                }}, new SecureRandom());

            final SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext);

            final InputStream is = new FileInputStream(new File(this.inputFile));
            final HttpClient client = HttpClientBuilder.create().setSSLSocketFactory(socketFactory).build();

            if (getRestActionByType(type) == null) {
                throw new Exception("Not supported REST action");
            }
            final HttpPost postRequest = new HttpPost(this.url + getRestActionByType(this.type));
            final HttpEntity entity = new ByteArrayEntity(IOUtils.toByteArray(is));

            postRequest.setEntity(entity);
            postRequest.addHeader("Content-Type", "application/" + FilenameUtils.getExtension(this.inputFile));
            postRequest.addHeader("Accept-Language", this.language);

            final HttpResponse response = client.execute(postRequest);
            response.getEntity().writeTo(new FileOutputStream(this.outputFile));
        }
        catch (final KeyManagementException | NoSuchAlgorithmException | IOException e) {
            System.out.println(e);
        }
        catch (final Exception e) {
            System.out.println(e);
        }
    }

    private String getRestActionByType(final String type) {
        return (String)restActionMap.get(type);
    }


    public void setInputFile(final String inputFile) {
        this.inputFile = inputFile;
    }
    public void setOutputFile(final String outputFile) {
        this.outputFile = outputFile;
    }
    public void setLanguage(final String language) {
        this.language = language;
    }
    public void setType(final String type) {
        this.type = type;
    }
    public void setUrl(final String url) {
        this.url = url;
    }
}
