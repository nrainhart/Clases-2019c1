package ar.edu.utn.frba.mobile.a2019c1

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.core.IsNot.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun botonesDesactivadosSinTexto (){
        onView(withId(R.id.temperaturaIngresadaC)).check(matches(withText("")))
        onView(withId(R.id.botonCelsius)).check(matches(not(isEnabled())))
    }

    @Test
    fun alIngresarTextoSeHabilitanLosBotones(){
        onView(withId(R.id.temperaturaIngresadaC)).perform(typeText("some text"))
        onView(withId(R.id.botonCelsius)).check(matches(isEnabled()))
    }
}