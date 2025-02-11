import random
from player import Player
from enemy import Goblin
from item import HealthPotion, ExperienceGem
from level import Level

class Game:
    def __init__(self):
        self.player = Player(input("Введите имя героя: "))

    def start(self):
        print(f"🎮 Добро пожаловать в игру, {self.player.name}!")
        level = Level(1)
        level.start(self.player)

        while self.player.health > 0:
            action = input("\nЧто делать? (fight/pick/use/status/exit): ").lower()

            if action == "fight":
                enemy = Goblin()
                print("⚔️ Битва началась!")
                enemy.attack(self.player)
                if self.player.health > 0:
                    print("🎉 Победа! Ты получаешь 20 опыта.")
                    self.player.gain_experience(20)

            elif action == "pick":
                item = random.choice([HealthPotion(), ExperienceGem()])
                self.player.add_to_inventory(item)

            elif action == "use":
                if self.player.inventory:
                    print("🎒 Твой инвентарь:")
                    for i, item in enumerate(self.player.inventory):
                        print(f"{i+1}. {item.name}")
                    choice = int(input("Выбери предмет (номер): ")) - 1
                    if 0 <= choice < len(self.player.inventory):
                        self.player.inventory[choice].use(self.player)
                        self.player.inventory.pop(choice)
                else:
                    print("📭 Инвентарь пуст!")

            elif action == "status":
                print(f"💖 Здоровье: {self.player.health} | ⭐ Опыт: {self.player.experience}")

            elif action == "exit":
                print("👋 Выход из игры.")
                break

            else:
                print("⚠️ Неизвестная команда!")

        print("💀 Ты умер. Игра окончена.")
