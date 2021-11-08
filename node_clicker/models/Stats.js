const mongoose = require("mongoose");

const StatsSchema = new mongoose.Schema({
  nodes: String,
});

module.exports = mongoose.model("Stats", StatsSchema);
