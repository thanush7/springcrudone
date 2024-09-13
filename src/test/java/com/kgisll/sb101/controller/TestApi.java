// package com.kgisll.sb101.controller;

// import java.util.HashMap;
// import java.util.Map;

// import org.junit.jupiter.api.AfterAll;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import org.junit.jupiter.api.BeforeAll;
// import org.junit.jupiter.api.Order;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.TestInstance;
// import org.springframework.boot.test.context.SpringBootTest;

// import com.google.gson.Gson;
// import com.google.gson.JsonArray;
// import com.kgisll.sb101.entity.Person;
// import com.microsoft.playwright.APIRequest;
// import com.microsoft.playwright.APIRequestContext;
// import com.microsoft.playwright.APIResponse;
// import com.microsoft.playwright.Playwright;
// import com.microsoft.playwright.options.RequestOptions;

// // @TestInstance(TestInstance.Lifecycle.PER_CLASS)
// @SpringBootTest
// @TestInstance(TestInstance.Lifecycle.PER_CLASS)
// public class TestApi {

//     private Playwright playwright;
//     private APIRequestContext request;

//     // private static final String BaseUR
//     @BeforeAll
//     void beforeAll() {
//         createPlaywright();
//         createAPIRequestContext();
//     }

//     void createPlaywright() {
//         playwright = Playwright.create();
//     }

//     void createAPIRequestContext() {
//         Map<String, String> headers = new HashMap<>();
//         request = playwright.request().newContext(new APIRequest.NewContextOptions()
//                 // All requests we send go to this API endpoint.
//                 .setBaseURL("http://localhost:9090")
//                 .setExtraHTTPHeaders(headers));
//     }

//     void disposeAPIRequestContext() {
//         if (request != null) {
//             request.dispose();
//             request = null;
//         }
//     }

//     void closePlaywright() {
//         if (playwright != null) {
//             playwright.close();
//             playwright = null;
//         }
//     }

//     @AfterAll
//     void afterAll() {
//         disposeAPIRequestContext();
//         closePlaywright();
//     }

//     //get all
//     @Test
//     @Order(1)
//     void shouldGetAllPersons() {
//         APIResponse response = request.get("/person");

//         JsonArray json = new Gson().fromJson(response.text(), JsonArray.class);
//         // assertEquals(26, json.size());
//         Person firstPerson = new Gson().fromJson(json.get(1), Person.class);

//         assertEquals(firstPerson.uname(), "string");
//         assertEquals(firstPerson.email(), "string");
//     }

//     //create
//     @Test
//     @Order(2)
//     void shouldCreatePerson() {
//         Map<String, String> data = new HashMap<>();
//         data.put("uname", "PlaywrightF1");
//         data.put("email", "email1@email.com");

//         APIResponse response = request.post("/person", RequestOptions.create().setData(data));

//         Person person = new Gson().fromJson(response.text(), Person.class);

//         assertEquals(201, response.status());

//         assertEquals(person.uname(), "PlaywrightF1");
//         assertEquals(person.email(), "email1@email.com");
//     }
//     //get by id

//     @Test
//     @Order(3)
//     void shouldGetPerson() {

//         APIResponse response = request.get("/person/2");

//         Person person = new Gson().fromJson(response.text(), Person.class);

//         assertEquals(200, response.status());

//         assertEquals(person.uname(), "Bob 2");
//         assertEquals(person.email(), "bob@example");
//     }

//     // @Disabled
//     @Test
//     @Order(5)
//     void shouldDeletePerson() {
//         APIResponse response = request.delete("/person/2");
//         assertEquals(204, response.status());
//     }

//     @Test
//     @Order(4)
//     void shouldUpdatePerson() {
//         Map<String, String> data = new HashMap<>();
//         data.put("id", "2");
//         data.put("uname", "alagu");
//         data.put("email", "thanush@email.com");

//         APIResponse response = request.put("/person/5", RequestOptions.create().setData(data));
//         Person person = new Gson().fromJson(response.text(), Person.class);
//         assertEquals(200, response.status());
//         assertEquals(person.uname(), "alagu");
//         assertEquals(person.email(), "thanush@email.com");
//     }

// }
