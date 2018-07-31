package emcorp.studio.pijat.Library;

import java.io.Serializable;

/**
 * Created by Lincoln on 04/04/16.
 */
public class Image implements Serializable{
    private String name;
    private int foto;
    private String recid;

    public Image() {
    }

    public Image(String name, int foto, String recid) {
        this.name = name;
        this.foto = foto;
        this.recid = recid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto= foto;
    }

    public String getRecid() {
        return recid;
    }

    public void setRecid(String recid) {
        this.recid= recid;
    }
}
