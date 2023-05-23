package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {
    MovieService movieService=new MovieService();
     @PostMapping("POST /movies/add-movie")
     public ResponseEntity<String> addMovie(@RequestBody Movie movie){
         movieService.moviePost(movie);
         return new ResponseEntity<>("Movie posted successfully",HttpStatus.CREATED);
     }

    @PostMapping("POST /movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
         movieService.directorPost(director);
        return new ResponseEntity<>("Director posted successfully",HttpStatus.CREATED);
    }

    @PutMapping ("PUT /movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String director,@RequestParam String movie){
         movieService.movieDirectorPost(director,movie);
        return new ResponseEntity<>("Movie and Director paired successfully",HttpStatus.CREATED);
    }

    @GetMapping("GET /movies/get-movie-by-name/{neme}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
         Movie movie=movieService.movieGet(name);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }

    @GetMapping("GET /movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        Director director=movieService.directorGet(name);
        return new ResponseEntity<>(director,HttpStatus.CREATED);
    }

    @GetMapping("GET /movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
        List<String> moviesList=movieService.moviesOfDirector(director);
        return new ResponseEntity<>(moviesList,HttpStatus.CREATED);
    }

    @GetMapping("GET /movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> moviesList=movieService.moviesAllGet();
        return new ResponseEntity<>(moviesList,HttpStatus.CREATED);
    }

    @DeleteMapping("DELETE /movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String director){
         movieService.directorDel(director);
        return new ResponseEntity<>("Movie deleted successfully",HttpStatus.CREATED);
    }

    @DeleteMapping("DELETE /movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
         movieService.deleteAllPair();
        return new ResponseEntity<>("All Movies are deleted successfully",HttpStatus.CREATED);
    }
}
