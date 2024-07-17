-- 코드를 작성해주세요
SELECT f.id, f.length
  FROM FISH_INFO AS f
 ORDER BY f.length DESC, f.id ASC
 LIMIT 10;
