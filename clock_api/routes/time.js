const express = require("express");

const { getTime } = require("../controllers/time");

const router = express.Router();

router.route("/").get(getTime);

module.exports = router;
