from itertools import *

def min_dist(graph, start): #функция для нахождения минимального пути
     
    vert = set(graph.keys()) #вершины
 
    min_distance = float('inf') #минимальное расстояние и путь
    min_path = None

    for path in permutations(vert): #генерация всех возможных путей с помощью перестановки
        if path[0] != start: #начало пути - "первый город" 
            continue

        distance = 0  #вычисление расстояния для текущего пути
        for i in range(len(path) - 1):
            distance += graph[path[i]][path[i+1]]

        if distance < min_distance: #обновление минимального
            min_distance = distance
            min_path = path

    return ' -> '.join(min_path)


graph = {
    'A': {'B': 20, 'C': 42, 'D': 35},
    'B': {'A': 20, 'C': 30, 'D': 34},
    'C': {'A': 42, 'B': 30, 'D': 12},
    'D': {'A': 35, 'B': 34, 'C': 12}
}

start = 'A'
min_path = min_dist(graph, start)

print("\nМинимальный путь: ", min_path, "\n")


