var express = require("express");
var router = express.Router();

const logs = [
  {
    id: 1,
    title: "Authentication bypass detected",
    description:
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras aliquet, tellus quis auctor auctor, mauris urna vehicula ipsum, vitae commodo tortor felis ut lectus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Cras feugiat et justo eget finibus. Donec non tortor rhoncus, rutrum urna quis, tincidunt arcu. Quisque eleifend faucibus urna tincidunt ultricies. Morbi blandit eros dolor, ut dignissim neque faucibus sit amet. Ut rhoncus, sem sed placerat euismod, lorem lorem auctor purus, nec rhoncus risus nisi eu libero. In interdum aliquam semper. Ut mollis odio lorem, eu egestas orci dignissim ac. In hac habitasse platea dictumst. Nulla eu odio non lacus convallis mattis vel eu sapien. Phasellus arcu tortor, maximus a velit et, rutrum egestas augue. Nulla tempor consequat fermentum. Nunc arcu odio, hendrerit ut ipsum sit amet, rutrum laoreet diam. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.",
  },
];

router
  .get("/:id", (req, res) => {
    const log = logs.find((e) => e.id === Number(req.params.id));
    if (log === undefined)
      return res.status(404).json({
        success: false,
        message: "Log was not found!",
      });
    res.status(200).json(log);
  })
  .post("/", (req, res) => {
    const log = { id: Math.round(Math.random() * Number.MAX_SAFE_INTEGER), ...req.body };
    if (Object.keys(log).length !== 3 || typeof log.title !== "string" || typeof log.description !== "string") {
      return res.status(422).json({
        success: false,
        message: "Log contained invalid input types!",
      });
    }
    logs.push(log);
    res.status(201).json({
      success: true,
      message: "Log added successfully!",
    });
  })
  .put("/:id", (req, res) => {})
  .delete("/:id", (req, res) => {});

module.exports = router;
