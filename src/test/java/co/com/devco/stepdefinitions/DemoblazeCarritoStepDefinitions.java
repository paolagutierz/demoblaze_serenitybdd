package co.com.devco.stepdefinitions;

import co.com.devco.interactions.ClickNavBar;
import co.com.devco.tasks.AgregarAlCarrito;
import co.com.devco.tasks.LimpiarCarrito;
import co.com.devco.tasks.Loguearse;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.OpenUrl;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.devco.userinterfaces.DemoblazeCarritoPage.*;
import static co.com.devco.userinterfaces.DemoblazeIndexPage.LINK_CARRITO;
import static co.com.devco.userinterfaces.DemoblazeIndexPage.LINK_HOME;
import static co.com.devco.userinterfaces.DemoblazeProductosPage.LINK_PRODUCTO;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DemoblazeCarritoStepDefinitions {

    @Dado("que {string} se loguea como {string}")
    public void loguin(String actor, String rol) {
        theActorCalled(actor).attemptsTo(
                Loguearse.como(rol),
                LimpiarCarrito.completamente()
        );
    }

    @Cuando("agrega el {string} al carrito vacio")
    public void agregarObjetoAlCarrito(String producto) {
        theActorInTheSpotlight().attemptsTo(
                AgregarAlCarrito.elProducto(producto)
        );
    }

    @Entonces("debe ver como unico elemento el {string}")
    public void verificarObjetoCarrito(String producto) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(PRODUCTOS_CARRITO).values().hasSize(1),
                Ensure.that(TITULO_PRODUCTO_CARRITO.of(producto)).isEnabled()
        );

    }


}
