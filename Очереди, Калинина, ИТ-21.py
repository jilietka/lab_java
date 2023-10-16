import random


def gen_duration(): # Генерация случайной длительности заявки
    duration = float(random.randint(180, 300))
    return duration


def gen_inerval(): # Генерация случайного интервала между заявками
    interval = float(random.randint(60, 120))
    return interval


class Stack(): # Объявление класса Стэк
    def __init__(self):
        self.stack = []

    def len(self): # Функция возвращающая текущую длину очереди
        return len(self.stack)

    def pop(self): # Функция извлечающая 1 элемент из очереди или None, если она пустая
        if len(self.stack) == 0:
            return None
        else:
            return self.stack.pop(0)

    def push(self, item): # Функция добавления в конец очереди
        self.stack.append(item)

    def back(self, item): # Функция возвращения элемента в начало очереди, если мы оттуда изъяли
        self.stack = [item, *self.stack]


class Application(): # Объявление класса заявка с полями
    def __init__(self, id, insert_time, out_time=None):
        self.id = id # Уникальный идентификатор
        self.insert_time = insert_time # Время помещения в очередь
        if out_time != None: 
            self.out_time = out_time # Время извлечения из очереди


# Создание и объявление обрабочиков

QA_0 = Stack()
QA_0_processed = Stack()

QA_1 = Stack()
QA_1_processed = Stack()

QA_2 = Stack()
QA_2_processed = Stack()

time = 0

duration_QA_1 = 0
duration_QA_2 = 0

for id in range(1000): # Добавление 1000 заявок в очередь
    id += 1

    interval = gen_inerval()

    insert_time = time + interval
    time += interval

    app = Application(str(id), time) # Создание объекта заявка на основе параметров

    if QA_1.len() <= QA_2.len(): # Кидаем в очередь с меньшей длиной для 2 аппаратов
        QA_1.push(app)
    else:
        QA_2.push(app)

    QA_0.push(app) # Кидаем в общую очередь для 1 аппарата

# Проверка работы с 1 обрабочиком (для 2 аналогично)
print("QA_0")
QA_0_times = []
l_out_time = 0
while QA_0.len() != 0:
    app = QA_0.pop() # Извлекаем из стэка
    work_time = gen_duration() # Генерируем длительность обработки

    if l_out_time < app.insert_time: # Сверяемся с прошлыми заявками - если прошлый вышел раньше, чем этот пришел, то просто плюсуем время
        app.out_time = app.insert_time + work_time
        l_out_time = app.out_time
    else: # Иначе начинаем отсчёт с момента завершения прошлой заявки
        app.out_time = l_out_time + work_time
        l_out_time = app.out_time

    QA_0_times.append(app.out_time - app.insert_time) # Добавляем время пребывания в очереди в массив

    if len(QA_0_times) % 100 == 0: # Каждые 100 объектов выводим информацию о средней длительности пребывания в очереди и оставшихся объектах
        print(QA_0.len(),
              round(sum(QA_0_times)/len(QA_0_times)),
              app.insert_time, app.out_time)

print("QA_1 и QA_2")
QA_1_and_2_times = []
l_out_time = 0

while QA_1.len() != 0:
    app = QA_1.pop()
    work_time = gen_duration()

    if l_out_time < app.insert_time:
        app.out_time = app.insert_time + work_time
        l_out_time = app.out_time
    else:
        app.out_time = l_out_time + work_time
        l_out_time = app.out_time

    QA_1_and_2_times.append(app.out_time - app.insert_time)

    if len(QA_1_and_2_times) % 100 == 0:
        print(QA_1.len() + QA_2.len(), round(sum(QA_1_and_2_times) /
              len(QA_1_and_2_times)), app.insert_time, app.out_time)

l_out_time = 0
while QA_2.len() != 0:
    app = QA_2.pop()
    work_time = gen_duration()

    if l_out_time < app.insert_time:
        app.out_time = app.insert_time + work_time
        l_out_time = app.out_time
    else:
        app.out_time = l_out_time + work_time
        l_out_time = app.out_time

    QA_1_and_2_times.append(app.out_time - app.insert_time)

    if len(QA_1_and_2_times) % 100 == 0:
        print(QA_1.len() + QA_2.len(), round(sum(QA_1_and_2_times) /
              len(QA_1_and_2_times)), app.insert_time, app.out_time)

print(f"Время работы двух аппаратов составляет {(sum(QA_1_and_2_times)/len(QA_1_and_2_times)) / (sum(QA_0_times)/len(QA_0_times)) * 100}% от времени работы одного аппарата")
