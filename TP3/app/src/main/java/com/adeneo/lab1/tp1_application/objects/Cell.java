package com.adeneo.lab1.tp1_application.objects;

public class Cell {

    private String titre;
    private String description;
    private int image;
    private int id;
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

    public Cell(int id, String titre, String description, int image, CellType cellType){
        this.id = id;
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

    public int getImage() {
        return image;
    }

    public CellType getType() {
        return cellType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
