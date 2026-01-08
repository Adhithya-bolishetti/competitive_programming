SELECT w1.id
FROM Weather w1, Weather w2
WHERE DATEDIFF(w1.recordDate, w2.recorddate) = 1 AND w1.temperature > w2.temperature;
