package com.adeneo.lab1.tp1_application.manager;

import com.adeneo.lab1.tp1_application.R;
import com.adeneo.lab1.tp1_application.objects.Category;
import com.adeneo.lab1.tp1_application.objects.Cell;
import com.adeneo.lab1.tp1_application.objects.Comment;

import java.util.ArrayList;
import java.util.List;

public class MovieManager {

    private static final MovieManager instanceMovieManager = new MovieManager();
    List<Cell> movies = new ArrayList<>();
    List<Category> categories = new ArrayList<>();
    List<Comment> comments = new ArrayList<>();

    private MovieManager(){
        categories.add(new Category("Humour"));
        categories.add(new Category("Film d'horreur"));
        categories.add(new Category("Comédie"));
        categories.add(new Category("Action"));
        categories.add(new Category("Aventure"));
        categories.add(new Category("Humour"));
        categories.add(new Category("Documentaires"));
        categories.add(new Category("Policier"));
        categories.add(new Category("Amour"));
        categories.add(new Category("Comédies musicales"));
        categories.add(new Category("Dessins animés"));
        categories.add(new Category("Francais"));
        categories.add(new Category("Manga"));
        categories.add(new Category("Science fiction"));
        categories.add(new Category("Fantastique"));

        movies.add(new Cell(0, "Fast and furious 8", "Maintenant que Dom et Letty sont en lune de miel, que Brian et Mia se sont rangés et que le reste de l’équipe a été disculpé, la bande de globetrotteurs retrouve un semblant de vie normale. Mais quand une mystérieuse femme entraîne Dom dans le monde de la criminalité, ce dernier ne pourra éviter de trahir ses proches qui vont faire face à des épreuves qu’ils n’avaient jamais rencontrées jusqu’alors.", R.drawable.fastandfurious8, Cell.CellType.MOVIE));
        movies.add(new Cell(1, "Star wars 10", "film sympa, un peu d'action et d'amour, apprecié par toute catégorie d'âge", R.drawable.fastandfurious8, Cell.CellType.MOVIE));
        movies.add(new Cell(2, "Avengers", "film sympa, un peu d'action et d'amour, apprecié par toute catégorie d'âge", R.drawable.fastandfurious8, Cell.CellType.MOVIE));
        movies.add(new Cell(3, "Babysitting", "film sympa, un peu d'action et d'amour, apprecié par toute catégorie d'âge", R.drawable.fastandfurious8, Cell.CellType.MOVIE));
        movies.add(new Cell(4, "Cringe", "film sympa, un peu d'action et d'amour, apprecié par toute catégorie d'âge", R.drawable.fastandfurious8, Cell.CellType.MOVIE));
        movies.add(new Cell(5, "Zoe la nerveuse", "film sympa, un peu d'action et d'amour, apprecié par toute catégorie d'âge", R.drawable.fastandfurious8, Cell.CellType.MOVIE));
        movies.add(new Cell(6, "Bananasplit", "film sympa, un peu d'action et d'amour, apprecié par toute catégorie d'âge", R.drawable.fastandfurious8, Cell.CellType.MOVIE));

        comments.add(new Comment("misterV", "Trop bien LOL !", R.drawable.avatar));
        comments.add(new Comment("LeCrapeauDu74", "Pas ouf, pas assez d'action", R.drawable.avatar));



    }

    public static MovieManager getInstance() {
        return instanceMovieManager;
    }

    public List<Cell> getMovies(){
        return movies;
    }

    public void setMovies(List<Cell> movies) {
        this.movies = movies;
    }

    public Cell getMovieById(int id){
        return movies.get(id);
    }

    public List<Category> getCategories(){
        return categories;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
