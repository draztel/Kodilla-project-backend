package com.kodilla.project.controller;

import com.kodilla.project.domain.dto.FactDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FactController.class)
@RunWith(SpringRunner.class)
public class FactControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FactController controller;

    @Test
    public void shouldGetRandomFact() throws Exception {
        //given
        FactDto factDto = new FactDto("text");

        //when
        when(controller.getRandomFact()).thenReturn(factDto);

        //then
        mockMvc.perform(get("/v1/fact/random"))
                .andExpect(status().isOk());
    }
}
