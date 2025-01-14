import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {

    // Тест переключения на следующую станцию
    @Test
    public void shouldSwitchToNextStation() {
        Radio radio = new Radio();
        radio.setStation(8);
        radio.nextStation();
        assertEquals(9, radio.getCurrentStation());

        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    // Тест переключения на предыдущую станцию
    @Test
    public void shouldSwitchToPrevStation() {
        Radio radio = new Radio();
        radio.setStation(1);
        radio.prevStation();
        assertEquals(0, radio.getCurrentStation());

        radio.prevStation();
        assertEquals(9, radio.getCurrentStation());
    }

    // Тест установки радиостанции вручную
    @Test
    public void shouldSetStationManually() {
        Radio radio = new Radio();
        radio.setStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    // Тест установки радиостанции за пределами диапазона
    @Test
    public void shouldNotSetStationOutOfRange() {
        Radio radio = new Radio();
        radio.setStation(10);
        assertEquals(0, radio.getCurrentStation());
    }

    // Тест увеличения громкости
    @Test
    public void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());

        radio.setVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume()); // Максимальная громкость не превышается
    }

    // Тест уменьшения громкости
    @Test
    public void shouldDecreaseVolume() {
        Radio radio = new Radio();
        radio.setVolume(1);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());

        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume()); // Минимальная громкость не падает ниже 0
    }

    // Тест установки громкости вручную в допустимых пределах
    @Test
    public void shouldSetVolumeWithinRange() {
        Radio radio = new Radio();
        radio.setVolume(50);
        assertEquals(50, radio.getCurrentVolume());
    }

    // Тест установки громкости вручную за пределами диапазона
    @Test
    public void shouldNotSetVolumeOutOfRange() {
        Radio radio = new Radio();
        radio.setVolume(-1); // Меньше 0
        assertEquals(0, radio.getCurrentVolume());

        radio.setVolume(101); // Больше 100
        assertEquals(0, radio.getCurrentVolume()); // Громкость остаётся неизменной
    }
}
