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
    public void obtenerVuelosPositivo() {
        Aeropuerto aeropuerto = Aeropuerto.builder()
                .idAeropuerto(1)
                .nombre("Aeropuerto El Dorado")
                .iata("BOG")
                .ubicacion("Bogotá")
                .estado("A")
                .build();

        Vuelo.builder()
                .idVuelo(1)
                .aeropuertoOrigen(aeropuerto)
                .aeropuertoDestino(aeropuerto)
                .precio(100000)
                .horaSalida(new Date())
                .horaLlegada(new Date())
                .precioAsientoBasico(100000)
                .precioAsientoNormal(200000)
                .precioAsientoVip(300000)
                .estado("A")
                .build();

        List<Vuelo> vuelos = Arrays.asList(Vuelo.builder()
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
                        .build(),
                Vuelo.builder()
                        .idVuelo(2)
                        .aeropuertoOrigen(aeropuerto)
                        .aeropuertoDestino(aeropuerto)
                        .precio(150000)
                        .horaSalida(new Date())
                        .horaLlegada(new Date())
                        .precioAsientoVip(80000)
                        .precioAsientoNormal(50000)
                        .precioAsientoBasico(30000)
                        .estado("A")
                        .build());

        Mockito.when(vueloRepository.findAll()).thenReturn(vuelos);
        List<VueloDTO> vuelosDTO = vueloService.obtenerVuelos();
        
        assertEquals(2, vuelosDTO.size());
        assertEquals(10000, vuelosDTO.get(0).getPrecio());


    }

    @Test
    public void obtenerVuelosNegativo(){
        List<Vuelo> vuelos = Arrays.asList();
        Mockito.when(vueloRepository.findAll()).thenReturn(vuelos);
        List<VueloDTO> vuelosDTO = vueloService.obtenerVuelos();
        assertEquals(0, vuelosDTO.size());
    }
    
    @Test
    public void obtenerVuelosIdPositivo() throws Exception {
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
        
        Mockito.when(vueloRepository.existsById(1)).thenReturn(true);
        Mockito.when(vueloRepository.getReferenceById(1)).thenReturn(vuelo);
        VueloDTO vueloDTO = vueloService.obtenerVueloPorId(1);
        assertEquals(1, vueloDTO.getIdVuelo());
    }

    @Test
    public void obtenerVuelosIdNegativo() throws Exception {
        Mockito.when(vueloRepository.existsById(1)).thenReturn(false);
        VueloDTO vueloDTO = vueloService.obtenerVueloPorId(1);
        assertEquals(null, vueloDTO);
    }

    @Test
    public void guardarVueloPositivo () throws Exception {
        Aeropuerto aeropuerto = Aeropuerto.builder()
                .idAeropuerto(1)
                .nombre("Aeropuerto El Dorado")
                .iata("BOG")
                .ubicacion("Bogotá")
                .estado("A")
                .build();

        VueloDTO vueloDTO = VueloDTO.builder()
                .idVuelo(1)
                .idAeropuertoOrigen(1)
                .idAeropuertoDestino(1)
                .precio(100000)
                .horaSalida(new Date())
                .horaLlegada(new Date())
                .precioAsientoVip(50000)
                .precioAsientoNormal(30000)
                .precioAsientoBasico(10000)
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

        Mockito.when(vueloRepository.save(vuelo)).thenReturn(vuelo);
        VueloDTO vueloDTOGuardado = vueloService.guardarVuelo(vueloDTO);
        assertEquals(1, vueloDTOGuardado.getIdVuelo());
    }

    @Test
    public void guardarVueloNegativo() throws Exception {
        VueloDTO vueloDTO = VueloDTO.builder()
                .idVuelo(1)
                .idAeropuertoOrigen(1)
                .idAeropuertoDestino(1)
                .precio(100000)
                .horaSalida(new Date())
                .horaLlegada(new Date())
                .precioAsientoVip(50000)
                .precioAsientoNormal(30000)
                .precioAsientoBasico(10000)
                .estado("A")
                .build();

        Mockito.when(vueloRepository.save(null)).thenReturn(null);
        VueloDTO vueloDTOGuardado = vueloService.guardarVuelo(vueloDTO);
        assertEquals(null, vueloDTOGuardado);
    }

    @Test
    public void actualizarVueloPositivo() throws Exception {
        Aeropuerto aeropuerto = Aeropuerto.builder()
                .idAeropuerto(1)
                .nombre("Aeropuerto El Dorado")
                .iata("BOG")
                .ubicacion("Bogotá")
                .estado("A")
                .build();

        VueloDTO vueloDTO = VueloDTO.builder()
                .idVuelo(1)
                .idAeropuertoOrigen(1)
                .idAeropuertoDestino(1)
                .precio(100000)
                .horaSalida(new Date())
                .horaLlegada(new Date())
                .precioAsientoVip(50000)
                .precioAsientoNormal(30000)
                .precioAsientoBasico(10000)
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

        Mockito.when(vueloRepository.existsById(1)).thenReturn(true);
        Mockito.when(vueloRepository.save(vuelo)).thenReturn(vuelo);
        VueloDTO vueloDTOGuardado = vueloService.actualizarVuelo(vueloDTO);
        assertEquals(1, vueloDTOGuardado.getIdVuelo());
    }

    @Test
    public void actualizarVueloNegativo() throws Exception {
        VueloDTO vueloDTO = VueloDTO.builder()
                .idVuelo(1)
                .idAeropuertoOrigen(1)
                .idAeropuertoDestino(1)
                .precio(100000)
                .horaSalida(new Date())
                .horaLlegada(new Date())
                .precioAsientoVip(50000)
                .precioAsientoNormal(30000)
                .precioAsientoBasico(10000)
                .estado("A")
                .build();

        Mockito.when(vueloRepository.existsById(1)).thenReturn(false);
        Mockito.when(vueloRepository.save(null)).thenReturn(null);
        VueloDTO vueloDTOGuardado = vueloService.actualizarVuelo(vueloDTO);
        assertEquals(null, vueloDTOGuardado);
    }

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
