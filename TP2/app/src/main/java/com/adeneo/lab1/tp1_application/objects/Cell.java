package com.adeneo.lab1.tp1_application.objects;

public class Cell {

    private String titre;
    private String description;
    private String image;
    private CellType cellType;

    public enum CellType {
        MOVIE("Movie"),
        HEADER("Header"),
        FOOTER("Footer");

        private String type = "";

        CellType(String type){
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    public Cell(String titre, String description, String image, CellType cellType){
        this.titre = titre;
        this.description = description;
        this.image = image;
        this.cellType = cellType;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public CellType getType() {
        return cellType;
    }

}
