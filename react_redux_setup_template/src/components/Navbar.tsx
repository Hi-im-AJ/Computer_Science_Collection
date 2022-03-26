import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <nav>
      <ul style={{ listStyle: "none" }}>
        <li>
          <input placeholder="search" />
          <button>Search</button>
        </li>
        <li style={{ margin: "1rem 0" }}>
          <Link to="/">Home</Link>
          <Link style={{ margin: "0 1rem" }} to="/about">
            About
          </Link>
          <Link to="/movie">Movie</Link>
        </li>
      </ul>
    </nav>
  );
};

export default Navbar;
