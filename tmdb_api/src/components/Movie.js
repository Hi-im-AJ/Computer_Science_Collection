import React from "react";

const Movie = ({ movie }) => {
  return (
    <div>
      <a target="_blank" rel="noreferrer" href={`https://www.themoviedb.org/movie/${movie.id}`}>
        <img
          className="poster"
          alt={movie.title}
          src={
            movie.poster_path !== null
              ? `https://www.themoviedb.org/t/p/w600_and_h900_bestv2${movie.poster_path}`
              : "https://www.themoviedb.org/assets/2/v4/glyphicons/basic/glyphicons-basic-38-picture-grey-c2ebdbb057f2a7614185931650f8cee23fa137b93812ccb132b9df511df1cfac.svg"
          }
        />
      </a>
    </div>
  );
};

export default Movie;
