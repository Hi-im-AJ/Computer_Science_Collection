import { BrowserRouter, Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import Popular from "./components/Popular";
import About from "./components/About";
import Movie from "./components/Movie";

const App = () => {
  return (
    <main>
      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route path="/" element={<Popular />} />
          <Route path="/about" element={<About />} />
          <Route path="/movie" element={<Movie />} />
        </Routes>
      </BrowserRouter>
    </main>
  );
};

export default App;
