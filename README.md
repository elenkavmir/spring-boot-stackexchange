## spring-boot-stackexchange 

Search questions in Stack Overflow.

http://api.stackexchange.com/docs/search


**Модули**

* spring-boot-stackexchange - SpringBoot проект (backend)
* spring-boot-stackexchange-ui - angular cli проект (frontend).  
При сбрке устанавливается node и npm. Подкачиваются зависимости.


**Сборка**  
Maven версии 3 и выше
Итог в spring-boot-stackexchange/target

 * war - профиль maven wepapp
 * jar - профиль maven batch (SpringBoot)
 
 __Запуск SpringBoot jar__

```
java stackexchange-0.0.1-SNAPSHOT.jar
```
Приложение доступно по адресу http://localhost:8080

Пример с определенным портом и с proxy
```
java -Dserver.port=8081 -Dhttp.proxyHost=proxy.izh.ts -Dhttp.proxyPort=81 -Dhttps.proxyHost=proxy.izh.ts -Dhttps.proxyPort=81 -jar stackexchange-0.0.1-SNAPSHOT.jar
```
Приложение доступно по адресу http://localhost:8081