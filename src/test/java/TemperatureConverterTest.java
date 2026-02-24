import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    private TemperatureConverter converter;

    @BeforeEach
    void setUp() {
        converter = new TemperatureConverter();
    }

    @Test
    void testFahrenheitToCelsius_FreezingPoint() {
        assertEquals(0.0, converter.fahrenheitToCelsius(32.0), 0.01);
    }

    @Test
    void testFahrenheitToCelsius_BoilingPoint() {
        assertEquals(100.0, converter.fahrenheitToCelsius(212.0), 0.01);
    }

    @Test
    void testFahrenheitToCelsius_NegativeTemperature() {
        assertEquals(-40.0, converter.fahrenheitToCelsius(-40.0), 0.01);
    }

    @Test
    void testFahrenheitToCelsius_RoomTemperature() {
        assertEquals(25.0, converter.fahrenheitToCelsius(77.0), 0.01);
    }

    @Test
    void testCelsiusToFahrenheit_FreezingPoint() {
        assertEquals(32.0, converter.celsiusToFahrenheit(0.0), 0.01);
    }

    @Test
    void testCelsiusToFahrenheit_BoilingPoint() {
        assertEquals(212.0, converter.celsiusToFahrenheit(100.0), 0.01);
    }

    @Test
    void testCelsiusToFahrenheit_NegativeTemperature() {
        assertEquals(-40.0, converter.celsiusToFahrenheit(-40.0), 0.01);
    }

    @Test
    void testCelsiusToFahrenheit_RoomTemperature() {
        assertEquals(77.0, converter.celsiusToFahrenheit(25.0), 0.01);
    }

    @Test
    void testKelvinToCelsius_AbsoluteZero() {
        assertEquals(-273.15, converter.kelvinToCelsius(0.0), 0.01);
    }

    @Test
    void testKelvinToCelsius_FreezingPoint() {
        assertEquals(0.0, converter.kelvinToCelsius(273.15), 0.01);
    }

    @Test
    void testKelvinToCelsius_BoilingPoint() {
        assertEquals(100.0, converter.kelvinToCelsius(373.15), 0.01);
    }

    @Test
    void testKelvinToCelsius_RoomTemperature() {
        assertEquals(26.85, converter.kelvinToCelsius(300.0), 0.01);
    }

    @Test
    void testIsExtremeTemperature_BelowMinusForty() {
        assertTrue(converter.isExtremeTemperature(-41.0));
        assertTrue(converter.isExtremeTemperature(-50.0));
    }

    @Test
    void testIsExtremeTemperature_AboveFifty() {
        assertTrue(converter.isExtremeTemperature(51.0));
        assertTrue(converter.isExtremeTemperature(60.0));
    }

    @Test
    void testIsExtremeTemperature_BoundaryValues() {
        assertFalse(converter.isExtremeTemperature(-40.0));
        assertFalse(converter.isExtremeTemperature(50.0));
    }

    @Test
    void testIsExtremeTemperature_NormalTemperatures() {
        assertFalse(converter.isExtremeTemperature(0.0));
        assertFalse(converter.isExtremeTemperature(25.0));
        assertFalse(converter.isExtremeTemperature(-20.0));
        assertFalse(converter.isExtremeTemperature(40.0));
    }
}