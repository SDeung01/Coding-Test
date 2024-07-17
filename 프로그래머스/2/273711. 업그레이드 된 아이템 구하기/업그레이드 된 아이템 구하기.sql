-- 코드를 작성해주세요
SELECT info.item_id, info.item_name, info.rarity
  FROM ITEM_INFO info
  JOIN ITEM_TREE tree
    ON info.item_id = tree.item_id
 WHERE tree.parent_item_id IN (SELECT item_id FROM ITEM_INFO WHERE rarity = 'RARE')
 ORDER BY info.item_id DESC;