const initialState = {
  popularMovieList: [],
};

const movieReducer = (state = initialState, action: any) => {
  switch (action.type) {
    case "GET_POPULAR_MOVIES":
      return { ...state, popularMovieList: action.payload };
    default:
      return state;
  }
};

export default movieReducer;
