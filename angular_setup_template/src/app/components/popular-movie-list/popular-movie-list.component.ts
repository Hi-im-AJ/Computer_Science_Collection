import { Component, OnInit } from '@angular/core';
import { MovieService } from 'src/app/services/movie.service';
import { Movie } from 'src/app/Movie';

@Component({
  selector: 'app-list',
  templateUrl: './popular-movie-list.component.html',
  styleUrls: ['./popular-movie-list.component.scss'],
  providers: [MovieService],
})
export class PopularMovieListComponent implements OnInit {
  movies: Movie[] = [];
  message: string = '';
  constructor(private movieService: MovieService) {}

  ngOnInit(): void {
    this.movieService.getMovies().subscribe((movies: any) => {
      this.movies = movies['results'].map((movie: Movie) => ({
        ...movie,
        backdrop_path: `https://www.themoviedb.org/t/p/w600_and_h900_bestv2/${movie.backdrop_path}`,
      }));
      console.log(this.movies);
    });
  }
  onClick(): void {
    this.message = !this.message ? 'Event-binding!' : '';
  }
}
