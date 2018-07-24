package com.senasoft_2.prueba.Base_datos;

public class Usuario {


    private Integer id;
    private int radioEscritor;
    private int radioEscultor;
    private int radioPintor;
    private int radioGroup;
    private String nombre;
    private String biografia;


    public Usuario(Integer id, int radioEscritor, int radioEscultor, int radioPintor, int radioGroup, String nombre, String biografia) {
        this.id = id;
        this.radioEscritor = radioEscritor;
        this.radioEscultor = radioEscultor;
        this.radioPintor = radioPintor;
        this.radioGroup = radioGroup;
        this.nombre = nombre;
        this.biografia = biografia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRadioEscritor() {
        return radioEscritor;
    }

    public void setRadioEscritor(int radioEscritor) {
        this.radioEscritor = radioEscritor;
    }

    public int getRadioEscultor() {
        return radioEscultor;
    }

    public void setRadioEscultor(int radioEscultor) {
        this.radioEscultor = radioEscultor;
    }

    public int getRadioPintor() {
        return radioPintor;
    }

    public void setRadioPintor(int radioPintor) {
        this.radioPintor = radioPintor;
    }

    public int getRadioGroup() {
        return radioGroup;
    }

    public void setRadioGroup(int radioGroup) {
        this.radioGroup = radioGroup;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
}
