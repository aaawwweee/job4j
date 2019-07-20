/*
Таблицы: Кузов, Двигатель, Коробка передач.
Создать структуру (таблицу) "Машина". Машина не может существовать без деталей выше.
Создать SQL запросы:
1. Вывести список всех машин и все привязанные к ним детали.
2. Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.
*/
CREATE TABLE engine(
	ID SERIAL PRIMARY KEY,
	engine_type CHARACTER VARYING(10)
);
INSERT INTO engine VALUES (1, 'V12');
INSERT INTO engine VALUES (2, 'V8');
INSERT INTO engine VALUES (3, 'V10');
INSERT INTO engine VALUES (4, 'V6');

CREATE TABLE body(
	ID SERIAL PRIMARY KEY,
	body_type CHARACTER VARYING(10)
);
INSERT INTO body VALUES (1, 'Sedan');
INSERT INTO body VALUES (2, 'Hatchback');
INSERT INTO body VALUES (3, '4x4');
INSERT INTO body VALUES (4, 'Sport');

CREATE TABLE transmission(
	ID SERIAL PRIMARY KEY,
	transmission_type CHARACTER VARYING(10)
);
INSERT INTO transmission VALUES (1, 'Easy');
INSERT INTO transmission VALUES (2, 'Normal');
INSERT INTO transmission VALUES (3, 'Hard');

CREATE TABLE car(
	ID SERIAL PRIMARY KEY,
	car_name CHARACTER VARYING(10),
	engine_id INTEGER REFERENCES engine(id),
	body_id INTEGER REFERENCES body(id),
	transmission_id INTEGER REFERENCES transmission(id)
);
INSERT INTO car(ID, car_name, engine_id, body_id, transmission_id) VALUES
(1, 'Ferrari', 1, 4, 1);
INSERT INTO car(ID, car_name, engine_id, body_id, transmission_id) VALUES
(2, 'Volga', 4, 1, 3);
INSERT INTO car(ID, car_name, engine_id, body_id, transmission_id) VALUES
(3, 'Jeep', 2, 3, 1);

--Вывести все машины и их детали.
SELECT car_name, engine_type, body_type, transmission_type FROM car AS C 
JOIN engine AS e ON c.engine_id = e.id
JOIN body AS b ON c.body_id = b.id
JOIN transmission AS t ON c.transmission_id = t.id;

--Вывести детали, которые не используются в машине.
--Двигатель, который не используется.
select e.engine_type from engine as e left outer join car as c on c.engine_id = e.id where c.id is null;
--Кузов, который не используется.
select b.body_type from body as b left outer join car as c on c.body_id = b.id where c.id is null;
--Коробка передач, которая не используется.
select t.transmission_type from transmission as t left outer join car as c on c.transmission_id = t.id where c.id is null;