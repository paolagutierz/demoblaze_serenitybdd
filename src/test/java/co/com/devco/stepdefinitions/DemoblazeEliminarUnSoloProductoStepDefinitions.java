package co.com.devco.stepdefinitions;

import co.com.devco.tasks.AgregarAlCarrito;
import co.com.devco.tasks.LimpiarCarrito;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.ensure.Ensure;

import static co.com.devco.userinterfaces.DemoblazeCarritoPage.PRODUCTOS_CARRITO;
import static co.com.devco.userinterfaces.DemoblazeCarritoPage.TITULO_PRODUCTO_CARRITO;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DemoblazeEliminarUnSoloProductoStepDefinitions {

    @Dado("{string} agrega {string} y {string} al carrito vacio")
    public void agregaProductosAlCarrito(String actor, String... productos) {
        for (String producto : productos) {
            theActorCalled(actor).attemptsTo(
                    AgregarAlCarrito.elProducto(producto)
            );
        }
    }

    @Cuando("elimina {string}")
    public void eliminaProductoDelCarrito(String producto) {
        theActorInTheSpotlight().attemptsTo(
                LimpiarCarrito.unElemento(producto)
        );
    }

    @Entonces("debe ver como único elemento un {string}")
    public void verificarObjetoCarrito(String producto) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(PRODUCTOS_CARRITO).values().hasSize(1),
                Ensure.that(TITULO_PRODUCTO_CARRITO.of(producto)).isEnabled()
        );

    }
}


