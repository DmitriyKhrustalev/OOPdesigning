package org.example;

public class Radio {
    private int currentStation; // Номер текущей радиостанции
    private int currentVolume;  // Уровень громкости
    private int stationCount;

    // Метод переключения на следующую станцию
    public void nextStation() {
        if (currentStation == 9) {
            currentStation = 0;
        } else {
            currentStation++;
        }
    }

    // Метод переключения на предыдущую станцию
    public void prevStation() {
        if (currentStation == 0) {
            currentStation = 9;
        } else {
            currentStation--;
        }
    }

    // Метод установки радиостанции вручную
    public void setStation(int station) {
        if (station >= 0 && station <= 9) {
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

    // Сеттер для установки текущей громкости (если потребуется)
    public void setVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            currentVolume = volume;
        }
    }
}
