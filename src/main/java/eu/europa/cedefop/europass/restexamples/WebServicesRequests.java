package eu.europa.cedefop.europass.restexamples;

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
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

public class WebServicesRequests {

    private String url;
    private String filename;
    private String filenamePostfix = "";
    private String from;
    private String to;
    private String language;

    private static final String DOT = ".";

    public void execute() {

        try {

            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null,
                    new TrustManager[]{new X509TrustManager() {
                        public X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }
                        public void checkClientTrusted(X509Certificate[] certs, String authType) {}
                        public void checkServerTrusted(X509Certificate[] certs, String authType) {}
                    }}, new SecureRandom());

            SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext,SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            final WebServicesRequests webServicesRequests = new WebServicesRequests();

            final InputStream is = webServicesRequests.getFile("assets/input/" + this.filename + DOT + this.from);
            final HttpClient client = HttpClientBuilder.create().setSSLSocketFactory(socketFactory).build();
            final HttpPost postRequest = new HttpPost(this.url);
            final HttpEntity entity = new ByteArrayEntity(IOUtils.toByteArray(is));
            is.close();

            postRequest.setEntity(entity);
            postRequest.addHeader("Content-Type", "application/" + this.from);
            postRequest.addHeader("Accept-Language", this.language);

            final HttpResponse response = client.execute(postRequest);
            response.getEntity().writeTo(webServicesRequests.getOutputStream(this.filename + this.filenamePostfix + DOT + this.to));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setUrl(final String url) {
        this.url = url;
    }
    public void setFilename(final String filename) {
        this.filename = filename;
    }
    public void setFrom(final String from) {
        this.from = from;
    }
    public void setTo(final String to) {
        this.to = to;
    }
    public void setFilenamePostfix(final String filenamePostfix) {
        this.filenamePostfix = filenamePostfix;
    }

    public void setLanguage(final String language) {
        this.language = language;
    }

    private OutputStream getOutputStream(final String filename) throws FileNotFoundException {

        final String outputDir = getClass().getResource("/assets/output").getFile();

        final OutputStream os = new FileOutputStream(outputDir + "/"+ filename);

        return os;
    }

    private InputStream getFile(final String fileName) {

        final ClassLoader classLoader = getClass().getClassLoader();
        InputStream result = null;
        try {
            result = classLoader.getResourceAsStream(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
