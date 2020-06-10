package com.example.myclouds.model;

public class Pregunta {

    private String imatge;
    private String correcta;
    private String opcio1;
    private String opcio2;

    public Pregunta(String imatge, String correcta){
        this.imatge = imatge;
        this.correcta = correcta;
    }

    public String getImatge() {
        return imatge;
    }

    public void setImatge(String imatge) {
        this.imatge = imatge;
    }

    public String getCorrecta() {
        return correcta;
    }

    public void setCorrecta(String correcta) {
        this.correcta = correcta;
    }
}
