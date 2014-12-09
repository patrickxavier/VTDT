/*
 * Created by Sanchit Chadha on 2014.12.07  * 
 * Copyright © 2014 Sanchit Chadha. All rights reserved. * 
 */

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.io.StringReader;
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
import org.primefaces.model.chart.PieChartModel;

@ManagedBean
public class ChartView implements Serializable {

    private PieChartModel pieModel;
    private WebTarget target;
    private Invocation invocation;
    private Response response;
    private String jsonString = "";
    private JsonReader reader;
    private JsonArray barArray;
    private JsonArray usersArray;
    private JsonObject object;
    private static final String URL = "http://jupiter.cs.vt.edu/VTDT-1.0/webresources/";
    
    @PostConstruct
    public void init() {
        pieModel = new PieChartModel();

        Client client = ClientBuilder.newClient();
        
        target = client.target(URL + "com.group2.vtdt.bars/");
        invocation = target.request().buildGet();
        response = invocation.invoke();
        jsonString = response.readEntity(String.class);

        reader = Json.createReader(new StringReader(jsonString));
        barArray = reader.readArray();
        
        int numBars = barArray.size();

        for (int i = 0; i < numBars; i++) {
            object = barArray.getJsonObject(i);
            target = client.target(URL + "com.group2.vtdt.users/findByCheckedInBar/" + (i + 1));
            invocation = target.request().buildGet();
            response = invocation.invoke();
            jsonString = response.readEntity(String.class);
            reader = Json.createReader(new StringReader(jsonString));
            usersArray = reader.readArray();
            if (usersArray.size() != 0) {
                
                pieModel.set(object.getString("name"), usersArray.size());
            }
        }

        pieModel.setTitle("People Checked In");
        pieModel.setLegendPosition("w");
        pieModel.setShowDataLabels(true);
        pieModel.setDataFormat("value");
        
        
    }

    public PieChartModel getPieModel() {
        return pieModel;
    }
}
