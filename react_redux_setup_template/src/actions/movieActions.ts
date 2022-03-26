import axios from "axios";

export const getPopularMovies = () => async (dispatch: any) => {
  try {
    const res = await axios({
      method: "get",
      url: `https://api.themoviedb.org/3/movie/popular?api_key=${process.env.REACT_APP_MDB_API_KEY}`,
    });
    dispatch({
      type: "GET_POPULAR_MOVIES",
      payload: res.data.results,
    });
  } catch (error) {
    console.error(error);
  }
};
