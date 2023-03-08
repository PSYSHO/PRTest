# Выполнение первой части задания

1. Используйте команды операционной системы Linux и создайте две новых директории – «Игрушки для школьников» и «Игрушки для дошколят»  
```powershell

kek@kek-VirtualBox:~$ mkdir Игрушки_для_дошколят
kek@kek-VirtualBox:~$ mkdir Игрушки_для_Школьников
```
2. Создайте в директории «Игрушки для школьников» текстовые файлы - «Роботы», «Конструктор», «Настольные игры»

```powershell
kek@kek-VirtualBox:~$ cd Игрушки_для_Школьников
kek@kek-VirtualBox:~/Игрушки_для_Школьников$ > Роботы
kek@kek-VirtualBox:~/Игрушки_для_Школьников$ > Конструктор
kek@kek-VirtualBox:~/Игрушки_для_Школьников$ > Настольные_Игры
```
3. Создайте в директории «Игрушки для дошколят» текстовые файлы «Мягкие игрушки», «Куклы», «Машинки»

```powershell 
kek@kek-VirtualBox:~/Игрушки_для_Школьников$ cd ..
kek@kek-VirtualBox:~$ cd Игрушки_для_дошколят
kek@kek-VirtualBox:~/Игрушки_для_дошколят$ > Мягкие_Игрушки
kek@kek-VirtualBox:~/Игрушки_для_дошколят$ > Куклы
kek@kek-VirtualBox:~/Игрушки_для_дошколят$ > Машинки
```
4. Объединить 2 директории в одну «Имя Игрушки»  
*Здесь я наперед выполняю задачу под номером **7***
```powershell
kek@kek-VirtualBox:~/Игрушки_для_дошколят$ cd
kek@kek-VirtualBox:~$ sudo snap install tree
[sudo] password for kek:
tree 1.8.0+pkg-3fd6 from 林博仁(Buo-ren, Lin) (brlin) installed
kek@kek-VirtualBox:~$ tree
kek@kek-VirtualBox:~$ mkdir Имя_Игрушки
kek@kek-VirtualBox:~$ mv Игрушки_для_Школьников/ Игрушки_для_дошколят/ Имя_Игрушки/
kek@kek-VirtualBox:~$ cd Имя_Игрушки
kek@kek-VirtualBox:~/Имя_Игрушки$ tree
```
5. Переименовать директорию «Имя Игрушки» в «Игрушки»
```powershell
kek@kek-VirtualBox:~/Имя_Игрушки$ cd
kek@kek-VirtualBox:~$ mv Имя_Игрушки/ Игрушки
kek@kek-VirtualBox:~$ ls
```
6. Просмотреть содержимое каталога «Игрушки».
```powershell
kek@kek-VirtualBox:~$ cd Игрушки
kek@kek-VirtualBox:~/Игрушки$ tree -g
```
7. Установить и удалить snap-пакет. (Любой, какой хотите)  
*Установка пакета была в пункте **4***
```powershell
kek@kek-VirtualBox:~/Игрушки$ sudo snap remove tree
tree removed
```
8. Добавить произвольную задачу для выполнения каждые 3 минуты  
(Например, запись в текстовый файл чего-то или копирование из каталога А в каталог Б).
```powershell
kek@kek-VirtualBox:~/Игрушки$ sudo vi /usr/local/bin/script.sh
    #!/bin/bash
    echo $(date) >> /var/log/testcron.log
    :w!
    :q
kek@kek-VirtualBox:~/Игрушки$ sudo chmod ugo+x /usr/local/bin/script.sh
kek@kek-VirtualBox:~/Игрушки$ sudo crontab -e
    0/3 * * * * /usr/local/bin/script.sh
crontab: installing new crontab