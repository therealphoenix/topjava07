Онлайн проекта Topjava
Напоминаю про работу с патчами (GIT Wiki)
Не стоит стремится прочитать все ссылки урока, они могут быть как справочник. Гораздо важнее сделать Домашнее Задание
hw Разбор домашнего задания HW0:

video 1. Optional: реализация getFilteredMealsWithExceeded через Stream API

1-1-HW0-stream.patch
Еще вариант группировки калорий за день:

Map<LocalDate, Integer> caloriesSumByDate = mealList.stream()
  .collect(
    Collectors.toMap(um -> um.getDateTime().toLocalDate(), UserMeal::getCalories, Integer::sum)
  );
video 2. Работа с git в IDEA. Реализация через цикл.

1-2-HW0-cycle.patch
Изменения в проекте: map.getOrDefault земенил на map.merge, for заменены на forEach
question Ваши вопросы по HW0

что делает метод Map.merge
никогда не надо ленится зайти в код Map и почитать там javadoc. Когда, если не сейчас?

что означает Integer::sum
это ссылка на метод, сокращенная форма лямбды. IDEA иногда предлагает замену, например um->um.getCalories() заменяет на UserMeal::getCalories.

почему не использовать в TimeUtil методы isBefore/isAfter
это строгие (excluded) сравнения, а нам также нужны краевые значения

Занятие 1:

video 3. Обзор используемых в проекте технологий. Интеграция ПО.

Обзор популярности инструментов и технологий Java за 2014 г.
Видео "Приложение Spring Pet Clinic"
Приложение Spring Pet Clinic.
Demo Spring Pet Clinic
video 4. Maven.

Среда сборки проектов Maven.
The Central Repository
Настройка пропертей Maven: кодировка, java version, зависимости, maven-compiler-plugin
The Reactor. Snapshots
Недостатки Maven. Другие инструменты сборки.
Справочник:
Автоматизация сборки проекта
Home Page
Maven: The Complete Reference
Разработка ПО вместе с maven
Build Lifecycle
Dependency Mechanism
Создание своих архетипов и каталогов в Maven
Зависимости, профили
Bintray: gateway to Maven Central
video 5. WAR. Веб-контейнер Tomcat. Сервлеты.

1-3-switch-to-war.patch

Сервлет добавляется в следующем патче, те в web.xml он будет подчеркиваться красным.
1-4-add-servlet-api.patch

1-5-forward-to-redirect.patch
Перевод проекта на Web.
Tomcat Home Page
Сервлеты.
Настройка и деплой в Tomcat. Tomcat manager. Remote debug.
Запуск Tomcat из IDEA. Динамическое обновление без передеплоя.
Redirect, Forward, Application context, Servlet context
Томкат менеджер: http://localhost:8080/manager
Наше приложение: http://localhost:8080/topjava
Наш сервлет: http://localhost:8080/topjava/users
Справочник:
Отладчик IntelliJ IDEA
Yakov Fain: Intro to Java EE. Glassfish. Servlets (по русски)
Yakov Fain: HTTP Sessions, Cookies, WAR deployments, JSP (по русски)
Golovach Courses: Junior.February2014.Servlets
Remotely debug on tomcat from IDEA
Java Server Page
Java Server Pages (JSP)
video 6. Логирование.

1-6-logging.patch
установите переменную окружения на TOPJAVA_ROOT на корень проекта и перезапустите IDEA

изменения в проекте: убрал LoggerWrapper и логирую напрямую в логгер SLF4J. При логгировании через вспомогательный класс, в логе теряется имя исходного класса.
Java Logging: история кошмара
Ведение лога приложения
Log4j, Logback
Добавление зависимостей логирования в проект. Переменная окружения TOPJAVA_ROOT
Конфигурирование логирования. Настройка Live Template.
Тестирование логирования в сервлете.
Проверочные вопросы:

Что нужно изменить в pom.xml, чтобы перейти с logback на log4j ?
video 7. Подсоединение к логгеру по JMX. Выбор работы.

1-7-remote-jmx.patch
Для подключения к Remote Process (localhost:1099) положить setenv.bat в $TOMCET_HOME/bin.
Управление логированием по Java Management Extensions.
question Ваши вопросы

Используются ли еще где-то в реальной разработке JSP, или это уже устаревшая технология? Заменит ли ее JSF (https://javatalks.ru/topics/38037)?
JSF и JSP- разные ниши и задачи. JSP- шаблонизатор, JSF- МVС фреймворк. Из моего опыта- с JSP сталкивался в 60% проектов. Его прямая замена: http://www.thymeleaf.org, но пока встречется достаточно редко. JSP не умирает, потому что просто и дешево. Кроме того включается в большнство веб-контейнеров (в Tomcat его реализация Jasper)

JSF- sun-овский еще фреймворк, с которым я ни разу не сталкивался и особого желания нет. Вот он как раз, по моему мнению, активно замещается хотябы angular.

А зачем мы использовали logback? Почему SLF4J нас не устроило? Почему реализация логирования не log4j?
SLF4J-API это API. Там есть только пустая реализация org.slf4j.helpers.NOPLogger (можно посмотреть в исходниках). Logback для новых проектов стал стандарт. spring-petclinic и spring-boot используют его.

http://logback.qos.ch/reasonsToSwitch.html
hw Домашнее задание HW01 (делаем ветку HW01 от последнего патча)

По аналогии с UserServlet добавить MealServlet и mealList.jsp.
Задеплоить приложение (war) в Tomcat c applicationContext=topjava (приложение должно быть доступно по http://localhost:8080/topjava)
Попробовать разные деплои в Tomcat, remote и local debug
Сделать отображения списка еды в jsp, цвет записи в таблице зависит от параметра isExceeded (красный/зеленый).
Время выводить без 'T', список выводим БЕЗ фильтрации, user к UserMeal НЕ добавляем.
Вариант реализации:
из сервлета преобразуете еду в памяти в List<UserMealWithExceeded>;
кладете список в запрос (request.setAttribute);
делаете forward на jsp для отрисовки таблицы (при redirect аттрибуты теряются).
Деплоиться лучше как war exploded: нет упаковки в war и при нажатой кнопке Update Resources on Frame Deactivation можно обновляться css, html, jsp без передеплоя. При изменении web.xml, добавлении методов, классов необходим redeploy.
В JSP для цикла можно использовать JSTL tag forEach. Для подключения JSTL в pom.xml и шапку JSP нужно добавить:
    <dependency>
       <groupId>javax.servlet</groupId>
       <artifactId>jstl</artifactId>
       <version>1.2</version>
    </dependency>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    ...
Интернет-приложения на JAVA
HTTP 1.0 vs 1.1
JSP
JSTL для написания JSP страниц
JSTL: Шаблоны для разработки веб-приложений в java
Optional

Сделать В ПАМЯТИ реализацию CRUD (create/read/update/delete) для еды с учетом многопоточности (хранение в памяти будет одна из наших реализаций, такжен будет JDBC, JPA и DATA-JPA)).
В качестве ключа добавить id в UserMeal/ UserMealWithExceed.
Работать с реализацией через интерфейс, который не должен ничего знать о деталях реализации (Map, DB или что-то еще).
Сделать форму редактирования в JSP: AJAX/JavaScript использовать НЕ надо, делаем через <form method="post"> и doPost() в сервлете.
Simple CRUD using JSP, Servlet
error Решение проблем

Если вы не попадаете на страничку/брекпойнт в сервлете:
внимательно проверьте url и applicationContext (Application Context должен быть тот же, что и url приложения: wiki IDEA)
посомтрите в task manager: возможно у вас запущено несколько JVM и они мешают друг другу.
После выставления переменной окружения IDEA нужно рестартовать. Проверить, видит ли java переменную окуржения можно так: System.getenv("TOPJAVA_ROOT"). Еще вариант: добавить -DTOPJAVA_ROOT=... в опции запуска приложения, тогда она доступна из java как System.getProperty("TOPJAVA_ROOT").
Проблемы с кодировкой в POST. Возможное решение:
protected void doPost(HttpServletRequest request, ...) {
    request.setCharacterEncoding("UTF-8");
error Типичные ошибки

Хранить нужно UserMeal и конвертировать ее в UserMealWithExceed когда отдаем список на отображение в JSP. Иначе при редактировании любой записи или изменении юзером своей нормы caloriesPerDay нужно будет пересчитывать все записи юзера.
Стили color можно применять ко всей строке таблицы tr, а не каждой ячейке.
DateTimeFormatter можно сделать один заранее (он потокобезопасный в отличии от SimpleDateFormatter), а не создавать новый при каждом запросе.
Реализаций интерфейса хранения будет несколько. Нужно учитывать это в названии класса.
Если в названии класса есть Meal, не нужно использовать слово meal в методах класса.
