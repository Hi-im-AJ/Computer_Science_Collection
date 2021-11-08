const express = require("express");
const { getNodes, updateNodes } = require("../controllers/stats");

const router = express.Router();

router.route("/").get(getNodes).put(updateNodes);

module.exports = router;
