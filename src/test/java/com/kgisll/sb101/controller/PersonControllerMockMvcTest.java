// package com.kgisll.sb101.controller;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


// @SpringBootTest
// @AutoConfigureMockMvc
// public class PersonControllerMockMvcTest {
    
//     @Autowired
//     private MockMvc mockmvc;

//     @Test
//     public void testGetallPersonsEndpoint() throws Exception {
//         mockmvc.perform(MockMvcRequestBuilders.get("/person"))
//                 .andExpect(status().isOk());
//     }

//     @Test
//     public void testGetPersonByIdEndpoint() throws Exception {
//         int personId = 2;
//         mockmvc.perform(MockMvcRequestBuilders.get("/person/{id}", personId))
//                 .andExpect(status().isOk())
//                 .andExpect(content().contentType(MediaType.APPLICATION_JSON));
//     }
//     @Test
//     public void testDeletePersonEndpoint() throws Exception {
//         int personId = 1; 
//         mockmvc.perform(MockMvcRequestBuilders.delete("/person/{id}", personId))
//                 .andExpect(status().isNoContent());
//     }

//     @Test
//     public void testCreatePersonEndpoint() throws Exception {
//         String newPersonJson = "{\"uname\":\"John Doe\",\"email\":\"email@email.com\"}";
//         mockmvc.perform(MockMvcRequestBuilders.post("/person")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(newPersonJson))
//                 .andExpect(status().isCreated())
//                 .andExpect(content().contentType(MediaType.APPLICATION_JSON));
//     }

//     @Test
//     public void testUpdatePersonEndpoint() throws Exception {
//         int personId = 195; // Adjust this ID based on your test data
//         String updatedPersonJson = "{\"uname\":\"John Doe update\",\"email\":\"updateemail@email.com\"}";
//         mockmvc.perform(MockMvcRequestBuilders.put("/person/{id}", personId)
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(updatedPersonJson))
//                 .andExpect(status().isOk())
//                 .andExpect(content().contentType(MediaType.APPLICATION_JSON));
//     }

// }
