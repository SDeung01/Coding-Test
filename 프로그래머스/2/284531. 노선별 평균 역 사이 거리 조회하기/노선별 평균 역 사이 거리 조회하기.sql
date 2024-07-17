-- 코드를 작성해주세요
SELECT s.route,
       CONCAT(ROUND(SUM(s.d_between_dist),1), 'km') AS TOTAL_DISTANCE,
       CONCAT(ROUND(AVG(s.d_between_dist),2), 'km') AS AVERAGE_DISTANCE
  FROM SUBWAY_DISTANCE s
 GROUP BY s.route
 ORDER BY ROUND(SUM(s.d_between_dist)) DESC;