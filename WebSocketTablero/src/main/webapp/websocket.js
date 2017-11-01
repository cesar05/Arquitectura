/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
var wsUri="ws://"+document.location.host+
                  document.location.pathname+
                  "mitablero";*/

var wsUri="ws://192.168.194.22:8080/Tablero/MiTablero";
        
var websocket=new WebSocket(wsUri);
var output =document.getElementById("output");

function writeToSreen(message){
    output.innerHTML +=message +"<br/>";
}
websocket.onmessage=function(evt){
    console.log("recived: "+evt.data);
    drawImageText(evt.data);
}
websocket.onopen=function(evt){
    writeToSreen("Conectado a : "+wsUri);
};

websocket.onerror=function(evt){
    writeToScreen('<pan style="color:red;">ERROR:</span>'+evt.data);
};

function sendText(json){
    console.log("sending text:"+json);
    websocket.send(json);
}


