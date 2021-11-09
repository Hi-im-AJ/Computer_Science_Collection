import { useState, useEffect } from "react";
import axios from "axios";

const App = () => {
  const [time, setTime] = useState("");

  const getTime = async () => {
    const res = await axios.get("http://localhost:5000/api/time");
    const data = res.data;
    const time = `${data.hours}:${data.minutes}:${data.seconds}`;
    setTime(time);
  };

  useEffect(() => {
    getTime();
    const timer = setInterval(getTime, 1000);
    return () => {
      clearInterval(timer);
    };
  }, []);

  return (
    <div className="main">
      <div>{time}</div>
    </div>
  );
};

export default App;
