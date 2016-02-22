# bitbucket

1. В проекте использовал базу данных MySQL. В базе данных 3 таблицы. Таблица author - содержит поля id, name, password и login. 
Команда создания таблицы: 

CREATE TABLE `author` (<br/>
  `id` int(11) NOT NULL AUTO_INCREMENT,<br/>
  `name` varchar(50) NOT NULL,<br/>
  `password` int(11) NOT NULL,<br/>
  `login` varchar(20) NOT NULL,<br/>
  PRIMARY KEY (`id`)<br/>
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8<br/>

Таблица category - содержит поля id и category. Команда создания таблицы:<br/>

CREATE TABLE `category` (<br/>
  `id` int(11) NOT NULL AUTO_INCREMENT,<br/>
  `category` varchar(30) NOT NULL,<br/>
  PRIMARY KEY (`id`)<br/>
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8
<br/>
Таблица message - содержит поля id, id_author, date, id_category, title, content. Команда создания таблицы:

CREATE TABLE `category` (<br/>
  `id` int(11) NOT NULL AUTO_INCREMENT,<br/>
  `category` varchar(30) NOT NULL,<br/>
  PRIMARY KEY (`id`)<br/>
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8
<br/>
Для нормальной работы проекта в таблицы author и category добавте несколько полей. Сообщения можно будет добавлять из под проекта. <br/>

2. Проект разрабатывался в среде intellij idea. Для сборки проекта использовался Maven. 
Проект отлаживался с помощью контейнера tomcat7.<br/>

3. Для формирования .war файла необходимо в командной строке, из под проекта, выполнить 'mvn clean package' 
и в дальнейшем произвести deploy, собранного .war файла, средствами tomcat. В браузере в адресную строку 
введите http://localhost:8080/dm/. Для запуска проекта из под intellij idea необходимо в командной строке, 
из под проекта, выполнить 'mvn clean package tomcat7:run-war-only'. В браузере в адресную строку введите http://localhost:8080/.  
