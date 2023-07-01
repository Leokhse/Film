package ru.netology.film;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {
    private MovieManager movieManager;

    @BeforeEach
    public void setUp() {
        movieManager = new MovieManager(5);
    }

    @Test
    public void shouldAddFilm() {
        Film film = new Film("Film 1");
        movieManager.addFilm(film);
        Film[] films = movieManager.findAll();
        Assertions.assertEquals(1, films.length);
        Assertions.assertArrayEquals(new Film[]{film}, films);
    }

    @Test
    public void shouldReturnAllFilms() {
        Film film1 = new Film("Film 1");
        Film film2 = new Film("Film 2");
        movieManager.addFilm(film1);
        movieManager.addFilm(film2);
        Film[] films = movieManager.findAll();
        Assertions.assertEquals(2, films.length);
        Assertions.assertArrayEquals(new Film[]{film1, film2}, films);
    }

    @Test
    public void shouldReturnLastFiveFilmsByDefault() {
        Film film1 = new Film("Film 1");
        Film film2 = new Film("Film 2");
        Film film3 = new Film("Film 3");
        Film film4 = new Film("Film 4");
        Film film5 = new Film("Film 5");
        Film film6 = new Film("Film 6");
        movieManager.addFilm(film1);
        movieManager.addFilm(film2);
        movieManager.addFilm(film3);
        movieManager.addFilm(film4);
        movieManager.addFilm(film5);
        movieManager.addFilm(film6);
        Film[] lastFilms = movieManager.findLast();
        Assertions.assertEquals(5, lastFilms.length);
        Assertions.assertArrayEquals(new Film[]{film6, film5, film4, film3, film2}, lastFilms);
    }

    @Test
    public void shouldReturnLastThreeFilms() {
        MovieManager movieManager = new MovieManager(3);
        Film film1 = new Film("Film 1");
        Film film2 = new Film("Film 2");
        Film film3 = new Film("Film 3");
        Film film4 = new Film("Film 4");
        movieManager.addFilm(film1);
        movieManager.addFilm(film2);
        movieManager.addFilm(film3);
        movieManager.addFilm(film4);
        Film[] lastFilms = movieManager.findLast();
        Assertions.assertEquals(3, lastFilms.length);
        Assertions.assertArrayEquals(new Film[]{film4, film3, film2}, lastFilms);
    }
}