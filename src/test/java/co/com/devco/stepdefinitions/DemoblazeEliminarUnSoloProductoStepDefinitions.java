package co.com.devco.stepdefinitions;

import co.com.devco.interactions.ClickNavBar;
import co.com.devco.tasks.AgregarAlCarrito;
import co.com.devco.tasks.LimpiarCarrito;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.actions.Open;

import static co.com.devco.userinterfaces.DemoblazeIndexPage.LINK_CARRITO;
import static co.com.devco.userinterfaces.DemoblazeIndexPage.LINK_HOME;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DemoblazeEliminarUnSoloProductoStepDefinitions {

    @Dado("{string} agrega {string} y {string} al carrito vacio")
    public void agregaProductosAlCarrito(String actor, String producto1, String producto2) {
        theActorCalled(actor).attemptsTo(
                Open.url("https://www.demoblaze.com/#"),
                LimpiarCarrito.completamente(),
                ClickNavBar.enTab(LINK_HOME),
                AgregarAlCarrito.elProducto(producto1),
                ClickNavBar.enTab(LINK_HOME),
                AgregarAlCarrito.elProducto(producto2)

        );
    }

    @Cuando("elimina {string}")
    public void eliminaProductoDelCarrito(String producto1) {
        theActorInTheSpotlight().attemptsTo(
                ClickNavBar.enTab(LINK_HOME),
                LimpiarCarrito.unProducto(producto1),
                ClickNavBar.enTab(LINK_CARRITO)
        );
    }
}


