DROP TABLE IF EXISTS employee;
CREATE TABLE IF NOT EXISTS employee (
    `id` INT PRIMARY KEY,
    `name` VARCHAR(20),
    `position` VARCHAR(30),
    `department` VARCHAR(30)
);

INSERT INTO employee (`id`, `name`, `position`, `department`)
VALUES (1, '홍길동', '매니저', '영업'),
       (2, '김철수', '대리', '마케팅'),
       (3, '김영희', '실장', '인사');