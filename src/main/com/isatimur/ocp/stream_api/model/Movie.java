package com.isatimur.ocp.stream_api.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by developer on 7/12/16.
 */
public class Movie {
    private String title;
    private int releaseYear;

    private Set<Actor> actors = new HashSet<>();

    public Movie(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addActor(Actor actor) {
        this.actors.add(actor);
    }

    public Set<Actor> actors() {
        return this.actors;
    }

    @Override public String toString() {
        return "Movie{" +
            "title='" + title + '\'' +
            ", releaseYear=" + releaseYear +
            ", actors=" + actors +
            '}';
    }
}
