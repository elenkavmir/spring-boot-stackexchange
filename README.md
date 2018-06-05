## spring-boot-stackexchange 

Search questions in Stack Overflow.

http://api.stackexchange.com/docs/search

**Сборка**

 * war - профиль maven wepapp
 ```
 spring-boot-stackexchange$ install -f pom.xml -P webapp
 ```
 * jar - SpringBoot профиль maven batch
 ```
 spring-boot-stackexchange$ install -f pom.xml -P batch
 ```
 
 __Запуск SpringBoot jar__

```
```

**Модули**

* spring-boot-stackexchange - SpringBoot проект
* spring-boot-stackexchange-ui - angular cli проект. При сбрке устанавливается node и npm. Подкачиваются зависимости.
