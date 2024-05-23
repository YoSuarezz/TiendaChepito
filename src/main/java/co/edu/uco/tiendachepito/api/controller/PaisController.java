package co.edu.uco.tiendachepito.api.controller;


import co.edu.uco.tiendachepito.api.response.pais.PaisResponse;
import co.edu.uco.tiendachepito.business.facade.ConsultarPaisesFachada;
import co.edu.uco.tiendachepito.crosscutting.exceptions.TiendaChepitoException;
import co.edu.uco.tiendachepito.crosscutting.helpers.NumericHelper;
import co.edu.uco.tiendachepito.dto.PaisDTO;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/paises")
public class PaisController {

    public PaisController(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }

    public ResponseEntity<PaisResponse> consultar(@RequestParam(required = false, defaultValue = "0") String id,
                                                  @RequestParam(required = false, defaultValue = "") String nombre) {
        PaisResponse paisResponse = PaisResponse.build();
        HttpStatus httpsStatusResponse = HttpStatus.OK;

        try {
            final var paisDtoFilter = PaisDTO.build().setId(NumericHelper.convertToInt(id)).setNombre(nombre);

            final ConsultarPaisesFachada fachada = new ConsultarPaisesFachadaImpl();
            paisResponse.setDatos(fachada.execute(PaisDTO.build()));
            paisResponse.getMensajes().add("Países consultados exitosamente");
        } catch (final TiendaChepitoException exception) {
            exception.printStackTrace();
            paisResponse.getMensajes().add(exception.getMensajeUsuario());
            httpsStatusResponse = HttpStatus.BAD_REQUEST;
        } catch (final Exception exception) {
            exception.printStackTrace();
            paisResponse.getMensajes().add("Se ha presentado un error inesperado tratando de consultar");
            httpsStatusResponse = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(paisResponse, httpStatusResponse);
    }
    @PostMapping
    public ResponseEntity<PaisResponse> crear(@RequestBody PaisDTO pais) {
        PaisResponse paisResponse = PaisResponse.build();
        HttpStatus httpsStatusResponse = HttpStatus.OK;
        try {
            //llamar la fachada de registor del nuevo pais
            paisResponse.getDatos().add(PaisDTO.build());
            paisResponse.getMensajes().add("País registrado exitosamente");
        } catch (final TiendaChepitoException exception) {
            exception.printStackTrace();
            paisResponse.getMensajes().add(exception.getMensajeUsuario());
            httpsStatusResponse = HttpStatus.BAD_REQUEST;
        } catch (final Exception exception) {
            exception.printStackTrace();
            paisResponse.getMensajes().add("Se ha presentado un error inesperado tratando de consultar");
            httpsStatusResponse = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(paisResponse, httpStatusResponse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<PaisResponse> eliminar(@RequestBody int id) {
        PaisResponse paisResponse = PaisResponse.build();
        HttpStatus httpsStatusResponse = HttpStatus.OK;
        try {
            //llamar la fachada de eliminar el pais
            paisResponse.getMensajes().add("País eliminado exitosamente");
        } catch (final TiendaChepitoException exception) {
            exception.printStackTrace();
            paisResponse.getMensajes().add(exception.getMensajeUsuario());
            httpsStatusResponse = HttpStatus.BAD_REQUEST;
        } catch (final Exception exception) {
            exception.printStackTrace();
            paisResponse.getMensajes().add("Se ha presentado un error inesperado tratando de consultar");
            httpsStatusResponse = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(paisResponse, httpStatusResponse);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PaisResponse> modificar(@PathVariable int id, @RequestBody PaisDTO pais) {
        PaisResponse paisResponse = PaisResponse.build();
        HttpStatus httpsStatusResponse = HttpStatus.OK;
        try {
            //llamar la fachada de modificar el pais
            paisResponse.getDatos().add(pais);
            paisResponse.getMensajes().add("País modificadode forma exitosa");
        } catch (final TiendaChepitoException exception) {
            exception.printStackTrace();
            paisResponse.getMensajes().add(exception.getMensajeUsuario());
            httpsStatusResponse = HttpStatus.BAD_REQUEST;
        } catch (final Exception exception) {
            exception.printStackTrace();
            paisResponse.getMensajes().add("Se ha presentado un error inesperado tratando de consultar");
            httpsStatusResponse = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(paisResponse, httpStatusResponse);
    }
}