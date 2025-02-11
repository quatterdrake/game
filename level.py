class Level:
    def __init__(self, number):
        self.number = number

    def start(self, player):
        print(f"📍 Начало уровня {self.number} для {player.name}!")
