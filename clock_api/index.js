const express = require("express");
const dotenv = require("dotenv");

const getDate = require("./routes/getDate");

dotenv.config({ path: "config/config.env" });

const app = express();

app.use(express.json());

app.use("/api/getdate", getDate);

const PORT = process.env.PORT || 5000;

const server = app.listen(PORT, `Server is running in ${process.env.NODE_ENV} mode on port ${PORT}`);

process.on("unhandledRejection", (err) => {
  console.error(err.message);
  server.close(() => process.exit(1));
});
