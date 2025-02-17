public class Main {
    public static void main(String[] args) {
        // Создаем комнаты и предметы
        Room room1 = new Room("Stone Chamber", "A small stone chamber with dim lighting.");
        Room room2 = new Room("Dark Hallway", "A long, narrow hallway with a faint glow.");

        Item sword = new Item("sword", "A sharp sword with a steel blade.");
        Item shield = new Item("shield", "A sturdy shield made of iron.");

        room1.addItem(sword);
        room2.addItem(shield);

        // Связываем комнаты
        room1.connect("forward", room2);
        room2.connect("back", room1);

        // Создаем игрока
        Player player = new Player("Hero", room1);

        // Запускаем игру
        MUDController controller = new MUDController(player);
        controller.runGameLoop();
    }
}
