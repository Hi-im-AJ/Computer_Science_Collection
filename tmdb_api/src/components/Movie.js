import React from "react";

const Movie = ({ movie }) => {
  return (
    <div>
      {movie.poster_path != null ? (
        <a target="_blank" rel="noreferrer" href={`https://www.themoviedb.org/movie/${movie.id}`}>
          <img
            className="poster"
            alt={movie.title}
            src={
              movie.poster_path != null
                ? `https://www.themoviedb.org/t/p/w600_and_h900_bestv2${movie.poster_path}`
                : undefined
            }
          />
        </a>
      ) : (
        <h4>{movie.title}</h4>
      )}
    </div>
  );
};

export default Movie;
