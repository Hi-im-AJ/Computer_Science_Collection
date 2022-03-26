import { BrowserRouter } from "react-router-dom";
import Navbar from "./components/Navbar";
import Popular from "./components/Popular";

const App = () => {
  return (
    <main>
      <Navbar />
      <BrowserRouter>
        <Popular />
      </BrowserRouter>
    </main>
  );
};

export default App;
