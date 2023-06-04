package co.edu.usbcali.airlinesapp.service;

import co.edu.usbcali.airlinesapp.dtos.TrayectoDTO;
import co.edu.usbcali.airlinesapp.repository.AeropuertoRepository;
import co.edu.usbcali.airlinesapp.repository.AvionRepository;
import co.edu.usbcali.airlinesapp.repository.TrayectoRepository;
import co.edu.usbcali.airlinesapp.repository.VueloRepository;
import co.edu.usbcali.airlinesapp.services.implementation.TrayectoServiceImpl;
import co.edu.usbcali.airlinesapp.utilities.AeropuertoUtility;
import co.edu.usbcali.airlinesapp.utilities.AvionUtility;
import co.edu.usbcali.airlinesapp.utilities.TrayectoUtility;
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
public class TrayectoServiceImplTest {
    @InjectMocks
    private TrayectoServiceImpl trayectoServiceImpl;

    @Mock
    private TrayectoRepository trayectoRepository;

    @Mock
    private AvionRepository avionRepository;

    @Mock
    private AeropuertoRepository aeropuertoRepository;

    @Mock
    private VueloRepository vueloRepository;

    @Test
    public void guardarTrayectoOk() throws Exception {
        given(avionRepository.existsById(AvionUtility.IDNUNO)).willReturn(true);
        given(avionRepository.getReferenceById(AvionUtility.IDNUNO)).willReturn(AvionUtility.AVIONNUNO);
        given(aeropuertoRepository.existsById(AeropuertoUtility.IDNUNO)).willReturn(true);
        given(aeropuertoRepository.getReferenceById(AeropuertoUtility.IDNUNO)).willReturn(AeropuertoUtility.AEROPUERTONUNO);
        given(aeropuertoRepository.existsById(AeropuertoUtility.IDNDOS)).willReturn(true);
        given(aeropuertoRepository.getReferenceById(AeropuertoUtility.IDNDOS)).willReturn(AeropuertoUtility.AEROPUERTONDOS);
        given(vueloRepository.existsById(VueloUtility.IDNUNO)).willReturn(true);
        given(vueloRepository.getReferenceById(VueloUtility.IDNUNO)).willReturn(VueloUtility.VUELONUNO);
        given(trayectoRepository.existsById(TrayectoUtility.IDNUNO)).willReturn(false);
        given(trayectoRepository.save(any())).willReturn(TrayectoUtility.TRAYECTONUNO);

        TrayectoDTO trayectoSavedDTO = trayectoServiceImpl.guardarTrayecto(TrayectoUtility.TRAYECTODTONUNO);

        assertEquals(TrayectoUtility.IDNUNO, trayectoSavedDTO.getIdTrayecto());
    }

    @Test
    public void guardarTrayectoNotOk() {
        given(trayectoRepository.existsById(TrayectoUtility.IDNUNO)).willReturn(true);

        assertThrows(Exception.class, () -> trayectoServiceImpl.guardarTrayecto(TrayectoUtility.TRAYECTODTONUNO));
    }

    @Test
    public void obtenerTrayectosOk() {
        given(trayectoRepository.findAll()).willReturn(TrayectoUtility.TRAYECTOS);

        List<TrayectoDTO> trayectosSavedDTO = trayectoServiceImpl.obtenerTrayectos();

        assertEquals(TrayectoUtility.TRAYECTOSNSIZE, trayectosSavedDTO.size());
        assertEquals(TrayectoUtility.IDNUNO, trayectosSavedDTO.get(0).getIdTrayecto());
    }

    @Test
    public void obtenerTrayectosNotOk() {
        given(trayectoRepository.findAll()).willReturn(TrayectoUtility.TRAYECTOSNVACIO);

        List<TrayectoDTO> trayectosSavedDTO = trayectoServiceImpl.obtenerTrayectos();

        assertEquals(TrayectoUtility.TRAYECTOSNVACIONSIZE, trayectosSavedDTO.size());
    }

    @Test
    public void obtenerTrayectosActivosOk() {
        given(trayectoRepository.findAllByEstado("A")).willReturn(TrayectoUtility.TRAYECTOS);

        List<TrayectoDTO> trayectosSavedDTO = trayectoServiceImpl.obtenerTrayectosActivos();

        assertEquals(TrayectoUtility.TRAYECTOSNSIZE, trayectosSavedDTO.size());
        assertEquals(TrayectoUtility.IDNUNO, trayectosSavedDTO.get(0).getIdTrayecto());
    }

    @Test
    public void obtenerTrayectosActivosNotOk() {
        given(trayectoRepository.findAllByEstado("A")).willReturn(TrayectoUtility.TRAYECTOSNVACIO);

        List<TrayectoDTO> trayectosSavedDTO = trayectoServiceImpl.obtenerTrayectosActivos();

        assertEquals(TrayectoUtility.TRAYECTOSNVACIONSIZE, trayectosSavedDTO.size());
    }

    @Test
    public void obtenerTrayectosPorIdOk() throws Exception {
        avionRepository.save(AvionUtility.AVIONNUNO);
        aeropuertoRepository.save(AeropuertoUtility.AEROPUERTONUNO);
        aeropuertoRepository.save(AeropuertoUtility.AEROPUERTONDOS);
        vueloRepository.save(VueloUtility.VUELONUNO);
        trayectoRepository.save(TrayectoUtility.TRAYECTONUNO);

        given(trayectoRepository.existsById(TrayectoUtility.IDNUNO)).willReturn(true);
        given(trayectoRepository.getReferenceById(TrayectoUtility.IDNUNO)).willReturn(TrayectoUtility.TRAYECTONUNO);

        TrayectoDTO trayectoSavedDTO = trayectoServiceImpl.obtenerTrayectoPorId(TrayectoUtility.IDNUNO);

        assertEquals(TrayectoUtility.IDNUNO, trayectoSavedDTO.getIdTrayecto());
    }

    @Test
    public void obtenerTrayectosPorIdNotOk() {
        given(trayectoRepository.existsById(TrayectoUtility.IDNUNO)).willReturn(false);

        assertThrows(Exception.class, () -> trayectoServiceImpl.obtenerTrayectoPorId(TrayectoUtility.IDNUNO));
    }

    @Test
    public void actualizarTrayectoOk() throws Exception {
        given(avionRepository.existsById(AvionUtility.IDNUNO)).willReturn(true);
        given(avionRepository.getReferenceById(AvionUtility.IDNUNO)).willReturn(AvionUtility.AVIONNUNO);
        given(aeropuertoRepository.existsById(AeropuertoUtility.IDNUNO)).willReturn(true);
        given(aeropuertoRepository.getReferenceById(AeropuertoUtility.IDNUNO)).willReturn(AeropuertoUtility.AEROPUERTONUNO);
        given(aeropuertoRepository.existsById(AeropuertoUtility.IDNDOS)).willReturn(true);
        given(aeropuertoRepository.getReferenceById(AeropuertoUtility.IDNDOS)).willReturn(AeropuertoUtility.AEROPUERTONDOS);
        given(vueloRepository.existsById(VueloUtility.IDNUNO)).willReturn(true);
        given(vueloRepository.getReferenceById(VueloUtility.IDNUNO)).willReturn(VueloUtility.VUELONUNO);
        given(trayectoRepository.existsById(TrayectoUtility.IDNUNO)).willReturn(true);
        given(trayectoRepository.save(any())).willReturn(TrayectoUtility.TRAYECTONUNO);

        TrayectoDTO trayectoSavedDTO = trayectoServiceImpl.actualizarTrayecto(TrayectoUtility.TRAYECTODTONUNO);

        assertEquals(TrayectoUtility.IDNUNO, trayectoSavedDTO.getIdTrayecto());
    }

    @Test
    public void actualizarTrayectoNotOk() {
        given(trayectoRepository.existsById(TrayectoUtility.IDNUNO)).willReturn(false);

        assertThrows(Exception.class, () -> trayectoServiceImpl.actualizarTrayecto(TrayectoUtility.TRAYECTODTONUNO));
    }
}
