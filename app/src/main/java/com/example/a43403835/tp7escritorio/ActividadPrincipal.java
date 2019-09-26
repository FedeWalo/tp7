package com.example.a43403835.tp7escritorio;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import org.cocos2d.layers.Layer;
import org.cocos2d.nodes.Director;
import org.cocos2d.nodes.Scene;
import org.cocos2d.opengl.CCGLSurfaceView;

public class ActividadPrincipal extends Activity {

    CCGLSurfaceView VistaPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.actividad_principal);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        VistaPrincipal = new CCGLSurfaceView(this);
        setContentView(VistaPrincipal);
    }

    @Override
    protected void onStart(){
        super.onStart();
        clsJuego miGenialJuego;
        miGenialJuego = new clsJuego(VistaPrincipal);
        miGenialJuego.ComenzarJuego();
    }

    public class clsJuego{
        CCGLSurfaceView _VistaDelJuego;
        public clsJuego(CCGLSurfaceView VistaDelJuego){
            Log.d("Comienzo","Comienza el constructor de la clase");
            _VistaDelJuego=VistaDelJuego;
        }

        public void ComenzarJuego(){
            Log.d("Comienzo","Comienzo el juego");
            Director.sharedDirector().attachInView(_VistaDelJuego);

            Log.d("Comienzo","Declaro e instancio la escena");
            Scene escenaAUsar;
            escenaAUsar=EscenaComienzo();

            Log.d("Comienzo","le digo al director que inicie la escena");
            Director.sharedDirector().runWithScene(escenaAUsar);
        }

        private org.cocos2d.nodes.Scene EscenaComienzo(){
            Log.d("EscenaComienzo","Comienza");
            Scene escenaADevolver;
            escenaADevolver= Scene.node();

            Log.d("EscenaComienzo","Voy a agregar la capa");
            capaJuego unaCapa;
            unaCapa= new capaJuego();
            escenaADevolver.addChild(unaCapa);

            Log.d("EscenaComienzo", "Devuelvo la escena creada");
            return  escenaADevolver;
        }

        class capaJuego extends Layer {

        }

    }


}
