var express = require("express");
var router = express.Router();

/* GET users listing. */
router
  .get("/:id", (req, res) => {
    res.send("respond with a resource");
  })
  .post("/", (req, res) => {})
  .put("/:id", (req, res) => {})
  .delete("/:id", (req, res) => {});

module.exports = router;
