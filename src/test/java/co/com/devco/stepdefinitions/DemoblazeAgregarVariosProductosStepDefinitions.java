package co.com.devco.stepdefinitions;

import co.com.devco.tasks.AgregarAlCarrito;
import co.com.devco.tasks.LimpiarCarrito;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;

import static co.com.devco.userinterfaces.DemoblazeCarritoPage.PRODUCTOS_CARRITO;
import static co.com.devco.userinterfaces.DemoblazeCarritoPage.TITULO_PRODUCTO_CARRITO;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DemoblazeAgregarVariosProductosStepDefinitions {

    @Cuando("{string} agrega {string} {string} al carrito")
    public void agregarVariosProductos(String actor, String cantidadStr, String producto) {
        int cantidad = Integer.parseInt(cantidadStr);

        theActorCalled(actor).attemptsTo(
                Open.url("https://www.demoblaze.com/#"),
                LimpiarCarrito.completamente(),
                AgregarAlCarrito.losProductos(producto, cantidad)
        );
    }

    @Entonces("debe ver {string} elementos de {string}")
    public void verificarObjetoCarrito(String cantidadStr, String producto) {
        int cantidad = Integer.parseInt(cantidadStr);

        theActorInTheSpotlight().attemptsTo(
                Ensure.that(PRODUCTOS_CARRITO).values().hasSize(cantidad),
                Ensure.that(TITULO_PRODUCTO_CARRITO.of(producto)).isEnabled()
        );

    }
}
