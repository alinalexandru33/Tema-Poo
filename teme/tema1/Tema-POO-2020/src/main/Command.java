package main;

import fileio.ActionInputData;
import fileio.MovieInputData;
import fileio.SerialInputData;
import fileio.UserInputData;

import java.util.List;

public class Command {
    ActionInputData action;
    UserInputData user;
    List<MovieInputData> movies;
    List<SerialInputData> series;

    public Command(ActionInputData action, UserInputData user, List<MovieInputData> movies, List<SerialInputData> series) {
        this.action = action;
        this.user = user;
        this.movies = movies;
        this.series = series;
    }

    public String Favorite() {
        if(!user.getHistory().containsKey(action.getTitle()) || user.getHistory().get(action.getTitle()) == 0) {
            return "error -> " + action.getTitle() + " is not seen";
        }

        if(user.getFavoriteMovies().contains(action.getTitle())) {
            return "error -> " + action.getTitle() + " is already in favourite list";
        }

        user.getFavoriteMovies().add(action.getTitle());
        return "success -> " + action.getTitle() + " was added as favourite";
    }

    public String View() {
        if(!user.getHistory().containsKey(action.getTitle())) {
            user.getHistory().put(action.getTitle(), 1);
        }
        else {
            user.getHistory().replace(action.getTitle(), user.getHistory().get(action.getTitle()) + 1);
        }

        return "success -> " + action.getTitle() + " was viewed with total views of " + user.getHistory().get(action.getTitle());
    }

    public String Rate() {
        for(MovieInputData movie : movies) {
            if(movie.getTitle().compareTo(action.getTitle()) == 0) {
                movie.setRating(action.getGrade());
            }
        }

        for(SerialInputData serie : series) {
            if(serie.getTitle().compareTo(action.getTitle()) == 0) {
                serie.getSeasons().get(action.getSeasonNumber() - 1).setRating(action.getGrade());
            }
        }

        return "success -> " + action.getTitle() + " was rated with " + action.getGrade() + " by " + user.getUsername();
    }
}
