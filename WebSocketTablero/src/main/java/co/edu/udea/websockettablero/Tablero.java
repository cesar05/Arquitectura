/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.websockettablero;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author cesar.munozr
 */
@ServerEndpoint(value="/mitablero",encoders = {FiguraEncoder.class},decoders = {FiguraDecoder.class})
public class Tablero {
    
    private static final Set<Session> peers=Collections.synchronizedSet(new HashSet<Session>());
    
    @OnMessage
    public void broadcastFigure(Figura figura,Session session) throws IOException, EncodeException {
        System.out.println("Figura: "+figura);
        for(Session peer: peers){
            if(!peer.equals(session)){
                peer.getBasicRemote().sendObject(figura);
            }
        }
    }

    @OnOpen
    public void onOpen(Session peer) {
        this.peers.add(peer);                
    }

    @OnError
    public void onError(Throwable t) {
    }

    @OnClose
    public void onClose(Session peer) {
        this.peers.remove(peer);
    }
    
}
