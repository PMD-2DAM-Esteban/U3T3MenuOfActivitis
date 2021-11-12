package dam.esteban.u3t3menuofactivitis.Model;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class Item implements Serializable {

    private Drawable imagen;
    private float version;
    private String nombreVersion;
    private int anyoLanzamiento;
    private int numeroApi;
    private String url;

    public Item() {
    }

    public Item(Drawable imagen, float version, String nombreVersion, int anyoLanzamiento, int numeroApi, String url) {
        this.imagen = imagen;
        this.version = version;
        this.nombreVersion = nombreVersion;
        this.anyoLanzamiento = anyoLanzamiento;
        this.numeroApi = numeroApi;
        this.url = url;
    }

    public Drawable getImagen() {
        return imagen;
    }

    public void setImagen(Drawable imagen) {
        this.imagen = imagen;
    }

    public float getVersion() {
        return version;
    }

    public void setVersion(float version) {
        this.version = version;
    }

    public String getNombreVersion() {
        return nombreVersion;
    }

    public void setNombreVersion(String nombreVersion) {
        this.nombreVersion = nombreVersion;
    }

    public int getAnyoLanzamiento() {
        return anyoLanzamiento;
    }

    public void setAnyoLanzamiento(int anyoLanzamiento) {
        this.anyoLanzamiento = anyoLanzamiento;
    }

    public int getNumeroApi() {
        return numeroApi;
    }

    public void setNumeroApi(int numeroApi) {
        this.numeroApi = numeroApi;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
