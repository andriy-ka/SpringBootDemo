package com.training;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.model.User;
import com.training.repository.MainRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objMapper;

    @MockBean
    private MainRepository mainRepositoryMock;

    private final User user = new User(2, "Roman", 19);

    @Test
    public void getUserByIdTest() throws Exception {

        when(mainRepositoryMock.getUserById(Mockito.anyInt())).thenReturn(user);

        mockMvc.perform(get("/main/user?id={id}", String.valueOf(user.getId()))
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(user.getId()))
                .andExpect(jsonPath("$.name").value(user.getName()))
                .andExpect(jsonPath("$.age").value(user.getAge()));
    }

    @Test
    public void getAllUsersTest() throws Exception {

        when(mainRepositoryMock.findAll()).thenReturn(Collections.singletonList(user));

        mockMvc.perform(get("/main/users")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].id").isNotEmpty())
                .andExpect(jsonPath("$.[0].name").value(user.getName()))
                .andExpect(jsonPath("$.[0].age").value(user.getAge()));
    }

    @Test
    public void createUserTest() throws Exception {

        mockMvc.perform(post("/main/create")
                .content(objMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .characterEncoding("UTF-8")
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.name").value(user.getName()))
                .andExpect(jsonPath("$.age").value(user.getAge()));
    }

    @Test
    public void updateUserTest() throws Exception {
        mockMvc.perform(post("/main/update")
                .content(objMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .characterEncoding("UTF-8")
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.name").value(user.getName()))
                .andExpect(jsonPath("$.age").value(user.getAge()));
    }

    @Test
    public void deleteUserTest() throws Exception {

        doNothing().when(mainRepositoryMock).deleteById(Mockito.anyInt());

        mockMvc.perform(get("/main/delete/user?id={id}", 2)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk());

    }
}
