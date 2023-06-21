package ru.ku.jungle.util;

import ru.ku.jungle.model.Snake;

public class EventManager {
    //спала  +20 энергии  (0-20)
    //съела яйцо -15 энергии, + 3 * 3.1 (preyEnergyFactor) здоровья  (21-25)
    //съела лягушку -20 энергии + 5 * 3.1 (preyEnergyFactor) здоровья  (25-28)
    //ползала  -20 энергии  (29-39)
    //плавала  -10 энергии  (40-45)
    //охотилась -30 энергии  (46-66)
    //спасалась от мангуста  -50 энергии (67-73)
    //спасалась от ежа  -40 энергии (74-80)
    //пугала туристов  -25 энергии (81-90)
    //грелась на солнце  +10 энергии (91-100)

    public void eventStarter(Snake snake) {
        while (statusChecker(snake)) {
            int eventVariant = (int) (Math.random() * 100);
            if (eventVariant >= 0 && eventVariant < 21) {
                snakeSleep(snake);
            } else if (eventVariant >= 21 && eventVariant < 25) {
                snakeEatEgg(snake);
            } else if (eventVariant >= 25 && eventVariant < 29) {
                snakeEatFrog(snake);
            } else if (eventVariant >= 29 && eventVariant < 40) {
                snakeCrawl(snake);
            } else if (eventVariant >= 40 && eventVariant < 46) {
                snakeSwim(snake);
            } else if (eventVariant >= 46 && eventVariant < 67) {
                snakeHunt(snake);
            } else if (eventVariant >= 67 && eventVariant < 74) {
                snakeEscapeMongoose(snake);
            } else if (eventVariant >= 74 && eventVariant < 81) {
                snakeEscapeHedgehog(snake);
            } else if (eventVariant >= 81 && eventVariant < 91) {
                snakeScareTourists(snake);
            } else if (eventVariant >= 91 && eventVariant <= 100) {
                snakeBaskInTheSun(snake);
            }
        }
        System.out.println("Snake is dead!:( The End!");
    }

    private void snakeSleep(Snake snake) {
        int energy = snake.getEnergy();
        energy = energy + 20;
        snake.setEnergy(energy);
        healthModifier(snake);
        System.out.println("Snake slept! + 20 energy");
    }

    private void snakeEatEgg(Snake snake) {
        int energy = snake.getEnergy();
        int health = snake.getHealth();
        energy = energy - 15;
        health = health + (int) (snake.getPreyEnergyFactor() * 3);
        snake.setEnergy(energy);
        snake.setHealth(health);
        healthModifier(snake);
        System.out.println("Snake ate an egg! - 15 energy");
    }

    private void snakeEatFrog(Snake snake) {
        int energy = snake.getEnergy();
        int health = snake.getHealth();
        energy = energy - 20;
        health = health + (int) (snake.getPreyEnergyFactor() * 5);
        snake.setEnergy(energy);
        snake.setHealth(health);
        healthModifier(snake);
        System.out.println("Snake ate a frog! - 20 energy");
    }

    private void snakeCrawl(Snake snake) {
        int energy = snake.getEnergy();
        energy = energy - 20;
        snake.setEnergy(energy);
        healthModifier(snake);
        System.out.println("Snake crawled! - 20 energy");
    }

    private void snakeSwim(Snake snake) {
        int energy = snake.getEnergy();
        energy = energy - 10;
        snake.setEnergy(energy);
        healthModifier(snake);
        System.out.println("Snake swam! - 10 energy");
    }

    private void snakeHunt(Snake snake) {
        int energy = snake.getEnergy();
        energy = energy - 30;
        snake.setEnergy(energy);
        healthModifier(snake);
        System.out.println("Snake hunted! - 30 energy");
    }

    private void snakeEscapeMongoose(Snake snake) {
        int energy = snake.getEnergy();
        energy = energy - 50;
        snake.setEnergy(energy);
        healthModifier(snake);
        System.out.println("Snake escaped from the mongoose! - 50 energy");
    }

    private void snakeEscapeHedgehog(Snake snake) {
        int energy = snake.getEnergy();
        energy = energy - 40;
        snake.setEnergy(energy);
        healthModifier(snake);
        System.out.println("Snake escaped from the hedgehog! - 40 energy");
    }

    private void snakeScareTourists(Snake snake) {
        int energy = snake.getEnergy();
        energy = energy - 25;
        snake.setEnergy(energy);
        healthModifier(snake);
        System.out.println("Snake scared tourists! - 25 energy");
    }

    private void snakeBaskInTheSun(Snake snake) {
        int energy = snake.getEnergy();
        energy = energy + 10;
        snake.setEnergy(energy);
        healthModifier(snake);
        System.out.println("Snake basked in the sun! + 10 energy");
    }

    private boolean statusChecker(Snake snake) {
        System.out.println("health: " + snake.getHealth() + ", energy: " + snake.getEnergy());
        if (snake.getHealth() == 0) {
            return false;
        } else {
            return true;
        }
    }

    private void healthModifier(Snake snake) {
        int health = snake.getHealth();
        if (snake.getEnergy() <= 0) {
            health = health - 20;
        }
        snake.setHealth(health);
        int energy = snake.getEnergy();
        if (snake.getEnergy() < 0) {
            energy = 0;
        } else if (snake.getEnergy() > 100) {
            energy = 100;
        }
        snake.setEnergy(energy);
        if (snake.getHealth() < 0) {
            health = 0;
        } else if (snake.getHealth() > 100) {
            health = 100;
        }
        snake.setHealth(health);
    }
}
