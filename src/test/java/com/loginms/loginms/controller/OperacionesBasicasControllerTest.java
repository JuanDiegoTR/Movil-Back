package com.loginms.loginms.controller;

import com.loginms.loginms.dto.ContaOutDTO;
import com.loginms.loginms.service.implementation.OperacionesBasicasService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class OperacionesBasicasControllerTest {

    @Mock
    OperacionesBasicasService operacionesBasicasService;
    @InjectMocks
    OperacionesBasicasController operacionesBasicasController;
    @Test
    void gastosDeUsuario() {
        String usuario = "Juan";
        Long gastos= 1L;
        Mockito.when(operacionesBasicasService.gastosDeUsuario(usuario))
                .thenReturn(gastos);
        Long result = operacionesBasicasController.gastosDeUsuario(usuario);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(result,gastos);
    }

    @Test
    void ingresosDeUsuario() {
    }

    @Test
    void listGastosByusuario() {
    }

    @Test
    void listIngresosByusuario() {
        String usuario = "Juan";
        Long pagina = 1L;
        Long cantidad =2L;
        ContaOutDTO conta = Mockito.mock(ContaOutDTO.class);
        Mockito.when(operacionesBasicasService.paginadoIngresos(usuario,pagina,cantidad))
                .thenReturn(conta);
        ContaOutDTO conte = operacionesBasicasController.listIngresosByusuario(usuario,pagina,cantidad);
        Assertions.assertEquals(conte,conta);
        Assertions.assertNotNull(conta);
    }

    @Test
    void disponible() {
    }
}