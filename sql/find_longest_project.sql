SELECT *
FROM project
WHERE TIMESTAMPDIFF(DAY, START_DATE, FINISH_DATE) = (
    SELECT MAX(TIMESTAMPDIFF(DAY, START_DATE, FINISH_DATE))
    FROM project
);
