package com.yt.android.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * @author zhangsan
 * @version 1.0
 * @package com.yt.android.util
 * @date 2016/5/6 0006 10:47
 * @descption: 疯狂的王麻子团队!
 */
public class HttpUtil {

    public static String CONTENT_TYPE_PLAIN = "text/plain";
    public static String CONTENT_TYPE_HTML = "text/html";
    public static String CONTENT_TYPE_XML = "text/xml";
    public static String CONTENT_TYPE_JSON = "application/json";


    public static String SendRequest(String adress_Http, String strJson, String contentType) {

        String returnLine = "";
        try {
            URL my_url = new URL(adress_Http);
            HttpURLConnection connection = (HttpURLConnection) my_url.openConnection();
            connection.setDoOutput(true);

            connection.setDoInput(true);

            connection.setRequestMethod("POST");

            connection.setUseCaches(false);

            connection.setInstanceFollowRedirects(true);
            //相应头设置
            if (contentType == null || contentType.equals("")) {
                contentType = CONTENT_TYPE_JSON;
            }
            connection.setRequestProperty("Content-Type", contentType);

            connection.connect();
            DataOutputStream out = new DataOutputStream(connection
                    .getOutputStream());

            byte[] content = strJson.getBytes("utf-8");

            out.write(content, 0, content.length);
            out.flush();
            out.close(); // flush and close

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));


            String line = "";

            System.out.println("Contents of post request start");

            while ((line = reader.readLine()) != null) {
                // line = new String(line.getBytes(), "utf-8");
                returnLine += line;
            }

            reader.close();
            connection.disconnect();
            System.out.println("========返回的结果的为========" + returnLine);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnLine;
    }











}
