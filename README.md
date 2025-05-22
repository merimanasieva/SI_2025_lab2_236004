# Втора лабораториска вежба по Софтверско инженерство
## Мери Манасиева 236004
### Control Flow Graph
![CFG](https://github.com/user-attachments/assets/8c12f88f-6f68-4c93-b8a6-8cf30c945cfe)

### Цикломатска комплексност
Цикломатската комплексност на овој код е 29 истата ја добив преку формулата P+1, каде што P е бројот на предикатни јазли. Во случајoв P=8, па цикломатската комплексност изнесува 9.

### Тест случаи според критериумот Every statement
![every_statement](https://github.com/user-attachments/assets/a5c7f5ba-bfeb-4dab-be3b-b1829e86d9c9)

### Тест случаи според критериумот Every path
![multiplecondition](https://github.com/user-attachments/assets/3904536a-19fb-4d10-9d45-275c80c7ff85)

### Објаснување на напишаните unit tests

1. testEveryStatement()
Овој тест се користи за Statement Coverage (покриеност на секоја линија) во функцијата checkCart.

Test 1: allItems = null
SILab2.checkCart(null, "1234567890123456")
Очекува да фрли RuntimeException со порака "allItems list can't be null!".
Го тестира првиот if (allItems == null) во функцијата.

Test 2: Item со null име
Item item2 = new Item(null, 1, 100, 0);
SILab2.checkCart(List.of(item2), "1234567890123456")
Очекува RuntimeException со порака "Invalid item!".
Го тестира делот каде што се проверува дали item.getName() е null, што е дел од if (item.getName() == null || ...).

Test 3: Validен Item
Item item3 = new Item("Soap", 5, 100, 0.2);
double result = SILab2.checkCart(List.of(item3), "1234567890123456");
Очекува пресметана цена 370.0.
Овој тест помага да се потврди дека пресметката е точна за нормален случај.

2. testMultipleCondition()
Овој тест се користи за Multiple Condition Coverage, т.е. да се покријат сите можни комбинации на три логички услови во еден if.
if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getQuantity() > 10)
    sum -= 30;
Тука имаме 3 логички услови, што дава 2³ = 8 можни комбинации (T/F за секој услов).


