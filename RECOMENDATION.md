Скрипт для БД:

    CREATE DATABASE CONVERTER;
    CREATE USER j with password '1111';
    \q
    
    psql -h localhost converter j
                      
                           
    CREATE TABLE IF NOT EXISTS USERS
       (
         ID       VARCHAR(50) not null,
         NAME     VARCHAR(50) not null,
         PASSWORD VARCHAR(50) not null,
         primary key (ID)
       ) ;
      
Инициализация БД:
   
    INSERT INTO public.roles(id, name)
    VALUES (1, 'ROLE_USER'), (2, 'ROLE_ADMIN');

    INSERT INTO public.users(id, username, password)
    VALUES (1, 'ADMIN', 'ADMIN');

    INSERT INTO public.users_roles(user_id, roles_id)
    VALUES (1, 2);  
      
      
bash:

    lsof -i tcp:8080
    kill -9 pid