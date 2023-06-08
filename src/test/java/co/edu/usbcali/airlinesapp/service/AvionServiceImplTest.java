package co.edu.usbcali.airlinesapp.service;

import co.edu.usbcali.airlinesapp.utilities.AvionUtilityTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import co.edu.usbcali.airlinesapp.dtos.AvionDTO;
import co.edu.usbcali.airlinesapp.repository.AvionRepository;
import co.edu.usbcali.airlinesapp.services.implementation.AvionServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class AvionServiceImplTest {
    @InjectMocks
    private AvionServiceImpl avionServiceImpl;

    @Mock
    private AvionRepository avionRepository;


    @Test
    public void guardarAvionNegativo() {
        given(avionRepository.existsById(AvionUtilityTest.ID_UNO)).willReturn(true);

        assertThrows(Exception.class, () -> avionServiceImpl.guardarAvion(AvionUtilityTest.AVIONDTO_UNO));
    }

    @Test
    public void obtenerAvionesPositivo() {
        given(avionRepository.findAll()).willReturn(AvionUtilityTest.AVIONES);

        List<AvionDTO> avionesSavedDTO = avionServiceImpl.obtenerAviones();

        assertEquals(AvionUtilityTest.AVIONES_SIZE, avionesSavedDTO.size());
        assertEquals(AvionUtilityTest.MODELO_UNO, avionesSavedDTO.get(0).getModelo());
    }

    @Test
    public void obtenerAvionesNegativo() {
        given(avionRepository.findAll()).willReturn(AvionUtilityTest.AVIONES_VACIO);

        List<AvionDTO> avionesDTO = avionServiceImpl.obtenerAviones();

        assertEquals(AvionUtilityTest.AVIONES_VACIO_SIZE, avionesDTO.size());
    }

    @Test
    public void obtenerAvionesActivosPositivo() {
        given(avionRepository.findAllByEstado("A")).willReturn(AvionUtilityTest.AVIONES);

        List<AvionDTO> avionesSavedDTO = avionServiceImpl.obtenerAvionesActivos();

        assertEquals(AvionUtilityTest.AVIONES_SIZE, avionesSavedDTO.size());
        assertEquals(AvionUtilityTest.MODELO_UNO, avionesSavedDTO.get(0).getModelo());
    }

    @Test
    public void obtenerAvionesActivosNegativo() {
        given(avionRepository.findAllByEstado("A")).willReturn(AvionUtilityTest.AVIONES_VACIO);

        List<AvionDTO> avionesSavedDTO = avionServiceImpl.obtenerAvionesActivos();

        assertEquals(AvionUtilityTest.AVIONES_VACIO_SIZE, avionesSavedDTO.size());
    }

    @Test
    public void obtenerAvionPorIdPositivo() throws Exception {
        avionRepository.save(AvionUtilityTest.AVION_UNO);

        given(avionRepository.existsById(AvionUtilityTest.ID_UNO)).willReturn(true);
        given(avionRepository.getReferenceById(AvionUtilityTest.ID_UNO)).willReturn(AvionUtilityTest.AVION_UNO);

        AvionDTO avionDTO = avionServiceImpl.obtenerAvionPorId(AvionUtilityTest.ID_UNO);

        assertEquals(AvionUtilityTest.ID_UNO, avionDTO.getIdAvion());
    }

    @Test
    public void obtenerAvionPorIdNegativo() {
        given(avionRepository.existsById(AvionUtilityTest.ID_UNO)).willReturn(false);

        assertThrows(Exception.class, () -> avionServiceImpl.obtenerAvionPorId(AvionUtilityTest.ID_UNO));
    }


    @Test
    public void actualizarAvionNegativo() {
        given(avionRepository.existsById(AvionUtilityTest.ID_UNO)).willReturn(false);

        assertThrows(Exception.class, () -> avionServiceImpl.actualizarAvion(AvionUtilityTest.AVIONDTO_UNO));
    }
}
