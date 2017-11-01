/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.websockettablero;

import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author cesar.munozr
 */
public class FiguraDecoder implements Decoder.Text<Figura>{

    @Override
    public Figura decode(String string) throws DecodeException {
        JsonObject jsonObject=Json.createReader(new StringReader(string)).readObject();
        return new Figura(jsonObject);
    }

    @Override
    public boolean willDecode(String arg0) {
        try{
            Json.createReader(new StringReader(arg0)).readObject();
            return true;
        }
        catch(JsonException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void init(EndpointConfig config) {
        System.out.println("init");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }

   
    
}
