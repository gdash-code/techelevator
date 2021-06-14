CREATE TABLE test (
id serial NOT NULL
);
ALTER TABLE test
ADD COLUMN test_value varchar(50);


DROP TABLE test;