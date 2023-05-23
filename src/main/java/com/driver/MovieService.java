package com.driver;

import java.util.List;

public class MovieService {
    MovieRepository movieRepository=new MovieRepository();
    public void moviePost(Movie movie){
        movieRepository.postNewMovie(movie);
    }

    public void directorPost(Director director){
        movieRepository.postNewDirector(director);
    }

    public void movieDirectorPost(String director,String movie){
        movieRepository.pair_Movie_Director(director,movie);
    }

    public Movie movieGet(String movie){
        return movieRepository.get_Movie(movie);
    }

    public Director directorGet(String director){
        return movieRepository.get_Director(director);
    }

    public List<String> moviesAllGet(){
        return movieRepository.get_Movie_All();
    }

    public List<String> moviesOfDirector(String director){
        return movieRepository.get_Movie_Director(director);
    }

    public void directorDel(String director){
        movieRepository.delete_A_DirectorList(director);
    }

    public void deleteAllPair(){
        movieRepository.delete_All_List();
    }
}
