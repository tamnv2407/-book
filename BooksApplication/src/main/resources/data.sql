INSERT INTO role (role_type)
VALUES ('Admin');
INSERT INTO role (role_type) 
VALUES ('User');

INSERT INTO user(
   email,
   password,
   firstName,
   lastName,
   role_key
) 
VALUES ('user@gmail.com', '$2a$10$P3McY2Q58NT5ichbUjjnlud.T/Z2WAkFJqmg2RqH9APFmuhZc8rXS', 'Nguyen', 'Tam', 1);

--INSERT INTO book(
--   title,
--   author,
--   description,
--   date_create,
--   date_update)
--   VALUES
--   ('How to change your code', 'Tam nguyen', 'Talk about design pattern in Java', '2017-04-30', '2017-04-30'),
--   ('Design partern', 'Aut ABC', 'Talk about design pattern in Java', '2017-04-30', '2017-04-30');