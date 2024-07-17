-- 코드를 작성해주세요
SELECT COUNT(f.id) AS FISH_COUNT
  FROM FISH_INFO f
 WHERE YEAR(f.time) = '2021';

