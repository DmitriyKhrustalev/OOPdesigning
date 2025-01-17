import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {

    // Тест на установку валидной станции
    @Test
    public void shouldSetValidStation() {
        Radio radio = new Radio(10);
        radio.setStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    // Тест на установку станции ниже нуля
    @Test
    public void shouldNotSetStationBelowZero() {
        Radio radio = new Radio(10);
        radio.setStation(-1);
        assertEquals(0, radio.getCurrentStation());
    }

    // Тест на установку станции выше максимума
    @Test
    public void shouldNotSetStationAboveMax() {
        Radio radio = new Radio(10);
        radio.setStation(10);
        assertEquals(0, radio.getCurrentStation());
    }

    // Тест переключения на следующую станцию (обычный случай)
    @Test
    public void shouldSwitchToNextStation() {
        Radio radio = new Radio(10);
        radio.setStation(8);
        radio.nextStation();
        assertEquals(9, radio.getCurrentStation());
    }

    // Тест переключения на следующую станцию с переходом на ноль
    @Test
    public void shouldSwitchToNextStationFromLast() {
        Radio radio = new Radio(10);
        radio.setStation(9);
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    // Тест переключения на предыдущую станцию (обычный случай)
    @Test
    public void shouldSwitchToPrevStation() {
        Radio radio = new Radio(10);
        radio.setStation(1);
        radio.prevStation();
        assertEquals(0, radio.getCurrentStation());
    }

    // Тест переключения на предыдущую станцию с переходом на максимальную
    @Test
    public void shouldSwitchToPrevStationFromFirst() {
        Radio radio = new Radio(10);
        radio.setStation(0);
        radio.prevStation();
        assertEquals(9, radio.getCurrentStation());
    }

    // Тест увеличения громкости до максимума
    @Test
    public void shouldIncreaseVolumeToMax() {
        Radio radio = new Radio();
        radio.setVolume(99);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    // Тест увеличения громкости выше максимума (не должно изменяться)
    @Test
    public void shouldNotIncreaseVolumeAboveMax() {
        Radio radio = new Radio();
        radio.setVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    // Тест уменьшения громкости до минимума
    @Test
    public void shouldDecreaseVolumeToMin() {
        Radio radio = new Radio();
        radio.setVolume(1);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    // Тест уменьшения громкости ниже минимума (не должно изменяться)
    @Test
    public void shouldNotDecreaseVolumeBelowMin() {
        Radio radio = new Radio();
        radio.setVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    // Тест установки громкости выше максимума (должно сбрасываться на 0)
    @Test
    public void shouldNotSetVolumeAboveMax() {
        Radio radio = new Radio();
        radio.setVolume(101);
        assertEquals(0, radio.getCurrentVolume());
    }

    // Тест установки громкости ниже минимума (должно сбрасываться на 0)
    @Test
    public void shouldNotSetVolumeBelowMin() {
        Radio radio = new Radio();
        radio.setVolume(-1);
        assertEquals(0, radio.getCurrentVolume());
    }

    // Тест конструктора по умолчанию
    @Test
    public void shouldCreateRadioWithDefaultStationCount() {
        Radio radio = new Radio();
        assertEquals(10, radio.getStationCount());
    }

    // Тест конструктора с кастомным количеством станций
    @Test
    public void shouldCreateRadioWithCustomStationCount() {
        Radio radio = new Radio(20);
        assertEquals(20, radio.getStationCount());
    }
}
