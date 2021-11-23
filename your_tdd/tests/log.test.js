const request = require("supertest");
const app = require("../app");

describe("/Log", () => {
  it("GET /log/1 --> Get specific log by ID", async () => {
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
  it("GET /log/id --> 404 if not found", async () => {
    const max_int = Number.MAX_SAFE_INTEGER;
    return request(app)
      .get(`/log/${max_int}`)
      .expect("Content-Type", /json/)
      .expect(404)
      .then((res) => {
        expect(res.body).toEqual(
          expect.objectContaining({
            success: false,
            message: "Log was not found!",
          })
        );
      });
  });

  it("POST /log --> Add log", async () => {
    return request(app)
      .post("/log")
      .send({
        title: "Test title",
        description: "Testing, hehe",
      })
      .expect("Content-Type", /json/)
      .expect(201)
      .then((res) => {
        expect(res.body).toEqual(
          expect.objectContaining({
            success: true,
            message: "Log added successfully!",
          })
        );
      });
  });
  it("POST /log/id --> Validate request body types", async () => {
    return request(app)
      .post("/log")
      .send({
        title: 1,
        description: "Testing, hehe",
      })
      .expect("Content-Type", /json/)
      .expect(422)
      .then((res) => {
        expect(res.body).toEqual(
          expect.objectContaining({
            success: false,
            message: "Log contained invalid input types!",
          })
        );
      });
  });
  it("PUT /log/id --> Update specific log by ID", async () => {
    return request(app)
      .put("/log/1")
      .send({
        title: "Hackerman was here!",
        description: "You have no logs on me! Haha!",
      })
      .expect(200)
      .expect("Content-Type", /json/)
      .then((res) => {
        expect(res.body).toEqual(
          expect.objectContaining({
            success: true,
            message: "Log updated successfully!",
          })
        );
      });
  });
  it("DELETE /log/id --> Delete specific log by ID", async () => {
    return request(app)
      .delete("/log/1")
      .expect(200)
      .expect("Content-Type", /json/)
      .then((res) => {
        expect(res.body).toEqual(
          expect.objectContaining({
            success: true,
            message: "Log deleted successfully!",
          })
        );
      });
  });
});
