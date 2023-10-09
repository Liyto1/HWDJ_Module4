SELECT c.NAME AS Client_Name, COUNT(p.ID) AS Project_Count FROM client c LEFT JOIN project p ON c.ID = p.CLIENT_ID
GROUP BY c.ID, c.NAME
HAVING COUNT(p.ID) = ( SELECT MAX(Project_Count)
 FROM (
        SELECT c.ID, COUNT(p.ID) AS Project_Count
        FROM client c
        LEFT JOIN project p ON c.ID = p.CLIENT_ID
        GROUP BY c.ID
    ) AS Client_Project_Count
);
