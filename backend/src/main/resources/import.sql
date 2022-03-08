INSERT INTO tb_user (first_Name, last_Name) VALUES ('Alan', 'Pacheco');
INSERT INTO tb_user (first_Name, last_Name) VALUES ('Ben', 'Pacheco');
INSERT INTO tb_user (first_Name, last_Name) VALUES ('Evelin', 'Maria');
INSERT INTO tb_user (first_Name, last_Name) VALUES ('Bob', 'Brown');

INSERT INTO tb_category (name) VALUES ('Alimentação');
INSERT INTO tb_category (name) VALUES ('Moradia');
INSERT INTO tb_category (name) VALUES ('Transporte');
INSERT INTO tb_category (name) VALUES ('Saúde');
INSERT INTO tb_category (name) VALUES ('Educação');
INSERT INTO tb_category (name) VALUES ('Lazer');

INSERT INTO tb_expense (moment, amount, user_id, description, category_id) VALUES (TIMESTAMP WITH TIME ZONE '2021-11-20T13:00:00Z', 23.00, 1, 'Lanche escolar Ben', 1);
INSERT INTO tb_expense (moment, amount, user_id, description, category_id) VALUES (TIMESTAMP WITH TIME ZONE '2021-11-20T13:00:00Z', 28.00, 2, 'Condominio', 2);
INSERT INTO tb_expense (moment, amount, user_id, description, category_id) VALUES (TIMESTAMP WITH TIME ZONE '2021-11-20T13:00:00Z', 53.00, 2, 'Almoço semanal', 1);
INSERT INTO tb_expense (moment, amount, user_id, description, category_id) VALUES (TIMESTAMP WITH TIME ZONE '2021-11-20T13:00:00Z', 3.00, 3, 'metro casa para o trabalho', 3);
INSERT INTO tb_expense (moment, amount, user_id, description, category_id) VALUES (TIMESTAMP WITH TIME ZONE '2021-11-20T13:00:00Z', 1095.50, 3, 'Mensalidade escola Ben', 5);

INSERT INTO tb_payment (payment_Type, amount, expense_id) VALUES (0, 23.00, 1)
INSERT INTO tb_payment (payment_Type, amount, expense_id) VALUES (2, 23.00, 2)
INSERT INTO tb_payment (payment_Type, amount, expense_id) VALUES (1, 5.00, 2)
INSERT INTO tb_payment (payment_Type, amount, expense_id) VALUES (4, 3.00, 4)
INSERT INTO tb_payment (payment_Type, amount, expense_id) VALUES (4, 53.00, 3)
INSERT INTO tb_payment (payment_Type, amount, expense_id) VALUES (3, 65.50, 5)
INSERT INTO tb_payment (payment_Type, amount, expense_id) VALUES (1, 30.00, 5)
INSERT INTO tb_payment (payment_Type, amount, expense_id) VALUES (4, 1000.00, 5)


