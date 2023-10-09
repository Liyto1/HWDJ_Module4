INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY) VALUES
    ('Forrest Gump', '1990-05-15', 'Trainee', 800),
    ('Michael Bay', '1985-02-20', 'Junior', 1200),
    ('Shia LaBeouf', '1980-09-10', 'Middle', 3000),
    ('Martin Lawrence', '1975-11-30', 'Senior', 6000),
    ('John Krasinski', '1992-03-05', 'Trainee', 900),
    ('Steven Carell', '1987-07-12', 'Junior', 1500),
    ('David Bowie', '1995-08-25', 'Middle', 3500),
    ('Mick Jagger', '1983-04-18', 'Senior', 7000),
    ('Iggy Pop', '1994-01-10', 'Trainee', 950),
    ('Anthony Kiedis', '1982-06-08', 'Junior', 1300);

INSERT INTO client (NAME) VALUES
    ('Client A'),
    ('Client B'),
    ('Client C'),
    ('Client D'),
    ('Client E');

INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE) VALUES
    (1, '2023-01-01', '2023-03-31'),
    (2, '2023-02-15', '2023-06-30'),
    (3, '2023-04-01', '2023-05-31'),
    (4, '2023-03-10', '2023-07-15'),
    (5, '2023-05-20', '2023-08-15'),
    (1, '2023-06-01', '2023-09-30'),
    (3, '2023-07-15', '2023-10-31'),
    (2, '2023-08-10', '2023-11-30'),
    (4, '2023-09-05', '2024-01-31'),
    (5, '2023-10-20', '2024-02-28');

INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES
    (1, 1), (1, 2),
    (2, 3), (2, 4), (2, 5),
    (3, 6),
    (4, 7), (4, 8),
    (5, 9), (5, 10),
    (6, 1),
    (7, 2), (7, 3),
    (8, 4), (8, 5),
    (9, 6), (9, 7),
    (10, 8), (10, 9), (10, 10);