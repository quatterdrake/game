from interfaces import IEnemy

class Goblin(IEnemy):
    def __init__(self):
        self.health = 30

    def attack(self, player):
        damage = 10
        print("Гоблин атакует!")
        player.take_damage(damage)
