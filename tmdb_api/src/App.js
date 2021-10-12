import React, { useState } from "react";
import axios from "axios";
import { Form, Button, Row, Col, Container } from "react-bootstrap";
import Movie from "./components/Movie";

function App() {
  const [movies, setMovies] = useState([]);
  const [searchResult, setSearchResult] = useState(null);
  const [lastQuery, setLastQuery] = useState("");
  const [input, setInput] = useState("");

  const search = async (query, page = 1) => {
    setLastQuery(query);
    const res = await axios.get(
      `https://api.themoviedb.org/3/search/movie?api_key=${process.env.REACT_APP_TMDB_KEY}&language=en-US&query=${lastQuery}&page=${page}&include_adult=false`
    );
    setSearchResult(res.data);
    page !== 1 ? setMovies([...movies, res.data.results]) : setMovies([]);
  };
  const onChange = (e) => setInput(e.target.value);
  const onKeyPress = (e) => (e.code === "Enter" ? search(input) : undefined);

  return (
    <div className="App">
      <Container>
        <Form as={Row} className="m-3">
          <Form.Group sm={10} as={Col}>
            <Form.Control
              onKeyPress={(e) => onKeyPress(e)}
              onChange={(e) => onChange(e)}
              type="text"
              placeholder="Search"
            />
          </Form.Group>
          <Form.Group sm={2} as={Col}>
            <Button onClick={() => search(input)} variant="primary" type="submit">
              Search
            </Button>
          </Form.Group>
        </Form>
      </Container>
      <Container className="">
        <Row>
          {searchResult != null &&
            searchResult.results.map((e) => (
              <Col key={e.id} className="m-3">
                <Movie movie={e} />
              </Col>
            ))}
        </Row>
      </Container>
    </div>
  );
}

export default App;
