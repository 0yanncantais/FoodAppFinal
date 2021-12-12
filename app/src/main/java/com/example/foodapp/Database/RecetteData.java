package com.example.foodapp.Database;

public class RecetteData {

    public String getRecettes() {
        return recettes;
    }

    public void setRecettes(String recettes) {
        this.recettes = recettes;
    }

    public RecetteData(int idRecette,String recettes) {
        this.idRecette=idRecette;
        this.recettes = recettes;
    }

    public int getIdRecette() {
        return idRecette;
    }

    public void setIdRecette(int idRecette) {
        this.idRecette = idRecette;
    }

    private int idRecette;
    private String recettes;

    public String toString(){
        return recettes;
    }
}
