package co.edu.usbcali.airlinesapp.service;

import co.edu.usbcali.airlinesapp.dtos.TipoAsientoDTO;
import co.edu.usbcali.airlinesapp.repository.TipoAsientoRepository;
import co.edu.usbcali.airlinesapp.services.implementation.TipoAsientoServiceImpl;
import co.edu.usbcali.airlinesapp.utilities.TipoAsientoUtilityTest;
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
    public void guardarTipoAsientoPositivo() throws Exception {
        given(tipoAsientoRepository.existsById(TipoAsientoUtilityTest.ID_UNO)).willReturn(false);
        given(tipoAsientoRepository.save(TipoAsientoUtilityTest.TIPOASIENTO_UNO)).willReturn(TipoAsientoUtilityTest.TIPOASIENTO_UNO);

        TipoAsientoDTO tipoAsientoSavedDTO = tipoAsientoServiceImpl.guardarTipoAsiento(TipoAsientoUtilityTest.TIPOASIENTODTO_UNO);

        assertEquals(TipoAsientoUtilityTest.ID_UNO, tipoAsientoSavedDTO.getIdTipoAsiento());
    }

    @Test
    public void guardarTipoAsientoNegativo() {
        given(tipoAsientoRepository.existsById(TipoAsientoUtilityTest.ID_UNO)).willReturn(true);

        assertThrows(Exception.class, () -> tipoAsientoServiceImpl.guardarTipoAsiento(TipoAsientoUtilityTest.TIPOASIENTODTO_UNO));
    }

    @Test
    public void obtenerTipoAsientosPositivo() {
        given(tipoAsientoRepository.findAll()).willReturn(TipoAsientoUtilityTest.TIPOASIENTOS);

        List<TipoAsientoDTO> tipoAsientosSavedDTO = tipoAsientoServiceImpl.obtenerTipoAsientos();

        assertEquals(TipoAsientoUtilityTest.TIPOASIENTOS_SIZE, tipoAsientosSavedDTO.size());
        assertEquals(TipoAsientoUtilityTest.DESCRIPCION_UNO, tipoAsientosSavedDTO.get(0).getDescripcion());
    }

    @Test
    public void obtenerTipoAsientosNegativo() {
        given(tipoAsientoRepository.findAll()).willReturn(TipoAsientoUtilityTest.TIPOASIENTOS_VACIO);

        List<TipoAsientoDTO> tipoAsientosSavedDTO = tipoAsientoServiceImpl.obtenerTipoAsientos();

        assertEquals(TipoAsientoUtilityTest.TIPOASIENTOS_VACIO_SIZE, tipoAsientosSavedDTO.size());
    }

    @Test
    public void obtenerTipoAsientosActivosPositivo() {
        given(tipoAsientoRepository.findAllByEstado("A")).willReturn(TipoAsientoUtilityTest.TIPOASIENTOS);

        List<TipoAsientoDTO> tipoAsientosSavedDTO = tipoAsientoServiceImpl.obtenerTipoAsientosActivos();

        assertEquals(TipoAsientoUtilityTest.TIPOASIENTOS_SIZE, tipoAsientosSavedDTO.size());
        assertEquals(TipoAsientoUtilityTest.DESCRIPCION_UNO, tipoAsientosSavedDTO.get(0).getDescripcion());
    }

    @Test
    public void obtenerTipoAsientosActivosNegativo() {
        given(tipoAsientoRepository.findAllByEstado("A")).willReturn(TipoAsientoUtilityTest.TIPOASIENTOS_VACIO);

        List<TipoAsientoDTO> tipoAsientosSavedDTO = tipoAsientoServiceImpl.obtenerTipoAsientosActivos();

        assertEquals(TipoAsientoUtilityTest.TIPOASIENTOS_VACIO_SIZE, tipoAsientosSavedDTO.size());
    }

    @Test
    public void obtenerTipoAsientoPorIdPositivo() throws Exception {
        tipoAsientoRepository.save(TipoAsientoUtilityTest.TIPOASIENTO_UNO);

        given(tipoAsientoRepository.existsById(TipoAsientoUtilityTest.ID_UNO)).willReturn(true);
        given(tipoAsientoRepository.getReferenceById(TipoAsientoUtilityTest.ID_UNO)).willReturn(TipoAsientoUtilityTest.TIPOASIENTO_UNO);

        TipoAsientoDTO tipoAsientoSavedDTO = tipoAsientoServiceImpl.obtenerTipoAsientoPorId(TipoAsientoUtilityTest.ID_UNO);

        assertEquals(TipoAsientoUtilityTest.DESCRIPCION_UNO, tipoAsientoSavedDTO.getDescripcion());
    }

    @Test
    public void obtenerTipoAsientoPorIdNegativo() {
        given(tipoAsientoRepository.existsById(TipoAsientoUtilityTest.ID_UNO)).willReturn(false);

        assertThrows(Exception.class, () -> tipoAsientoServiceImpl.obtenerTipoAsientoPorId(TipoAsientoUtilityTest.ID_UNO));
    }

    @Test
    public void actualizarTipoAsientoPositivo() throws Exception {
        given(tipoAsientoRepository.existsById(TipoAsientoUtilityTest.ID_UNO)).willReturn(true);
        given(tipoAsientoRepository.save(TipoAsientoUtilityTest.TIPOASIENTO_UNO)).willReturn(TipoAsientoUtilityTest.TIPOASIENTO_UNO);

        TipoAsientoDTO tipoAsientoSavedDTO = tipoAsientoServiceImpl.actualizarTipoAsiento(TipoAsientoUtilityTest.TIPOASIENTODTO_UNO);

        assertEquals(TipoAsientoUtilityTest.ID_UNO, tipoAsientoSavedDTO.getIdTipoAsiento());
    }

    @Test
    public void actualizarTipoAsientoNegativo() {
        given(tipoAsientoRepository.existsById(TipoAsientoUtilityTest.ID_UNO)).willReturn(false);

        assertThrows(Exception.class, () -> tipoAsientoServiceImpl.actualizarTipoAsiento(TipoAsientoUtilityTest.TIPOASIENTODTO_UNO));
    }
}
