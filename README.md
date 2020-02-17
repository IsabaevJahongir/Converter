# Конвертер Валют 

**Используемые технологии:**

- Java 11 или Java 13
- Maven
- Spring boot 2.2.4
- PostgresSQL 12
- Html 5\CSS\JS


**Описание:**

При запуске приложения, получается список актуальных валют и их курсов с сайта ЦБРФ http://www.cbr.ru/scripts/XML_daily.asp и эти данные записываются в базу данных, а так же курсы (*привязанные к валюте*) на дату запроса. В конвертере есть авторизация по логину и паролю. Пользователь пройдя авторизацию попадает на главный экран, где может выбрать из какой валюты и в какую будет конвертация, указывает количество переводимых средств и нажимает кнопку "Конвертировать". После чего происходит запрос в БД на получение актуального курса на ***текущую дату ***, если данные на текущую дату отсутствуют, производится получение курсов с сайта ЦБ и добавление новых записей в базу данных. Также в конвертере ведется история произведенных конвертаций с записью в базу данных со ссылкой на курс по которой была произведена конвертаци. Историю можно посмотреть на отдельной вкладке



** Скрипт для БД:**

Если Вы хотите ввести свое имя пользователя БД (в данном случае j) и пароль (в данном случае '1111'), то необходимо поменять эти значение в свойствах (application.propertiea => spring.datasource.username=j spring.datasource.password=1111)
                                                                                                                                                                          
                                                                                                                                                                                 

    \psql
    
    CREATE DATABASE CONVERTER;
    CREATE USER j with password '1111';
    \q
    
    psql -h localhost converter j

    create table IF NOT EXISTS users
    (
    	id bigint not null
    		constraint users_pkey
    			primary key,
    	password varchar(255),
    	username varchar(255)
    );
    
    
    create table IF NOT EXISTS roles
    (
    	id bigint not null
    		constraint roles_pkey
    			primary key,
    	name varchar(255)
    );
    
    create table IF NOT EXISTS users_roles
    (
    	user_id bigint not null,
    	roles_id bigint not null
    		constraint fka62j07k5mhgifpp955h37ponj
    			references roles,
    	constraint users_roles_pkey
    		primary key (user_id, roles_id)
    );
    
    create table IF NOT EXISTS valutes
    (
    	id bigint not null
    		constraint valutes_pkey
    			primary key,
    	actual_date timestamp,
    	char_code varchar(255),
    	name varchar(255),
    	nominal integer,
    	num_code varchar(255),
    	value double precision
    );
                         
    create table IF NOT EXISTS conversions
    (
        id bigint not null constraint conversions_pkey primary key,
        amount double precision not null,
        from_valute_id bigint constraint fkhwujtfr8va5lgfiun41h4bboe references valutes,
        to_valute_id   bigint constraint fknw8engp2gy5lrjmt7nd2mbsat references valutes,
        user_id        bigint,
        date           timestamp
    );                  
                      
    alter sequence hibernate_sequence;             
                      

    
Инициализация БД:
   
    INSERT INTO public.roles(id, name)
    VALUES (1, 'ROLE_USER'), (2, 'ROLE_ADMIN');

    INSERT INTO public.users(id, username, password)
    VALUES (1, 'ADMIN', 'ADMIN');

    INSERT INTO public.users_roles(user_id, roles_id)
    VALUES (1, 2);  