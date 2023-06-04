package co.edu.usbcali.airlinesapp.service;

import co.edu.usbcali.airlinesapp.dtos.TipoAsientoDTO;
import co.edu.usbcali.airlinesapp.repository.TipoAsientoRepository;
import co.edu.usbcali.airlinesapp.services.implementation.TipoAsientoServiceImpl;
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
public class TipoAsientoServiceImplTest {
    @InjectMocks
    private TipoAsientoServiceImpl tipoAsientoServiceImpl;

    @Mock
    private TipoAsientoRepository tipoAsientoRepository;

    @Test
    public void guardarTipoAsientoOk() throws Exception {
        given(tipoAsientoRepository.existsById(TipoAsientoUtility.IDNUNO)).willReturn(false);
        given(tipoAsientoRepository.save(TipoAsientoUtility.TIPOASIENTONUNO)).willReturn(TipoAsientoUtility.TIPOASIENTONUNO);

        TipoAsientoDTO tipoAsientoSavedDTO = tipoAsientoServiceImpl.guardarTipoAsiento(TipoAsientoUtility.TIPOASIENTODTONUNO);

        assertEquals(TipoAsientoUtility.IDNUNO, tipoAsientoSavedDTO.getIdTipoAsiento());
    }

    @Test
    public void guardarTipoAsientoNotOk() {
        given(tipoAsientoRepository.existsById(TipoAsientoUtility.IDNUNO)).willReturn(true);

        assertThrows(Exception.class, () -> tipoAsientoServiceImpl.guardarTipoAsiento(TipoAsientoUtility.TIPOASIENTODTONUNO));
    }

    @Test
    public void obtenerTipoAsientosOk() {
        given(tipoAsientoRepository.findAll()).willReturn(TipoAsientoUtility.TIPOASIENTOS);

        List<TipoAsientoDTO> tipoAsientosSavedDTO = tipoAsientoServiceImpl.obtenerTipoAsientos();

        assertEquals(TipoAsientoUtility.TIPOASIENTOSNSIZE, tipoAsientosSavedDTO.size());
        assertEquals(TipoAsientoUtility.DESCRIPCIONNUNO, tipoAsientosSavedDTO.get(0).getDescripcion());
    }

    @Test
    public void obtenerTipoAsientosNotOk() {
        given(tipoAsientoRepository.findAll()).willReturn(TipoAsientoUtility.TIPOASIENTOSNVACIO);

        List<TipoAsientoDTO> tipoAsientosSavedDTO = tipoAsientoServiceImpl.obtenerTipoAsientos();

        assertEquals(TipoAsientoUtility.TIPOASIENTOSNVACIONSIZE, tipoAsientosSavedDTO.size());
    }

    @Test
    public void obtenerTipoAsientosActivosOk() {
        given(tipoAsientoRepository.findAllByEstado("A")).willReturn(TipoAsientoUtility.TIPOASIENTOS);

        List<TipoAsientoDTO> tipoAsientosSavedDTO = tipoAsientoServiceImpl.obtenerTipoAsientosActivos();

        assertEquals(TipoAsientoUtility.TIPOASIENTOSNSIZE, tipoAsientosSavedDTO.size());
        assertEquals(TipoAsientoUtility.DESCRIPCIONNUNO, tipoAsientosSavedDTO.get(0).getDescripcion());
    }

    @Test
    public void obtenerTipoAsientosActivosNotOk() {
        given(tipoAsientoRepository.findAllByEstado("A")).willReturn(TipoAsientoUtility.TIPOASIENTOSNVACIO);

        List<TipoAsientoDTO> tipoAsientosSavedDTO = tipoAsientoServiceImpl.obtenerTipoAsientosActivos();

        assertEquals(TipoAsientoUtility.TIPOASIENTOSNVACIONSIZE, tipoAsientosSavedDTO.size());
    }

    @Test
    public void obtenerTipoAsientoPorIdOk() throws Exception {
        tipoAsientoRepository.save(TipoAsientoUtility.TIPOASIENTONUNO);

        given(tipoAsientoRepository.existsById(TipoAsientoUtility.IDNUNO)).willReturn(true);
        given(tipoAsientoRepository.getReferenceById(TipoAsientoUtility.IDNUNO)).willReturn(TipoAsientoUtility.TIPOASIENTONUNO);

        TipoAsientoDTO tipoAsientoSavedDTO = tipoAsientoServiceImpl.obtenerTipoAsientoPorId(TipoAsientoUtility.IDNUNO);

        assertEquals(TipoAsientoUtility.DESCRIPCIONNUNO, tipoAsientoSavedDTO.getDescripcion());
    }

    @Test
    public void obtenerTipoAsientoPorIdNotOk() {
        given(tipoAsientoRepository.existsById(TipoAsientoUtility.IDNUNO)).willReturn(false);

        assertThrows(Exception.class, () -> tipoAsientoServiceImpl.obtenerTipoAsientoPorId(TipoAsientoUtility.IDNUNO));
    }

    @Test
    public void actualizarTipoAsientoOk() throws Exception {
        given(tipoAsientoRepository.existsById(TipoAsientoUtility.IDNUNO)).willReturn(true);
        given(tipoAsientoRepository.save(TipoAsientoUtility.TIPOASIENTONUNO)).willReturn(TipoAsientoUtility.TIPOASIENTONUNO);

        TipoAsientoDTO tipoAsientoSavedDTO = tipoAsientoServiceImpl.actualizarTipoAsiento(TipoAsientoUtility.TIPOASIENTODTONUNO);

        assertEquals(TipoAsientoUtility.IDNUNO, tipoAsientoSavedDTO.getIdTipoAsiento());
    }

    @Test
    public void actualizarTipoAsientoNotOk() {
        given(tipoAsientoRepository.existsById(TipoAsientoUtility.IDNUNO)).willReturn(false);

        assertThrows(Exception.class, () -> tipoAsientoServiceImpl.actualizarTipoAsiento(TipoAsientoUtility.TIPOASIENTODTONUNO));
    }
}
