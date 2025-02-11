from abc import ABC, abstractmethod

class IEnemy(ABC):
    @abstractmethod
    def attack(self, player):
        pass

class IItem(ABC):
    @abstractmethod
    def use(self, player):
        pass
