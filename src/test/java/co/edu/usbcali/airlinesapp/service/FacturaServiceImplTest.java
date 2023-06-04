package co.edu.usbcali.airlinesapp.service;

import co.edu.usbcali.airlinesapp.dtos.FacturaDTO;
import co.edu.usbcali.airlinesapp.repository.FacturaRepository;
import co.edu.usbcali.airlinesapp.repository.ReservaRepository;
import co.edu.usbcali.airlinesapp.services.implementation.FacturaServiceImpl;
import co.edu.usbcali.airlinesapp.utilities.FacturaUtility;
import co.edu.usbcali.airlinesapp.utilities.ReservaUtility;
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
public class FacturaServiceImplTest {
    @InjectMocks
    private FacturaServiceImpl facturaServiceImpl;

    @Mock
    private FacturaRepository facturaRepository;

    @Mock
    private ReservaRepository reservaRepository;

    @Test
    public void guardarFacturaOk() throws Exception {
        given(reservaRepository.existsById(ReservaUtility.IDNUNO)).willReturn(true);
        given(reservaRepository.getReferenceById(ReservaUtility.IDNUNO)).willReturn(ReservaUtility.RESERVANUNO);
        given(facturaRepository.existsById(FacturaUtility.IDNUNO)).willReturn(false);
        given(facturaRepository.save(any())).willReturn(FacturaUtility.FACTURANUNO);

        FacturaDTO facturaSavedDTO = facturaServiceImpl.guardarFactura(FacturaUtility.FACTURADTONUNO);

        assertEquals(FacturaUtility.IDNUNO, facturaSavedDTO.getIdFactura());
    }

    @Test
    public void guardarFacturaNotOk() {
        given(facturaRepository.existsById(FacturaUtility.IDNUNO)).willReturn(true);

        assertThrows(Exception.class, () -> facturaServiceImpl.guardarFactura(FacturaUtility.FACTURADTONUNO));
    }

    @Test
    public void obtenerFacturasOk() {
        given(facturaRepository.findAll()).willReturn(FacturaUtility.FACTURAS);

        List<FacturaDTO> facturasSavedDTO = facturaServiceImpl.obtenerFacturas();

        assertEquals(FacturaUtility.FACTURASNSIZE, facturasSavedDTO.size());
        assertEquals(FacturaUtility.IDNUNO, facturasSavedDTO.get(0).getIdFactura());
    }

    @Test
    public void obtenerFacturasNotOk() {
        given(facturaRepository.findAll()).willReturn(FacturaUtility.FACTURASNVACIO);

        List<FacturaDTO> facturasSavedDTO = facturaServiceImpl.obtenerFacturas();

        assertEquals(FacturaUtility.FACTURASNVACIONSIZE, facturasSavedDTO.size());
    }

    @Test
    public void obtenerFacturasActivasOk() {
        given(facturaRepository.findAllByEstado("A")).willReturn(FacturaUtility.FACTURAS);

        List<FacturaDTO> facturasSavedTO = facturaServiceImpl.obtenerFacturasActivas();

        assertEquals(FacturaUtility.FACTURASNSIZE, facturasSavedTO.size());
        assertEquals(FacturaUtility.IDNUNO, facturasSavedTO.get(0).getIdFactura());
    }

    @Test
    public void obtenerFacturasActivasNotOk() {
        given(facturaRepository.findAllByEstado("A")).willReturn(FacturaUtility.FACTURASNVACIO);

        List<FacturaDTO> facturasSavedTO = facturaServiceImpl.obtenerFacturasActivas();

        assertEquals(FacturaUtility.FACTURASNVACIONSIZE, facturasSavedTO.size());
    }

    @Test
    public void obtenerFacturaPorIdOk() throws Exception {
        reservaRepository.save(ReservaUtility.RESERVANUNO);
        facturaRepository.save(FacturaUtility.FACTURANUNO);

        given(facturaRepository.existsById(FacturaUtility.IDNUNO)).willReturn(true);
        given(facturaRepository.getReferenceById(FacturaUtility.IDNUNO)).willReturn(FacturaUtility.FACTURANUNO);

        FacturaDTO facturaSavedDTO = facturaServiceImpl.obtenerFacturaPorId(FacturaUtility.IDNUNO);

        assertEquals(FacturaUtility.IDNUNO, facturaSavedDTO.getIdFactura());
    }

    @Test
    public void obtenerFacturaPorIdNotOk() {
        given(facturaRepository.existsById(FacturaUtility.IDNUNO)).willReturn(false);

        assertThrows(Exception.class, () -> facturaServiceImpl.obtenerFacturaPorId(FacturaUtility.IDNUNO));
    }

    @Test
    public void actualizarFacturaOk() throws Exception {
        given(reservaRepository.existsById(ReservaUtility.IDNUNO)).willReturn(true);
        given(reservaRepository.getReferenceById(ReservaUtility.IDNUNO)).willReturn(ReservaUtility.RESERVANUNO);
        given(facturaRepository.existsById(FacturaUtility.IDNUNO)).willReturn(true);
        given(facturaRepository.save(any())).willReturn(FacturaUtility.FACTURANUNO);

        FacturaDTO facturaSavedDTO = facturaServiceImpl.actualizarFactura(FacturaUtility.FACTURADTONUNO);

        assertEquals(FacturaUtility.IDNUNO, facturaSavedDTO.getIdFactura());
    }

    @Test
    public void actualizarFacturaNotOk() {
        given(facturaRepository.existsById(FacturaUtility.IDNUNO)).willReturn(false);

        assertThrows(Exception.class, () -> facturaServiceImpl.actualizarFactura(FacturaUtility.FACTURADTONUNO));
    }
}
