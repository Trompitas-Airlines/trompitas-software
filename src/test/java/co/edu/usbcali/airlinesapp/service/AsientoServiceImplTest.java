package co.edu.usbcali.airlinesapp.service;

import co.edu.usbcali.airlinesapp.dtos.AsientoDTO;
import co.edu.usbcali.airlinesapp.repository.AsientoRepository;
import co.edu.usbcali.airlinesapp.repository.TipoAsientoRepository;
import co.edu.usbcali.airlinesapp.services.implementation.AsientoServiceImpl;
import co.edu.usbcali.airlinesapp.utilities.AsientoUtility;
import co.edu.usbcali.airlinesapp.utilities.TipoAsientoUtility;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class AsientoServiceImplTest {
    @InjectMocks
    private AsientoServiceImpl asientoServiceImpl;

    @Mock
    private AsientoRepository asientoRepository;

    @Mock
    private TipoAsientoRepository tipoAsientoRepository;


    @Test
    public void guardarAsientoOk() throws Exception {
        given(tipoAsientoRepository.existsById(TipoAsientoUtility.IDNUNO)).willReturn(true);
        given(tipoAsientoRepository.getReferenceById(TipoAsientoUtility.IDNUNO)).willReturn(TipoAsientoUtility.TIPOASIENTONUNO);
        given(asientoRepository.existsById(AsientoUtility.IDNUNO)).willReturn(false);
        given(asientoRepository.save(AsientoUtility.ASIENTONUNO)).willReturn(AsientoUtility.ASIENTONUNO);

        AsientoDTO asientoSavedDTO = asientoServiceImpl.guardarAsiento(AsientoUtility.ASIENTODTONUNO);

        assertEquals(AsientoUtility.IDNUNO, asientoSavedDTO.getIdAsiento());
    }

    @Test
    public void guardarAsientoNotOk() {
        given(asientoRepository.existsById(AsientoUtility.IDNUNO)).willReturn(true);

        assertThrows(Exception.class, () -> asientoServiceImpl.guardarAsiento(AsientoUtility.ASIENTODTONUNO));
    }

    @Test
    public void obtenerAsientosOk() {
        given(asientoRepository.findAll()).willReturn(AsientoUtility.ASIENTOS);

        List<AsientoDTO> asientosSavedDTO = asientoServiceImpl.obtenerAsientos();

        assertEquals(AsientoUtility.ASIENTOSNSIZE, asientosSavedDTO.size());
        assertEquals(AsientoUtility.UBICACIONNUNO, asientosSavedDTO.get(0).getUbicacion());
    }

    @Test
    public void obtenerAsientosNotOk() {
        given(asientoRepository.findAll()).willReturn(AsientoUtility.ASIENTOSNVACIO);

        List<AsientoDTO> asientosSavedDTO = asientoServiceImpl.obtenerAsientos();

        assertEquals(AsientoUtility.ASIENTOSNVACIONSIZE, asientosSavedDTO.size());
    }

    @Test
    public void obtenerAsientosActivosOk() {
        given(asientoRepository.findAllByEstado("A")).willReturn(AsientoUtility.ASIENTOS);

        List<AsientoDTO> asientosSavedDTO = asientoServiceImpl.obtenerAsientosActivos();

        assertEquals(AsientoUtility.ASIENTOSNSIZE, asientosSavedDTO.size());
        assertEquals(AsientoUtility.UBICACIONNUNO, asientosSavedDTO.get(0).getUbicacion());
    }

    @Test
    public void obtenerAsientosActivosNotOk() {
        given(asientoRepository.findAllByEstado("A")).willReturn(AsientoUtility.ASIENTOSNVACIO);

        List<AsientoDTO> asientosSavedDTO = asientoServiceImpl.obtenerAsientosActivos();

        assertEquals(AsientoUtility.ASIENTOSNVACIONSIZE, asientosSavedDTO.size());
    }

    @Test
    public void obtenerAsientoPorIdOk() throws Exception {
        tipoAsientoRepository.save(TipoAsientoUtility.TIPOASIENTONUNO);
        asientoRepository.save(AsientoUtility.ASIENTONUNO);

        given(asientoRepository.existsById(AsientoUtility.IDNUNO)).willReturn(true);
        given(asientoRepository.getReferenceById(AsientoUtility.IDNUNO)).willReturn(AsientoUtility.ASIENTONUNO);

        AsientoDTO asientoSavedDTO = asientoServiceImpl.obtenerAsientoPorId(AsientoUtility.IDNUNO);

        assertEquals(AsientoUtility.IDNUNO, asientoSavedDTO.getIdAsiento());
    }

    @Test
    public void obtenerAsientoPorIdNotOk() {
        given(asientoRepository.existsById(AsientoUtility.IDNUNO)).willReturn(false);

        assertThrows(Exception.class, () -> asientoServiceImpl.obtenerAsientoPorId(AsientoUtility.IDNUNO));
    }

    @Test
    public void actualizarAsientoOk() throws Exception {
        given(tipoAsientoRepository.existsById(TipoAsientoUtility.IDNUNO)).willReturn(true);
        given(tipoAsientoRepository.getReferenceById(TipoAsientoUtility.IDNUNO)).willReturn(TipoAsientoUtility.TIPOASIENTONUNO);
        given(asientoRepository.existsById(AsientoUtility.IDNUNO)).willReturn(true);
        given(asientoRepository.save(AsientoUtility.ASIENTONUNO)).willReturn(AsientoUtility.ASIENTONUNO);

        AsientoDTO asientoSavedDTO = asientoServiceImpl.actualizarAsiento(AsientoUtility.ASIENTODTONUNO);

        assertEquals(AsientoUtility.IDNUNO, asientoSavedDTO.getIdAsiento());
    }

    @Test
    public void actualizarAsientoNotOk() {
        given(asientoRepository.existsById(AsientoUtility.IDNUNO)).willReturn(false);

        assertThrows(Exception.class, () -> asientoServiceImpl.actualizarAsiento(AsientoUtility.ASIENTODTONUNO));
    }
}
