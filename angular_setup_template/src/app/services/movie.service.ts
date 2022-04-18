import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Movie } from 'src/app/Movie';

@Injectable({
  providedIn: 'root',
})
export class MovieService {
  private apiUrl = `https://api.themoviedb.org/3/movie/550?api_key=${process.env.API_KEY}`;
  constructor() {}

  getMovies(): Observable<Movie[]> {
    const movies: Movie[] = [];
    return movies;
  }
}
