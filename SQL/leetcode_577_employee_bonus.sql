SELECT E.name, B.bonus
FROM Employee as E
LEFT JOIN Bonus as B ON E.empId = B.empId
WHERE B.bonus IS NULL OR B.bonus < 1000;