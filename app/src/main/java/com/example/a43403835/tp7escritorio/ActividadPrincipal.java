package com.example.a43403835.tp7escritorio;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import org.cocos2d.layers.Layer;
import org.cocos2d.nodes.Director;
import org.cocos2d.nodes.Scene;
import org.cocos2d.nodes.Sprite;
import org.cocos2d.opengl.CCGLSurfaceView;
import org.cocos2d.types.CCSize;

import java.util.Random;

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
        CCSize _Pantalla;
        Sprite _Objeto;

        public clsJuego(CCGLSurfaceView VistaDelJuego){
            Log.d("Comienzo","Comienza el constructor de la clase");
            _VistaDelJuego=VistaDelJuego;
        }

        public void ComenzarJuego(){
            Log.d("Comienzo","Comienzo el juego");
            Director.sharedDirector().attachInView(_VistaDelJuego);

            _Pantalla=Director.sharedDirector().displaySize();
            Log.d("Comienzo","Pantalla - Ancho: "+ _Pantalla.getWidth()+" - Alto "+ _Pantalla.getHeight());

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
            int posicionInicialX;
            public capaJuego() {
                Log.d("Comienzo","Comienza el constructor");

                Log.d("Juego","Ubico al objeto en su lugar inicial");
                ponerObjeto();
            }


            void ponerObjeto(){
                Log.d("UbicoPersonaje","Ubico al objeto en su lugar inicial");

                Log.d("UbicoPersonaje","le asigno una imagen");
                _Objeto=Sprite.sprite("");

                Log.d("UbicoPersonaje","le asigno su posicion inicial");

                Random generador;
                generador= new Random();
                float AnchoObjeto;
                AnchoObjeto = _Objeto.getWidth();
                posicionInicialX= generador.nextInt((int)( _Pantalla.getWidth()-AnchoObjeto));
                posicionInicialX += AnchoObjeto/2;

                _Objeto.setPosition(100,100);

            }
        }



    }


}
