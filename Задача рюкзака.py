from random import *
class thing: #предметы
    def __init__(self, name, price, weight):
        self.name = name
        self.price = price
        self.weight = weight


class bag: #рюкзак
    def __init__(self, capacity):
        self.capacity = capacity
        self.things = []

    def add_thing(self, thing): #добавление вещей
        if self.capacity >= thing.weight:
            self.things.append(thing)
            self.capacity -= thing.weight
            return True
        return False

    def contents(self): #вывод комбинаций, которые поместятся в рюкзак
        print("В рюкзак поместится:")
        for thing in self.things:
            print(f"{thing.name} - Стоимость: {thing.price}, Вес: {thing.weight}")

        print("_" * 35 + "\n")


def sort_price(thing): #сортировка по цене
    return thing.price


def sort_weight(thing): #сортировка по весу
    return thing.weight


def sort_price_weight(thing): #сортировка соотношению цены к весу
    return thing.price/thing.weight

bag_weight = randint(10, 40) #вместимость рандомным числом
print(f"В рюкзак можно положить {bag_weight} кг вещей\n")

def strategy(things, sort_strategy): #собираем рюкзак в зависимости от стратегии
    sorted_things = sorted(things, key=sort_strategy)
    bagpack = bag(bag_weight) #вместимость через экземляр класса

    for i in sorted_things:
        if not bagpack.add_thing(i):
            break

    bagpack.contents()

#создаем вещи
thing1 = thing("Вещь 1", randint(1,25), randint(1,7))
thing2 = thing("Вещь 2", randint(1,25), randint(1,7))
thing3 = thing("Вещь 3", randint(1,25), randint(1,7))
thing4 = thing("Вещь 4", randint(1,25), randint(1,7))
thing5 = thing("Вещь 5", randint(1,25), randint(1,7))

#вещи в список
things = [thing1, thing2, thing3, thing4, thing5]

#стратегия заполнения рюкзака по цене
strategy(things, sort_price)

#по весу
strategy(things, sort_weight)

#по отношению цены к весу
strategy(things, sort_price_weight)