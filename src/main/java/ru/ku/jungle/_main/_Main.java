package ru.ku.jungle._main;
import ru.ku.jungle.model.Snake;
import ru.ku.jungle.util.EventManager;

public class _Main {
    public static void main(String[] args) {
        Snake snake = new Snake();
        EventManager eventManager = new EventManager();
        eventManager.eventStarter(snake);
    }
}
