exports.getTime = (req, res) => {
  const date = new Date();
  const day = date.getDay();
  const month = date.getMonth();
  const year = date.getFullYear();
  const hours = date.getHours();
  const minutes = date.getMinutes();
  const seconds = date.getSeconds();
  res.status(200).json({
    day,
    month,
    year,
    hours,
    minutes,
    seconds,
  });
};
