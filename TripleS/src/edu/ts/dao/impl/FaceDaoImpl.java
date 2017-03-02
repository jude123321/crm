package edu.ts.dao.impl;

import edu.ts.dao.FaceDao;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;

/**
 * Created by jose on 2017/3/2.
 */
public class FaceDaoImpl implements FaceDao {

    public String detectFace(String url) {
        String faceId= null;
        JSONObject jsonUrl = new JSONObject();
        try {
            jsonUrl.put("url",url);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        HttpClient httpclient = HttpClients.createDefault();
        try {
            URIBuilder builder = new URIBuilder("https://westus.api.cognitive.microsoft.com/face/v1.0/detect");
            builder.setParameter("returnFaceId", "true");
            builder.setParameter("returnFaceLandmarks", "false");


            URI uri =  builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type","application/json");
            request.setHeader("Ocp-Apim-Subscription-Key","d52e6570d5124c1ca59ca8e189cf69e0");

            // Request body
            StringEntity reqEntity = new StringEntity(jsonUrl.toString());
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null)
            {
                String str = EntityUtils.toString(entity);
                str = str.substring(1,str.length()-1);
                JSONObject jsonObject = new JSONObject(str);
                faceId = jsonObject.getString("faceId");

                return faceId;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return faceId;
    }

    public String identifyFace(String personGroupId, String faceId) {
        String personId = null;

        //去包装body
        JSONObject jsonPerson = new JSONObject();
        try {
            JSONArray jsonFaceIds = new JSONArray();
            jsonPerson.put("personGroupId",personGroupId);
            jsonFaceIds.put(faceId);
            jsonPerson.put("faceIds",jsonFaceIds);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        HttpClient httpclient = HttpClients.createDefault();
        try {
            URIBuilder builder = new URIBuilder("https://westus.api.cognitive.microsoft.com/face/v1.0/identify");

            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", "d52e6570d5124c1ca59ca8e189cf69e0");

            // Request body
            StringEntity reqEntity = new StringEntity(jsonPerson.toString());
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null)
            {
                String str = EntityUtils.toString(entity);
                str = str.substring(1,str.length()-1);
                JSONObject jsonObj = new JSONObject(str);
                JSONArray jsonArray = jsonObj.getJSONArray("candidates");
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                personId = jsonObject.getString("personId");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return personId;
    }
}
