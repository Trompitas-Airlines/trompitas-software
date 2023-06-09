package co.edu.usbcali.airlinesapp.service;

import co.edu.usbcali.airlinesapp.dtos.AeropuertoDTO;
import co.edu.usbcali.airlinesapp.repository.AeropuertoRepository;
import co.edu.usbcali.airlinesapp.services.implementation.AeropuertoServiceImpl;
import co.edu.usbcali.airlinesapp.utilities.AeropuertoUtilityTest;
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
    public void guardarAeropuertoPositivo() throws Exception {
        given(aeropuertoRepository.existsById(AeropuertoUtilityTest.ID_UNO)).willReturn(false);
        given(aeropuertoRepository.save(AeropuertoUtilityTest.AEROPUERTO_UNO)).willReturn(AeropuertoUtilityTest.AEROPUERTO_UNO);

        AeropuertoDTO aeropuertoSavedDTO = aeropuertoServiceImpl.guardarAeropuerto(AeropuertoUtilityTest.AEROPUERTODTO_UNO);

        assertEquals(AeropuertoUtilityTest.ID_UNO, aeropuertoSavedDTO.getIdAeropuerto());
    }

    @Test
    public void guardarAeropuertoNegativo() {
        given(aeropuertoRepository.existsById(AeropuertoUtilityTest.ID_UNO)).willReturn(true);

        assertThrows(Exception.class, () -> aeropuertoServiceImpl.guardarAeropuerto(AeropuertoUtilityTest.AEROPUERTODTO_UNO));
    }

    @Test
    public void obtenerAeropuertosPositivo() {
        given(aeropuertoRepository.findAll()).willReturn(AeropuertoUtilityTest.AEROPUERTOS);

        List<AeropuertoDTO> aeropuertosSavedDTO = aeropuertoServiceImpl.obtenerAeropuertos();

        assertEquals(AeropuertoUtilityTest.AEROPUERTOS_SIZE, aeropuertosSavedDTO.size());
        assertEquals(AeropuertoUtilityTest.NOMBRE_UNO, aeropuertosSavedDTO.get(0).getNombre());
    }

    @Test
    public void obtenerAeropuertosNegativo() {
        given(aeropuertoRepository.findAll()).willReturn(AeropuertoUtilityTest.AEROPUERTOS_VACIO);

        List<AeropuertoDTO> aeropuertosSavedDTO = aeropuertoServiceImpl.obtenerAeropuertos();

        assertEquals(AeropuertoUtilityTest.AEROPUERTOS_VACIO_SIZE, aeropuertosSavedDTO.size());
    }

    @Test
    public void obtenerAeropuertosActivosPositivo() {
        given(aeropuertoRepository.findAllByEstado("A")).willReturn(AeropuertoUtilityTest.AEROPUERTOS);

        List<AeropuertoDTO> aeropuertosSavedDTO = aeropuertoServiceImpl.obtenerAeropuertosActivos();

        assertEquals(AeropuertoUtilityTest.AEROPUERTOS_SIZE, aeropuertosSavedDTO.size());
        assertEquals(AeropuertoUtilityTest.NOMBRE_UNO, aeropuertosSavedDTO.get(0).getNombre());
    }

    @Test
    public void obtenerAeropuertosActivosNegativo() {
        given(aeropuertoRepository.findAllByEstado("A")).willReturn(AeropuertoUtilityTest.AEROPUERTOS_VACIO);

        List<AeropuertoDTO> aeropuertosSavedDTO = aeropuertoServiceImpl.obtenerAeropuertosActivos();

        assertEquals(AeropuertoUtilityTest.AEROPUERTOS_VACIO_SIZE, aeropuertosSavedDTO.size());
    }

    @Test
    public void obtenerAeropuertoPorIdPositivo() throws Exception {
        aeropuertoRepository.save(AeropuertoUtilityTest.AEROPUERTO_UNO);

        given(aeropuertoRepository.existsById(AeropuertoUtilityTest.ID_UNO)).willReturn(true);
        given(aeropuertoRepository.getReferenceById(AeropuertoUtilityTest.ID_UNO)).willReturn(AeropuertoUtilityTest.AEROPUERTO_UNO);

        AeropuertoDTO aeropuertoSavedDTO = aeropuertoServiceImpl.obtenerAeropuertoPorId(AeropuertoUtilityTest.ID_UNO);

        assertEquals(AeropuertoUtilityTest.ID_UNO, aeropuertoSavedDTO.getIdAeropuerto());
    }

    @Test
    public void obtenerAeropuertoPorIdNegativo() {
        given(aeropuertoRepository.existsById(AeropuertoUtilityTest.ID_UNO)).willReturn(false);

        assertThrows(Exception.class, () -> aeropuertoServiceImpl.obtenerAeropuertoPorId(AeropuertoUtilityTest.ID_UNO));
    }

    @Test
    public void actualizarAeropuertoPositivo() throws Exception {
        given(aeropuertoRepository.existsById(AeropuertoUtilityTest.ID_UNO)).willReturn(true);
        given(aeropuertoRepository.save(AeropuertoUtilityTest.AEROPUERTO_UNO)).willReturn(AeropuertoUtilityTest.AEROPUERTO_UNO);

        AeropuertoDTO aeropuertoSavedDTO = aeropuertoServiceImpl.actualizarAeropuerto(AeropuertoUtilityTest.AEROPUERTODTO_UNO);

        assertEquals(AeropuertoUtilityTest.AEROPUERTODTO_UNO.getIdAeropuerto(), aeropuertoSavedDTO.getIdAeropuerto());
    }

    @Test
    public void actualizarAeropuertoNegativo() {
        given(aeropuertoRepository.existsById(AeropuertoUtilityTest.ID_UNO)).willReturn(false);

        assertThrows(Exception.class, () -> aeropuertoServiceImpl.actualizarAeropuerto(AeropuertoUtilityTest.AEROPUERTODTO_UNO));
    }
}
