package co.edu.usbcali.airlinesapp.service;

import co.edu.usbcali.airlinesapp.dtos.VueloDTO;
import co.edu.usbcali.airlinesapp.repository.AeropuertoRepository;
import co.edu.usbcali.airlinesapp.repository.VueloRepository;
import co.edu.usbcali.airlinesapp.services.implementation.VueloServiceImpl;
import co.edu.usbcali.airlinesapp.utilities.AeropuertoUtility;
import co.edu.usbcali.airlinesapp.utilities.VueloUtility;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class VueloServiceImplTest {
    @InjectMocks
    private VueloServiceImpl vueloServiceImpl;

    @Mock
    private VueloRepository vueloRepository;

    @Mock
    private AeropuertoRepository aeropuertoRepository;

    @Test
    public void guardarVueloOk() throws Exception {
        given(aeropuertoRepository.existsById(AeropuertoUtility.IDNUNO)).willReturn(true);
        given(aeropuertoRepository.getReferenceById(AeropuertoUtility.IDNUNO)).willReturn(AeropuertoUtility.AEROPUERTONUNO);
        given(aeropuertoRepository.existsById(AeropuertoUtility.IDNDOS)).willReturn(true);
        given(aeropuertoRepository.getReferenceById(AeropuertoUtility.IDNDOS)).willReturn(AeropuertoUtility.AEROPUERTONDOS);
        given(vueloRepository.existsById(VueloUtility.IDNUNO)).willReturn(false);
        given(vueloRepository.save(any())).willReturn(VueloUtility.VUELONUNO);

        VueloDTO vueloSavedDTO = vueloServiceImpl.guardarVuelo(VueloUtility.VUELODTONUNO);

        assertEquals(VueloUtility.IDNUNO, vueloSavedDTO.getIdVuelo());
    }

    @Test
    public void guardarVueloNotOk() {
        given(vueloRepository.existsById(VueloUtility.IDNUNO)).willReturn(true);

        assertThrows(Exception.class, () -> vueloServiceImpl.guardarVuelo(VueloUtility.VUELODTONUNO));
    }

    @Test
    public void obtenerVuelosOk() {
        given(vueloRepository.findAll()).willReturn(VueloUtility.VUELOS);

        List<VueloDTO> vuelosSavedDTO = vueloServiceImpl.obtenerVuelos();

        assertEquals(VueloUtility.VUELOSNSIZE, vuelosSavedDTO.size());
        assertEquals(VueloUtility.PRECIONUNO, vuelosSavedDTO.get(0).getPrecio());
    }

    @Test
    public void obtenerVuelosNotOk() {
        given(vueloRepository.findAll()).willReturn(VueloUtility.VUELOSNVACIO);

        List<VueloDTO> vuelosSavedDTO = vueloServiceImpl.obtenerVuelos();

        assertEquals(VueloUtility.VUELOSNVACIONSIZE, vuelosSavedDTO.size());
    }

    @Test
    public void obtenerVuelosActivosOk() {
        given(vueloRepository.findAllByEstado("A")).willReturn(VueloUtility.VUELOS);

        List<VueloDTO> vuelosSavedDTO = vueloServiceImpl.obtenerVuelosActivos();

        assertEquals(VueloUtility.VUELOSNSIZE, vuelosSavedDTO.size());
        assertEquals(VueloUtility.PRECIONUNO, vuelosSavedDTO.get(0).getPrecio());
    }

    @Test
    public void obtenerVuelosActivosNotOk() {
        given(vueloRepository.findAllByEstado("A")).willReturn(VueloUtility.VUELOSNVACIO);

        List<VueloDTO> vuelosSavedDTO = vueloServiceImpl.obtenerVuelosActivos();

        assertEquals(VueloUtility.VUELOSNVACIONSIZE, vuelosSavedDTO.size());
    }

    @Test
    public void obtenerVueloPorIdOk() throws Exception {
        aeropuertoRepository.save(AeropuertoUtility.AEROPUERTONUNO);
        aeropuertoRepository.save(AeropuertoUtility.AEROPUERTONDOS);
        vueloRepository.save(VueloUtility.VUELONUNO);

        given(vueloRepository.existsById(VueloUtility.IDNUNO)).willReturn(true);
        given(vueloRepository.getReferenceById(VueloUtility.IDNUNO)).willReturn(VueloUtility.VUELONUNO);

        VueloDTO vueloSavedDTO = vueloServiceImpl.obtenerVueloPorId(VueloUtility.IDNUNO);

        assertEquals(VueloUtility.IDNUNO, vueloSavedDTO.getIdVuelo());
    }

    @Test
    public void obtenerVueloPorIdNotOk() {
        given(vueloRepository.existsById(VueloUtility.IDNUNO)).willReturn(false);

        assertThrows(Exception.class, () -> vueloServiceImpl.obtenerVueloPorId(VueloUtility.IDNUNO));
    }

    @Test
    public void actualizarVueloOk() throws Exception {
        given(aeropuertoRepository.existsById(AeropuertoUtility.IDNUNO)).willReturn(true);
        given(aeropuertoRepository.getReferenceById(AeropuertoUtility.IDNUNO)).willReturn(AeropuertoUtility.AEROPUERTONUNO);
        given(aeropuertoRepository.existsById(AeropuertoUtility.IDNDOS)).willReturn(true);
        given(aeropuertoRepository.getReferenceById(AeropuertoUtility.IDNDOS)).willReturn(AeropuertoUtility.AEROPUERTONDOS);
        given(vueloRepository.existsById(VueloUtility.IDNUNO)).willReturn(true);
        given(vueloRepository.save(any())).willReturn(VueloUtility.VUELONUNO);

        VueloDTO vueloSavedDTO = vueloServiceImpl.actualizarVuelo(VueloUtility.VUELODTONUNO);

        assertEquals(VueloUtility.IDNUNO, vueloSavedDTO.getIdVuelo());
    }

    @Test
    public void actualizarVueloNotOk() {
        given(vueloRepository.existsById(VueloUtility.IDNUNO)).willReturn(false);

        assertThrows(Exception.class, () -> vueloServiceImpl.actualizarVuelo(VueloUtility.VUELODTONUNO));
    }
}
