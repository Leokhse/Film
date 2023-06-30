package ru.netology.film;


public class MovieManager {
    private Film[] films;
    private int limit;

    public MovieManager() {
        this.films = new Film[0];
        this.limit = 5;
    }

    public MovieManager(int limit) {
        this.films = new Film[0];
        this.limit = limit;
    }

    public void addFilm(Film film) {
        Film[] newFilms = new Film[films.length + 1];
        System.arraycopy(films, 0, newFilms, 0, films.length);
        newFilms[films.length] = film;
        films = newFilms;
    }

    public Film[] findAll() {
        return films;
    }

    public Film[] findLast() {
        int resultLength = Math.min(limit, films.length);
        Film[] result = new Film[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = films[films.length - 1 - i];
        }
        return result;
    }

    public int getLimit() {
        return limit;
    }
}
