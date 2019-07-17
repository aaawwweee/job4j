CREATE TABLE product(
	ID SERIAL PRIMARY KEY,
	name_of_product CHARACTER VARYING(20),
	type_id INTEGER REFERENCES type_of_product(id),
	expired_date TIMESTAMP,
	price INTEGER
);

INSERT INTO type_of_product VALUES (1, 'СЫР');
INSERT INTO type_of_product VALUES (2, 'ОВОЩИ');
INSERT INTO type_of_product VALUES (3, 'МОЛОКО');
INSERT INTO type_of_product VALUES (4, 'МОРОЖЕНОЕ');

INSERT INTO product VALUES (1, 'Маасдам', 1, '2019-07-17 12:12:12', 400);
INSERT INTO product VALUES (2, 'Пошехонский', 1, '2019-08-01 12:12:12', 300);
INSERT INTO product VALUES (3, 'Российский', 1, '2019-10-03 12:12:12', 250);

ALTER TABLE product ADD COLUMN amount INTEGER;

INSERT INTO product VALUES (4, 'Домик в деревне', 3, '2019-07-25 12:12:12', 50, 13);
INSERT INTO product VALUES (5, 'Веселый молочник', 3, '2019-07-30 12:12:12', 55, 7);
INSERT INTO product VALUES (6, 'Лучшее молоко', 3, '2019-08-01 12:12:12', 70, 8);

UPDATE product as p
SET amount = 15
WHERE p.id < 4;

INSERT INTO product VALUES (10, 'Русское мороженое', 4, '2019-08-14 12:12:12', 60, 11);
INSERT INTO product VALUES (11, 'Лакомка', 4, '2019-08-15 12:12:12', 65, 9);
INSERT INTO product VALUES (12, 'Айсберри', 4, '2019-09-02 12:12:12', 75, 10);

--Написать запрос получение всех продуктов с типом "СЫР"
SELECT p.* FROM product AS P 
JOIN type_of_product AS T ON 
P.type_id = T.id
WHERE T.name_of_type = 'СЫР';

--Написать запрос получения всех продуктов, у кого в имени есть слово "мороженое"
SELECT * FROM product AS P
WHERE P.name_of_product LIKE '%мороженое%';

-- запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
SELECT * FROM product AS P
WHERE P.expired_date >= '2019-08-01 00:00:00' 
AND P.expired_date <  '2019-08-31 00:00:00';

--Написать запрос, который выводит количество всех продуктов определенного типа (например, с типой 'СЫР').
SELECT SUM (amount) FROM product AS P 
JOIN type_of_product AS T ON 
P.type_id = T.id
WHERE T.name_of_type = 'СЫР';

--Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
SELECT P.* FROM product AS P 
JOIN type_of_product AS T ON 
P.type_id = T.id
WHERE T.name_of_type IN ('СЫР', 'МОЛОКО');

--Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
SELECT T.name_of_type FROM product AS P
JOIN type_of_product AS T ON 
P.type_id = T.id
GROUP BY T.name_of_type HAVING COUNT(P.amount) < 10;

--Вывести все продукты и их тип.
SELECT P.name_of_product, T.name_of_type FROM product AS P
JOIN type_of_product AS T ON 
P.type_id = T.id;