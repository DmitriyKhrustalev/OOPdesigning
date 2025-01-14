
public class Radio {
    private int currentStation;  // Номер текущей радиостанции
    private int currentVolume;   // Уровень громкости
    private final int stationCount;    // Количество радиостанций

    // Конструктор по умолчанию (10 станций)
    public Radio() {
        this.stationCount = 10;
    }

    // Конструктор с параметром (задаёт количество станций)
    public Radio(int stationCount) {
        this.stationCount = stationCount;
    }

    // Метод переключения на следующую станцию
    public void nextStation() {
        if (currentStation == stationCount - 1) {
            currentStation = 0;
        } else {
            currentStation++;
        }
    }

    // Метод переключения на предыдущую станцию
    public void prevStation() {
        if (currentStation == 0) {
            currentStation = stationCount - 1;
        } else {
            currentStation--;
        }
    }

    // Метод установки радиостанции вручную
    public void setStation(int station) {
        if (station >= 0 && station < stationCount) {
            currentStation = station;
        }
    }

    // Метод увеличения громкости
    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    // Метод уменьшения громкости
    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }

    // Геттер для текущей радиостанции
    public int getCurrentStation() {
        return currentStation;
    }

    // Геттер для текущей громкости
    public int getCurrentVolume() {
        return currentVolume;
    }

    // Геттер для количества радиостанций
    public int getStationCount() {
        return stationCount;
    }

    // Сеттер для установки текущей громкости
    public void setVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            currentVolume = volume;
        }
    }
}
