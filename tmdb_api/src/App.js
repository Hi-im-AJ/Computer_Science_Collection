import React, { useState } from "react";
import axios from "axios";
import { Form, Button, Row, Col } from "react-bootstrap";

function App() {
  const [searchList, setSearchList] = useState(null);
  const [input, setInput] = useState("");

  const search = async (query) => {
    console.log(query);
    const res = await axios.get(
      `https://api.themoviedb.org/3/search/movie?api_key=${process.env.REACT_APP_TMDB_KEY}&language=en-US&query=${query}&page=1&include_adult=false`
    );
    setSearchList(res.data);
  };
  const onInputChange = (e) => setInput(e.target.value);

  return (
    <div className="App">
      <Form as={Row} className="m-3">
        <Form.Group as={Col}>
          <Form.Control onChange={(e) => onInputChange(e)} type="text" placeholder="Search" />
        </Form.Group>
        <Form.Group as={Col}>
          <Button onClick={() => search(input)} variant="primary" type="submit">
            Search
          </Button>
        </Form.Group>
      </Form>
      <div>
        <table>
          {searchList.results.map((e) => (
            <tr>
              <td>{e.title}</td>
            </tr>
          ))}
        </table>
      </div>
    </div>
  );
}

export default App;
