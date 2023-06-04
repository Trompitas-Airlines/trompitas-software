package co.edu.usbcali.airlinesapp.service;

import co.edu.usbcali.airlinesapp.dtos.AvionDTO;
import co.edu.usbcali.airlinesapp.repository.AvionRepository;
import co.edu.usbcali.airlinesapp.services.implementation.AvionServiceImpl;
import co.edu.usbcali.airlinesapp.utilities.AvionUtility;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

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
    public void guardarAvionOk() throws Exception {
        given(avionRepository.existsById(AvionUtility.IDNUNO)).willReturn(false);
        given(avionRepository.save(AvionUtility.AVIONNUNO)).willReturn(AvionUtility.AVIONNUNO);

        AvionDTO avionSavedDTO = avionServiceImpl.guardarAvion(AvionUtility.AVIONDTONUNO);

        assertEquals(AvionUtility.IDNUNO, avionSavedDTO.getIdAvion());
    }

    @Test
    public void guardarAvionNotOk() {
        given(avionRepository.existsById(AvionUtility.IDNUNO)).willReturn(true);

        assertThrows(Exception.class, () -> avionServiceImpl.guardarAvion(AvionUtility.AVIONDTONUNO));
    }

    @Test
    public void obtenerAvionesOk() {
        given(avionRepository.findAll()).willReturn(AvionUtility.AVIONES);

        List<AvionDTO> avionesSavedDTO = avionServiceImpl.obtenerAviones();

        assertEquals(AvionUtility.AVIONESNSIZE, avionesSavedDTO.size());
        assertEquals(AvionUtility.MODELONUNO, avionesSavedDTO.get(0).getModelo());
    }

    @Test
    public void obtenerAvionesNotOk() {
        given(avionRepository.findAll()).willReturn(AvionUtility.AVIONESNVACIO);

        List<AvionDTO> avionesDTO = avionServiceImpl.obtenerAviones();

        assertEquals(AvionUtility.AVIONESNVACIONSIZE, avionesDTO.size());
    }

    @Test
    public void obtenerAvionesActivosOk() {
        given(avionRepository.findAllByEstado("A")).willReturn(AvionUtility.AVIONES);

        List<AvionDTO> avionesSavedDTO = avionServiceImpl.obtenerAvionesActivos();

        assertEquals(AvionUtility.AVIONESNSIZE, avionesSavedDTO.size());
        assertEquals(AvionUtility.MODELONUNO, avionesSavedDTO.get(0).getModelo());
    }

    @Test
    public void obtenerAvionesActivosNotOk() {
        given(avionRepository.findAllByEstado("A")).willReturn(AvionUtility.AVIONESNVACIO);

        List<AvionDTO> avionesSavedDTO = avionServiceImpl.obtenerAvionesActivos();

        assertEquals(AvionUtility.AVIONESNVACIONSIZE, avionesSavedDTO.size());
    }

    @Test
    public void obtenerAvionPorIdOk() throws Exception {
        avionRepository.save(AvionUtility.AVIONNUNO);

        given(avionRepository.existsById(AvionUtility.IDNUNO)).willReturn(true);
        given(avionRepository.getReferenceById(AvionUtility.IDNUNO)).willReturn(AvionUtility.AVIONNUNO);

        AvionDTO avionDTO = avionServiceImpl.obtenerAvionPorId(AvionUtility.IDNUNO);

        assertEquals(AvionUtility.IDNUNO, avionDTO.getIdAvion());
    }

    @Test
    public void obtenerAvionPorIdNotOk() {
        given(avionRepository.existsById(AvionUtility.IDNUNO)).willReturn(false);

        assertThrows(Exception.class, () -> avionServiceImpl.obtenerAvionPorId(AvionUtility.IDNUNO));
    }

    @Test
    public void actualizarAvionOk() throws Exception {
        given(avionRepository.existsById(AvionUtility.IDNUNO)).willReturn(true);
        given(avionRepository.save(AvionUtility.AVIONNUNO)).willReturn(AvionUtility.AVIONNUNO);

        AvionDTO avionSavedDTO = avionServiceImpl.actualizarAvion(AvionUtility.AVIONDTONUNO);

        assertEquals(AvionUtility.IDNUNO, avionSavedDTO.getIdAvion());
    }

    @Test
    public void actualizarAvionNotOk() {
        given(avionRepository.existsById(AvionUtility.IDNUNO)).willReturn(false);

        assertThrows(Exception.class, () -> avionServiceImpl.actualizarAvion(AvionUtility.AVIONDTONUNO));
    }
}
