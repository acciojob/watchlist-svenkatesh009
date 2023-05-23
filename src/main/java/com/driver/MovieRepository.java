package com.driver;

import java.security.PrivateKey;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
public class MovieRepository {
    private Map<String,List<String>> movieDirectorData=new HashMap<>();
    private Map<String,Movie> movieData=new HashMap<>();
    private Map<String ,Director> DirectorData=new HashMap<>();

    public void postNewMovie(Movie movie){
        movieData.put(movie.getName(),movie);
    }

    public void postNewDirector(Director director){
        DirectorData.put(director.getName(),director);
    }

    public void pair_Movie_Director(String director,String movie){
        if(!movieData.containsKey(movie) || !DirectorData.containsKey(director)) return;
        if(movieDirectorData.containsKey(director)){
            List<String> oldList=movieDirectorData.get(director);
            oldList.add(movie);
            movieDirectorData.put(director,oldList);
            Director director1=DirectorData.get(director);
            director1.setNumberOfMovies(oldList.size());
        }
        else{
            List<String> newList=new ArrayList<>();
            newList.add(movie);
            movieDirectorData.put(director,newList);
            Director director1=DirectorData.get(director);
            director1.setNumberOfMovies(newList.size());
        }
    }

    public Movie get_Movie(String movie){
        if(movieData.containsKey(movie)){
            return movieData.get(movie);
        }
        return new Movie();
    }

    public Director get_Director(String Director){
        return DirectorData.getOrDefault(DirectorData.get(Director),new Director());
    }

    public List<String> get_Movie_Director(String director){
        if(DirectorData.containsKey(director))return movieDirectorData.get(director);
        return new ArrayList<>();
    }

    public List<String> get_Movie_All(){
        List<String> moviesList=new ArrayList<>();
        moviesList.addAll(movieData.keySet());
        return moviesList;
    }

    public void delete_A_DirectorList(String director){
        if(movieDirectorData.containsKey(director)) {
            DirectorData.remove(director);
            List<String> movies = movieDirectorData.get(director);
            for (String movie : movies) movieData.remove(movie);
            movieDirectorData.remove(director);
        }
    }

    public void delete_All_List(){
        for (String director:movieDirectorData.keySet()){
            delete_A_DirectorList(director);
        }
    }
}
