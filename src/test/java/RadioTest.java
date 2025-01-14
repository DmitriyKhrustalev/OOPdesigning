import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {

    // Тест переключения на следующую станцию
    @Test
    public void shouldSwitchToNextStation() {
        Radio radio = new Radio(10); // Радио с 10 станциями
        radio.setStation(8);
        radio.nextStation();
        assertEquals(9, radio.getCurrentStation());

        radio.nextStation();
        assertEquals(0, radio.getCurrentStation()); // Возврат на первую станцию
    }

    // Тест переключения на следующую станцию с пользовательским количеством
    @Test
    public void shouldSwitchToNextStationCustomCount() {
        Radio radio = new Radio(5); // Радио с 5 станциями
        radio.setStation(3);
        radio.nextStation();
        assertEquals(4, radio.getCurrentStation());

        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    // Тест переключения на предыдущую станцию
    @Test
    public void shouldSwitchToPrevStation() {
        Radio radio = new Radio(10);
        radio.setStation(1);
        radio.prevStation();
        assertEquals(0, radio.getCurrentStation());

        radio.prevStation();
        assertEquals(9, radio.getCurrentStation()); // Переход на последнюю станцию
    }

    // Тест переключения на предыдущую станцию с пользовательским количеством
    @Test
    public void shouldSwitchToPrevStationCustomCount() {
        Radio radio = new Radio(5); // Радио с 5 станциями
        radio.setStation(0);
        radio.prevStation();
        assertEquals(4, radio.getCurrentStation());
    }

    // Тест установки радиостанции вручную
    @Test
    public void shouldSetStationManually() {
        Radio radio = new Radio(10);
        radio.setStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    // Тест установки радиостанции за пределами диапазона
    @Test
    public void shouldNotSetStationOutOfRange() {
        Radio radio = new Radio(10);
        radio.setStation(10); // Номер станции вне диапазона
        assertEquals(0, radio.getCurrentStation()); // Станция не изменяется

        radio.setStation(-1); // Номер станции меньше 0
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

    // Тест создания радио с количеством станций по умолчанию
    @Test
    public void shouldCreateRadioWithDefaultStationCount() {
        Radio radio = new Radio();
        assertEquals(10, radio.getStationCount());
    }

    // Тест создания радио с пользовательским количеством станций
    @Test
    public void shouldCreateRadioWithCustomStationCount() {
        Radio radio = new Radio(20);
        assertEquals(20, radio.getStationCount());
    }
}
