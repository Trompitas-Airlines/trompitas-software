package co.edu.usbcali.airlinesapp.service;

import co.edu.usbcali.airlinesapp.repository.FacturaRepository;
import co.edu.usbcali.airlinesapp.repository.ReservaRepository;
import co.edu.usbcali.airlinesapp.services.implementation.FacturaServiceImpl;
import co.edu.usbcali.airlinesapp.utilities.FacturaUtilityTest;
import co.edu.usbcali.airlinesapp.utilities.ReservaUtilityTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import co.edu.usbcali.airlinesapp.dtos.FacturaDTO;


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
    public void guardarFacturaPositivo() throws Exception {
        given(reservaRepository.existsById(ReservaUtilityTest.ID_UNO)).willReturn(true);
        given(reservaRepository.getReferenceById(ReservaUtilityTest.ID_UNO)).willReturn(ReservaUtilityTest.RESERVA_UNO);
        given(facturaRepository.existsById(FacturaUtilityTest.ID_UNO)).willReturn(false);
        given(facturaRepository.save(any())).willReturn(FacturaUtilityTest.FACTURA_UNO);

        FacturaDTO facturaSavedDTO = facturaServiceImpl.guardarFactura(FacturaUtilityTest.FACTURADTO_UNO);

        assertEquals(FacturaUtilityTest.ID_UNO, facturaSavedDTO.getIdFactura());
    }

    @Test
    public void guardarFacturaNegativo() {
        given(facturaRepository.existsById(FacturaUtilityTest.ID_UNO)).willReturn(true);

        assertThrows(Exception.class, () -> facturaServiceImpl.guardarFactura(FacturaUtilityTest.FACTURADTO_UNO));
    }

    @Test
    public void obtenerFacturasPositivo() {
        given(facturaRepository.findAll()).willReturn(FacturaUtilityTest.FACTURAS);

        List<FacturaDTO> facturasSavedDTO = facturaServiceImpl.obtenerFacturas();

        assertEquals(FacturaUtilityTest.FACTURAS_SIZE, facturasSavedDTO.size());
        assertEquals(FacturaUtilityTest.ID_UNO, facturasSavedDTO.get(0).getIdFactura());
    }

    @Test
    public void obtenerFacturasNegativo() {
        given(facturaRepository.findAll()).willReturn(FacturaUtilityTest.FACTURAS_VACIO);

        List<FacturaDTO> facturasSavedDTO = facturaServiceImpl.obtenerFacturas();

        assertEquals(FacturaUtilityTest.FACTURAS_VACIO_SIZE, facturasSavedDTO.size());
    }

    @Test
    public void obtenerFacturasActivasPositivo() {
        given(facturaRepository.findAllByEstado("A")).willReturn(FacturaUtilityTest.FACTURAS);

        List<FacturaDTO> facturasSavedTO = facturaServiceImpl.obtenerFacturasActivas();

        assertEquals(FacturaUtilityTest.FACTURAS_SIZE, facturasSavedTO.size());
        assertEquals(FacturaUtilityTest.ID_UNO, facturasSavedTO.get(0).getIdFactura());
    }

    @Test
    public void obtenerFacturasActivasNegativo() {
        given(facturaRepository.findAllByEstado("A")).willReturn(FacturaUtilityTest.FACTURAS_VACIO);

        List<FacturaDTO> facturasSavedTO = facturaServiceImpl.obtenerFacturasActivas();

        assertEquals(FacturaUtilityTest.FACTURAS_VACIO_SIZE, facturasSavedTO.size());
    }

    @Test
    public void obtenerFacturaPorIdPositivo() throws Exception {
        reservaRepository.save(ReservaUtilityTest.RESERVA_UNO);
        facturaRepository.save(FacturaUtilityTest.FACTURA_UNO);

        given(facturaRepository.existsById(FacturaUtilityTest.ID_UNO)).willReturn(true);
        given(facturaRepository.getReferenceById(FacturaUtilityTest.ID_UNO)).willReturn(FacturaUtilityTest.FACTURA_UNO);

        FacturaDTO facturaSavedDTO = facturaServiceImpl.obtenerFacturaPorId(FacturaUtilityTest.ID_UNO);

        assertEquals(FacturaUtilityTest.ID_UNO, facturaSavedDTO.getIdFactura());
    }

    @Test
    public void obtenerFacturaPorIdNegativo() {
        given(facturaRepository.existsById(FacturaUtilityTest.ID_UNO)).willReturn(false);

        assertThrows(Exception.class, () -> facturaServiceImpl.obtenerFacturaPorId(FacturaUtilityTest.ID_UNO));
    }

    @Test
    public void actualizarFacturaPositivo() throws Exception {
        given(reservaRepository.existsById(ReservaUtilityTest.ID_UNO)).willReturn(true);
        given(reservaRepository.getReferenceById(ReservaUtilityTest.ID_UNO)).willReturn(ReservaUtilityTest.RESERVA_UNO);
        given(facturaRepository.existsById(FacturaUtilityTest.ID_UNO)).willReturn(true);
        given(facturaRepository.save(any())).willReturn(FacturaUtilityTest.FACTURA_UNO);

        FacturaDTO facturaSavedDTO = facturaServiceImpl.actualizarFactura(FacturaUtilityTest.FACTURADTO_UNO);

        assertEquals(FacturaUtilityTest.ID_UNO, facturaSavedDTO.getIdFactura());
    }

    @Test
    public void actualizarFacturaNegativo() {
        given(facturaRepository.existsById(FacturaUtilityTest.ID_UNO)).willReturn(false);

        assertThrows(Exception.class, () -> facturaServiceImpl.actualizarFactura(FacturaUtilityTest.FACTURADTO_UNO));
    }
}
