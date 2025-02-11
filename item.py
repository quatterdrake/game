from interfaces import IItem

class HealthPotion(IItem):
    def __init__(self):
        self.name = "Зелье здоровья"

    def use(self, player):
        heal_amount = 20
        player.health += heal_amount
        print(f"{player.name} выпил зелье! Здоровье: {player.health}")

class ExperienceGem(IItem):
    def __init__(self):
        self.name = "Камень опыта"

    def use(self, player):
        exp_amount = 50
        player.gain_experience(exp_amount)
