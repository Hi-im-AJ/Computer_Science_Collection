import { useEffect } from "react";
import { connect } from "react-redux";
import MovieCard from "./MovieCard";
import { getPopularMovies } from "../actions/movieActions";

const Popular = ({ movies, getPopularMovies }: any) => {
  const { popularMovieList } = movies;

  useEffect(() => {
    getPopularMovies();
  }, [getPopularMovies]);

  if (popularMovieList.length === 0) {
    return <p>No movies to show</p>;
  }

  return (
    <div>
      {popularMovieList.map((movie: any) => (
        <MovieCard key={movie.id} title={movie.title} />
      ))}
    </div>
  );
};

export default connect(
  (state: any) => ({
    movies: state.movies,
  }),
  { getPopularMovies }
)(Popular);
