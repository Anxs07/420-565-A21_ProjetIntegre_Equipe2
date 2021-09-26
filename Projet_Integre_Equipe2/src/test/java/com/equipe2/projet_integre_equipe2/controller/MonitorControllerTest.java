package com.equipe2.projet_integre_equipe2.controller;

import com.equipe2.projet_integre_equipe2.model.Monitor;
import com.equipe2.projet_integre_equipe2.repository.MonitorRepository;
import com.equipe2.projet_integre_equipe2.service.MonitorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@WebMvcTest(MonitorController.class)
class MonitorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MonitorService monitorService;

    @MockBean
    private MonitorRepository monitorRepository;

    private Monitor expected;

    @Test
    public void subscribeMonitorTest() throws Exception {
        expected = Monitor.monitorBuilder()
                .firstName("toto")
                .lastName("toto")
                .email("toto@toto")
                .enterpriseName("toto")
                .password("1234")
                .build();
        when(monitorService.registerMonitor(expected)).thenReturn(Optional.of(expected));

        MvcResult result = mockMvc.perform(post("/monitors/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(expected))).andReturn();

        var actualMonitor = new ObjectMapper().readValue(result.getResponse().getContentAsString(), Monitor.class);
        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(expected).isEqualTo(actualMonitor);
    }

    @Test
    public void testMonitorExistsByEmail() {
        // Arrange
        
        String expectedEmail = "toto@toto.toto";
        boolean expectedResult = true;
        when(monitorRepository.existsByEmail(expectedEmail)).thenReturn(false);
        // Act
        boolean actualResult = monitorService.isMonitorExistsByEmail(expectedEmail);
        // Assert
        assertThat(actualResult).isFalse();
    }

    @Test
    public void testRegisterMonitorDuplicateId() {
        Monitor monitor1 = Monitor.monitorBuilder()
                .password("toto")
                .lastName("toto")
                .firstName("toto")
                .enterpriseName("toto")
                .email("toto@toto")
                .build();
        Monitor monitor2 = Monitor.monitorBuilder()
                .password("tata")
                .lastName("tata")
                .firstName("tata")
                .enterpriseName("tata")
                .email("tota@toto")
                .build();
        monitorService.registerMonitor(monitor1);
        monitorService.registerMonitor(monitor2);
        when(monitorService.isMonitorExistsByEmail(monitor1.getEmail())).thenReturn(true);
        assertThat(monitorService.isMonitorExistsByEmail(monitor1.getEmail())).isTrue();

    }
}