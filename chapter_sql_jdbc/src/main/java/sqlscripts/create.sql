--Скрипт для создания базы данных и работы с ней
--Создание базы данных
CREATE DATABASE database_name;

--Создание таблицы + примеры ограничений
CREATE TABLE tables_name(
	Id SERIAL PRIMARY KEY,
	Name1 data_type NOT NULL,
	Name2 data_type NULL,
	Name3 data_type VARYING(numbers),
	Name4 data_type UNIQUE CHECK(Name4 != 'smth'),
	Name5 data_type DEFAULT default_value
);

--Заполнение таблицы
INSERT INTO database_name (1, smth_to_Name1, smth_to_Name2, smth_to_Name3, smth_to_Name4, smth_to_Name5);

--Извлечение данных
--Все объекты из таблицы
SELECT * FROM tables_name;

--Извлечение данных из определенных столбцов
SELECT Name1, Name5 FROM tables_name;

-------UML--------
--user - role = many-to-one 
--role - rules = many-to-many
--item - user = many-to-one
--item - comments = one-to-many
--item - attachs = one-to-many
--item - category = many-to-one
--item - state = many-to-one
--CREATE DATABASE some_database;

--many users to one role
CREATE TABLE users(
	ID SERIAL PRIMARY KEY,
	FirstName CHARACTER VARYING(15),
	LastName CHARACTER VARYING(15),
	NickName CHARACTER VARYING(15),
	Age INTEGER,
	roles_id INTEGER REFERENCES roles(id)
);

CREATE TABLE roles(
	ID SERIAL PRIMARY KEY,
	Name_of_role CHARACTER VARYING(15)
);

CREATE TABLE rules(
	ID SERIAL PRIMARY KEY,
	Name_of_rules CHARACTER VARYING(15)
);

--many rules to many roles
CREATE TABLE roles_rules(
	ID SERIAL PRIMARY KEY,
	roles_id INTEGER REFERENCES roles(ID),
	rules_id INTEGER REFERENCES rules(ID)
);

--many items to one category
--many items to one user
--many items to one state
CREATE TABLE items(
	ID SERIAL PRIMARY KEY,
	Name_of_items CHARACTER VARYING(15),
	user_id INTEGER REFERENCES users(ID),
	category_id INTEGER REFERENCES category(ID),
	states_id INTEGER REFERENCES category(ID)
);

--one item to many comments
CREATE TABLE someCommments(
	ID SERIAL PRIMARY KEY,
	Name_of_comments CHARACTER VARYING(15),
	items_id INTEGER REFERENCES items(id)
);

--one item to many attachs
CREATE TABLE attachs(
	ID SERIAL PRIMARY KEY,
	Name_of_attachs CHARACTER VARYING(15),
	items_id INTEGER REFERENCES items(id)
);

CREATE TABLE category(
	ID SERIAL PRIMARY KEY,
	Name_of_category CHARACTER VARYING(15)
);

CREATE TABLE states(
	ID SERIAL PRIMARY KEY,
	Name_of_states CHARACTER VARYING(15)
);