package com.group2.news;

import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
 
@ManagedBean(name = "newsService")
@ApplicationScoped

public class NewsService {
    
    private WebTarget target;
    private Invocation invocation;
    private Response response;
    private String jsonString = "";
    private JsonReader reader;
    private JsonArray newsArray;
    private JsonObject object;
    private static final String URL = "http://jupiter.cs.vt.edu/VTDT-1.0/webresources/";
     
    public List<News> createNews () {
        
        newsArray = queryNewsFeed();
        
        List<News> list = new ArrayList<News>();
        for(int i = 0 ; i < newsArray.size() ; i++) {

            object = newsArray.getJsonObject(i);
            
            String uid = object.getString("username");
            String name = queryUserTable(uid);
                
            String barName = queryForBar(object.getInt("bar"));
            //need to create string that says "at <barname> around <time>"
            String locationTime = "at " + barName + " - " + formatTime(object.getString("timePosted"));
            list.add(new News(name, object.getString("message"), locationTime, uid));
           
        }
//         System.out.println(list.toString());
         for(News n : list) {
             System.out.println(n.getMessage());
         }
        return list;
    }
    
    public JsonArray queryNewsFeed() {
        
        Client client = ClientBuilder.newClient();
        
        target = client.target(URL + "com.group2.vtdt.newsfeed/sorted");
        invocation = target.request().buildGet();
        response = invocation.invoke();
        jsonString = response.readEntity(String.class);

        reader = Json.createReader(new StringReader(jsonString));
        
        return reader.readArray();
    }
    
    public String queryUserTable(String username) {
        //username = uid
        //we want to query for name
        
        Client client = ClientBuilder.newClient();
        
        target = client.target(URL + "com.group2.vtdt.users/findByUsername/" + username);
        invocation = target.request().buildGet();
        response = invocation.invoke();
        jsonString = response.readEntity(String.class);

        reader = Json.createReader(new StringReader(jsonString));
        
        return reader.readArray().getJsonObject(0).getString("name");
    }
    
    public String queryForBar(Integer barID) {
         Client client = ClientBuilder.newClient();
        
        target = client.target(URL + "com.group2.vtdt.bars/" + barID.toString());
        invocation = target.request().buildGet();
        response = invocation.invoke();
        jsonString = response.readEntity(String.class);

        reader = Json.createReader(new StringReader(jsonString));
        return reader.readObject().getString("name");
        
    }
    
    public String formatTime(String timeStamp) {
        
        String timeDate = "";
        String day = "";
        String fullDate = "";
        
        try {
            
            Date d = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")).parse(timeStamp);
            timeDate = (new SimpleDateFormat("h:mm aa")).format(d);
            
            fullDate = (new SimpleDateFormat("yyyy-MM-dd")).format(d);
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();

            if (fullDate.equals(dateFormat.format(date))) {
                day = " today";
            }
            else {
                day = " on " + (new SimpleDateFormat("EEEE")).format(d); 
            }
            
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
        
        return timeDate + day;
                
    }
}