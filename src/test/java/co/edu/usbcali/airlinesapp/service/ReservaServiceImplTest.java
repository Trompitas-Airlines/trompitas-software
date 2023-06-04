package co.edu.usbcali.airlinesapp.service;

import co.edu.usbcali.airlinesapp.dtos.ReservaDTO;
import co.edu.usbcali.airlinesapp.repository.AsientoRepository;
import co.edu.usbcali.airlinesapp.repository.ReservaRepository;
import co.edu.usbcali.airlinesapp.repository.UsuarioRepository;
import co.edu.usbcali.airlinesapp.repository.VueloRepository;
import co.edu.usbcali.airlinesapp.services.implementation.ReservaServiceImpl;
import co.edu.usbcali.airlinesapp.utilities.AsientoUtility;
import co.edu.usbcali.airlinesapp.utilities.ReservaUtility;
import co.edu.usbcali.airlinesapp.utilities.UsuarioUtility;
import co.edu.usbcali.airlinesapp.utilities.VueloUtility;
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
public class ReservaServiceImplTest {
    @InjectMocks
    private ReservaServiceImpl reservaServiceImpl;

    @Mock
    private ReservaRepository reservaRepository;

    @Mock
    private VueloRepository vueloRepository;

    @Mock
    private AsientoRepository asientoRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Test
    public void guardarReservaOk() throws Exception {
        given(vueloRepository.existsById(VueloUtility.IDNUNO)).willReturn(true);
        given(vueloRepository.getReferenceById(VueloUtility.IDNUNO)).willReturn(VueloUtility.VUELONUNO);
        given(asientoRepository.existsById(AsientoUtility.IDNUNO)).willReturn(true);
        given(asientoRepository.getReferenceById(AsientoUtility.IDNUNO)).willReturn(AsientoUtility.ASIENTONUNO);
        given(usuarioRepository.existsById(UsuarioUtility.IDNUNO)).willReturn(true);
        given(usuarioRepository.getReferenceById(UsuarioUtility.IDNUNO)).willReturn(UsuarioUtility.USUARIONUNO);
        given(reservaRepository.existsById(ReservaUtility.IDNUNO)).willReturn(false);
        given(reservaRepository.save(any())).willReturn(ReservaUtility.RESERVANUNO);

        ReservaDTO reservaSavedDTO = reservaServiceImpl.guardarReserva(ReservaUtility.RESERVADTONUNO);

        assertEquals(ReservaUtility.IDNUNO, reservaSavedDTO.getIdReserva());
    }

    @Test
    public void guardarReservaNotOk() {
        given(reservaRepository.existsById(ReservaUtility.IDNUNO)).willReturn(true);

        assertThrows(Exception.class, () -> reservaServiceImpl.guardarReserva(ReservaUtility.RESERVADTONUNO));
    }

    @Test
    public void obtenerReservasOk() {
        given(reservaRepository.findAll()).willReturn(ReservaUtility.RESERVAS);

        List<ReservaDTO> reservasSavedDTO = reservaServiceImpl.obtenerReservas();

        assertEquals(ReservaUtility.RESERVASNSIZE, reservasSavedDTO.size());
        assertEquals(ReservaUtility.PRECIONTOTALNUNO, reservasSavedDTO.get(0).getPrecioTotal());
    }

    @Test
    public void obtenerReservasNotOk() {
        given(reservaRepository.findAll()).willReturn(ReservaUtility.RESERVASNVACIO);

        List<ReservaDTO> reservasSavedDTO = reservaServiceImpl.obtenerReservas();

        assertEquals(ReservaUtility.RESERVASNVACIONSIZE, reservasSavedDTO.size());
    }

    @Test
    public void obtenerReservasActivasOk() {
        given(reservaRepository.findAllByEstado("A")).willReturn(ReservaUtility.RESERVAS);

        List<ReservaDTO> reservasSavedDTO = reservaServiceImpl.obtenerReservasActivas();

        assertEquals(ReservaUtility.RESERVASNSIZE, reservasSavedDTO.size());
        assertEquals(ReservaUtility.PRECIONTOTALNUNO, reservasSavedDTO.get(0).getPrecioTotal());
    }

    @Test
    public void obtenerReservasActivasNotOk() {
        given(reservaRepository.findAllByEstado("A")).willReturn(ReservaUtility.RESERVASNVACIO);

        List<ReservaDTO> reservasSavedDTO = reservaServiceImpl.obtenerReservasActivas();

        assertEquals(ReservaUtility.RESERVASNVACIONSIZE, reservasSavedDTO.size());
    }

    @Test
    public void obtenerReservaPorIdOk() throws Exception {
        vueloRepository.save(VueloUtility.VUELONUNO);
        asientoRepository.save(AsientoUtility.ASIENTONUNO);
        usuarioRepository.save(UsuarioUtility.USUARIONUNO);
        reservaRepository.save(ReservaUtility.RESERVANUNO);

        given(reservaRepository.existsById(ReservaUtility.IDNUNO)).willReturn(true);
        given(reservaRepository.getReferenceById(ReservaUtility.IDNUNO)).willReturn(ReservaUtility.RESERVANUNO);

        ReservaDTO reservaSavedDTO = reservaServiceImpl.obtenerReservaPorId(ReservaUtility.IDNUNO);

        assertEquals(ReservaUtility.IDNUNO, reservaSavedDTO.getIdUsuario());
    }

    @Test
    public void obtenerReservaPorIdNotOk() {
        given(reservaRepository.existsById(ReservaUtility.IDNUNO)).willReturn(false);

        assertThrows(Exception.class, () -> reservaServiceImpl.obtenerReservaPorId(ReservaUtility.IDNUNO));
    }

    @Test
    public void actualizarReservaOk() throws Exception {
        given(vueloRepository.existsById(VueloUtility.IDNUNO)).willReturn(true);
        given(vueloRepository.getReferenceById(VueloUtility.IDNUNO)).willReturn(VueloUtility.VUELONUNO);
        given(asientoRepository.existsById(AsientoUtility.IDNUNO)).willReturn(true);
        given(asientoRepository.getReferenceById(AsientoUtility.IDNUNO)).willReturn(AsientoUtility.ASIENTONUNO);
        given(usuarioRepository.existsById(UsuarioUtility.IDNUNO)).willReturn(true);
        given(usuarioRepository.getReferenceById(UsuarioUtility.IDNUNO)).willReturn(UsuarioUtility.USUARIONUNO);
        given(reservaRepository.existsById(ReservaUtility.IDNUNO)).willReturn(true);
        given(reservaRepository.save(any())).willReturn(ReservaUtility.RESERVANUNO);

        ReservaDTO reservaSavedDTO = reservaServiceImpl.actualizarReserva(ReservaUtility.RESERVADTONUNO);

        assertEquals(ReservaUtility.IDNUNO, reservaSavedDTO.getIdReserva());
    }

    @Test
    public void actualizarReservaNotOk() {
        given(reservaRepository.existsById(ReservaUtility.IDNUNO)).willReturn(false);

        assertThrows(Exception.class, () -> reservaServiceImpl.actualizarReserva(ReservaUtility.RESERVADTONUNO));
    }
}
