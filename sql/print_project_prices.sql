SELECT
    p.ID AS Project_ID,
    p.CLIENT_ID,
    p.START_DATE,
    p.FINISH_DATE,
    SUM(w.SALARY) * (DATEDIFF(p.FINISH_DATE, p.START_DATE) + 1) AS Project_Price
FROM project p
JOIN project_worker pw ON p.ID = pw.PROJECT_ID
JOIN worker w ON pw.WORKER_ID = w.ID
GROUP BY p.ID, p.CLIENT_ID, p.START_DATE, p.FINISH_DATE
ORDER BY Project_Price DESC;
