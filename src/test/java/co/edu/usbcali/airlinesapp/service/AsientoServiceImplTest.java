package co.edu.usbcali.airlinesapp.service;

import co.edu.usbcali.airlinesapp.dtos.AsientoDTO;
import co.edu.usbcali.airlinesapp.repository.AsientoRepository;
import co.edu.usbcali.airlinesapp.repository.TipoAsientoRepository;
import co.edu.usbcali.airlinesapp.services.implementation.AsientoServiceImpl;
import co.edu.usbcali.airlinesapp.utilities.AsientoUtilityTest;
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
public class AsientoServiceImplTest {
    @InjectMocks
    private AsientoServiceImpl asientoServiceImpl;

    @Mock
    private AsientoRepository asientoRepository;

    @Mock
    private TipoAsientoRepository tipoAsientoRepository;


    @Test
    public void guardarAsientoPositivo() throws Exception {
        given(tipoAsientoRepository.existsById(TipoAsientoUtilityTest.ID_UNO)).willReturn(true);
        given(tipoAsientoRepository.getReferenceById(TipoAsientoUtilityTest.ID_UNO)).willReturn(TipoAsientoUtilityTest.TIPOASIENTO_UNO);
        given(asientoRepository.existsById(AsientoUtilityTest.ID_UNO)).willReturn(false);
        given(asientoRepository.save(AsientoUtilityTest.ASIENTO_UNO)).willReturn(AsientoUtilityTest.ASIENTO_UNO);

        AsientoDTO asientoSavedDTO = asientoServiceImpl.guardarAsiento(AsientoUtilityTest.ASIENTODTO_UNO);

        assertEquals(AsientoUtilityTest.ID_UNO, asientoSavedDTO.getIdAsiento());
    }

    @Test
    public void guardarAsientoNegativo() {
        given(asientoRepository.existsById(AsientoUtilityTest.ID_UNO)).willReturn(true);

        assertThrows(Exception.class, () -> asientoServiceImpl.guardarAsiento(AsientoUtilityTest.ASIENTODTO_UNO));
    }

    @Test
    public void obtenerAsientosPositivo() {
        given(asientoRepository.findAll()).willReturn(AsientoUtilityTest.ASIENTOS);

        List<AsientoDTO> asientosSavedDTO = asientoServiceImpl.obtenerAsientos();

        assertEquals(AsientoUtilityTest.ASIENTOS_SIZE, asientosSavedDTO.size());
        assertEquals(AsientoUtilityTest.UBICACION_UNO, asientosSavedDTO.get(0).getUbicacion());
    }

    @Test
    public void obtenerAsientosNegativo() {
        given(asientoRepository.findAll()).willReturn(AsientoUtilityTest.ASIENTOS_VACIO);

        List<AsientoDTO> asientosSavedDTO = asientoServiceImpl.obtenerAsientos();

        assertEquals(AsientoUtilityTest.ASIENTOS_VACIO_SIZE, asientosSavedDTO.size());
    }

    @Test
    public void obtenerAsientosActivosPositivo() {
        given(asientoRepository.findAllByEstado("A")).willReturn(AsientoUtilityTest.ASIENTOS);

        List<AsientoDTO> asientosSavedDTO = asientoServiceImpl.obtenerAsientosActivos();

        assertEquals(AsientoUtilityTest.ASIENTOS_SIZE, asientosSavedDTO.size());
        assertEquals(AsientoUtilityTest.UBICACION_UNO, asientosSavedDTO.get(0).getUbicacion());
    }

    @Test
    public void obtenerAsientosActivosNegativo() {
        given(asientoRepository.findAllByEstado("A")).willReturn(AsientoUtilityTest.ASIENTOS_VACIO);

        List<AsientoDTO> asientosSavedDTO = asientoServiceImpl.obtenerAsientosActivos();

        assertEquals(AsientoUtilityTest.ASIENTOS_VACIO_SIZE, asientosSavedDTO.size());
    }

    @Test
    public void obtenerAsientoPorIdPositivo() throws Exception {
        tipoAsientoRepository.save(TipoAsientoUtilityTest.TIPOASIENTO_UNO);
        asientoRepository.save(AsientoUtilityTest.ASIENTO_UNO);

        given(asientoRepository.existsById(AsientoUtilityTest.ID_UNO)).willReturn(true);
        given(asientoRepository.getReferenceById(AsientoUtilityTest.ID_UNO)).willReturn(AsientoUtilityTest.ASIENTO_UNO);

        AsientoDTO asientoSavedDTO = asientoServiceImpl.obtenerAsientoPorId(AsientoUtilityTest.ID_UNO);

        assertEquals(AsientoUtilityTest.ID_UNO, asientoSavedDTO.getIdAsiento());
    }

    @Test
    public void obtenerAsientoPorIdNegativo() {
        given(asientoRepository.existsById(AsientoUtilityTest.ID_UNO)).willReturn(false);

        assertThrows(Exception.class, () -> asientoServiceImpl.obtenerAsientoPorId(AsientoUtilityTest.ID_UNO));
    }

    @Test
    public void actualizarAsientoPositivo() throws Exception {
        given(tipoAsientoRepository.existsById(TipoAsientoUtilityTest.ID_UNO)).willReturn(true);
        given(tipoAsientoRepository.getReferenceById(TipoAsientoUtilityTest.ID_UNO)).willReturn(TipoAsientoUtilityTest.TIPOASIENTO_UNO);
        given(asientoRepository.existsById(AsientoUtilityTest.ID_UNO)).willReturn(true);
        given(asientoRepository.save(AsientoUtilityTest.ASIENTO_UNO)).willReturn(AsientoUtilityTest.ASIENTO_UNO);

        AsientoDTO asientoSavedDTO = asientoServiceImpl.actualizarAsiento(AsientoUtilityTest.ASIENTODTO_UNO);

        assertEquals(AsientoUtilityTest.ID_UNO, asientoSavedDTO.getIdAsiento());
    }

    @Test
    public void actualizarAsientoNegativo() {
        given(asientoRepository.existsById(AsientoUtilityTest.ID_UNO)).willReturn(false);

        assertThrows(Exception.class, () -> asientoServiceImpl.actualizarAsiento(AsientoUtilityTest.ASIENTODTO_UNO));
    }
}
