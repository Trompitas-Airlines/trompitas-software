package co.edu.usbcali.airlinesapp.service;


import co.edu.usbcali.airlinesapp.domain.Aeropuerto;
import co.edu.usbcali.airlinesapp.domain.Vuelo;
import co.edu.usbcali.airlinesapp.dtos.VueloDTO;
import co.edu.usbcali.airlinesapp.repository.VueloRepository;
import co.edu.usbcali.airlinesapp.services.interfaces.VueloService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class VueloServiceImplTest {
    @Autowired
    private VueloService vueloService;

    @MockBean
    private VueloRepository vueloRepository;
    @Test
    public void eliminarVueloPositivo() throws Exception {

    }

    @Test
    public void eliminarVueloNegativo() throws Exception {

    }

    @Test
    public void obtenerVuelosActivosPositivo() throws Exception {
        Aeropuerto aeropuerto = Aeropuerto.builder()
                .idAeropuerto(1)
                .nombre("Aeropuerto El Dorado")
                .iata("BOG")
                .ubicacion("Bogotá")
                .estado("A")
                .build();

        Vuelo vuelo = Vuelo.builder()
                .idVuelo(1)
                .aeropuertoOrigen(aeropuerto)
                .aeropuertoDestino(aeropuerto)
                .precio(100000)
                .horaSalida(new Date())
                .horaLlegada(new Date())
                .precioAsientoVip(50000)
                .precioAsientoNormal(30000)
                .precioAsientoBasico(10000)
                .estado("A")
                .build();

        List<Vuelo> vuelos = new ArrayList<>();
        vuelos.add(vuelo);

       Mockito.when(vueloRepository.getReferenceById(1)).thenReturn(vuelo);
        Mockito.when(vueloRepository.findAllByEstado("A")).thenReturn(vuelos);
        List<VueloDTO> vuelosDTO = vueloService.obtenerVuelosActivos();
        assertEquals(1, vuelosDTO.size());
    }

    @Test
    public void obtenerVuelosActivosNegativo() throws Exception {
        List<Vuelo> vuelos = new ArrayList<>();
        Mockito.when(vueloRepository.findAllByEstado("I")).thenReturn(vuelos);
        List<VueloDTO> vuelosDTO = vueloService.obtenerVuelosActivos();
        assertEquals(0, vuelosDTO.size());
    }


}
