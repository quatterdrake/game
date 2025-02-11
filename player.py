class Player:
    def __init__(self, name):
        self.name = name
        self.health = 100
        self.experience = 0
        self.inventory = []

    def take_damage(self, amount):
        self.health -= amount
        print(f"{self.name} получил {amount} урона! Здоровье: {self.health}")

    def gain_experience(self, amount):
        self.experience += amount
        print(f"{self.name} получил {amount} опыта! Опыт: {self.experience}")

    def add_to_inventory(self, item):
        self.inventory.append(item)
        print(f"{self.name} получил {item.name} в инвентарь!")
