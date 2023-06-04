package co.edu.usbcali.airlinesapp.service;

import co.edu.usbcali.airlinesapp.dtos.AeropuertoDTO;
import co.edu.usbcali.airlinesapp.repository.AeropuertoRepository;
import co.edu.usbcali.airlinesapp.services.implementation.AeropuertoServiceImpl;
import co.edu.usbcali.airlinesapp.utilities.AeropuertoUtility;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class AeropuertoServiceImplTest {
    @InjectMocks
    private AeropuertoServiceImpl aeropuertoServiceImpl;

    @Mock
    private AeropuertoRepository aeropuertoRepository;

    @Test
    public void guardarAeropuertoOk() throws Exception {
        given(aeropuertoRepository.existsById(AeropuertoUtility.IDNUNO)).willReturn(false);
        given(aeropuertoRepository.save(AeropuertoUtility.AEROPUERTONUNO)).willReturn(AeropuertoUtility.AEROPUERTONUNO);

        AeropuertoDTO aeropuertoSavedDTO = aeropuertoServiceImpl.guardarAeropuerto(AeropuertoUtility.AEROPUERTODTONUNO);

        assertEquals(AeropuertoUtility.IDNUNO, aeropuertoSavedDTO.getIdAeropuerto());
    }

    @Test
    public void guardarAeropuertoNotOk() {
        given(aeropuertoRepository.existsById(AeropuertoUtility.IDNUNO)).willReturn(true);

        assertThrows(Exception.class, () -> aeropuertoServiceImpl.guardarAeropuerto(AeropuertoUtility.AEROPUERTODTONUNO));
    }

    @Test
    public void obtenerAeropuertosOk() {
        given(aeropuertoRepository.findAll()).willReturn(AeropuertoUtility.AEROPUERTOS);

        List<AeropuertoDTO> aeropuertosSavedDTO = aeropuertoServiceImpl.obtenerAeropuertos();

        assertEquals(AeropuertoUtility.AEROPUERTOSNSIZE, aeropuertosSavedDTO.size());
        assertEquals(AeropuertoUtility.NOMBRENUNO, aeropuertosSavedDTO.get(0).getNombre());
    }

    @Test
    public void obtenerAeropuertosNotOk() {
        given(aeropuertoRepository.findAll()).willReturn(AeropuertoUtility.AEROPUERTOSNVACIO);

        List<AeropuertoDTO> aeropuertosSavedDTO = aeropuertoServiceImpl.obtenerAeropuertos();

        assertEquals(AeropuertoUtility.AEROPUERTOSNVACIONSIZE, aeropuertosSavedDTO.size());
    }

    @Test
    public void obtenerAeropuertosActivosOk() {
        given(aeropuertoRepository.findAllByEstado("A")).willReturn(AeropuertoUtility.AEROPUERTOS);

        List<AeropuertoDTO> aeropuertosSavedDTO = aeropuertoServiceImpl.obtenerAeropuertosActivos();

        assertEquals(AeropuertoUtility.AEROPUERTOSNSIZE, aeropuertosSavedDTO.size());
        assertEquals(AeropuertoUtility.NOMBRENUNO, aeropuertosSavedDTO.get(0).getNombre());
    }

    @Test
    public void obtenerAeropuertosActivosNotOk() {
        given(aeropuertoRepository.findAllByEstado("A")).willReturn(AeropuertoUtility.AEROPUERTOSNVACIO);

        List<AeropuertoDTO> aeropuertosSavedDTO = aeropuertoServiceImpl.obtenerAeropuertosActivos();

        assertEquals(AeropuertoUtility.AEROPUERTOSNVACIONSIZE, aeropuertosSavedDTO.size());
    }

    @Test
    public void obtenerAeropuertoPorIdOk() throws Exception {
        aeropuertoRepository.save(AeropuertoUtility.AEROPUERTONUNO);

        given(aeropuertoRepository.existsById(AeropuertoUtility.IDNUNO)).willReturn(true);
        given(aeropuertoRepository.getReferenceById(AeropuertoUtility.IDNUNO)).willReturn(AeropuertoUtility.AEROPUERTONUNO);

        AeropuertoDTO aeropuertoSavedDTO = aeropuertoServiceImpl.obtenerAeropuertoPorId(AeropuertoUtility.IDNUNO);

        assertEquals(AeropuertoUtility.IDNUNO, aeropuertoSavedDTO.getIdAeropuerto());
    }

    @Test
    public void obtenerAeropuertoPorIdNotOk() {
        given(aeropuertoRepository.existsById(AeropuertoUtility.IDNUNO)).willReturn(false);

        assertThrows(Exception.class, () -> aeropuertoServiceImpl.obtenerAeropuertoPorId(AeropuertoUtility.IDNUNO));
    }

    @Test
    public void actualizarAeropuertoOk() throws Exception {
        given(aeropuertoRepository.existsById(AeropuertoUtility.IDNUNO)).willReturn(true);
        given(aeropuertoRepository.save(AeropuertoUtility.AEROPUERTONUNO)).willReturn(AeropuertoUtility.AEROPUERTONUNO);

        AeropuertoDTO aeropuertoSavedDTO = aeropuertoServiceImpl.actualizarAeropuerto(AeropuertoUtility.AEROPUERTODTONUNO);

        assertEquals(AeropuertoUtility.AEROPUERTODTONUNO.getIdAeropuerto(), aeropuertoSavedDTO.getIdAeropuerto());
    }

    @Test
    public void actualizarAeropuertoNotOk() {
        given(aeropuertoRepository.existsById(AeropuertoUtility.IDNUNO)).willReturn(false);

        assertThrows(Exception.class, () -> aeropuertoServiceImpl.actualizarAeropuerto(AeropuertoUtility.AEROPUERTODTONUNO));
    }
}
