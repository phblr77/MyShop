create table products
(
    id    bigserial primary key,
    title varchar(255),
    price int
);
insert into products (title, price)
values ('Milk', 85),
       ('Bread', 25),
       ('Cheese', 45),
       ('Butter', 87),
       ('Oil', 23),
       ('Pizza', 41),
       ('Meat', 56),
       ('Chicken', 34),
       ('Oranges', 28),
       ('Juice', 54),
       ('Apples', 63),
       ('Tomatoes', 31),
       ('Salad', 78),
       ('Coffee', 99),
       ('Tea', 36),
       ('Oats', 88),
       ('Bananas', 97),
       ('Cherry', 44),
       ('Pears', 29),
       ('Lemons', 15);

