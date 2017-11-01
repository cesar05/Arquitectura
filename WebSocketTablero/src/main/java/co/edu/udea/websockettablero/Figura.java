/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.websockettablero;

import java.io.StringWriter;
import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author cesar.munozr
 */
public class Figura {

    private JsonObject json;
    
    public Figura() {
    }    

    public Figura(JsonObject json) {
        this.json = json;
    }

    public JsonObject getJson() {
        return json;
    }

    public void setJson(JsonObject json) {
        this.json = json;
    }

    @Override
    public String toString() {
        StringWriter write=new StringWriter();
        Json.createWriter(write).write(json);
        return write.toString();
    }
    
}
