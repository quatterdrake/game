public class Main {
    public static void main(String[] args) {
        // Создание предметов
        Item sword = new Item("Sword", "A sharp looking sword.");
        Item shield = new Item("Shield", "A sturdy wooden shield.");

        // Создание комнат
        Room room1 = new Room("Room 1", "A dark and gloomy room.");
        Room room2 = new Room("Room 2", "A bright, sunny room.");
        room1.setItem(sword);
        room2.setItem(shield);

        // Связываем комнаты
        room1.connectRoom("forward", room2);
        room2.connectRoom("back", room1);

        // Создание игрока
        Player player = new Player("Hero", room1);

        // Запуск игры
        MUDController game = new MUDController(player);
        game.runGameLoop();
    }
}
