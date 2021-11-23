const request = require("supertest");
const app = require("../app");

describe("/Log", () => {
  it("GET /log?id=1 --> Get specific log by ID", () => {
    return request(app)
      .get("/log/1")
      .expect("Content-Type", /json/)
      .expect(200)
      .then((res) => {
        expect(res.body).toEqual(
          expect.objectContaining({
            id: expect.any(Number),
            title: expect.any(String),
            description: expect.any(String),
          })
        );
      });
  });
  it("GET /log/id --> 404 if not found", () => {
    return false;
  });
  it("GET /log/id --> Validate request body", () => {
    return false;
  });
  it("POST /log --> Add log", () => {
    return false;
  });
  it("PUT /log/id --> Update specific log by ID", () => {
    return false;
  });
  it("DELETE /log/id --> Delete specific log by ID", () => {
    return false;
  });
});
