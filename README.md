# Проект по автоматизации тестирования для компании [Ситилинк](https://citilink.ru/) <img alt="Jenkins" height="25" src="images/icons/citilink.png" width="20"/>

> «Ситили́нк» — российская сеть магазинов, осуществляющая продажу компьютерной, цифровой и бытовой техники и позиционирующая себя как электронный дискаунтер. Основные цели включают проверку функциональности сайта, генерацию подробных отчетов и интеграцию с CI/CD.

## Стек технологий

<p align="center">  
<a href="https://www.jetbrains.com/idea/"><img src="images/icons/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="images/icons/java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://github.com/"><img src="images/icons/GitHub.svg" width="50" height="50"  alt="Github"/></a>  
<a href="https://junit.org/junit5/"><img src="images/icons/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="images/icons/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>  
<a href="https://selenide.org/"><img src="images/icons/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>  
<a href="https://aerokube.com/selenoid/"><img src="images/icons/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>  
<a href="https://github.com/allure-framework/allure2"><img src="images/icons/Allure.svg" width="50" height="50"  alt="Allure"/></a> 
<a href="https://qameta.io/"><img src="images/icons/AllureTestOps.svg" width="40" height="40"  alt="Allure TestOps"/></a> 
<a href="https://www.jenkins.io/"><img src="images/icons/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a> 
<a href="https://web.telegram.org/"><img src="images/icons/Telegram.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.atlassian.com/ru/software/jira/"><img src="images/icons/jira.svg" width="50" height="50"  alt="Jira"/></a>  

</p>

- **IntelliJ IDEA**: Среда разработки для написания кода.
- **Java**: Основной язык программирования проекта.
- **GitHub**: Платформа для хостинга и совместной разработки кода.
- **JUnit 5**: Фреймворк для написания и выполнения тестов.
- **Gradle**: Система сборки проектов.
- **Selenide**: Библиотека для написания UI тестов.
- **Selenoid**: Инструмент для управления браузерами в контейнерах.
- **Allure**: Фреймворк для генерации отчетов о тестировании.
- **Jenkins**: Инструмент для автоматизации сборки и CI/CD.
- **Telegram**: Мессенджер для уведомлений о сборке проекта.
- **Jira**: Платформа для управления проектами и отслеживания задач.
- **Allure TestOps**: Платформа для управления тестированием и анализа результатов тестов.

## <img alt="Jenkins" height="25" src="images/icons/Jenkins.svg" width="25"/></a><a name="Сборка"></a>Сборка в [Jenkins](https://jenkins.autotests.cloud/job/Kod3ik_qa_guru_x5/)</a>
Jenkins используется для автоматизации сборки и тестирования проекта. Он позволяет любому члену команды запускать тесты в любое время.
<p align="center">  
<a href="https://jenkins.autotests.cloud/job/Kod3ik_qa_guru_x5/"><img src="images/screenshots/jenkins-scrin.png" alt="Jenkins" width="950"/></a>  
</p>


### **Параметры сборки в Jenkins:**

- browser – браузер, по умолчанию chrome
- browserVersion – версия браузера, по умолчанию 122
- browserSize – размер окна браузера, по умолчанию 1920x1080
- remoteUrl – логин, пароль и адрес удаленного сервера Selenoid

<a id="console"></a>



### Плагины
- **java-library**: Плагин для работы с Java библиотеками.
- **io.qameta.allure (версия 2.11.2)**: Плагин для интеграции с Allure для генерации отчетов.

### Репозитории
- **mavenCentral**: Репозиторий Maven Central для получения зависимостей.

### Зависимости (Dependencies)
- **Selenide (версия 7.2.3)**: Фреймворк для написания лаконичных и стабильных UI тестов на Java.
- **JUnit 5 (версия 5.10.2)**: Фреймворк для модульного тестирования на Java.
- **Java Faker (версия 1.0.2)**: Библиотека для генерации фейковых данных для тестирования.
- **Allure Selenide (версия 2.27.0)**: Для интеграции Selenide с Allure для детализированных отчетов.
- **SLF4J Simple (версия 2.0.7)**: Простая фасадная библиотека для логирования в Java.

### Конфигурация
- **Конфигурация Allure** для генерации отчетов и использования AspectJ Weaver.
- **Конфигурация задач тестирования** для использования JUnit Platform и логирования определенных событий тестов.
- Передача системных свойств в задачи тестирования.
- Условное включение тегов тестов на основе системных свойств.

### Классы помощники (Helper Classes)
- **Attach**: Содержит методы для захвата скриншотов, исходного кода страницы, логов консоли браузера и встраивания видео в отчеты
- Использованал Selenoid для удаленного запуска брузеров в Docker контейнерах

### Интеграция с Telegram
Была выполнена интеграция с Telegram для автоматической сборки (в Jenkins) и отправки отчетности в Telegram канал каждые 6 часов


