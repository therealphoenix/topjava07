# Онлайн проекта <a href="https://github.com/JavaWebinar/topjava07">Topjava</a>

- **Браузер кэширует javascript и css. Если изменения не работают, обновите приложение в браузере по Ctrl+F5**
- **При удалении файлов не забывайте делать clean: `mvn clean package`**

## ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Разбор домашнего задания HW8

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 1. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFb0JKbElkT000amM">HW8</a>
> Поправка к видео: в гриде bootstrap 12 колонок.

- **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFdzZSeGlJYkw3aVE">1-HW8.patch</a>**
- <a href="http://getbootstrap.com/css/#grid">Grid system</a>
- <a href="http://getbootstrap.com/css/#description">Bootstrap description</a>
- <a href="http://getbootstrap.com/css/#forms">Bootstrap forms</a>

###  ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 2. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFV0VKY2FGbndGMTQ">HW8 Optional (enable/disable user)</a>
> Вместо использования id и селекторов сделал обработчики `onclick`

> Убрал  `init()`. При переводе таблицы на Ajax вместо него будет `createdRow`

-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFVnc1N2NFYkdnRFE">2-HW8-refactor.patch</a>**
- <a href="https://learn.javascript.ru/introduction-browser-events">Введение в браузерные события</a>
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFTmNuNmlhcU5CX0k">3-HW8-enable-disable.patch</a>**

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 3. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFMFJGLV9SaFBpQVE">HW8 Optional (new API)</a>
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFNU1IRVB6YVM0QWM">4_HW8_newApi.patch</a>**
> Новое API: поменялось как обновление таблицы, так и ее формат параметров.

-  <a href="https://datatables.net/upgrade/1.10-convert">Converting parameter names for 1.10</a>

## Занятие 9:

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 4.  <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFYlRkc2NGRGVydk0">Spring Binding</a>
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFRy04U3ZTZlkwc2c">5_binding.patch</a>**

>  Move `ru.javawebinar.topjava.util.UserMealsUtil.DEFAULT_CALORIES_PER_DAY` to `ru.javawebinar.topjava.util.UserUtil`

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 5.  <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFd2ZvcS1pSjdMQlU">Реализация update</a>
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFd0tSMFNNc001elE">6_update.patch</a>**

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 6.  <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFLXp5MTFDMEY5WFE">Spring Validation</a>
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFM0VVX3lPT3BXRDQ">7_validation.patch</a>**
-  <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/validation.html#validation-beanvalidation">Spring Validation.</a>
-  <a href="http://beanvalidation.org/">Bean Validation</a>
-  <a href="https://spring.io/blog/2012/08/29/integrating-spring-mvc-with-jquery-for-validation-rules">Валидация формы по AJAX.</a>
-  <a href="http://stackoverflow.com/questions/14730329/jpa-2-0-exception-to-use-javax-validation-package-in-jpa-2-0#answer-17142416">JSR-303, 349</a>
- <a href="https://dzone.com/articles/spring-31-valid-requestbody">@Valid @RequestBody + Error handling</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 7.  <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFcW1qeTVFdS1BdHM">Перевод DataTables на Ajax</a>
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFRWtKYVNxTzJoLW8">8-datatable-via-ajax.patch</a>**
-  <a href="http://legacy.datatables.net/usage/options">DataTables Options</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 8.  <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFUmhUTms1WnhTeHc">Форма логина / логаут.</a>
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFUjllT3dhazZEN00">9-min-form-login.patch</a>**
> Добавил в патч функциональность logout

-  <a href="http://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#ns-minimal">Минимальный form-login</a>
-  <a href="http://docs.spring.io/spring-security/site/migrate/current/3-to-4/html5/migrate-3-to-4-xml.html#m3to4-xmlnamespace-form-login">Migrating &lt;form-login&gt;</a>
- Вопросы:
  - Почему при логине как admin еда отдаются для user?
  - Почему при логине как user не отображается список пользователей?
  - Почему еда не редактируется?
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFMWFubFItaE5Tdzg">10-jsp-form-login.patch</a>**
-  <a href="http://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#ns-form-and-basic">Собственный form-login</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 9. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFYTA4aVN4bWxzbEU">Реализация собственного провайдера авторизации.</a>
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFdF9BZEY5ZE8tQmM">11_auth_via_user_service.patch</a>**
>  Изменения в проекте: вместо `LoggedUser implements UserDetails` сейчас `AuthorizedUser extends org.springframework.security.core.userdetails.User`

-  <a href="http://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#userdetailsservice-implementations">UserDetailsService Implementations</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 10.  <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFT2Qya2V4N0kzWWM">Принцип работы Spring Security. Проксирование.</a>
-  <a href="http://www.spring-source.ru/articles.php?type=manual&theme=articles&docs=article_07">Принцип работы Spring Security</a>
-  <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/aop.html#aop-proxying">Типы проксирования</a>
-  <a href="http://samolisov.blogspot.ru/2010/04/proxy-java.html">Dynamic Proxy API</a>
-  <a href="http://stackoverflow.com/questions/13977093/how-to-use-jparepositories-with-proxy-target-class-true/25543659#25543659">Конфликт проксирования Data Repository</a>
-  <a href="http://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#filter-stack">Security фильтры</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 11. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFU3hMR0o4eGNoUmc">Spring Security Test</a>
-  **<a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFTjBaRThxY21VSTA">12-spring-security-test.patch</a>**
>   Поправил RootControllerTest.

-  <a href="http://docs.spring.io/spring-security/site/docs/4.0.x/reference/htmlsingle/#test">Spring Security Test</a></h3>
-  <a href="http://docs.spring.io/spring-security/site/docs/4.0.x/reference/htmlsingle/#test-mockmvc">Интеграция со Spring MVC Test</a>
-  <a href="http://docs.spring.io/spring-security/site/docs/4.0.x/reference/htmlsingle/#testing-http-basic-authentication">HttpBasic авторизация</a>
-  <a href="http://habrahabr.ru/post/171911/">Тестирование контроллеров с помощью MockMvc (без spring-security-test)</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 12. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFUzNFanF6MGZGNHc">Cookie. Session.</a>
-  <a href="https://ru.wikipedia.org/wiki/HTTP_cookie">HTTP cookie</a></h3>
-  <a href="http://stackoverflow.com/questions/595872/under-what-conditions-is-a-jsessionid-created">Under what conditions is a JSESSIONID created?</a>
-  <a href="http://halyph.com/2014/08/how-to-disable-tomcat-session.html">Tomcat Session Serialization</a>

## ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Домашнее задание HW9

- Реализовать для meal Binding/ Update/ Validation. Проверить работу при пустом значении Calories.
- Перевести mealList.jsp на работу по ajax. Стиль строки таблицы сделать в зависимости от exceeded.
- Починить meals тесты

#### Optional
- Подключить datetime-picker
  - <a href="http://xdsoft.net/jqplugins/datetimepicker/">DateTimePicker jQuery plugin</a>

## ![question](https://cloud.githubusercontent.com/assets/13649199/13672858/9cd58692-e6e7-11e5-905d-c295d2a456f1.png) Ваши вопросы

> В `login.jsp` есть форма `&lt;form:form action="spring_security_check" ..&gt; Где такой url используется?

Это стандартный url для авторизации в spring-security. Он его и обрабатывает.
