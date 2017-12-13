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

public class WebServicesRequests {

    private String language;
    private String inputFile;
    private String outputFile;
    private String type;
    private String url;

    public void execute() {

        try {
            final InputStream is = new FileInputStream(new File(this.inputFile));
            final HttpClient client = HttpClientBuilder.create().setSSLSocketFactory(createSSLConnectionFactory()).build();

            final HttpPost postRequest = new HttpPost(this.url + this.type);
            final HttpEntity entity = new ByteArrayEntity(IOUtils.toByteArray(is));

            postRequest.setEntity(entity);
            postRequest.addHeader("Content-Type", "application/" + FilenameUtils.getExtension(this.inputFile));
            postRequest.addHeader("Accept-Language", this.language);

            final HttpResponse response = client.execute(postRequest);
            response.getEntity().writeTo(new FileOutputStream(this.outputFile));
        }
        catch (final Exception e) {
            System.out.println(e);
        }
    }

    private SSLConnectionSocketFactory createSSLConnectionFactory() throws KeyManagementException, NoSuchAlgorithmException {
        final SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null,
                new TrustManager[]{ new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() { return null; }
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {}
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {}
                }}, new SecureRandom());

        return new SSLConnectionSocketFactory(sslContext);
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
