package edu.ts.dao.impl;

import edu.ts.dao.PersonGroupDao;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;

/**
 * Created by jose on 2017/3/2.
 */
public class PersonGroupDaoImpl implements PersonGroupDao {
    public void createPersonGroup(String groupName, String personGroupId) {
        // 包装groupName成json格式
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("name",groupName);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HttpClient httpClient = HttpClients.createDefault();
        try {
            URIBuilder builder = new URIBuilder("https://westus.api.cognitive.microsoft.com/face/v1.0/persongroups/"+personGroupId);

            URI uri =  builder.build();
            HttpPut request = new HttpPut(uri);
            request.setHeader("Content-Type","application/json");
            request.setHeader("Ocp-Apim-Subscription-Key","d52e6570d5124c1ca59ca8e189cf69e0");

            //Request body
            StringEntity reqEntity =  new StringEntity(jsonObj.toString());
            request.setEntity(reqEntity);

            HttpResponse response = httpClient.execute(request);
            HttpEntity entity =  response.getEntity();

            if(entity != null){
                System.out.println(EntityUtils.toString(entity));
                //  解析entity
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getPersonGroupList() {
        HttpClient httpclient = HttpClients.createDefault();

        try {
            URIBuilder builder = new URIBuilder("https://westus.api.cognitive.microsoft.com/face/v1.0/persongroups");

            URI uri = builder.build();
            HttpGet request = new HttpGet(uri);
            request.setHeader("Ocp-Apim-Subscription-Key", "d52e6570d5124c1ca59ca8e189cf69e0");

            //StringEntity reqEntity = new StringEntity("{}");
            //request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null)
            {
                String str = EntityUtils.toString(entity);
                str = str.substring(1,str.length()-1);
                System.out.println(str);
                JSONObject jsonObj = new JSONObject(str);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void trainPersongroup(String personGroupId) {
        HttpClient httpclient = HttpClients.createDefault();

        try {
            URIBuilder builder = new URIBuilder("https://westus.api.cognitive.microsoft.com/face/v1.0/persongroups/"+personGroupId+"/train");
            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Ocp-Apim-Subscription-Key", "d52e6570d5124c1ca59ca8e189cf69e0");

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();
            if (entity != null)
            {
                String str = EntityUtils.toString(entity);
                System.out.println(str);
            }

        } catch (Exception e) {

        }
    }
}
