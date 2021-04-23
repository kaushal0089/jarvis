package in.kkd.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import javax.net.ssl.*;
import javax.sound.midi.Soundbank;
import javax.xml.ws.WebEndpoint;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;

public class BrokenImages extends BaseTest{

    @Test
    public void brokenImages() throws Exception {
        driver.get().get("https://www.demoqa.com/broken");
        List<WebElement> images = driver.get().findElements(By.tagName("img"));

        System.out.println("Total number of images on the page are : "+images.size());

        Iterator<WebElement> ele = images.iterator();
        while (ele.hasNext()){
            WebElement wimage = ele.next();
            String imageURL = wimage.getAttribute("src");
            System.out.println("URL of image is :"+imageURL);
            verifyImage(imageURL);

            try {
                boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver.get()).executeScript("return (typeof arguments[0].naturalWidth !=\"undefined\" && arguments[0].naturalWidth > 0);", wimage);
                if (imageDisplayed) {
                    System.out.println("DISPLAY - OK");
                }else {
                    System.out.println("DISPLAY - BROKEN");
                }
            }
            catch (Exception e) {
                System.out.println("Error Occured" +e);
            }
        }
    }

    public void verifyImage(String imageURL) throws Exception {
        URL url = new URL(imageURL);
        doTrustToCertificates();
        HttpURLConnection hcu = (HttpURLConnection) url.openConnection();
        hcu.setConnectTimeout(10000);
//        hcu.setRequestMethod("HEAD");
        hcu.connect();
        if(hcu.getResponseCode()>400){
            System.out.println("HTTP STATUS :"+hcu.getResponseCode()+" is a broken link");
        }
        else {
            System.out.println("HTTP STATUS :"+hcu.getResponseCode());
        }

    }
    public void doTrustToCertificates() throws Exception {
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException {
                        return;
                    }

                    public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException {
                        return;
                    }
                }
        };

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        HostnameVerifier hv = new HostnameVerifier() {
            public boolean verify(String urlHostName, SSLSession session) {
                if (!urlHostName.equalsIgnoreCase(session.getPeerHost())) {
                    System.out.println("Warning: URL host '" + urlHostName + "' is different to SSLSession host '" + session.getPeerHost() + "'.");
                }
                return true;
            }
        };
        HttpsURLConnection.setDefaultHostnameVerifier(hv);
    }

}
