#Разработка структуры данных «Префиксное дерево».
##Задача 26
Префиксное дерево — структура данных, позволяющая хранить ассоциативный массив, ключами которого являются строки. 
Представляет собой корневое дерево, каждое ребро которого помечено каким-то символом так, что для любого узла все рёбра,
 соединяющие этот узел с сыновьями, помечены разными символами, префиксное дерево содержит данную строку-ключ тогда и 
 только тогда, когда эту строку можно прочитать на пути из корня до какого-то выделенного узла (заметим, что такой узел 
 единственный).
 
Необходимо разработать такую структуру данных. Кроме этого, выбрать алгоритм, который эффективно решается при помощи 
этой структуры данных, и продемонстрировать работу этого алгоритма с реализованной вами структурой данных.

##Реализация

Префиксное дерево на Java 13. Реализация - класс classes.Trie в пакете. 