const Stats = require("../models/Stats");

exports.getNodes = async (req, res) => {
  const stats = await Stats.findById("6189786c643431e3e472ecf4");
  if (!stats) return res.status(400).json("Bad request");
  res.status(200).json({ nodes: stats.nodes });
};

exports.updateNodes = async (req, res) => {
  const stats = await Stats.findByIdAndUpdate("6189786c643431e3e472ecf4", req.body, {
    new: true,
    runValidators: true,
  });
  if (!stats) return res.status(400).json("Bad request");
  res.status(200).json({ nodes: stats.nodes });
};
